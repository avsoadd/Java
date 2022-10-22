package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
public class DemoApplication {

	public static class Abc
	{
		public int score;
		public String name;

		public Abc() {

		}
	}

	public static Timer mTimer;

	public static TimerTask mTask = new TimerTask() {
		public void run(){
			  try( CloseableHttpClient httpClient = HttpClients.createDefault() ) {
					RequestConfig config = RequestConfig.custom()
							.setSocketTimeout(3000)
							.setConnectTimeout(3000)
							.build();
					HttpPost httpPost = new HttpPost("http://localhost:8080");

					Map<String, Object> map = new HashMap<>();
					Abc abc = new Abc();
					abc.score = 122;
					abc.name = "name";
					map.put("abc", abc);
					map.put("score", 122);
					map.put("name", "name");
					ObjectMapper objMapper = new ObjectMapper();
					String json = objMapper.writeValueAsString(map);
					StringEntity entity = new StringEntity(json, "UTF-8");
					httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");
					httpPost.setConfig(config);
					httpPost.setEntity(entity);

					try ( CloseableHttpResponse httpResponse = httpClient.execute(httpPost); ) {
						int statusCode = httpResponse.getStatusLine().getStatusCode();
						if( statusCode != HttpStatus.OK.value() ) {
							System.out.println("error:" + statusCode);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
			  }catch(Exception e) {
					e.printStackTrace();
			  }
		}
	};


	public static void main(String[] args) {
		mTimer = new Timer();
		mTimer.schedule(mTask, 1000);
		SpringApplication.run(DemoApplication.class, args);
	}

}
