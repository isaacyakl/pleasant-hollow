package com.isaacyakl.pleasanthollow.api.category;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaacyakl.pleasanthollow.api.Constants;
import com.isaacyakl.pleasanthollow.api.error.CategoryNotFoundException;

import jakarta.validation.Valid;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        Category validCategory = category;
        // Make sure the view counts are set to defaults and not something else that the
        // client sends.
        validCategory.setViewCount(Constants.DEFAULT_VIEW_COUNT);
        return categoryRepository.save(validCategory);
    }

    @Override
    public Category fetchCategoryByUUID(UUID categoryUUID) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findById(categoryUUID);
        if (!category.isPresent())
            throw new CategoryNotFoundException("Category with UUID " + categoryUUID + " not found.");
        return category.get();
    }

    @Override
    public List<Category> fetchCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(UUID categoryUUID, @Valid Category categoryUpdate) throws CategoryNotFoundException {
        Optional<Category> currentCategory = categoryRepository.findById(categoryUUID);
        if (!currentCategory.isPresent())
            throw new CategoryNotFoundException("Category with UUID " + categoryUUID + " not found.");
        Category updatedCategory = currentCategory.get();
        // Edit description
        if (Objects.nonNull(categoryUpdate.getDescription()) && !"".equalsIgnoreCase(categoryUpdate.getDescription()))
            updatedCategory.setDescription(categoryUpdate.getDescription());
        // Edit parentId
        if (Objects.nonNull(categoryUpdate.getParentId()))
            updatedCategory.setParentId(categoryUpdate.getParentId());
        // Edit title
        if (Objects.nonNull(categoryUpdate.getTitle()) &&
                !"".equalsIgnoreCase(categoryUpdate.getTitle()))
            updatedCategory.setTitle(categoryUpdate.getTitle());
        // Edit isEnabled
        if (Objects.nonNull(categoryUpdate.getIsEnabled()))
            updatedCategory.setIsEnabled(categoryUpdate.getIsEnabled());
        return categoryRepository.save(updatedCategory);
    }

    @Override
    public void deleteCategory(UUID categoryUUID) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findById(categoryUUID);
        if (!category.isPresent())
            throw new CategoryNotFoundException("Category with UUID " + categoryUUID + " not found.");
        categoryRepository.deleteById(categoryUUID);
    }

    @Override
    public List<Category> fetchCategoryChildren(UUID parentId) {
        return categoryRepository.findByParentId(parentId);
    }

}
