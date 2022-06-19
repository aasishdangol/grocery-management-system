package com.developer.service;


import com.developer.entity.Category;

import java.util.List;

public interface CategoryServices {
    public List<Category> getAllCategory();

    public Category getCategory(Long id);

    public Category addCategory(Category category);

    public Category updateCategory(Category category,Long id);

    public void deleteCategory(Long id);

}
