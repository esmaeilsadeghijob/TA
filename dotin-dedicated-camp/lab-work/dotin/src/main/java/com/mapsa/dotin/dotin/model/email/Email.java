package com.mapsa.dotin.dotin.model.email;

import com.mapsa.dotin.dotin.model.user.User;

public class Email {
    private String receiverAddress;
    private String subject;
    private String body;
    private EmailStatus status;
    private User user;
}
