package com.works.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @Column(unique = true)
    private String username;
    private String password;

}
