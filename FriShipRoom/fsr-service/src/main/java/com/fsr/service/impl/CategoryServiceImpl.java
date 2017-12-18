package com.fsr.service.impl;

import com.fsr.CategoryService;
import com.fsr.domain.Category;

import java.util.List;

import com.fsr.repository.mybatis.CategoryMapper;
import org.springframework.stereotype.Service;

/**
 * Created by Hasee on 2017/5/11.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategories() {
        return this.categoryMapper.getAllCategories();
    }
}
