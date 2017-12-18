package com.fsr.repository.mybatis;


import com.fsr.domain.Category;
import com.fsr.repository.CategoryRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface CategoryMapper extends CategoryRepository {
    @Override
    List<Category> getAllCategories();
}
