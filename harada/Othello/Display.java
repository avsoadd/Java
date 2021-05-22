
import java.util.ArrayList;
import java.util.List;

// 表示クラス
public class Display
{
	// 盤面表示
	public static void showDisplay(Def.KOMATYPE[] field)
	{
		if(null == field)
		{
			return;
		}

		String[] strList = {
			"｜０　｜１　｜２　｜３　｜４　｜５　｜６　｜７　｜",
			"－－－－－－－－－－－－－－－－－－－－－－－－－",
			"｜８　｜９　｜１０｜１１｜１２｜１３｜１４｜１５｜",
			"－－－－－－－－－－－－－－－－－－－－－－－－－",
			"｜１６｜１７｜１８｜１９｜２０｜２１｜２２｜２３｜",
			"－－－－－－－－－－－－－－－－－－－－－－－－－",
			"｜２４｜２５｜２６｜２７｜２８｜２９｜３０｜３１｜",
			"－－－－－－－－－－－－－－－－－－－－－－－－－",
			"｜３２｜３３｜３４｜３５｜３６｜３７｜３８｜３９｜",
			"－－－－－－－－－－－－－－－－－－－－－－－－－",
			"｜４０｜４１｜４２｜４３｜４４｜４５｜４６｜４７｜",
			"－－－－－－－－－－－－－－－－－－－－－－－－－",
			"｜４８｜４９｜５０｜５１｜５２｜５３｜５４｜５５｜",
			"－－－－－－－－－－－－－－－－－－－－－－－－－",
			"｜５６｜５７｜５８｜５９｜６０｜６１｜６２｜６３｜",
		};

		// 現在の結果表作成
		List<String> resultStrList = new ArrayList<>(strList.length);

		String str = "";
		for(int index = 0; index < field.length; index++)
		{
			str += "｜";
			switch(field[index])
			{
			case BLACK:
				{
					str += "●";
				}
				break;
			case WHITE:
				{
					str += "○";
				}
				break;
			default:
				{
					str += "　";
				}
				break;
			}

			if((index+1) % 8 == 0)
			{
				str += "｜";
				resultStrList.add(str);
				str = "";
				if((index+1) != field.length)
				{
					str += "－－－－－－－－－－－－－－－－－";
					resultStrList.add(str);
					str = "";
				}
			}
		}

		// 入力値表と現在の結果表をコマンドプロンプトに表示する
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("　　　　　　　　　　入力値表 　　　　　　　　　　 | 　　　　　　結果表　　　　　　");
		System.out.println("------------------------------------------------------------------------------------");

		for(int index = 0; index < strList.length; index++)
		{
			System.out.println(strList[index] + " " + resultStrList.get(index));
		}

		System.out.println("------------------------------------------------------------------------------------");
	}

	// 勝者表示
	public static void showWinner(Field field, Def.WINNERTYPE winnerType)
	{
		Player player = null;
		final Player[] playerList = field.getPlayerList();

		Def.KOMATYPE komaType =Def.KOMATYPE.UNKNOWN;
		switch(winnerType)
		{
			case WHITE:
				{
					komaType = Def.KOMATYPE.WHITE;
				}
				break;
			case BLACK:
				{
					komaType = Def.KOMATYPE.BLACK;
				}
				break;
			default:
				{
				}
				break;
		}

		String playerName = "";
		for(int index = 0; index < playerList.length; index++)
		{
			player = playerList[index];
			if((null != player) && (komaType == player.getKomaType()))
			{
				playerName = player.getName();
				break;
			}
		}

		if(false == playerName.equals(""))
		{
			System.out.println(playerName + "の勝利です");
		}
		else
		{
			System.out.println("引き分けです");
		}
	}

	// 入力値表示
	public static void showInput(int setIndex, Player player)
	{
		if(null == player)
		{
			return;
		}

		String komaTypeName = "";
		switch(player.getKomaType())
		{
			case BLACK:
				{
					komaTypeName = "●";
				}
				break;
			case WHITE:
				{
					komaTypeName = "○";
				}
				break;
			default:
				{
				}
				break;
		}

		System.out.println(
				player.getName() +
				"【" +
				komaTypeName +
				"】の設定位置：" +
				setIndex
				);
	}
}
