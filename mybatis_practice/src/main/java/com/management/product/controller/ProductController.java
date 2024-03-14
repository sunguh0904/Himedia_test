package com.management.product.controller;

import com.common.SearchCondition;
import com.common.Template;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ProductController {

    private ProductService productService;

    private ProductPrint productPrint;

    public ProductController() {

        productService = new ProductService();

        productPrint = new ProductPrint();
    }

    public void selectAllProductList() {

        List<ProductDTO> productList = productService.selectAllProductList();

        if (productList != null) {
            productPrint.printAllProductList(productList);
            productPrint.printSuccessMessage("조회 " + "success");
        } else {
            productPrint.printErrorMessage("조회 " + "error");
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);

        if (productList != null) {
            productPrint.printProductList(productList, searchCondition);
            productPrint.printSuccessMessage("조회 " + "success");
        } else {
            productPrint.printErrorMessage("error");
        }
    }

    public void registNewProduct(ProductDTO product) {

        boolean isTrue = productService.registNewProduct(product);

        if (isTrue == true) {
            productPrint.printSuccessMessage("success");
        } else {
            productPrint.printErrorMessage("error");
        }
    }

    public void modifyProductInfo(ProductDTO product) {

        boolean isTrue = productService.modifyProductInfo(product);

        if (isTrue == true) {
            productPrint.printSuccessMessage("success");
        } else {
            productPrint.printErrorMessage("error");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {

        boolean isTrue = productService.deleteProduct(parameter);

        if (isTrue == true) {
            productPrint.printSuccessMessage( "success");
        } else {
            productPrint.printErrorMessage("error");
        }
    }
}
