package game.view;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class gameRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertName(String name) {

		// INSERT文
		String insert = "INSERT INTO game_info(name) "
				+ "VALUES(?)";
		jdbcTemplate.update(insert, name);

	}

	public int getTicket(String name) {
		// SELECT文
		String query = "SELECT "
				+ "ticket "
				+ "FROM game_info "
				+ "WHERE name=?";

		// 検索実行、mapで取得した値をModelクラスのインスタンスにセット
		Map<String, Object> map = jdbcTemplate.queryForMap(query, name);
		return (int) map.get("ticket");
	}
}