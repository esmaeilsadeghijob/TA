package com.mapsa.dotin.dotin.viewModel;

import com.mapsa.dotin.dotin.model.leave.LeaveType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveViewModel {
    private String id;
    private LeaveType leaveType;
    private String start;
    private String end;
    private String userId;
}
