package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(unique = true)
    private String email;
    private String password;
    private Boolean enable;

    @ManyToMany
    private List<Role> roles;

}
