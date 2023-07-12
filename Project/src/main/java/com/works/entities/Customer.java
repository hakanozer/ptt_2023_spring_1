package com.works.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
// @AllArgsConstructor
// @NoArgsConstructor
public class Customer extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Size(min = 2, max = 100)
    @NotEmpty
    @NotNull
    @Column(length = 100)
    private String name;

    @Size(min = 7, max = 20)
    @NotEmpty
    @NotNull
    @Column(length = 20)
    private String phone;

    @Email
    @NotEmpty
    @NotNull
    @Column(unique = true, length = 100)
    private String email;

    @Size(min = 5, max = 500)
    @NotEmpty
    @NotNull
    @Column(length = 500)
    private String password;

}
