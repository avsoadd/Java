package board;

import java.util.Scanner;

public class BoardMain {
	private int board[][] = new int[8][8];
	private int put[] = new int[2]; 
	private int turn;
	private Boolean loopFlag = true;
	private static final int player1 = 1;
	private static final int player2 = 2;
	
	//�R�X�g���N�^
	public BoardMain() {
		for(int i=0; i<8; i++) {
			for(int j = 0; j < 8; j++) {
				board[i][j] = 0;
			}
		}
		board[3][3] = 1;
		board[4][4] = 1;
		board[3][4] = 2;
		board[4][3] = 2;
	}
	
	//�Q�[�����C��
	public void game() {
		turn = player1;
		
		while(turn != 0) {
			boardPrint();
			while(loopFlag) {
				putSelect();
				calcProcess();
				if(loopFlag) System.out.println("�����ɂ͒u���܂���");
			}
			endJudge();
			if(turn == player1) turn = player2;
			else if(turn == player2) turn = player1;
			loopFlag = true;
		}
	}
	
	//�{�[�h�`��
	public void boardPrint() {
		System.out.println();
		System.out.print("  ");
		for(int i = 0; i < 8; i++) System.out.print((i + 1) + " ");
		System.out.println();
		for(int i = 0; i < 8; i++) {
			System.out.print((i + 1) + " ");
			for(int j = 0; j < 8; j++) {
				if(board[i][j] == 1) System.out.print("�� ");
				else if(board[i][j] == 2) System.out.print("�� ");
				else System.out.print("  "); 
			}
			System.out.println();
		}
	}
	
	//�v���C���[�I��
	public void putSelect() {
		Boolean breakFlag = true;
		Scanner scanner = new Scanner(System.in);
		
		while(breakFlag) {
			try {
				System.out.println();
				System.out.println("�v���C���["+turn+"�̔Ԃł�");
				System.out.println("�ǂ��ɒu���܂����H (�� : [�c�ԍ�,���ԍ�])");
				System.out.print("> ");
				String tmp[] = scanner.next().split(",");
				put[0] = Integer.valueOf(tmp[0])-1;
				put[1] = Integer.valueOf(tmp[1])-1;
				breakFlag = false;
			}catch(Exception e) {
				System.out.println("���͂�����Ă��܂�");
			}
		}	
	}
	
	//�v�Z����
	public void calcProcess() {
		int enemy=0;
		
		if(turn == player1) enemy = player2;
		else if(turn == player2) enemy = player1;
		
		//��
		for(int i = 1; i < 8; i++) {
			if(put[1] - i == -1 || board[put[0]][put[1] - i] == 0) break;
			if(board[put[0]][put[1] - i] == enemy) continue;
			else if(board[put[0]][put[1] - i] == turn) {
				for(int j = 0; j < i; j++) {
					board[put[0]][put[1] - j] = turn;
				}
				loopFlag = false;
				break;
			}
		}
		//�E
		for(int i = 1; i < 8; i++) {
			if(put[1] + i == 8 || board[put[0]][put[1] + i] == 0) break;
			if(board[put[0]][put[1] + i] == enemy) continue;
			else if(board[put[0]][put[1] + i] == turn) {
				for(int j = 0; j < i; j++) {
					board[put[0]][put[1] + j] = turn;
				}
				loopFlag = false;
				break;
			}
		}
		//��
		for(int i = 1; i < 8; i++) {
			if(put[0] - i == -1 || board[put[0] - i][put[1]] == 0) break;
			if(board[put[0] - i][put[1]] == enemy) continue;
			else if(board[put[0] - i][put[1]] == turn) {
				for(int j = 0; j < i; j++) {
					board[put[0] - j][put[1]] = turn;
				}
				loopFlag = false;
				break;
			}
		}
		//��
		for(int i = 1; i < 8; i++) {
			if(put[0] + i == 8 || board[put[0] + i][put[1]] == 0) break;
			if(board[put[0] + i][put[1]] == enemy) continue;
			else if(board[put[0] + i][put[1]] == turn) {
				for(int j = 0; j < i; j++) {
					board[put[0] + j][put[1]] = turn;
				}
				loopFlag = false;
				break;
			}
		}
		//����
		for(int i = 1; i < 8; i++) {
			if(put[0] - i == -1 || put[1] - i == -1 || board[put[0] - i][put[1] - i] == 0) break;
			if(board[put[0] - i][put[1] - i] == enemy) continue;
			else if(board[put[0] - i][put[1] - i] == turn) {
				for(int j = 0; j < i; j++) {
					board[put[0] - j][put[1] - j] = turn;
				}
				loopFlag = false;
				break;
			}
		}
		//�E��
		for(int i = 1; i < 8; i++) {
			if(put[0] - i == -1 || put[1] + i == 8 || board[put[0] - i][put[1] + i] == 0) break;
			if(board[put[0] - i][put[1] + i] == enemy) continue;
			else if(board[put[0] - i][put[1] + i] == turn) {
				for(int j = 0; j < i; j++) {
					board[put[0] - j][put[1] + j] = turn;
				}
				loopFlag = false;
				break;
			}
		}
		//����
		for(int i = 1; i < 8; i++) {
			if(put[0] + i == 8 || put[1] - i == -1 || board[put[0] + i][put[1] - i] == 0) break;
			if(board[put[0] + i][put[1] - i] == enemy) continue;
			else if(board[put[0] + i][put[1] - i] == turn) {
				for(int j = 0; j < i; j++) {
					board[put[0] + j][put[1] - j] = turn;
				}
				loopFlag = false;
				break;
			}
		}
		//�E��
		for(int i = 1; i < 8; i++) {
			if(put[0] + i == 8 || put[1] + i == 8 || board[put[0] + i][put[1] + i] == 0) break;
			if(board[put[0] + i][put[1] + i] == enemy) continue;
			else if(board[put[0] + i][put[1] + i] == turn) {
				for(int j = 0; j < i; j++) {
					board[put[0] + j][put[1] + j] = turn;
				}
				loopFlag = false;
				break;
			}
		}
	}
	
	//�I������
	public void endJudge() {
		int p1 = 0, p2 = 0;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(board[i][j] == 0) return;
				if(board[i][j] == 1) p1++;
				if(board[i][j] == 2) p2++;
			}
		}
		
		boardPrint();
		turn = 0;
		
		System.out.println();
		System.out.println("�v���C���[1:" + p1 + " , �v���C���[2:" + p2);
		if(p1 > p2) System.out.println("�v���C���[1�������܂���!!");
		else if(p1 < p2) System.out.println("�v���C���[2�������܂���!!");
		else System.out.println("���������ł�!!");
	}
}
