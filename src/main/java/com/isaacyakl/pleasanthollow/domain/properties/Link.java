package com.isaacyakl.pleasanthollow.domain.properties;

import com.isaacyakl.pleasanthollow.domain.template.Object;
import jakarta.persistence.Entity;

@Entity
public class Link extends Object {
    private String url;
    private String title;
    private Boolean showOnProfile;
}
