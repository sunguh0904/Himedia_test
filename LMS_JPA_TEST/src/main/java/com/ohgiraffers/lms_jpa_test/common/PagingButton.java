package com.ohgiraffers.lms_jpa_test.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingButton {

    private int currentPage;

    private int startPage;

    private int endPage;

    public PagingButton() {
    }

    public PagingButton(int currentPage, int startPage, int endPage) {
        this.currentPage = currentPage;
        this.startPage = startPage;
        this.endPage = endPage;
    }
}
