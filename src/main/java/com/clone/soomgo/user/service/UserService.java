package com.clone.soomgo.user.service;

import com.clone.soomgo.user.dto.SignupReqDto;
import com.clone.soomgo.user.model.User;
import com.clone.soomgo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User userSignup(SignupReqDto signupReqDto){

        String username = signupReqDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if(found.isPresent()){
            throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");
        }
        String password = passwordEncoder.encode(signupReqDto.getPassword());
        String email = signupReqDto.getEmail();

        User user = User.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();

        return userRepository.save(user);

    }
}
