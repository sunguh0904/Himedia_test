package com.ohgiraffers.hw2.model.comparator;

import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Comparator;

public class AscCategory implements Comparator<BookDTO> {

    public int compare(BookDTO b1, BookDTO b2) {
        return Integer.compare(b1.getbNo(), b2.getCategory());
    }
}
