package com.management.category.model.service;

import com.common.Template;
import com.management.category.model.dao.CategoryDAO;
import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.session.SqlSession;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryService {

    private static CategoryDAO categoryDAO;


    public List<CategoryDTO> selectCategoryList(Map<String, String> parameter) {

        SqlSession sqlSession = Template.getSqlSession();

        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        List<CategoryDTO> categoryDTOList = categoryDAO.selectCategoryList(parameter);

        sqlSession.close();

        return categoryDTOList;
    }

    public boolean registNewCategory(CategoryDTO category) {

        SqlSession sqlSession = Template.getSqlSession();

        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        int result = categoryDAO.insertCategory(category);

        boolean isTure = false;

        if (result > 0) {
            isTure = true;
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return isTure;
    }

    public boolean modifyCategoryName(CategoryDTO category) {

        SqlSession sqlSession = Template.getSqlSession();

        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        int result = categoryDAO.updateCategory(category);

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

    public boolean deleteCategory(Map<String, String> parameter) {

        SqlSession sqlSession = Template.getSqlSession();

        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        int result = categoryDAO.deleteCategory(parameter);

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
