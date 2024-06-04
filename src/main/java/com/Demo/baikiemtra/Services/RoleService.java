package com.Demo.baikiemtra.Services;

import com.Demo.baikiemtra.Entities.Role;
import com.Demo.baikiemtra.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(String id) {
        return roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy ID")
        );
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(String id, Role updatedRole) {
        Role existingRole = getRoleById(id);
        existingRole.setRole_name(updatedRole.getRole_name());
        return roleRepository.save(existingRole);
    }

    public void deleteRole(String id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Role với ID " + id + " không tồn tại.");
        }
    }
}