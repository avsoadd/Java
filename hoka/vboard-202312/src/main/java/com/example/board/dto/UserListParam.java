package com.example.board.dto;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * ユーザー情報一覧画面用 データクラス
 */
@Data
public class UserListParam implements Serializable {

  /**
   * ユーザー情報リスト
   */

  private List<UserData> userDataList;

}