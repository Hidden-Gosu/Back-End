package com.clone.soomgo.security.provider;


import com.clone.soomgo.security.UserDetailsImpl;
import com.clone.soomgo.security.jwt.JwtDecoder;
import com.clone.soomgo.security.jwt.JwtPreProcessingToken;
import com.clone.soomgo.user.domain.User;
import com.clone.soomgo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class JWTAuthProvider implements AuthenticationProvider {

    private final JwtDecoder jwtDecoder;

    private final UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String token = (String) authentication.getPrincipal();
        String username = jwtDecoder.decodeUsername(token);
        log.info("token , username ={}{}",token,username);
        // TODO: API 사용시마다 매번 User DB 조회 필요
        //  -> 해결을 위해서는 UserDetailsImpl 에 User 객체를 저장하지 않도록 수정
        //  ex) UserDetailsImpl 에 userId, username, role 만 저장
        //    -> JWT 에 userId, username, role 정보를 암호화/복호화하여 사용
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + username));;
        UserDetailsImpl userDetails = new UserDetailsImpl(user);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtPreProcessingToken.class.isAssignableFrom(authentication);
    }
}