package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UranaiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getResult(int id) {

        // SELECT文
        String query = "SELECT "
                + "answer_tablecol "
                + "FROM answer_table "
                + "WHERE id=?";

        // 検索実行、mapで取得した値をModelクラスのインスタンスにセット
        Map<String, Object> map = jdbcTemplate.queryForMap(query, id);

        return (String)map.get("answer_tablecol");
    }
}