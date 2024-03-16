package com.example.board.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.dto.UserData;
import com.example.board.dto.UserListParam;
import com.example.board.repository.UserRepository;

import model.Users;


/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public UserListParam searchAll() {
    // ユーザー情報の取得
    List<Users> userList = userRepository.findAll();

    UserListParam userListParam = new UserListParam();
    List<UserData> list = new ArrayList<UserData>();

    // エンティティを画面データに詰め替える
    for(Users user : userList) {
      UserData data = new UserData();
      data.setAddress(user.getEmail());
      data.setName(user.getUserName());
      data.setId(user.getUserId());
      list.add(data);
    }

    userListParam.setUserDataList(list);

    return userListParam;
  }

  /**
   * ユーザー情報更新
   * @param param 画面パラメータ
   */
  public void updateAll(UserListParam param) {

    List<Users> userList = new ArrayList<Users>();

    // 画面パラメータをエンティティに詰め替える
    for (UserData data : param.getUserDataList()) {
      Users user = userRepository.findById(data.getId()).get(0);
      user.setEmail(data.getAddress());
      user.setUserName(data.getName());
      user.setUserId(data.getId());
      userList.add(user);
    }

    userRepository.saveAll(userList);

  }
}