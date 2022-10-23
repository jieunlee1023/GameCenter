package game_center.view.userGameFrame;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game_center.dto.GameInfo;
import lombok.Data;

public class GameItem extends GameInfoFrame {

	public GameItem(GameInfo gameInfo) {
		super(gameInfo);
	}

	protected JLabel mainImg;

	// map 아이템들
	protected JLabel mapInfo;

	protected JLabel map1;
	protected JLabel map1Detail;
	protected JLabel map1Name;
	protected JLabel map1Info;

	protected JLabel map2;
	protected JLabel map2Detail;
	protected JLabel map2Name;
	protected JLabel map2Info;

	protected JLabel map3;
	protected JLabel map3Detail;
	protected JLabel map3Name;
	protected JLabel map3pInfo;

	protected JLabel updateMap1Name;
	protected JTextArea updateMap1Info;

	protected JLabel updateMap2Name;
	protected JTextArea updateMap2Info;

	protected JLabel updateMap3Name;
	protected JTextField updateMap3Info;

	// 캐릭터 아이템

	protected JLabel caracterInfo;

	protected JLabel character1;
	protected JLabel character1Name;
	protected JLabel character1Info;

	protected JLabel character2;
	protected JLabel character2Name;
	protected JLabel character2Info;

	protected JLabel character3;
	protected JLabel character3Name;
	protected JLabel character3Info;

	protected JLabel character4;
	protected JLabel character4Name;
	protected JLabel character4Info;

	protected JLabel updateCharacter1Name;
	protected JTextArea updateCharacter1nfo;

	protected JLabel updateCharacter2Name;
	protected JTextArea updateCharacter2nfo;

	protected JLabel updateCharacter3Name;
	protected JTextField updateCharacter3nfo;

	protected JLabel updateCharacter4Name;
	protected JTextField updateCharacter4nfo;

}
