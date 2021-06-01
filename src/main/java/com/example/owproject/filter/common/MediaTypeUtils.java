package com.example.owproject.filter.common;

import org.springframework.http.MediaType;

import java.util.HashSet;

class MediaTypeUtils {

    private static HashSet<MediaType> VISIBLE_TYPES = new HashSet<MediaType>();

    static {
        VISIBLE_TYPES.add(MediaType.valueOf("text/*"));
        VISIBLE_TYPES.add(MediaType.valueOf("application/*+json"));
        VISIBLE_TYPES.add(MediaType.valueOf("application/*+xml"));
        VISIBLE_TYPES.add(MediaType.APPLICATION_FORM_URLENCODED);
        VISIBLE_TYPES.add(MediaType.APPLICATION_JSON);
        VISIBLE_TYPES.add(MediaType.APPLICATION_JSON_UTF8);
        VISIBLE_TYPES.add(MediaType.APPLICATION_XML);
        VISIBLE_TYPES.add(MediaType.MULTIPART_FORM_DATA);

    }

    public static boolean isVisible(MediaType mediaType) {
        return VISIBLE_TYPES.contains(mediaType);
    }
}
