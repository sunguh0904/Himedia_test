package com.ohgiraffers.lms_jpa_test.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryDTO {

    private int categoryCode;
    private String categoryName;

    public CategoryDTO() {}

    public CategoryDTO(int categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }
}
