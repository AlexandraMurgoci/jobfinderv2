package com.topspec.jobfinderv2.service;

import java.util.List;

public class CustomPageImpl<T> {
    private List<T> content;
    private Integer totalPages;
    private Long totalElements;

    public CustomPageImpl() {
    }

    public CustomPageImpl(List<T> content, Integer totalPages, Long totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }
}
