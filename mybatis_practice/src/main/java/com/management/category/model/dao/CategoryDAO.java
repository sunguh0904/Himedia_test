package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public interface CategoryDAO {


    List<CategoryDTO> selectCategoryList(Map<String, String> parameter);

    int insertCategory(CategoryDTO category);

    int updateCategory(CategoryDTO category);

    int deleteCategory(Map<String, String> parameter);
}
