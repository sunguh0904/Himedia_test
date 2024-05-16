package com.ohgiraffers.lms_jpa_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_drink")
public class Drink {

    @Id
    private int drinkCode;

    private String drinkName;

    private int drinkPrice;
}
