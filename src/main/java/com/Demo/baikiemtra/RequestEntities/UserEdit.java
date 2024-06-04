package com.Demo.baikiemtra.RequestEntities;

import com.Demo.baikiemtra.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEdit {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthday;
    private boolean isDeleted;
    private Role role;
}