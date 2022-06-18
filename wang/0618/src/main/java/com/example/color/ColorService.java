package com.example.color;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//r,gを受け取る　bを生成
//"r,g,b"の文字列をreturn

@Service
public class ColorService {

	@Autowired
	private ColorRepository repository;

	public String getColor(int r, String w) {
		Random random = new Random();
		int ran = random.nextInt(60);

		ColorModel model = new ColorModel();
		model.setWeather(w);
		int g = repository.getWeather(model.getWeather());
		model.setColorR(r % 256);
		model.setColorG((g * ran) % 256);
		model.setColorB((int) System.currentTimeMillis() % 256);

		String colorCode = model.getColorR() + "," + model.getColorG() + "," + model.getColorB();

		return colorCode;
	}
}
