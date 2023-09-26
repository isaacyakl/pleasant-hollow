package com.isaacyakl.pleasanthollow.api.post;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaacyakl.pleasanthollow.api.Constants;
import com.isaacyakl.pleasanthollow.api.errors.PostNotFoundException;

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

    @Override
    public List<Post> fetchCategoryPosts(UUID categoryId) {
        List<Post> posts = postRepository.findByCategoryId(categoryId);
        return posts;
    }

    @Override
    public List<Post> findPostReplies(UUID parentId) {
        List<Post> posts = postRepository.findByParentId(parentId);
        return posts;
    }

}
