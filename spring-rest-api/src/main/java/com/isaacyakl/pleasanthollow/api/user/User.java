package com.isaacyakl.pleasanthollow.api.user;

import com.isaacyakl.pleasanthollow.api.entities.Person;
import com.isaacyakl.pleasanthollow.api.entities.attributes.Link;

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
