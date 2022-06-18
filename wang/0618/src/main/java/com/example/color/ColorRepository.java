package com.example.color;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ColorRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getWeather(String weather) {

		// SELECT文
		String query = "SELECT "
				+ "number "
				+ "FROM weather_table "
				+ "WHERE weather=?";

		// 検索実行、mapで取得した値をModelクラスのインスタンスにセット
		Map<String, Object> map = jdbcTemplate.queryForMap(query, weather);

		return (int) map.get("number");
	}
}