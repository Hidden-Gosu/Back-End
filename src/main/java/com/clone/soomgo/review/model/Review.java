package com.clone.soomgo.review.model;

import com.clone.soomgo.comm.exception.TimeStamped;
import com.clone.soomgo.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table (name = "review")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User user;

    @Column
    private String content;

}
