package com.trungthuc.domains;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;
    private String code;

    @ManyToMany
    @JoinTable(     name = "MEMBER_ROLE",
                    joinColumns = {@JoinColumn(name = "member_id",nullable = false) },
                    inverseJoinColumns = {@JoinColumn(name = "role_id",nullable = false) }
               )
    private List<Role> roles =new ArrayList<>();

}
