package main;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//キーボード入力からユーザの出し手を決める
		int User = getUser();

		//コンピュータの出し手の設定
		int pc =getPc();

		//勝敗の判定　
		String result =judgeJanken(User,pc);
		do {

		}while(result !="あいこ");

		//結果を表示する
		ShowResult(User,pc,result);
	}
	public static int getUser() {
		//キーボード入力
		Scanner stdin =new Scanner(System.in);

		//以下ループ
		while(true) {
			//最初のメッセージ
			System.out.println("自身の出し手を決定してください");
			System.out.print("(グー：0,チョキ：1,パー：2)：");

			//入力値のチェック
			if(stdin.hasNextInt()) {
				// 入力されたデータを整数として読み込む
				int number = stdin.nextInt();
				// 整数でも有効なのは「0，1，2」のみ
				if(number<=-1 || number >=3) {
					// 範囲外は無効なデータなのでやり直し
					System.out.println("【エラー】入力できるのは「0～2」です");
					continue;
				}else {
					// 0,1,2の場合、メソッドの結果として返す
					return number;
				}
			}else {
				// 整数以外の場合、無効なデータなのでやり直し
				System.out.println("【エラー】入力できるのは整数だけです");
				// 不要なトークンをバッファから取り除く
				stdin.next();
			}
		}
	}

	//CPUの出し手の決定
	public static int getPc() {
		Random rand = new Random();
		return rand.nextInt(3);
	}

	//じゃんけん結果表示
	public static String judgeJanken(int user,int pc) {
		String result="";

		//判別
		if((user==0 && pc==1)||(user==1 && pc==2)||(user==2 && pc==3)) {
			result="ユーザの勝ち";
		}else if((user==0 && pc==2)||(user==1 && pc==0)||(user==2 && pc==1)) {
			result="ユーザの負け";
		}else {
			result="あいこ";								//あいこの場合、もう一度出し手を決める

		}

		//勝敗を表示（返り値として出力）
		return result;
	}
	 public static void ShowResult(int User,int pc,String result) {
		 //引数の"User"と"pc"の数値を配列に紐づける
		 String[] janken = {"グー","チョキ","パー"};
		 //結果表示
		 System.out.println("最終的なユーザの出し手は"+janken[User]+"、CPUの出し手は"+janken[pc]+"。");
		 System.out.println("結果は「"+result+"」でした");
		 if(result=="ユーザの勝ち") {
			 System.out.println("おめでとう!");
		 }else {
			 System.out.println("ドンマイ!");
		 }
	 }

}
