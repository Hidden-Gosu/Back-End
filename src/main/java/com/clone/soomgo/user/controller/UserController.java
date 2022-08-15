package com.clone.soomgo.user.controller;

import com.clone.soomgo.comm.response.CommonResponse;
import com.clone.soomgo.security.UserDetailsImpl;
import com.clone.soomgo.user.domain.UserCommand;
import com.clone.soomgo.user.domain.UserInfo;
import com.clone.soomgo.user.dto.UserDto;
import com.clone.soomgo.user.domain.User;
import com.clone.soomgo.user.repository.UserRepository;
import com.clone.soomgo.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UserController {
    private final UserServiceImpl userService;


    @PostMapping(value = "/client")
    public CommonResponse clientSignup(@Valid @RequestBody UserDto.RegisterUserRequest request){
        UserCommand command = request.toCommand();
        userService.RegisterClient(command);
        return CommonResponse.success("ok");

    }

    @PostMapping("/pro")
    public void proSignup(){

    }

    @PostMapping("/info")
    public String userChk(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return userDetails.getUsername();
    }

}
