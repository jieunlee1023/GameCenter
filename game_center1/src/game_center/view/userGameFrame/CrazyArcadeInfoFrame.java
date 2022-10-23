package game_center.view.userGameFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import game_center.dto.CharacterInfo;
import game_center.dto.GameInfo;
import game_center.dto.MapInfo;
import game_center.dto.RequestGameCenter;
import game_center.service.GameCenterHostService;
import game_center.utils.Define;

public class CrazyArcadeInfoFrame extends GameItem {

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

	public CrazyArcadeInfoFrame(GameInfo gameInfo) {
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
			if (characterInfo.getGameCharacterName().equals("배찌")) {
				firstCharacterInfos = characterInfo;
			} else if (characterInfo.getGameCharacterName().equals("우니")) {
				secondCharacterInfos = characterInfo;
			} else if (characterInfo.getGameCharacterName().equals("계피")) {
				thirdCharacterInfos = characterInfo;
			} else if (characterInfo.getGameCharacterName().equals("다오")) {
				fourthCharacterInfos = characterInfo;
			}
		}

	}

	private void mapInfo() {
		for (MapInfo mapInfoClass : mapInfoClass) {
			if (mapInfoClass.getGameMapName().equals("패트릿")) {
				firstMapInfos = mapInfoClass;
			} else if (mapInfoClass.getGameMapName().equals("캠프")) {
				secondMapInfos = mapInfoClass;
			} else if (mapInfoClass.getGameMapName().equals("팩토리")) {
				thirdMapInfos = mapInfoClass;
			}
		}

	}

	private void initData() {
		setTitle("크레이지아케이드 정보창");

		mainImg = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "main.png"));
		setGameImage(mainImg);
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

		map1 = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "m1.png"));
		map1Detail = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "map1.png"));
		map1Name = new JLabel("111 맵 이름");
		map1Info = new JTextArea("111 맵정보");

		map2 = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "m2.png"));
		map2Detail = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "map2.png"));
		map2Name = new JLabel("222맵 이름");
		map2Info = new JTextArea("222게임정보");

		map3 = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "m3.png"));
		map3Detail = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "map3.png"));
		map3Name = new JLabel("333맵 이름");
		map3Info = new JTextArea("333맵정보");

	}

	private void thisMapImgRemove() {
		remove(mapInfo);
		remove(map1);
		remove(map1Detail);
		remove(map2);
		remove(map2Detail);
		remove(map3);
		remove(map3Detail);

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
		mapInfo.setLocation(140, 20);
		mapInfo.setFont(new Font("", Font.BOLD, 30));
		mapInfo.setForeground(Color.white);
		add(mapInfo);

		map1.setSize(100, 105);
		map1.setLocation(50, 80);
		add(map1);

		map1Detail.setSize(135, 120);
		map1Detail.setLocation(30, 480);
		add(map1Detail);

		map2.setSize(100, 105);
		map2.setLocation(200, 80);
		add(map2);

		map2Detail.setSize(135, 120);
		map2Detail.setLocation(175, 480);
		add(map2Detail);

		map3.setSize(100, 105);
		map3.setLocation(345, 80);
		add(map3);

		map3Detail.setSize(135, 120);
		map3Detail.setLocation(320, 480);
		add(map3Detail);

	}

	private void gameMapSelectComponents() {

		map1Name.setSize(100, 30);
		map1Name.setLocation(50, 200);
		map1Name.setForeground(Color.white);
		map1Name.setText(firstMapInfos.getGameMapName());
		add(map1Name);

		map1Info.setSize(100, 230);
		map1Info.setLocation(50, 230);
		map1Info.setText(firstMapInfos.getGameMapInfo());
		map1Info.setLineWrap(true);
		add(map1Info);

		map2Name.setSize(100, 30);
		map2Name.setLocation(200, 200);
		map2Name.setForeground(Color.white);
		map2Name.setText(secondMapInfos.getGameMapName());
		add(map2Name);

		map2Info.setSize(100, 230);
		map2Info.setLocation(200, 230);
		map2Info.setText(secondMapInfos.getGameMapInfo());
		map2Info.setLineWrap(true);
		add(map2Info);

		map3Name.setSize(100, 30);
		map3Name.setLocation(350, 200);
		map3Name.setForeground(Color.white);
		map3Name.setText(thirdMapInfos.getGameMapName());
		add(map3Name);

		map3Info.setSize(100, 230);
		map3Info.setLocation(350, 230);
		map3Info.setText(thirdMapInfos.getGameMapInfo());
		map3Info.setLineWrap(true);
		add(map3Info);

	}

	// character
	private void characterItem() {

		caracterInfo = new JLabel("★ Character Info ★");

		character1 = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "ca1.png"));
		character1Name = new JLabel("캐릭터 이름");
		character1Info = new JTextArea("캐릭터 소개");

		character2 = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "ca2.png"));
		character2Name = new JLabel("캐릭터 이름");
		character2Info = new JTextArea("캐릭터 소개");

		character3 = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "ca3.png"));
		character3Name = new JLabel("캐릭터 이름");
		character3Info = new JTextArea("캐릭터 소개");

		character4 = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "ca4.png"));
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
		caracterInfo.setLocation(105, 20);
		caracterInfo.setFont(new Font("", Font.BOLD, 30));
		caracterInfo.setForeground(Color.white);
		add(caracterInfo);

		character1.setSize(170, 165);
		character1.setLocation(50, 100);
		add(character1);

		character2.setSize(170, 165);
		character2.setLocation(280, 100);
		add(character2);

		character3.setSize(170, 165);
		character3.setLocation(50, 360);
		add(character3);

		character4.setSize(170, 165);
		character4.setLocation(280, 360);
		add(character4);

	}

	private void gameCharacterSelectComponents() {

		character1Name.setSize(100, 20);
		character1Name.setLocation(120, 270);
		character1Name.setForeground(Color.WHITE);
		character1Name.setText(firstCharacterInfos.getGameCharacterName());
		add(character1Name);
		character1Info.setSize(150, 50);
		character1Info.setLocation(60, 300);
		character1Info.setLineWrap(true);
		character1Info.setText(firstCharacterInfos.getGameCharacterInfo());
		add(character1Info);

		character2Name.setSize(100, 20);
		character2Name.setLocation(355, 270);
		character2Name.setForeground(Color.WHITE);
		character2Name.setText(secondCharacterInfos.getGameCharacterName());
		add(character2Name);
		character2Info.setSize(150, 50);
		character2Info.setLocation(290, 300);
		character2Info.setLineWrap(true);
		character2Info.setText(secondCharacterInfos.getGameCharacterInfo());
		add(character2Info);

		character3Name.setSize(100, 20);
		character3Name.setLocation(120, 530);
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
