package game_center.view.userGameFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game_center.dto.CharacterInfo;
import game_center.dto.GameInfo;
import game_center.dto.MapInfo;
import game_center.dto.RequestGameCenter;
import game_center.service.GameCenterHostService;
import game_center.utils.Define;
import lombok.experimental.SuperBuilder;

public class LOLInfoFrame extends GameItem {

	private GameCenterHostService gchs;
	private RequestGameCenter rgc;

	private List<MapInfo> mapInfoClass;
	private MapInfo firstMapInfos;
	private MapInfo secondMapInfos;
	private MapInfo thirdMapInfos;

	private List<CharacterInfo> characterInfosClass;
	private CharacterInfo firstCharacterInfos;
	private CharacterInfo secondCharacterInfos;
	private CharacterInfo thirdCharacterInfos;
	private CharacterInfo fourthCharacterInfos;

	public LOLInfoFrame(GameInfo gameInfo) {
		super(gameInfo);
		gchs = super.centerHostService;
		rgc = super.rgc;
		mapInfoClass = gchs.MapInfo();
		characterInfosClass = gchs.CharacterInfo();
		initData();

		mapInfo();
		characterInfo();
	}

	private void characterInfo() {
		for (CharacterInfo characterInfo : characterInfosClass) {
			if (characterInfo.getGameCharacterName().equals("야스오")) {
				firstCharacterInfos = characterInfo;
			} else if (characterInfo.getGameCharacterName().equals("럭스")) {
				secondCharacterInfos = characterInfo;
			} else if (characterInfo.getGameCharacterName().equals("아펠리오스")) {
				thirdCharacterInfos = characterInfo;
			} else if (characterInfo.getGameCharacterName().equals("쓰레쉬")) {
				fourthCharacterInfos = characterInfo;
			}
		}
	}

	private void mapInfo() {
		for (MapInfo mapInfoClass : mapInfoClass) {
			if (mapInfoClass.getGameMapName().equals("소환사의 협곡")) {
				firstMapInfos = mapInfoClass;
			} else if (mapInfoClass.getGameMapName().equals("칼바람 나락")) {
				secondMapInfos = mapInfoClass;
			} else if (mapInfoClass.getGameMapName().equals("수정의 상처")) {
				thirdMapInfos = mapInfoClass;
			}
		}
	}

