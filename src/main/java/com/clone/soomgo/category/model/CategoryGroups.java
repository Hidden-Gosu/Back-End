package com.clone.soomgo.category.model;

import com.clone.soomgo.comm.converter.BooleanToYNConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "category_groups")
@Getter
@NoArgsConstructor
public class CategoryGroups {

    @Id
    @Column(nullable = false,unique = true,name = "code")
    private String code;

    @Column(nullable = false)
    private String parentCode;

    @Column(nullable = false)
    private String categoryName;

    @Column
    @Convert(converter = BooleanToYNConverter.class)
    private boolean hasParent;


}
