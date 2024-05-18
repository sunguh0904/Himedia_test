package com.ohgiraffers.lms_jpa_test.repository;

import com.ohgiraffers.lms_jpa_test.dto.CategoryDTO;
import com.ohgiraffers.lms_jpa_test.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT C.* FROM tbl_category C ORDER BY C.CATEGORY_CODE", nativeQuery = true)
    List<Category> findAllCategory();
}
