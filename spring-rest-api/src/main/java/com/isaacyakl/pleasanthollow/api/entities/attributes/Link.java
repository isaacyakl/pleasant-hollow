package com.isaacyakl.pleasanthollow.api.entities.attributes;

import com.isaacyakl.pleasanthollow.api.entities.Object;

import lombok.Data;

//@Entity
//@Table(name = "links")
@Data
public class Link extends Object {
    private String url;
    private String title;
    private Boolean showOnProfile;
}
