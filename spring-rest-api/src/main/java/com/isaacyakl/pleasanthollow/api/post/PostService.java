package com.isaacyakl.pleasanthollow.api.post;

import java.util.List;
import java.util.UUID;

import com.isaacyakl.pleasanthollow.api.errors.PostNotFoundException;

import jakarta.validation.Valid;

public interface PostService {
    Post createPost(Post post);

    Post fetchPostByUUID(UUID postUUID) throws PostNotFoundException;

    List<Post> fetchPosts();

    List<Post> fetchCategoryPosts(UUID categoryId);

    List<Post> findPostReplies(UUID parentId);

    Post updatePost(UUID postUUID, @Valid Post postUpdate) throws PostNotFoundException;

    void deletePost(UUID postUUID) throws PostNotFoundException;
}
