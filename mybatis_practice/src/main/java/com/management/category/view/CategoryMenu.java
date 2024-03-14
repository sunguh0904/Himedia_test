package com.management.category.view;

import com.management.category.controller.CategoryController;
import com.management.category.model.dto.CategoryDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CategoryMenu {

    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        CategoryController categoryController = new CategoryController();

        do {
            System.out.println("======= Product Category 관리 =======");
            System.out.println("제품분류 정보 관리 화면입니다.");
            System.out.println("====================================");
            System.out.println("1. 전체 제품분류 정보 조회");
            System.out.println("2. 주력 제품분류 순위 조회");
            System.out.println("3. 신규 제품분류 정보 등록");
            System.out.println("4. 제품분류명 수정");
            System.out.println("5. 판매부진 제품군 삭제");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("===================================");
            System.out.print("원하는 메뉴의 번호를 입력해 주세요 : ");
            int selectMenu = sc.nextInt();

            switch (selectMenu) {
                case 1 : categoryController.selectCategoryList(inputSelectOption(selectMenu)); break;
                case 2 : categoryController.selectCategoryList(inputSelectOption(selectMenu)); break;
                case 3 : categoryController.registNewCategory(inputNewCategoryInfo()); break;
                case 4 : categoryController.modifyCategoryName(inputModifyCategoryInfo()); break;
                case 5 : categoryController.deleteCategory(inputDeleteCategoryInfo()); break;
                case 9 : System.out.println("========상위 메뉴로 이동합니다.========"); return;
                default : System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요."); break;
            }

        } while(true);
    }

    private static Map<String, String> inputSelectOption(int selectNo) {
        Map<String, String> parameter = new HashMap<>();

        if(selectNo == 2) {
            parameter.put("option", "orderList");
        } else {
            parameter.put("option", "allList");
        }

        return parameter;
    }

    private static CategoryDTO inputNewCategoryInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("신설할 제품분류 정보를 입력하세요.");
        System.out.println("===================================");

        System.out.println("제품분류명을 입력해 주세요 : ");
        String categoryName = sc.nextLine();

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(categoryName);

        return categoryDTO;
    }

    private static CategoryDTO inputModifyCategoryInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("변경 대상 제품분류 코드를 입력해 주세요 : ");
        String categoryCode = sc.nextLine();
        System.out.println("변경할 제품분류명을 입력해 주세요 : ");
        String categoryName = sc.nextLine().toUpperCase();
        System.out.println("===================================");

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryCode(categoryCode);
        categoryDTO.setCategoryName(categoryName);

        return categoryDTO;
    }

    private static Map<String, String> inputDeleteCategoryInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("삭제할 제품분류 코드를 입력해 주세요 : ");
        String categoryCode = sc.nextLine();
        System.out.println("===================================");

        Map<String, String> parameter = new HashMap<>();
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }
}
