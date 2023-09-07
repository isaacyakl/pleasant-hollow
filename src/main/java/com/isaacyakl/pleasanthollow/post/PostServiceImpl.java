package com.isaacyakl.pleasanthollow.post;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaacyakl.pleasanthollow.error.PostNotFoundException;
import com.isaacyakl.pleasanthollow.Constants;

import jakarta.validation.Valid;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        Post validatedPost = post;
        // Make sure the view and upvote counts are set to defaults and not something
        // else that the client sends.
        validatedPost.setViewCount(Constants.DEFAULT_VIEW_COUNT);
        validatedPost.setUpvoteCount(Constants.DEFAULT_UPVOTE_COUNT);
        return postRepository.save(validatedPost);
    }

    @Override
    public Post fetchPostByUUID(UUID postUUID) throws PostNotFoundException {
        // View count should only be incremented by fetchPostByUUID calls
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
        // Title should not be editable by users
        /*
         * if (Objects.nonNull(postUpdate.getTitle()) &&
         * !"".equalsIgnoreCase(postUpdate.getTitle()))
         * updatedPost.setTitle(postUpdate.getTitle());
         */
        // Edit body
        if (Objects.nonNull(postUpdate.getBody()) && !"".equalsIgnoreCase(postUpdate.getBody()))
            updatedPost.setBody(postUpdate.getBody());
        // Edit isEnabled
        if (Objects.nonNull(postUpdate.getIsEnabled()))
            updatedPost.setIsEnabled(postUpdate.getIsEnabled());
        // Edit categoryId
        if (Objects.nonNull(postUpdate.getCategoryId()))
            updatedPost.setCategoryId(postUpdate.getCategoryId());
        // Upvotes should be updated using this method
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
