package com.clone.soomgo.user.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class SignupReqDto {

    @NotBlank(message = "이름은 필수항목입니다.")
    @Length(min = 2,max = 7,message = "이름은 2~7자리 입니다.")
    private String username;
    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    @Length(min = 4,max = 8,message = "비밀번호는 4~8자리 입니다..")
    private String password;
    @NotBlank(message = "이메일은 필수항목입니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

}
