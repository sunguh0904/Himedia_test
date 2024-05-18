package com.ohgiraffers.lms_jpa_test.repository;

import com.ohgiraffers.lms_jpa_test.dto.DrinkDTO;
import com.ohgiraffers.lms_jpa_test.model.Drink;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
//    List<Drink> findByDrinkPriceGreaterThanEqual(Integer drinkPrice);
    List<Drink> findByDrinkPriceGreaterThanEqual(Integer drinkPrice, Sort sort);
}
