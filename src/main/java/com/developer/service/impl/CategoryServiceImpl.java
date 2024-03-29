package com.developer.service.impl;

import com.developer.entity.Category;
import com.developer.repository.CategoryRepository;
import com.developer.service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryServiceImpl  implements CategoryServices {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Category tempCategory = categoryRepository.findById(id).get();
        if (null != tempCategory) {
            category.setId(id);
            return categoryRepository.save(category);
        }
            return null;
        }


    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

    }
}
