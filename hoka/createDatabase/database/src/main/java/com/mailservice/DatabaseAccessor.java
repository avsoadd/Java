package com.mailservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mailservice.repositories.UserInfoRepository;

@Repository
public class DatabaseAccessor implements UserInfoRepository {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getAll() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM database.test_table");
		// jdbcTemplate.execute("");
		return list;
	}

	@Override
	public String getUser() {
		// TODO 自動生成されたメソッド・スタブ
		Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM database.test_table");
		private String user = map("id");
		return ;
	}
}
