package com.example.board.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * ユーザー情報
 */
@Data
public class UserData implements Serializable {

  /**
   * ID
   */
  private int id;
  /**
   * 名前
   */
  private String name;

  /**
   * メールアドレス
   */
  private String address;

}
