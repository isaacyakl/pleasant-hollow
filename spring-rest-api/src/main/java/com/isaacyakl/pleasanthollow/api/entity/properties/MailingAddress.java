package com.isaacyakl.pleasanthollow.api.entity.properties;

import com.isaacyakl.pleasanthollow.api.entity.Object;

import lombok.Data;

//@Entity
//@Table(name = "mailing_addresses")
@Data
public class MailingAddress extends Object {
    private String street;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private Boolean isPrimary;
    private Boolean showOnProfile;
}
