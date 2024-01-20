package com.example.po_projekt.service;

import com.example.po_projekt.entity.Category;
import com.example.po_projekt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private static long catId = 1;

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(long id){
        var value = categoryRepository.findById(id);
        return value.isEmpty()?null:value.get();
    }

    public void addCategory(Category category){
        category.setId(catId);
        categoryRepository.save(category);
        catId++;
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }
}
