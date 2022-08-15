package com.clone.soomgo.user.domain;


import com.clone.soomgo.category.model.CategoryGroups;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class UserCategory {

    @Id
    private Long CategoryId;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "code",referencedColumnName = "code")
    private CategoryGroups categoryGroups;

}
