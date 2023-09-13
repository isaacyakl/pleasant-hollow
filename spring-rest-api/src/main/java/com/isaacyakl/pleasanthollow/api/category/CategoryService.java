package com.isaacyakl.pleasanthollow.api.category;

import java.util.List;
import java.util.UUID;

import com.isaacyakl.pleasanthollow.api.error.CategoryNotFoundException;

import jakarta.validation.Valid;

public interface CategoryService {
    Category createCategory(Category category);

    Category fetchCategoryByUUID(UUID categoryUUID) throws CategoryNotFoundException;

    List<Category> fetchCategories();

    List<Category> fetchCategoryChildren(UUID parentId);

    Category updateCategory(UUID categoryUUID, @Valid Category categoryUpdate) throws CategoryNotFoundException;

    void deleteCategory(UUID categoryUUID) throws CategoryNotFoundException;
}
