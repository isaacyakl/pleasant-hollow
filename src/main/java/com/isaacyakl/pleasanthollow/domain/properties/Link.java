package com.isaacyakl.pleasanthollow.domain.properties;

import com.isaacyakl.pleasanthollow.domain.templates.Object;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "links")
public class Link extends Object {
    private String url;
    private String title;
    private Boolean showOnProfile;
}
