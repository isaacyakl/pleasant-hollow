// package com.isaacyakl.pleasanthollow.post;

// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import lombok.Data;

// @Data
// @Service
// @Transactional
// public class PostServiceImpl implements PostService {
// @Autowired
// PostRepository postRepository;

// @Override
// public Post createPost(boolean isEnabled, String title, String body) {
// String description = "";
// UUID postId = postRepository.create(isEnabled, title, body, description);
// // return postRepository.findById(postId);
// }
// }
