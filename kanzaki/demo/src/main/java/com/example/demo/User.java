package com.example.demo;

import java.util.Random;

import lombok.Data;

@Data
public class User {
	private Integer userHand;

	private Integer npc1Hand;
	private Integer npc2Hand;

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

	public String getNpc1handString() {

		Random random = new Random();
		this.npc1Hand = random.nextInt(3) + 1;

		if (this.npc1Hand == 1) {
			return "グー";
		} else if (this.npc1Hand == 2) {
			return "チョキ";
		} else if (this.npc1Hand == 3) {
			return "パー";
		} else {
			return "エラー";
		}
	}

	public String getNpc2handString() {
		Random random = new Random();
		this.npc2Hand = random.nextInt(3) + 1;
		if (this.npc2Hand == 1) {
			return "グー";
		} else if (this.npc2Hand == 2) {
			return "チョキ";
		} else if (this.npc2Hand == 3) {
			return "パー";
		} else {
			return "エラー";
		}
	}

	public String result(Integer userHand, Integer npc1Hand, Integer npc2Hand) {
		switch (userHand) {
		case 1:
			if (userHand == npc1Hand) {
				if (npc2Hand == 3) {
					return "npc2の勝利";
				} else {
					return "引き分け";
				}
			} else if (userHand == npc2Hand) {
				if (npc1Hand == 3) {
					return "npc1の勝利";
				} else {
					return "引き分け";
				}
			} else if (npc1Hand == npc2Hand) {
				if (npc1Hand == 2) {
					return "userの勝利";
				} else {
					return "引き分け";
				}
			}
			break;
		case 2:
			if (userHand == npc1Hand) {
				if (npc2Hand == 1) {
					return "npc2の勝利";
				} else {
					return "引き分け";
				}
			} else if (userHand == npc2Hand) {
				if (npc1Hand == 1) {
					return "npc1の勝利";
				} else {
					return "引き分け";
				}
			} else if (npc1Hand == npc2Hand) {
				if (npc1Hand == 3) {
					return "userの勝利";
				} else {
					return "引き分け";
				}
			}
			break;
		case 3:
			if (userHand == npc1Hand) {
				if (npc2Hand == 2) {
					return "npc2の勝利";
				} else {
					return "引き分け";
				}
			} else if (userHand == npc2Hand) {
				if (npc1Hand == 2) {
					return "npc1の勝利";
				} else {
					return "引き分け";
				}
			} else if (npc1Hand == npc2Hand) {
				if (npc1Hand == 1) {
					return "userの勝利";
				} else {
					return "引き分け";
				}
			}
			break;
		default:
			return "未知";
		}
		return "引き分け";
	}
}
