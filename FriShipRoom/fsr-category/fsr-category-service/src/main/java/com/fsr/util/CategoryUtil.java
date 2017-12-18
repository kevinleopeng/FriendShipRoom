package com.fsr.util;

import com.fsr.context.SpringContextHolder;
import com.fsr.domain.Category;
import com.fsr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Hasee on 2017/5/11.
 */
@Service
public class CategoryUtil {
    private static CategoryUtil categoryUtil = new CategoryUtil();

    public static CategoryUtil getInstance() {
        return categoryUtil;
    }

    private Map categoryMap = new HashMap();

    private Map<String, Map> groupMap = new HashMap();

    private CategoryService categoryService;

    private CategoryUtil() {
        System.out.println("CategoryUtil init");
        this.categoryService = (CategoryService) SpringContextHolder.getBean("categoryServiceImpl");
        init();
    }

    public void init(){
        List<Category> categories = categoryService.getAllCategories();
        if (null != categories && categories.size() > 0) {
            for(Category category: categories) {
                categoryMap.put(category.getId() + "", category.getCategory());
                String key = category.getParentId() + "";
                Map itemMap = groupMap.containsKey(key) ? groupMap.get(key) : new HashMap();

                itemMap.put(category.getId(), category.getCategory());
                groupMap.put(key, itemMap);
            }

        }
    }

    public String getCategoryById(String id) {
        return (null == categoryMap.get(id)) ? "" : categoryMap.get(id).toString();
    }

    public Map getGroupMap() {
        return groupMap;
    }

    public Map getGroupMapByParentId(String parentId) {
        return (null == groupMap.get(parentId)) ? new HashMap() : groupMap.get(parentId);
    }
}
