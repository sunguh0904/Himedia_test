package com.ohgiraffers.lms_jpa_test.repository;

import com.ohgiraffers.lms_jpa_test.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
