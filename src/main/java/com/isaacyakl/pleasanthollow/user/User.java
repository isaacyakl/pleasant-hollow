package com.isaacyakl.pleasanthollow.user;

import com.isaacyakl.pleasanthollow.entity.Person;
import com.isaacyakl.pleasanthollow.entity.properties.Link;

import lombok.Data;

//@Entity
//@Table(name = "users")
@Data
public class User extends Person {
    //    @Column(name = "display_name")
    private String displayName;
    private Link[] links;
    private UserSettings settings;

}
