package com.shoppingmall.controller;

import com.shoppingmall.dto.UserFormDto;
import com.shoppingmall.entity.User;
import com.shoppingmall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/new")
    public String userForm(Model model){
        model.addAttribute("userFormDto",new UserFormDto());
        return "user/userForm";
    }

    @PostMapping(value = "/new")
    public String userForm(UserFormDto userFormDto){
        User user = User.createUser(userFormDto, passwordEncoder);
        userService.saveUser(user);
        return "redirect:/";

    }
}
