package com.isaacyakl.pleasanthollow.api.category;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    private UUID testUUID = null;
    private final UUID TEST_PARENT_UUID = UUID.fromString("c65dc33a-1614-478a-88a8-b8ad6a187f89");
    Category testCategory;

    @BeforeEach
    void setUp() {
        testCategory = new Category(TEST_PARENT_UUID, true, "Test Category", "A place to test");
        entityManager.persist(testCategory);
        testUUID = testCategory.getId();
    }

    @Test
    public void whenFindByUUID_thenReturnCategory() {
        assertEquals(categoryRepository.findById(testUUID).get(), testCategory);
    }
}
