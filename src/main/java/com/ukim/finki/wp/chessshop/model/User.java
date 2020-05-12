/*
package com.ukim.finki.wp.chessshop.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@Entity
public class User extends AbstractPersistable<Long> {
    private static final long serialVersionUID = -7302800336276816169L;
    private String userId;
    private String userName;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(targetEntity = Address.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> addresses;

}
*/
