package com.Demo.baikiemtra.RequestEntities;

import com.Demo.baikiemtra.Entities.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleEdit {
    private String role_id;
    private String role_name;
}
