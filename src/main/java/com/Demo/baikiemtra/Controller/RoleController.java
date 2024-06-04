package com.Demo.baikiemtra.Controller;

import com.Demo.baikiemtra.Entities.Role;
import com.Demo.baikiemtra.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String getAllRoles(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "Role/getAll";
    }

    @GetMapping("/new")
    public String addRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "Role/add";
    }

    @PostMapping("/save")
    public String saveRole(@ModelAttribute("role") Role role) {
        roleService.createRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String editRoleForm(@PathVariable String id, Model model) {
        Role role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "Role/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateRole(@PathVariable String id, @ModelAttribute("role") Role role) {
        roleService.updateRole(id, role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
        return "redirect:/roles";
    }
}