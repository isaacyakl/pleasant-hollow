package com.isaacyakl.pleasanthollow.post;

import java.util.List;
import java.util.UUID;

import com.isaacyakl.pleasanthollow.error.PostNotFoundException;

import jakarta.validation.Valid;

public interface PostService {
    public Post createPost(Post post);

    public Post fetchPostByUUID(UUID postUUID) throws PostNotFoundException;

    public List<Post> fetchPosts();

    public Post updatePost(UUID postUUID, @Valid Post postUpdate) throws PostNotFoundException;

    public void deletePost(UUID postUUID) throws PostNotFoundException;
}
