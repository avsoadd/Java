package com.example.board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.repository.UserRepository;

import model.Users;

@Service
public class TestService {

    
	@Autowired
    private UserRepository userRepository;

    // ユーザーを保存するメソッド
    
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    // IDを使用してユーザーを取得するメソッド
    public List<Users> getUserById() {
        return userRepository.findAll();
    }

    // ユーザー名を使用してユーザーを取得するメソッドの例
    public List<Users> getUserByUsername(String user_name) {
        return userRepository.findByUserName(user_name);
    }

    // 他のビジネスロジックやメソッドも追加可能

}
