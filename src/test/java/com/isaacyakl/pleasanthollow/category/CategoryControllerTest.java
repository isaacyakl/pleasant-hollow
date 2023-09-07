package com.isaacyakl.pleasanthollow.category;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.isaacyakl.pleasanthollow.Constants;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {
        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private CategoryService categoryService;

        private final UUID TEST_CATEGORY_UUID = UUID.fromString("405c958a-ac6f-4822-b918-96b540d86d0f");
        private final UUID TEST_PARENT_CATEGORY_UUID = UUID.fromString("c65dc33a-1614-478a-88a8-b8ad6a187f89");

        private Category testCategory, testUpdateCategory;

        @BeforeEach
        void setUp() {
                testCategory = new Category(null, true, "Test Category", "A place for testing");
                testCategory.setId(TEST_CATEGORY_UUID);
                testUpdateCategory = new Category(TEST_PARENT_CATEGORY_UUID, false, "Test Category Updated",
                                "Updated description");
                testUpdateCategory.setId(TEST_CATEGORY_UUID);
        }

        @Test
        void whenCreateValidCategory_thenReturnCategory() throws Exception {
                Mockito.when(categoryService.createCategory(testCategory)).thenReturn(testCategory);
                mockMvc.perform(post(Constants.BASE_API_URL + "/categories")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\n" +
                                                "\t\"parentId\":null,\n" +
                                                "\t\"isEnabled\":true,\n" +
                                                "\t\"title\":\"Test Category\",\n" +
                                                "\t\"description\":\"A place for testing\"\n" +
                                                "}"))
                                .andExpect(status().isOk());
        }

        @Test
        void whenFetchByUUID_thenReturnCategory() throws Exception {
                Mockito.when(categoryService.fetchCategoryByUUID(TEST_CATEGORY_UUID)).thenReturn(testCategory);

                mockMvc.perform(get(Constants.BASE_API_URL + "/categories/" + TEST_CATEGORY_UUID))
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.id").value(TEST_CATEGORY_UUID.toString()))
                                .andExpect(jsonPath("$.title").value("Test Category"))
                                .andExpect(jsonPath("$.description").value("A place for testing"))
                                .andExpect(jsonPath("$.isEnabled").value(true));
        }

        @Test
        void whenUpdateCategoryByUUID_thenReturnCategory() throws Exception {
                Mockito.when(categoryService.updateCategory(TEST_CATEGORY_UUID, testUpdateCategory))
                                .thenReturn(testUpdateCategory);

                mockMvc.perform(put(Constants.BASE_API_URL + "/categories/" + TEST_CATEGORY_UUID)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\n" +
                                                "\t\"title\":\"Test Category Updated\",\n" +
                                                "\t\"description\":\"Updated Description\",\n" +
                                                "\t\"isEnabled\":false,\n" +
                                                "\t\"parentId\":\"" + TEST_PARENT_CATEGORY_UUID.toString() + "\"\n" +
                                                "}"))
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.id").value(TEST_CATEGORY_UUID.toString()))
                                .andExpect(jsonPath("$.parentId").value(TEST_PARENT_CATEGORY_UUID.toString()))
                                .andExpect(jsonPath("$.title").value("Test Category Updated"))
                                .andExpect(jsonPath("$.description").value("Updated description"))
                                .andExpect(jsonPath("$.isEnabled").value(false));
        }
}
