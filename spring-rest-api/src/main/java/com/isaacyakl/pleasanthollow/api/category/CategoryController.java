package com.isaacyakl.pleasanthollow.api.category;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaacyakl.pleasanthollow.api.Constants;
import com.isaacyakl.pleasanthollow.api.error.CategoryNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping(Constants.BASE_API_URL + "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/{categoryUUID}")
    public Category readCategory(@PathVariable("categoryUUID") UUID categoryUUID) throws CategoryNotFoundException {
        return categoryService.fetchCategoryByUUID(categoryUUID);
    }

    @GetMapping
    public List<Category> readCategories() {
        return categoryService.fetchCategories();
    }

    @PutMapping("/{categoryUUID}")
    public Category updateCategory(@PathVariable("categoryUUID") UUID categoryUUID,
            @RequestBody Category categoryUpdate)
            throws CategoryNotFoundException {
        return categoryService.updateCategory(categoryUUID, categoryUpdate);
    }

    @DeleteMapping("/{categoryUUID}")
    public void deleteCategory(@PathVariable("categoryUUID") UUID categoryUUID) throws CategoryNotFoundException {
        categoryService.deleteCategory(categoryUUID);
    }
}
