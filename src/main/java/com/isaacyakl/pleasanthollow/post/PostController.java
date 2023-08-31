// package com.isaacyakl.pleasanthollow.post;

// import java.util.Map;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.isaacyakl.pleasanthollow.Constants;

// import jakarta.servlet.http.HttpServletRequest;

// @RestController
// @RequestMapping(Constants.BASE_API_URL + "/post")
// public class PostController {
// @Autowired
// PostService postService;

// private final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

// @PostMapping("/create")
// public ResponseEntity<Post> createPost(HttpServletRequest request,
// @RequestBody Map<String, Object> postMap) {
// boolean isEnabled = (boolean) postMap.get("isEnabled"); // can be false if
// post is a draft
// String title = (String) postMap.get("title");
// String body = (String) postMap.get("body");
// Post post = postService.createPost(isEnabled, title, body);
// System.out.println(isEnabled + " " + title + " " + body);
// return new ResponseEntity<>(post, HttpStatus.CREATED);
// }
// }
