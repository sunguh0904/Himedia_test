package com.ohgiraffers.lms_jpa_test.common;

import org.springframework.data.domain.Page;

public class Pagenation {

    public static PagingButton getPagingButtonInfo(Page page) {
        /* getNumber: 현재 페이지 반환, 0부터 시작 */
        int currentPage = page.getNumber() + 1;
        /* 기본 페이지 개수? */
        int defaultButtonCount = 5;
        /* 시작 페이지 설정 */
        int startPage
                = (int) (Math.ceil((double) currentPage / defaultButtonCount) - 1)
                * defaultButtonCount + 1;
        int endPage = startPage + defaultButtonCount - 1;
        if (page.getTotalPages() < endPage) endPage = page.getTotalPages();
        if (page.getTotalPages() == 0 && endPage == 0) endPage = startPage;
        return new PagingButton(currentPage, startPage, endPage);
    }
}
