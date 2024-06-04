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
public class UserCreate {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthday;  // giữ nguyên kiểu dữ liệu String để dễ dàng xử lý trong dịch vụ
    private boolean isDeleted;  // đổi từ IsDeleted thành isDeleted
    private Role role;
}