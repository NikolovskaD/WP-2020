/*
package com.ukim.finki.wp.chessshop.model;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Address extends AbstractPersistable<Long> {

    private static final long serialVersionUID = -4863536267672915815L;

    private String city;
    private String state;
    private String country;
    //we will create one transient field for userId
    private transient Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
*/
