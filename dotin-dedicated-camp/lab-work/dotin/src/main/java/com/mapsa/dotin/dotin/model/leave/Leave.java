package com.mapsa.dotin.dotin.model.leave;

import com.mapsa.dotin.dotin.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Leave {
    private String id;
    private LeaveType leaveType;
    private String start;
    private String end;
    private User user;
}
