package com.clone.soomgo.user.domain;

import com.clone.soomgo.comm.util.TokenGenerator;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private static final String PREFIX_USER = "user_";
    private static final String PREFIX_PRO  = "pro_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name="user_token")
    private String userToken;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "pro_token")
    private String proToken;

    @Column(name = "category")
    @OneToMany(mappedBy = "userId",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<UserCategory> userCategories;

    @Enumerated(EnumType.STRING)
    private CurrentStatus currentStatus;


    @Getter
    @RequiredArgsConstructor
    public enum CurrentStatus{
        CLIENT("고객"),
        PRO("고수")
        ;

        private final String description;
    }

    // user 가입
    @Builder
    public User(String username, String password, String email){
        if(StringUtils.isEmpty(username)) throw new IllegalArgumentException("username은 필수값입니다.");
        if(StringUtils.isEmpty(password)) throw new IllegalArgumentException("password은 필수값입니다.");
        if(StringUtils.isEmpty(email)) throw new IllegalArgumentException("email은 필수값입니다.");

        this.userToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_USER);
        this.username=username;
        this.password = password;
        this.email=email;
        this.currentStatus = CurrentStatus.CLIENT;
    }

//    public User(
//        String username, String password
//    ){
//
//    }


    public void changeCurrClient(){
        this.currentStatus= CurrentStatus.CLIENT;
    }

    public void changeCurrPro(){
        this.currentStatus =CurrentStatus.PRO;
    }



}
