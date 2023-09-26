package com.isaacyakl.pleasanthollow.api.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class SocialObject extends Object {
    private Integer viewCount;
    private Integer upvoteCount;
    private String upvoteTitle;
    private AccessEvent[] accessLog;
}
