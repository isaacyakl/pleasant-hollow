package com.isaacyakl.pleasanthollow.entity.properties;

import com.isaacyakl.pleasanthollow.entity.Object;

import lombok.Data;

//@Entity
//@Table(name = "links")
@Data
public class Link extends Object {
    private String url;
    private String title;
    private Boolean showOnProfile;
}
