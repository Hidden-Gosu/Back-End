package com.clone.soomgo.user.service;

import com.clone.soomgo.user.domain.UserCommand;
import com.clone.soomgo.user.domain.User;
import com.clone.soomgo.user.dto.UserDto;
import com.clone.soomgo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void RegisterClient(UserCommand request) {
        String username = request.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if(found.isPresent()){
            throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");
        }
        User user = request.toEntity();
        userRepository.save(user);
    }
}
