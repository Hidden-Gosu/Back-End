package com.clone.soomgo.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


@Getter
@RequiredArgsConstructor
@Builder
public class UserCommand {

    private final PasswordEncoder passwordEncoder;

    private final String username;
    private final String password;
    private final String email;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();

    }

}
