package com.ohgiraffers.lms_jpa_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DrinkDTO {

    private int drinkCode;
    private String drinkName;
    private int drinkPrice;
    private int categoryCode;

    public DrinkDTO() {}
}
