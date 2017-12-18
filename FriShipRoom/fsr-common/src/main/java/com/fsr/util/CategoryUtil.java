/*
package com.com.fsr.util;

import com.com.fsr.context.SpringContextHolder;
import com.com.fsr.service.CategoryService;
import com.com.fsr.domain.Category;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


*/
/**
 * Created by Hasee on 2017/5/11.
 *//*

@Service
public class CategoryUtil {
    private static CategoryUtil categoryUtil = new CategoryUtil();

    public static CategoryUtil getInstance() {
        return categoryUtil;
    }

    private Map categoryMap = new HashMap();

    private CategoryService categoryService;

    private CategoryUtil() {
        this.categoryService = (CategoryService) SpringContextHolder.getBean("categoryServiceImpl");
        init();
    }

    public void init(){
        List<Category> categories = categoryService.getAllCategories();
        if (null != categories && categories.size() > 0) {
            for(Category category: categories) {
                categoryMap.put(category.getId() + "", category.getCategory());
            }
        }
    }

    public String getCategoryById(String id) {
        return (null == categoryMap.get(id)) ? "" : categoryMap.get(id).toString();
    }
}
*/
