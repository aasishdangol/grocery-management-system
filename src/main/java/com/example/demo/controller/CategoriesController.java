package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryServices;
import com.example.demo.util.ConstantValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/category")
public class CategoriesController {

    @Autowired
    private CategoryServices categoryServices;
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesController.class);

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/create")
    public String categoryAddForm(Model model){
        Category category = new Category();
        model.addAttribute("categoryTitle",  "Category Update");
        model.addAttribute("category", category);
        return "category/cate_addupdateform";
    }

    @GetMapping("/list")
    public String categorylist(Model model) throws JsonProcessingException {
        model.addAttribute("categoryList", categoryServices.getAllCategory());
        return "category/cate_list";
    }

    @PostMapping("/createorupdate")
    public String createCategory(Model model, Category category){
        if (category.getId() != null){
            categoryServices.updateCategory(category, category.getId());
        }else {
            category.setCategoryId(ConstantValue.generateCategoryId());
            category.setStatus("Active");
            category.setCreateDate(LocalDateTime.now().toString());
            categoryServices.addCategory(category);
        }

        return "redirect:/category/list";
    }


    @GetMapping("/update/{id}")
    public String updateCategoryForm(@PathVariable Long id, Model model){
        Category category = new Category();
        category = categoryServices.getCategory(id);
        model.addAttribute("category", category);
        model.addAttribute("categoryTitle",  "Category Update");
        return "category/cate_addupdateform";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryServices.deleteCategory(id);
        return "redirect:/category/list";
    }

}
