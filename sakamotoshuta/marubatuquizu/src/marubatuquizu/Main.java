package marubatuquizu;

public class Main
{
	public static char[][] banmen= {{'1','|','2','|','3'},
		{'-','-','-','-','-'},
		{'4','|','5','|','6'},
		{'-','-','-','-','-'},
		{'7','|','8','|','9'}};

	public static void main(String[] args){
		hyouzi v=new hyouzi();
		v.view(banmen);


		Playerturn t=new Playerturn();
		int[] q = t.player();
		//System.out.print(q[0]);

		if(banmen[q[0]][q[1] == 'o') {

				}

		banmen[q[0]][q[1]]='o';

		Npcturn npcturn=new Npcturn();
		int[] pc=npcturn.npc();
		//System.out.print(pc[0]);

		banmen[pc[0]][pc[1]]='x';

		v.view(banmen);
	}

}

