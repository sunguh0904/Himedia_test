package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {


    public void printAllProductList(List<ProductDTO> allProductList) {

        for (ProductDTO product : allProductList) {
            System.out.println(product);
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        for (ProductDTO product : productList) {
            System.out.println(product);
        }
        System.out.println("===================================");
        System.out.println("검색 조건은: " + searchCondition + " 입니다.");
    }

    public void printSuccessMessage(String successCode) {

        switch (successCode) {
            case "success":
                System.out.println("===================================");
                System.out.println("성공"); break;
        }
    }

    public void printErrorMessage(String errorCode) {

        switch (errorCode) {
            case "error":
                System.out.println("===================================");
                System.out.println("실패"); break;
        }
    }

}
