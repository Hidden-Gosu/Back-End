package com.clone.soomgo.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Getter
@Builder
@ToString
public class UserCommand {


    private final String username;
    private final String password;
    private final String email;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();

    }

}
