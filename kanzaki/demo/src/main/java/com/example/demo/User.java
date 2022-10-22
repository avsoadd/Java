package com.example.demo;


import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class User {
	@NotEmpty(message = "名前を入力してください")
    private String name;
	
    private Integer age;
}