	private void initData() {
		setTitle("롤 정보창");

		mainImg = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "main.png"));
		super.setGameImage(mainImg);
		mapItem();
		characterItem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		JMenuItem targetItem = (JMenuItem) e.getSource();

		if (targetItem.getText().equals(super.getGameSelected().getText())) {
			thisMapImgRemove();
			thisMapSelectRemove();

			thisCharacterImgRemove();
			thisCharacterSelectRemove();

			repaint();

		} else if (targetItem.getText().equals(super.getGameMapSelected().getText())) {

			superRemove();
			gameMapImageComponents();
			gameMapSelectComponents();

			thisCharacterImgRemove();
			thisCharacterSelectRemove();

			repaint();

		} else if (targetItem.getText().equals(super.getGameCharacterSelected().getText())) {

			superRemove();
			thisMapImgRemove();
			thisMapSelectRemove();

			gameCharacterImageComponents();
			gameCharacterSelectComponents();

			repaint();

		}

	}

	private void superRemove() {

		remove(super.getMainImage());
		remove(super.getLogo());
		remove(super.getInfomation());
		remove(super.getMemo());
		remove(super.getMemoTextArea());
		remove(super.getInfo());
		remove(super.getGameImage());
		remove(super.getGameName());
		remove(super.getAgeLimit());
		remove(super.getAgeLimitInfo());
		remove(super.getGameInformation());
	}

	// map
	private void mapItem() {

		mapInfo = new JLabel("★ Map Info ★");

		map1 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "map1.png"));
		map1Name = new JLabel("111맵 이름");
		map1Info = new JTextArea("111맵정보");

		map2 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "map2.png"));
		map2Name = new JLabel("222맵 이름");
		map2Info = new JTextArea("222맵정보");

		map3 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "map3.png"));
		map3Name = new JLabel("333맵 이름");
		map3Info = new JTextArea("333맵정보");
	}

	private void thisMapImgRemove() {
		remove(mapInfo);
		remove(map1);
		remove(map2);
		remove(map3);

	}

	private void thisMapSelectRemove() {

		remove(map1Name);
		remove(map1Info);
		remove(map2Name);
		remove(map2Info);
		remove(map3Name);
		remove(map3Info);
	}

	private void gameMapImageComponents() {

		mapInfo.setSize(500, 50);
		mapInfo.setLocation(140, 10);
		mapInfo.setFont(new Font("", Font.BOLD, 30));
		mapInfo.setForeground(Color.white);
		add(mapInfo);

		map1.setSize(350, 200);
		map1.setLocation(75, 70);
		add(map1);

		map2.setSize(250, 140);
		map2.setLocation(50, 320);
		add(map2);

		map3.setSize(250, 140);
		map3.setLocation(50, 470);
		add(map3);

	}

	private void gameMapSelectComponents() {

		map1Name.setSize(100, 20);
		map1Name.setLocation(50, 280);
		map1Name.setForeground(Color.white);
		map1Name.setText(firstMapInfos.getGameMapName());
		add(map1Name);

		map1Info.setSize(290, 20);
		map1Info.setLocation(160, 280);
		map1Info.setLineWrap(true);
		map1Info.setText(firstMapInfos.getGameMapInfo());
		add(map1Info);

		map2Name.setSize(140, 20);
		map2Name.setLocation(310, 325);
		map2Name.setForeground(Color.white);
		map2Name.setText(secondMapInfos.getGameMapName());
		add(map2Name);

		map2Info.setSize(140, 100);
		map2Info.setLocation(310, 355);
		map2Info.setLineWrap(true);
		map2Info.setText(secondMapInfos.getGameMapInfo());
		add(map2Info);

		map3Name.setSize(140, 20);
		map3Name.setLocation(310, 475);
		map3Name.setForeground(Color.white);
		map3Name.setText(thirdMapInfos.getGameMapName());
		add(map3Name);

		map3Info.setSize(140, 100);
		map3Info.setLocation(310, 505);
		map3Info.setLineWrap(true);
		map3Info.setText(thirdMapInfos.getGameMapInfo());
		add(map3Info);
	}

	private void characterItem() {

		caracterInfo = new JLabel("★ Character Info ★");

		character1 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "ca1.png"));
		character1Name = new JLabel("캐릭터 이름");
		character1Info = new JTextArea("캐릭터 소개");

		character2 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "ca2.png"));
		character2Name = new JLabel("캐릭터 이름");
		character2Info = new JTextArea("캐릭터 소개");

		character3 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "ca3.png"));
		character3Name = new JLabel("캐릭터 이름");
		character3Info = new JTextArea("캐릭터 소개");

		character4 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "ca4.png"));
		character4Name = new JLabel("캐릭터 이름");
		character4Info = new JTextArea("캐릭터 소개");

	}

	private void thisCharacterImgRemove() {

		remove(caracterInfo);
		remove(character1);
		remove(character2);
		remove(character3);
		remove(character4);
	}

	private void thisCharacterSelectRemove() {

		remove(character1Name);
		remove(character1Info);
		remove(character2Name);
		remove(character2Info);
		remove(character3Name);
		remove(character3Info);
		remove(character4Name);
		remove(character4Info);
	}

	private void gameCharacterImageComponents() {
		caracterInfo.setSize(500, 50);
		caracterInfo.setLocation(105, 10);
		caracterInfo.setFont(new Font("", Font.BOLD, 30));
		caracterInfo.setForeground(Color.white);
		add(caracterInfo);

		character1.setSize(180, 180);
		character1.setLocation(40, 70);
		add(character1);

		character2.setSize(180, 180);
		character2.setLocation(280, 70);
		add(character2);

		character3.setSize(180, 180);
		character3.setLocation(40, 345);
		add(character3);

		character4.setSize(180, 180);
		character4.setLocation(280, 345);
		add(character4);
	}

	private void gameCharacterSelectComponents() {

		character1Name.setSize(100, 20);
		character1Name.setLocation(115, 260);
		character1Name.setForeground(Color.WHITE);
		character1Name.setText(firstCharacterInfos.getGameCharacterName());
		add(character1Name);
		character1Info.setSize(150, 50);
		character1Info.setLocation(60, 290);
		character1Info.setLineWrap(true);
		character1Info.setText(firstCharacterInfos.getGameCharacterInfo());
		add(character1Info);

		character2Name.setSize(100, 20);
		character2Name.setLocation(355, 260);
		character2Name.setForeground(Color.WHITE);
		character2Name.setText(secondCharacterInfos.getGameCharacterName());
		add(character2Name);
		character2Info.setSize(150, 50);
		character2Info.setLocation(290, 290);
		character2Info.setLineWrap(true);
		character2Info.setText(secondCharacterInfos.getGameCharacterInfo());
		add(character2Info);

		character3Name.setSize(100, 20);
		character3Name.setLocation(100, 530);
		character3Name.setForeground(Color.WHITE);
		character3Name.setText(thirdCharacterInfos.getGameCharacterName());
		add(character3Name);
		character3Info.setSize(150, 50);
		character3Info.setLocation(60, 560);
		character3Info.setLineWrap(true);
		character3Info.setText(thirdCharacterInfos.getGameCharacterInfo());
		add(character3Info);

		character4Name.setSize(100, 20);
		character4Name.setLocation(355, 530);
		character4Name.setForeground(Color.WHITE);
		character4Name.setText(fourthCharacterInfos.getGameCharacterName());
		add(character4Name);
		character4Info.setSize(150, 50);
		character4Info.setLocation(290, 560);
		character4Info.setLineWrap(true);
		character4Info.setText(fourthCharacterInfos.getGameCharacterInfo());
		add(character4Info);

	}

}
