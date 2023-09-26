package com.isaacyakl.pleasanthollow.api.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

import com.isaacyakl.pleasanthollow.api.entities.attributes.EmailAddress;
import com.isaacyakl.pleasanthollow.api.entities.attributes.MailingAddress;
import com.isaacyakl.pleasanthollow.api.entities.attributes.PhoneNumber;

@MappedSuperclass
@Data
public class Person extends Object {
    private String firstName;
    private char[] middleInitial = new char[1];
    private String lastName;
    private String bio;
    private Date dob;
    private EmailAddress[] emailAddresses;
    private PhoneNumber[] phoneNumbers;
    private MailingAddress mailingAddress;
}
