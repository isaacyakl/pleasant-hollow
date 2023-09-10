package com.isaacyakl.pleasanthollow.api.user;

import com.isaacyakl.pleasanthollow.api.entity.Person;
import com.isaacyakl.pleasanthollow.api.entity.properties.Link;

import lombok.Data;

//@Entity
//@Table(name = "users")
@Data
public class User extends Person {
    // @Column(name = "display_name")
    private String displayName;
    private Link[] links;
    private UserSettings settings;

}
