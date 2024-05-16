package com.ohgiraffers.lms_jpa_test.repository;

import com.ohgiraffers.lms_jpa_test.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
}
