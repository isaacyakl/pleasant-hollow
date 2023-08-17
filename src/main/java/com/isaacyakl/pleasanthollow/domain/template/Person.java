package com.isaacyakl.pleasanthollow.domain.template;

import com.isaacyakl.pleasanthollow.domain.properties.EmailAddress;
import com.isaacyakl.pleasanthollow.domain.properties.MailingAddress;
import com.isaacyakl.pleasanthollow.domain.properties.PhoneNumber;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Person extends Object {
    private String firstName;
    private char[] middleInitial = new char[1];
    private String lastName;
    private String bio;
    private Date birthday;
    private EmailAddress[] emailAddresses;
    private PhoneNumber[] phoneNumbers;
    private MailingAddress mailingAddress;
}
