package com.example.color;

import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@Data
public class ColorModel {
	private int birth;
	private String weather;
	private int colorR;
	private int colorG;
	private int colorB;

}
