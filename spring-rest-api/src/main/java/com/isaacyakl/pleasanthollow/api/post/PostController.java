package com.isaacyakl.pleasanthollow.api.post;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaacyakl.pleasanthollow.api.Constants;
import com.isaacyakl.pleasanthollow.api.error.PostNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping(Constants.BASE_API_URL + "/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@Valid @RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping("/{postUUID}")
    public Post readPost(@PathVariable("postUUID") UUID postUUID) throws PostNotFoundException {
        return postService.fetchPostByUUID(postUUID);
    }

    @GetMapping("/{postUUID}/replies")
    public List<Post> readPostReplies(@PathVariable("postUUID") UUID postUUID) throws PostNotFoundException {
        return postService.findPostReplies(postUUID);
    }

    @GetMapping
    public List<Post> readPosts() {
        return postService.fetchPosts();
    }

    @PutMapping("/{postUUID}")
    public Post updatePost(@PathVariable("postUUID") UUID postUUID, @RequestBody Post postUpdate)
            throws PostNotFoundException {
        return postService.updatePost(postUUID, postUpdate);
    }

    @DeleteMapping("/{postUUID}")
    public void deletePost(@PathVariable("postUUID") UUID postUUID) throws PostNotFoundException {
        postService.deletePost(postUUID);
    }
}
