package com.isaacyakl.pleasanthollow.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

import com.isaacyakl.pleasanthollow.entity.properties.EmailAddress;
import com.isaacyakl.pleasanthollow.entity.properties.MailingAddress;
import com.isaacyakl.pleasanthollow.entity.properties.PhoneNumber;

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
