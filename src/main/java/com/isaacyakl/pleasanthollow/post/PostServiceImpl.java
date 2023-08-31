package com.isaacyakl.pleasanthollow.post;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaacyakl.pleasanthollow.error.PostNotFoundException;

import jakarta.validation.Valid;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post fetchPostByUUID(UUID postUUID) throws PostNotFoundException {
        Optional<Post> post = postRepository.findById(postUUID);
        if (!post.isPresent())
            throw new PostNotFoundException("Post with UUID " + postUUID + " not found.");
        return post.get();
    }

    @Override
    public List<Post> fetchPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(UUID postUUID, @Valid Post postUpdate) throws PostNotFoundException {
        Optional<Post> currentPost = postRepository.findById(postUUID);
        if (!currentPost.isPresent())
            throw new PostNotFoundException("Post with UUID " + postUUID + " not found.");
        Post updatedPost = currentPost.get();
        if (Objects.nonNull(postUpdate.getTitle()) && !"".equalsIgnoreCase(postUpdate.getTitle()))
            updatedPost.setTitle(postUpdate.getTitle());
        if (Objects.nonNull(postUpdate.getBody()) && !"".equalsIgnoreCase(postUpdate.getBody()))
            updatedPost.setBody(postUpdate.getBody());
        if (Objects.nonNull(postUpdate.getIsEnabled()))
            updatedPost.setIsEnabled(postUpdate.getIsEnabled());
        return postRepository.save(updatedPost);
    }

    @Override
    public void deletePost(UUID postUUID) throws PostNotFoundException {
        Optional<Post> post = postRepository.findById(postUUID);
        if (!post.isPresent())
            throw new PostNotFoundException("Post with UUID " + postUUID + " not found.");
        postRepository.deleteById(postUUID);
    }
}
