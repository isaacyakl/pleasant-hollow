package com.isaacyakl.pleasanthollow.post;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TestEntityManager entityManager;

    private UUID testUUID = null;
    private final UUID TEST_CATEGORY_UUID = UUID.fromString("405c958a-ac6f-4822-b918-96b540d86d0f");
    Post testPost;

    @BeforeEach
    void setUp() {
        testPost = new Post(null, true, "Test Post", "", TEST_CATEGORY_UUID, "Test Body");
        entityManager.persist(testPost);
        testUUID = testPost.getId();
    }

    @Test
    public void whenFindByUUID_thenReturnPost() {
        assertEquals(postRepository.findById(testUUID).get(), testPost);
    }
}
