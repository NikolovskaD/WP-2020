package com.ukim.finki.wp.chessshop.repository;

import com.ukim.finki.wp.chessshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
