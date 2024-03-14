package com.management.product.model.service;

import com.common.SearchCondition;
import com.common.Template;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ProductService {

    private static ProductDAO productDAO;

    public List<ProductDTO> selectAllProductList() {

        SqlSession sqlSession = Template.getSqlSession();

        productDAO = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = productDAO.selectAllProductList();

        sqlSession.close();

        return productList;

    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {

        SqlSession sqlSession = Template.getSqlSession();

        productDAO = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = productDAO.selectProductByCondition(searchCondition);

        sqlSession.close();

        return productList;
    }

    public boolean registNewProduct(ProductDTO product) {

        SqlSession sqlSession = Template.getSqlSession();

        productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.insertProduct(product);

        boolean isTrue = false;

        if (result > 0) {
            isTrue = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return isTrue;
    }

    public boolean modifyProductInfo(ProductDTO product) {

        SqlSession sqlSession = Template.getSqlSession();

        productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.updateProduct(product);

        boolean isTrue = false;

        if (result > 0) {
            isTrue = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return isTrue;
    }

    public boolean deleteProduct(Map<String, String> parameter) {

        SqlSession sqlSession = Template.getSqlSession();

        productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.deleteProduct(parameter);

        boolean isTrue = false;

        if (result > 0) {
            isTrue = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return isTrue;
    }
}
