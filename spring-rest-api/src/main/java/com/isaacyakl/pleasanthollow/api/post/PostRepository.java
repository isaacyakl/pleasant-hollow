package com.isaacyakl.pleasanthollow.api.post;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findByCategoryId(UUID categoryId);

    List<Post> findByParentId(UUID parentId);

}
