package com.clone.soomgo.user.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
public class UserInfo {

    private final Long userId;
    private final String userToken;
    private final String username;
    private final String password;
    private final String email;
    private final String proToken;
    private final List<UserCategory> userCategories;
    private final User.CurrentStatus currentStatus;


    public UserInfo(User user){
        this.userId=user.getUserId();
        this.userToken = user.getUserToken();
        this.username = user.getUsername();
        this.password=user.getPassword();
        this.email=user.getEmail();
        this.proToken=user.getProToken();
        this.userCategories=user.getUserCategories();
        this.currentStatus=user.getCurrentStatus();
    }


}
