package com.example.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    // ここにクエリメソッドやカスタムメソッドを定義することができます
    List<Users> findByUserName(String userName);
    
    List<Users> findById(int userId);
    
    
}