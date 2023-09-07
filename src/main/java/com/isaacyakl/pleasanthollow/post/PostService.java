package com.isaacyakl.pleasanthollow.post;

import java.util.List;
import java.util.UUID;

import com.isaacyakl.pleasanthollow.error.PostNotFoundException;

import jakarta.validation.Valid;

public interface PostService {
    Post createPost(Post post);

    Post fetchPostByUUID(UUID postUUID) throws PostNotFoundException;

    List<Post> fetchPosts();

    Post updatePost(UUID postUUID, @Valid Post postUpdate) throws PostNotFoundException;

    void deletePost(UUID postUUID) throws PostNotFoundException;
}
