package com.mapsa.dotin.dotin.viewModel;

import com.mapsa.dotin.dotin.model.email.EmailStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailViewModel {
    private String receiverAddress;
    private String subject;
    private String body;
    private EmailStatus status;
    private String username;
    private String userId;
}
