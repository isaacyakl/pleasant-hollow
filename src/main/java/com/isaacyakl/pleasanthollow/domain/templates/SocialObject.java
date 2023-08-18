package com.isaacyakl.pleasanthollow.domain.templates;

import com.isaacyakl.pleasanthollow.domain.AccessEvent;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class SocialObject extends Object {
    private Integer viewCount;
    private Integer upvoteCount;
    private String upvoteTitle;
    private AccessEvent[] accessLog;
}
