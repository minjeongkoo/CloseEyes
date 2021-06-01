package com.example.owproject.filter.common;

import org.springframework.http.MediaType;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

class ContentReadingHttpRequestWrapper extends ContentCachingRequestWrapper {

    private String contentAsString;
    private byte[] contentAsBytes;
    private ServletInputStream wrappedInputStream;

    public ContentReadingHttpRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public String getContentAsString() {

        return getContentAsStringLazy();
    }

    @Override
    public byte[] getContentAsByteArray() {

        return getContentAsBytesLazy();
    }

    @Override
    public ServletInputStream getInputStream() {

        return getWrappedInputStreamLazy();
    }

    private String getContentAsStringLazy() {

        if (this.contentAsString != null) {
            return this.contentAsString;
        }

        MediaType mediaType = MediaType.ALL;
        String contentType = getContentType();
        if (contentType != null) {
            mediaType = MediaType.valueOf(contentType);
        }

        if (MediaTypeUtils.isVisible(mediaType)) {
            Charset charset;
            if (Charset.isSupported(getCharacterEncoding())) {
                charset = Charset.forName(getCharacterEncoding());
            } else {
                charset = Charset.defaultCharset();
            }

            // Remove All Whitespace
            this.contentAsString = new String(getContentAsByteArray(), charset).replaceAll("(\r\n|\r|\n|\n\r|\\p{Z}|\\t)", "");
        } else {
            this.contentAsString = "*";
        }

        return this.contentAsString;
    }

    private byte[] getContentAsBytesLazy() {

        if (this.contentAsBytes != null) {
            return this.contentAsBytes;
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[1024];
            int count = super.getInputStream().read(buffer);
            while (-1 != count) {
                byteArrayOutputStream.write(buffer, 0, count);
                count = super.getInputStream().read(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.contentAsBytes = byteArrayOutputStream.toByteArray();

        return contentAsBytes;
    }

    private ServletInputStream getWrappedInputStreamLazy() {

        if (this.wrappedInputStream != null) {
            return wrappedInputStream;
        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(getContentAsByteArray());

        this.wrappedInputStream = new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return inputStream.read();
            }

            @Override
            public int read(byte[] b) throws IOException {
                return inputStream.read(b);
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };

        return this.wrappedInputStream;
    }
}
