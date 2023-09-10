package com.isaacyakl.pleasanthollow.api.post;

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

import com.isaacyakl.pleasanthollow.api.error.PostNotFoundException;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @MockBean
    private PostRepository postRepository;

    private final UUID TEST_UUID = UUID.fromString("f3868551-293c-4ddb-9b07-2eb076b89510");
    private final UUID TEST_UPDATED_UUID = UUID.fromString("cb674568-f379-44eb-98ba-d3022f6cc2cf");
    private final UUID TEST_CATEGORY_UUID = UUID.fromString("405c958a-ac6f-4822-b918-96b540d86d0f");
    private Post testPost, testUpdatedPost;

    @BeforeEach
    void setUp() {
        testPost = new Post(null, true, "Test Post", "", TEST_CATEGORY_UUID, "Test Body");
        testUpdatedPost = new Post(null, true, "Updated Post", "", TEST_CATEGORY_UUID, "Updated Body");

        // Set the UUIDs for testing otherwise they are normally set by database
        testPost.setId(TEST_UUID);
        testUpdatedPost.setId(TEST_UPDATED_UUID);
        Mockito.when(postRepository.findById(TEST_UUID))
                .thenReturn(java.util.Optional.of(testPost));
        Mockito.when(postRepository.save(testPost)).thenReturn(testPost);
        Mockito.when(postRepository.findAll()).thenReturn(List.of(testPost));
        Mockito.when(postRepository.save(testUpdatedPost)).thenReturn(testUpdatedPost);
        doNothing().when(postRepository).deleteById(any(UUID.class));
    }

    @Test
    void whenCreateByValidPost_thenReturnPost() {
        Post returnedPost = postService.createPost(testPost);
        assertEquals(testPost, returnedPost);
    }

    @Test
    void whenFetchByValidPostUUID_thenReturnPost() throws PostNotFoundException {
        Post post = postService.fetchPostByUUID(TEST_UUID);
        assertEquals(TEST_UUID, post.getId());
    }

    @Test
    void whenFetchPosts_thenReturnPosts() {
        assertEquals(List.of(testPost), postService.fetchPosts());
    }

    @Test
    void whenUpdatePost_thenReturnPost() throws PostNotFoundException {
        assertEquals(testUpdatedPost, postService.updatePost(TEST_UUID, testUpdatedPost));
    }

    @Test
    void whenDeletePostValidPostUUID() {
        assertDoesNotThrow(() -> {
            postService.deletePost(TEST_UUID);
        });
    }
}
