package com.Demo.baikiemtra.Controller;

import com.Demo.baikiemtra.Entities.Role;
import com.Demo.baikiemtra.Entities.User;
import com.Demo.baikiemtra.RequestEntities.UserCreate;
import com.Demo.baikiemtra.RequestEntities.UserEdit;
import com.Demo.baikiemtra.Services.RoleService;
import com.Demo.baikiemtra.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "User/getAll";
    }

    @GetMapping("/add")
    public String addUserForm(Model model){
        UserCreate userCreate = new UserCreate();
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("user", userCreate);
        model.addAttribute("roles", roles);
        return "User/add";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") UserCreate userCreate){
        userService.createUser(userCreate);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable String id, Model model){
        User user = userService.getUserById(id);
        List<Role> roles = roleService.getAllRoles();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        UserEdit userEdit = new UserEdit(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                dateFormat.format(user.getBirthday()),
                user.isDeleted(),  // Sử dụng đúng getter cho boolean
                user.getRole()
        );
        model.addAttribute("user", userEdit);
        model.addAttribute("roles", roles);
        return "User/edit";
    }


    @PostMapping("/saveedit")
    public String saveUserEdit(@ModelAttribute("userEdit") UserEdit userEdit){
        userService.updateUser(userEdit);
        return "redirect:/users";
    }

    @GetMapping("/findemail")
    public String findUserByEmail(Model model){
        User user = userService.findUserByEmail("bm.toan@hutech.edu.vn");
        model.addAttribute("user", user);
        return "User/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}