package com.ukim.finki.wp.chessshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.ukim.finki.wp.chessshop.model.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    //private String userId;

    @Id
    @NotNull
    @Column(length = 30)
    private String username;


    private String password;


    private String email;

    @Enumerated(EnumType.STRING) // za da se socuva vo bazata kako String
    private UserRole userRole = UserRole.UNDEFINED;


}
