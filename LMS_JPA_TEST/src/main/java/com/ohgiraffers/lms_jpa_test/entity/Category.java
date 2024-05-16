package com.ohgiraffers.lms_jpa_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;

    private String categoryName;
}
