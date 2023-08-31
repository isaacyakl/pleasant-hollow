package com.isaacyakl.pleasanthollow.entity.properties;

import com.isaacyakl.pleasanthollow.entity.Object;

import lombok.Data;

//@Entity
//@Table(name = "email_addresses")
@Data
public class EmailAddress extends Object {
    private String email;
    private Boolean isPrimary;
    private Boolean isVerified;
    private Boolean showOnProfile;
}
