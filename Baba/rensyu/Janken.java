import java.util.Random;
import java.util.Scanner;

class Janken{
    public static void main(String[] args) {

        String imput_text = "";

        while(true){
            System.out.println("ここに入力してください");
            Scanner scanner = new Scanner(System.in,"ms932");
            imput_text = scanner.nextLine();
            String guu = "グー";
            if(imput_text.equals("グー") || imput_text.equals("チョキ") || imput_text.equals("パー")){
                break;
            }
            System.out.println("グー、チョキ、パーのいずれかを入力してください");
        }
        String[] aite = {"グー","チョキ","パー"};
        String[][] aite2 = {{"グー","チョキ"},
                            {"チョキ","パー"},
                            {"パー","グー"}};

        Random rand = new Random();
        int ransuu = rand.nextInt(2);

        if(aite[ransuu] == imput_text){
            System.out.println("あいこ");
        }
     for(int i = 0; i<aite2.length; i++){
        if(aite2[i][0].equals(aite[ransuu]) && aite2[i][1].equals(imput_text)){
            System.out.println("相手の勝ち");
            break;
        }
     }   
    }
}