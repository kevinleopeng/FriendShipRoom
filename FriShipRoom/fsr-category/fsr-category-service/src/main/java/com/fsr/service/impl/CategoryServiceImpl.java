package com.fsr.service.impl;

import com.fsr.domain.Category;
import com.fsr.repository.mybatis.CategoryMapper;
import com.fsr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategories() {
        return this.categoryMapper.getAllCategories();
    }

    public CategoryServiceImpl(){
        System.out.println("categoryservice init");
    }
}
