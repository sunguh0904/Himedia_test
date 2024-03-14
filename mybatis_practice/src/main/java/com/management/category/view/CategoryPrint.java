package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        String option = parameter.get("option");

        switch (option) {
            case "allList":
                for (CategoryDTO category : categoryList) {
                    System.out.println(category);
                }
                System.out.println("====================================");
                System.out.println("전체 목록 조회"); break;
            case "orderList":
                for (CategoryDTO category : categoryList) {
                    System.out.println(category);
                }
                System.out.println("====================================");
                System.out.println("순위별 제품분류 조회"); break;
            default: break;
        }
    }

    public void printSuccessMessage(String successCode) {

        switch (successCode) {
            case "insert": System.out.println("추가 성공"); break;
            case "update": System.out.println("수정 성공"); break;
            case "delete": System.out.println("삭제 성공"); break;
        }
    }

    public void printErrorMessage(String errorCode) {

        switch (errorCode) {
            case "insert": System.out.println("추가 실패"); break;
            case "update": System.out.println("수정 실패"); break;
            case "delete": System.out.println("삭제 실패"); break;
        }
    }

}
