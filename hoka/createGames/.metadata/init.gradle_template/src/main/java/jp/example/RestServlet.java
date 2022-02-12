package jp.example;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class RestServlet extends HttpServlet {

	private final ObjectMapper json = new JsonMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/json; charset=UTF-8");
		json.writeValue(res.getWriter(), List.of("ハローワールド", new Date()));
	}
}
