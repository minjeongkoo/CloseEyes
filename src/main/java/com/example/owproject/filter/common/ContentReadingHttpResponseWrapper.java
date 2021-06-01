package com.example.owproject.filter.common;

import org.springframework.http.MediaType;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

class ContentReadingHttpResponseWrapper extends ContentCachingResponseWrapper {

    private String contentAsString;

    public ContentReadingHttpResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public String getContentAsString() {

        return getContentAsStringLazy();
    }

    public String getContentAsStringLazy() {

        if (this.contentAsString != null) {
            return contentAsString;
        }

        MediaType mediaType = MediaType.ALL;
        String contentType = getContentType();
        if (contentType != null) {
            mediaType = MediaType.valueOf(contentType);
        }

        if (MediaTypeUtils.isVisible(mediaType)) {
            Charset charset;

//            String characterEncoding = getCharacterEncoding();
//            String csn = characterEncoding != null ? characterEncoding : "ISO-8859-1";
            String csn = "UTF-8";
            if (Charset.isSupported(csn)) {
                charset = Charset.forName(csn);
            } else {
                charset = Charset.defaultCharset();
            }

            this.contentAsString = new String(getContentAsByteArray(), charset);
        } else {
            this.contentAsString = "*";
        }

        return this.contentAsString;
    }
}
