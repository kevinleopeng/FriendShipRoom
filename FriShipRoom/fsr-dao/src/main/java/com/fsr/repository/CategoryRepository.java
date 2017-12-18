package com.fsr.repository;


import com.fsr.domain.Category;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface CategoryRepository {
    List<Category> getAllCategories();
}
