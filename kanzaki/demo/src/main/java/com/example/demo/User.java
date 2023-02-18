package com.example.demo;

import java.util.Random;

import lombok.Data;

@Data
public class User {

	private String name;

	private Integer age;

	private Integer userHand;

	private Integer npcHand;

	public String getUserhandString() {
		if (this.userHand == 1) {
			return "グー";
		} else if (this.userHand == 2) {
			return "チョキ";
		} else if (this.userHand == 3) {
			return "パー";
		} else {
			return "エラー";
		}
	}

	public String getNpchandString() {

		Random random = new Random();
		this.npcHand = random.nextInt(3)+1;

		if (this.npcHand == 1) {
			return "グー";
		} else if (this.npcHand == 2) {
			return "チョキ";
		} else if (this.npcHand == 3) {
			return "パー";
		} else {
			return "エラー";
		}
	}

    public String result(Integer userHand, Integer npcHand) {
        if (userHand == npcHand) {
            return "引き分け"; 
        } else if ((userHand == 1 && npcHand == 2) || (userHand == 2 && npcHand == 3) || (userHand == 3 && npcHand == 1)) {
            return "userの勝利";
        } else {
            return "npcの勝利"; 
        }
    }
}
