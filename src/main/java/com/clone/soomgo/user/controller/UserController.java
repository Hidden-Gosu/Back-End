package com.clone.soomgo.user.controller;

import com.clone.soomgo.user.dto.SignupReqDto;
import com.clone.soomgo.user.model.User;
import com.clone.soomgo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/users/client")
    public User clientSignup(@Valid SignupReqDto signupReqDto){
      return userService.userSignup(signupReqDto);

    }

    @PostMapping("/users/pro")
    public void  proSignup(){

    }

}
