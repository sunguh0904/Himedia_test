package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private static CategoryPrint categoryPrint;

    private static CategoryService categoryService;

    public CategoryController() {

        categoryService = new CategoryService();
        categoryPrint = new CategoryPrint();
    }

    public void selectCategoryList(Map<String, String> parameter) {

        List<CategoryDTO> categoryDTOList = categoryService.selectCategoryList(parameter);

        if (categoryDTOList != null && categoryDTOList.size() > 0) {
            categoryPrint.printTeamList(categoryDTOList, parameter);
        }
    }

    public void registNewCategory(CategoryDTO category) {

        boolean isTrue = categoryService.registNewCategory(category);

        if (isTrue == true) {
            categoryPrint.printSuccessMessage("insert");
        } else {
            categoryPrint.printErrorMessage("insert");
        }
    }

    public void modifyCategoryName(CategoryDTO category) {

        boolean isTrue = categoryService.modifyCategoryName(category);

        if (isTrue == true) {
            categoryPrint.printSuccessMessage("update");
        } else {
            categoryPrint.printErrorMessage("update");
        }
    }

    public void deleteCategory(Map<String, String> parameter) {

        boolean isTrue = categoryService.deleteCategory(parameter);

        if (isTrue == true) {
            categoryPrint.printSuccessMessage("delete");
        } else {
            categoryPrint.printErrorMessage("delete");
        }
    }
}
