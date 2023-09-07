package com.isaacyakl.pleasanthollow.category;

import java.util.List;
import java.util.UUID;

import com.isaacyakl.pleasanthollow.error.CategoryNotFoundException;

import jakarta.validation.Valid;

public interface CategoryService {
    Category createCategory(Category category);

    Category fetchCategoryByUUID(UUID categoryUUID) throws CategoryNotFoundException;

    List<Category> fetchCategories();

    Category updateCategory(UUID categoryUUID, @Valid Category categoryUpdate) throws CategoryNotFoundException;

    void deleteCategory(UUID categoryUUID) throws CategoryNotFoundException;
}
