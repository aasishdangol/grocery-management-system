package com.example.demo.service;


import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryServices {
    public List<Category> getAllCategory();

    public Category getCategory(Long id);

    public Category addCategory(Category category);

    public Category updateCategory(Category category,Long id);

    public void deleteCategory(Long id);

}
