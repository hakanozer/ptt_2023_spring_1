package com.works.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
// @AllArgsConstructor
// @NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(length = 100)
    private String name;

    @Column(length = 20)
    private String phone;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 500)
    private String password;

}
