package com.example.owproject.filter.common;

import org.slf4j.MDC;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.UUID;

@Component
class HttpLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (super.isAsyncDispatch(request)) {

            filterChain.doFilter(request, response);
        } else {
            doFilterWrapped(
                    new ContentReadingHttpRequestWrapper(request),
                    new ContentReadingHttpResponseWrapper(response),
                    filterChain
            );
        }
    }

    private void doFilterWrapped(
            ContentReadingHttpRequestWrapper request,
            ContentReadingHttpResponseWrapper response,
            FilterChain filterChain
    ) throws IOException, ServletException {

        Pair<String, LocalDateTime> pair = beforeRequest(request);

        String requestLog = pair.getFirst();
        LocalDateTime startedAt = pair.getSecond();

        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            if (e instanceof ServletException || e instanceof IOException) {
                logger.error("요청/응답에 대한 필터 처리 중에 오류가 발생했습니다.", e);
            }
            else {
                throw e;
            }
        } finally {
            afterResponse(response, requestLog, startedAt);
        }
    }

    private Pair<String, LocalDateTime> beforeRequest(ContentReadingHttpRequestWrapper request) {
        MDC.put("REQUEST_ID", UUID.randomUUID().toString());

        return yieldRequestLog(request, LocalDateTime.now());
    }

    private Pair<String, LocalDateTime> yieldRequestLog(ContentReadingHttpRequestWrapper request, LocalDateTime startedAt) {

        Enumeration<String> headerNames = request.getHeaderNames();

        StringBuilder headersBuilder = new StringBuilder();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headersBuilder.append(headerName).append(": ").append(headerValue).append(", ");
        }
        stringBuilderWrapUp(headersBuilder, "");

        String headers = headersBuilder.toString();

        String params;
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (!parameterMap.isEmpty()) {

            StringBuilder paramsBuilder = new StringBuilder();

            paramsBuilder.append("{");
            for (String s : parameterMap.keySet()) {

                paramsBuilder.append("(").append(s).append(", [");
                String[] strings = parameterMap.get(s);

                for (String string : strings) {
                    paramsBuilder.append(string).append(", ");
                }

                stringBuilderWrapUp(paramsBuilder, "]), ");
            }
            stringBuilderWrapUp(paramsBuilder, "}");

            params = paramsBuilder.toString();
        }
        else {
            params = "*";
        }

        String requestId = MDC.get("REQUEST_ID");
        return Pair.of(
                "\n    ⊙ " + request.getMethod() + " " + request.getRequestURI() + "\n" +
                        "    ├─ Request Id: " + requestId + "\n" +
                        "    ├─ Started At: " + startedAt + "\n" +
                        "    ├─ Request Headers: " + headers + "\n" +
                        "    ├─ Request Params: " + params + "\n" +
                        "    ├─ Request Body: " + request.getContentAsString() + "\n",
                startedAt
        );
    }

    private void stringBuilderWrapUp(StringBuilder stringBuilder, String s) {
        int length = stringBuilder.length();
        stringBuilder.replace(length - 2, length, s);
    }

    private void afterResponse(ContentReadingHttpResponseWrapper response, String requestLog, LocalDateTime startedAt) throws IOException {
        try {
            logRequestAndResponse(response, requestLog, startedAt);
        } finally {
            // CAUTION! copyBodyToResponse 메서드를 실행하지 않을 경우 출력 스트림이 리셋되지 않아서 클라이언트가 응답을 받을 수 없게 됩니다.
            response.copyBodyToResponse();
        }
    }

    private void logRequestAndResponse(ContentReadingHttpResponseWrapper response, String requestLog, LocalDateTime startedAt) {

        Collection<String> headerNames = response.getHeaderNames();
        StringBuilder headersBuilder = new StringBuilder();
        if (!headerNames.isEmpty()) {
            for (String headerName : headerNames) {
                String headerValue = response.getHeader(headerName);
                headersBuilder.append(headerName).append(": ").append(headerValue).append(", ");
            }
            stringBuilderWrapUp(headersBuilder, "");
        }
        
        String headers = headersBuilder.toString();

        logger.info(requestLog +
                "    ├─ Response Headers: " + headers + "\n" +
                "    ├─ Response Body: " + response.getContentAsString() + "\n" +
                "    └─ Completed with " + response.getStatus() + " in " + ChronoUnit.MILLIS.between(startedAt, LocalDateTime.now()) + " ms");
    }
}
