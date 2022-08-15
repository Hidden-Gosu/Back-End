package com.clone.soomgo.user.service;

import com.clone.soomgo.user.domain.UserCommand;
import com.clone.soomgo.user.dto.UserDto;

public interface UserService {

    void RegisterClient(UserCommand request);
}
