package com.clone.soomgo.user.dto;


import com.clone.soomgo.user.domain.UserCommand;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



public class UserDto {


    @Getter
    @Setter
    @ToString
    public static class RegisterUserRequest{
        @NotBlank(message = "이름은 필수항목입니다.")
        @Length(min = 2,max = 7,message = "이름은 2~7자리 입니다.")
        private String username;
        @NotBlank(message = "비밀번호는 필수 항목입니다.")
        @Length(min = 4,max = 8,message = "비밀번호는 4~8자리 입니다..")
        private String password;
        @NotBlank(message = "이메일은 필수항목입니다.")
        @Email(message = "email 형식에 맞아야 합니다")
        private String email;


        public UserCommand toCommand(){
            return UserCommand.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .build();

        }

    }
    public class RegisterUserResponse{

    }



}
