package com.isaacyakl.pleasanthollow.domain.template;

import jakarta.persistence.Entity;

@Entity
public class SocialObject extends Object {
    private Integer viewCount;
    private Integer upvoteCount;
    private String upvoteTitle;
    private AccessEvent[] accessLog;
}
