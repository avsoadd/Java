package testdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class TestdemoApplication {

	public static Timer mTimer;

	public static TimerTask mTask = new TimerTask() {

		public void run() {
			try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
				RequestConfig config = RequestConfig.custom()
						.setSocketTimeout(3000)
						.setConnectTimeout(3000)
						.build();
				HttpPost httpPost = new HttpPost("http://localhost:8080/test/" + "receive");

				Map<String, Object> map = new HashMap<>();
				UserInfo us = new UserInfo();
				int score = us.getScore();
				String name = us.getName();
				//map.put("score", 122);
				//map.put("name", "name");
				map.put("score", score);
				map.put("name", name);
				System.out.println("aaaaaaaaaaaa");
				ObjectMapper objMapper = new ObjectMapper();
				String json = objMapper.writeValueAsString(map);

				StringEntity entity = new StringEntity(json, "UTF-8");
				httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");
				httpPost.setConfig(config);
				httpPost.setEntity(entity);

				try (CloseableHttpResponse httpResponse = httpClient.execute(httpPost);) {
					if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	public static void main(String[] args) {
		//mTimer = new Timer();
		//mTimer.schedule(mTask, 5000);
		SpringApplication.run(TestdemoApplication.class, args);
		System.out.println("aaaaa");

	}

	//scoreをDBに登録する処理
	public void insertScore(int score) {

	}

}
