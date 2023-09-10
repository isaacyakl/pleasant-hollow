package com.isaacyakl.pleasanthollow.api.category;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.isaacyakl.pleasanthollow.api.error.CategoryNotFoundException;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    private final UUID TEST_CATEGORY_UUID = UUID.fromString("405c958a-ac6f-4822-b918-96b540d86d0f");
    private final UUID TEST_PARENT_CATEGORY_UUID = UUID.fromString("c65dc33a-1614-478a-88a8-b8ad6a187f89");

    private Category testCategory, testUpdateCategory;

    @BeforeEach
    void setUp() {
        testCategory = new Category(TEST_PARENT_CATEGORY_UUID, true, "Test Category", "Test Description");
        testUpdateCategory = new Category(TEST_PARENT_CATEGORY_UUID, true, "Updated Category", "Update Description");

        // Set the UUIDs for testing otherwise they are normally set by database
        testCategory.setId(TEST_CATEGORY_UUID);
        testUpdateCategory.setId(TEST_CATEGORY_UUID);
        Mockito.when(categoryRepository.findById(TEST_CATEGORY_UUID))
                .thenReturn(java.util.Optional.of(testCategory));
        Mockito.when(categoryRepository.save(testCategory)).thenReturn(testCategory);
        Mockito.when(categoryRepository.findAll()).thenReturn(List.of(testCategory));
        Mockito.when(categoryRepository.save(testUpdateCategory)).thenReturn(testUpdateCategory);
        doNothing().when(categoryRepository).deleteById(any(UUID.class));
    }

    @Test
    void whenCreateByValidCategory_thenReturnCategory() {
        Category returnedCategory = categoryService.createCategory(testCategory);
        assertEquals(testCategory, returnedCategory);
    }

    @Test
    void whenFetchByValidCategoryUUID_thenReturnCategory() throws CategoryNotFoundException {
        Category category = categoryService.fetchCategoryByUUID(TEST_CATEGORY_UUID);
        assertEquals(TEST_CATEGORY_UUID, category.getId());
    }

    @Test
    void whenFetchCategories_thenReturnCategories() {
        assertEquals(List.of(testCategory), categoryService.fetchCategories());
    }

    @Test
    void whenUpdateCategory_thenReturnPost() throws CategoryNotFoundException {
        assertEquals(testUpdateCategory, categoryService.updateCategory(TEST_CATEGORY_UUID, testUpdateCategory));
    }

    @Test
    void whenDeleteCategoryValidPostUUID() {
        assertDoesNotThrow(() -> {
            categoryService.deleteCategory(TEST_CATEGORY_UUID);
        });
    }

}
