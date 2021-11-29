package com.mapsa.security.viewModel;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MapsaUserViewModel {
    private String username;
    private String password;
    private String email;
}
