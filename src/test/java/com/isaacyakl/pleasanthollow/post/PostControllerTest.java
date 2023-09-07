package com.isaacyakl.pleasanthollow.post;

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

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    private final UUID TEST_UUID = UUID.fromString("f3868551-293c-4ddb-9b07-2eb076b89510");
    private final UUID TEST_CATEGORY_UUID = UUID.fromString("405c958a-ac6f-4822-b918-96b540d86d0f");

    private Post testPost, testUpdatePost;

    @BeforeEach
    void setUp() {
        testPost = new Post(null, true, "Test Post", "", TEST_CATEGORY_UUID, "Test Body");
        testPost.setId(TEST_UUID);
        testUpdatePost = new Post(null, false, "Updated Post", "", TEST_CATEGORY_UUID, "Updated Body");
        testUpdatePost.setId(TEST_UUID);
    }

    @Test
    void whenCreateValidPost_thenReturnPost() throws Exception {
        Mockito.when(postService.createPost(testPost)).thenReturn(testPost);
        mockMvc.perform(post(Constants.BASE_API_URL + "/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"title\":\"Test Post\",\n" +
                        "\t\"body\":\"Test Body\",\n" +
                        "\t\"parentId\":null,\n" +
                        "\t\"isEnabled\":true,\n" +
                        "\t\"categoryId\":\"405c958a-ac6f-4822-b918-96b540d86d0f\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void whenFetchByUUID_thenReturnPost() throws Exception {
        Mockito.when(postService.fetchPostByUUID(TEST_UUID)).thenReturn(testPost);

        mockMvc.perform(get(Constants.BASE_API_URL + "/posts/" + TEST_UUID))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(TEST_UUID.toString()))
                .andExpect(jsonPath("$.title").value("Test Post"))
                .andExpect(jsonPath("$.body").value("Test Body"))
                .andExpect(jsonPath("$.isEnabled").value(true));
    }

    @Test
    void whenUpdatePostByUUID_thenReturnPost() throws Exception {
        Mockito.when(postService.updatePost(TEST_UUID, testUpdatePost)).thenReturn(testUpdatePost);

        mockMvc.perform(put(Constants.BASE_API_URL + "/posts/" + TEST_UUID)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"title\":\"Updated Post\",\n" +
                        "\t\"body\":\"Updated Body\",\n" +
                        "\t\"isEnabled\":false\n" +
                        "}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(TEST_UUID.toString()))
                .andExpect(jsonPath("$.title").value("Updated Post"))
                .andExpect(jsonPath("$.body").value("Updated Body"))
                .andExpect(jsonPath("$.isEnabled").value(false));
    }
}
