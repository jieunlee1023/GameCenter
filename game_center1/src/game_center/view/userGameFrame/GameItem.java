package game_center.view.userGameFrame;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game_center.dto.GameInfo;
import game_center.view.GameCenterHostFrame;
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
	protected JTextArea map1Info;

	protected JLabel map2;
	protected JLabel map2Detail;
	protected JLabel map2Name;
	protected JTextArea map2Info;

	protected JLabel map3;
	protected JLabel map3Detail;
	protected JLabel map3Name;
	protected JTextArea map3Info;

	// 캐릭터 아이템

	protected JLabel caracterInfo;

	protected JLabel character1;
	protected JLabel character1Name;
	protected JTextArea character1Info;

	protected JLabel character2;
	protected JLabel character2Name;
	protected JTextArea character2Info;

	protected JLabel character3;
	protected JLabel character3Name;
	protected JTextArea character3Info;

	protected JLabel character4;
	protected JLabel character4Name;
	protected JTextArea character4Info;

}
