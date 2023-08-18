package com.isaacyakl.pleasanthollow.domain.properties;

import com.isaacyakl.pleasanthollow.domain.templates.Object;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "mailing_addresses")
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
