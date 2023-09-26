package com.isaacyakl.pleasanthollow.api.entities.attributes;

import com.isaacyakl.pleasanthollow.api.entities.Object;

import lombok.Data;

//@Entity
//@Table(name = "phone_numbers")
@Data
public class PhoneNumber extends Object {
    private String number;
    private Boolean isPrimary;
    private Boolean isVerified;
    private Boolean showOnProfile;
    private Boolean isSmsEnabled;
}
