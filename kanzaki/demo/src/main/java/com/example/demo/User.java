package com.example.demo;

import lombok.Data;

@Data
public class User {

    private String name;
	
    private Integer age;
    
    private Integer userhand;
    
    public String getUserhandString() {
        if (this.userhand == 1) {
            return "グー";
        } else if (this.userhand == 2) {
            return "チョキ";
        } else if (this.userhand == 3) {
            return "パー";
        } else {
            return "エラー";
        }
    }

}
