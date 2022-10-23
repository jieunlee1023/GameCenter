package game_center.view.hostGameFrame;

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

public class LOLHostInfoFrame extends GameHostItem {

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

	public LOLHostInfoFrame(GameInfo gameInfo) {
		super(gameInfo);
		gchs = super.centerHostService;
		rgc = super.rgc;
		mapInfoClass = gchs.MapInfo();
		characterInfosClass = gchs.CharacterInfo();
		initData();
		setInitLayout();

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

	private void setInitLayout() {
		super.setGameImage(new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "main.png")));
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
			thisMapUpdateRemove();

			thisCharacterImgRemove();
			thisCharacterSelectRemove();
			thisCharacterUpdateRemove();

			repaint();

		} else if (targetItem.getText().equals(super.getGameUpDate().getText())) {

			thisMapImgRemove();
			thisMapSelectRemove();
			thisMapUpdateRemove();

			thisCharacterImgRemove();
			thisCharacterSelectRemove();
			thisCharacterUpdateRemove();

			repaint();

		} else if (targetItem.getText().equals(super.getGameMapSelected().getText())) {

			superRemove();
			thisMapUpdateRemove();
			gameMapImageComponents();
			gameMapSelectComponents();

			thisCharacterImgRemove();
			thisCharacterSelectRemove();
			thisCharacterUpdateRemove();

			repaint();

		} else if (targetItem.getText().equals(super.getGameMapUpdate().getText())) {

			superRemove();
			thisMapSelectRemove();
			gameMapImageComponents();
			gameMapUpdateComponents();

			thisCharacterImgRemove();
			thisCharacterSelectRemove();
			thisCharacterUpdateRemove();

			repaint();

		} else if (targetItem.getText().equals(super.getGameMapSave().getText())) {

			rgc.setGameMapInfo(updateMap1Info.getText());
			gchs.updateMap(rgc, firstMapInfos);

			rgc.setGameMapInfo(updateMap2Info.getText());
			gchs.updateMap(rgc, secondMapInfos);

			rgc.setGameMapInfo(updateMap3Info.getText());
			gchs.updateMap(rgc, thirdMapInfos);

		} else if (targetItem.getText().equals(super.getGameCharacterSelected().getText())) {

			superRemove();
			thisMapImgRemove();
			thisMapSelectRemove();
			thisMapUpdateRemove();

			gameCharacterImageComponents();
			gameCharacterSelectComponents();

			thisCharacterUpdateRemove();
			repaint();

		} else if (targetItem.getText().equals(super.getGameCharacterUpdate().getText())) {

			superRemove();
			thisMapImgRemove();
			thisMapSelectRemove();
			thisMapUpdateRemove();

			gameCharacterImageComponents();
			gameCharacterUpdateComponents();

			thisCharacterSelectRemove();
			repaint();
		} else if (targetItem.getText().equals(super.getGameCharacterSave().getText())) {

			rgc.setGameCharacterInfo(updateCharacter1nfo.getText());
			gchs.updateCharacter(rgc, firstCharacterInfos);

			rgc.setGameCharacterInfo(updateCharacter2nfo.getText());
			gchs.updateCharacter(rgc, secondCharacterInfos);

			rgc.setGameCharacterInfo(updateCharacter3nfo.getText());
			gchs.updateCharacter(rgc, thirdCharacterInfos);

			rgc.setGameCharacterInfo(updateCharacter4nfo.getText());
			gchs.updateCharacter(rgc, fourthCharacterInfos);
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
		remove(super.getGameNameUpdate());
		remove(super.getAgeLimitUpdate());
		remove(super.getGameInfomationUpdate());
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

		updateMap1Name = new JLabel();
		updateMap1Info = new JTextArea();

		updateMap2Name = new JLabel();
		updateMap2Info = new JTextArea();

		updateMap3Name = new JLabel();
		updateMap3Info = new JTextArea();
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

	private void thisMapUpdateRemove() {

		remove(updateMap1Name);
		remove(updateMap1Info);
		remove(updateMap2Name);
		remove(updateMap2Info);
		remove(updateMap3Name);
		remove(updateMap3Info);
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
		map1Info.setText(firstMapInfos.getGameMapInfo());
		add(map1Info);

		map2Name.setSize(140, 20);
		map2Name.setLocation(310, 325);
		map2Name.setForeground(Color.white);
		map2Name.setText(secondMapInfos.getGameMapName());
		add(map2Name);

		map2Info.setSize(140, 100);
		map2Info.setLocation(310, 355);
		map2Info.setText(secondMapInfos.getGameMapInfo());
		add(map2Info);

		map3Name.setSize(140, 20);
		map3Name.setLocation(310, 475);
		map3Name.setForeground(Color.white);
		map3Name.setText(thirdMapInfos.getGameMapName());
		add(map3Name);

		map3Info.setSize(140, 100);
		map3Info.setLocation(310, 505);
		map3Info.setText(thirdMapInfos.getGameMapInfo());
		add(map3Info);
	}

	private void gameMapUpdateComponents() {
		updateMap1Name.setSize(100, 20);
		updateMap1Name.setForeground(Color.white);
		updateMap1Name.setLocation(50, 280);
		updateMap1Name.setText(firstMapInfos.getGameMapName());
		add(updateMap1Name);

		updateMap1Info.setSize(290, 20);
		updateMap1Info.setLocation(160, 280);
		updateMap1Info.setText(firstMapInfos.getGameMapInfo());
		add(updateMap1Info);

		updateMap2Name.setSize(140, 20);
		updateMap2Name.setForeground(Color.white);
		updateMap2Name.setLocation(310, 325);
		updateMap2Name.setText(secondMapInfos.getGameMapName());
		add(updateMap2Name);

		updateMap2Info.setSize(140, 100);
		updateMap2Info.setLocation(310, 355);
		updateMap2Info.setText(secondMapInfos.getGameMapInfo());
		add(updateMap2Info);

		updateMap3Name.setSize(140, 20);
		updateMap3Name.setForeground(Color.white);
		updateMap3Name.setLocation(310, 475);
		updateMap3Name.setText(thirdMapInfos.getGameMapName());
		add(updateMap3Name);

		updateMap3Info.setSize(140, 100);
		updateMap3Info.setLocation(310, 505);
		updateMap3Info.setText(thirdMapInfos.getGameMapInfo());
		add(updateMap3Info);

	}

	// character

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

		updateCharacter1Name = new JLabel();
		updateCharacter1nfo = new JTextArea();

		updateCharacter2Name = new JLabel();
		updateCharacter2nfo = new JTextArea();

		updateCharacter3Name = new JLabel();
		updateCharacter3nfo = new JTextArea();

		updateCharacter4Name = new JLabel();
		updateCharacter4nfo = new JTextArea();
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

	private void thisCharacterUpdateRemove() {
		remove(updateCharacter1Name);
		remove(updateCharacter1nfo);
		remove(updateCharacter2Name);
		remove(updateCharacter2nfo);
		remove(updateCharacter3Name);
		remove(updateCharacter3nfo);
		remove(updateCharacter4Name);
		remove(updateCharacter4nfo);
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
		character1Name.setLocation(85, 260);
		character1Name.setForeground(Color.WHITE);
		character1Name.setText(firstCharacterInfos.getGameCharacterName());
		add(character1Name);
		character1Info.setSize(150, 50);
		character1Info.setLocation(60, 290);
		character1Info.setText(firstCharacterInfos.getGameCharacterInfo());
		add(character1Info);

		character2Name.setSize(100, 20);
		character2Name.setLocation(315, 260);
		character2Name.setForeground(Color.WHITE);
		character2Name.setText(secondCharacterInfos.getGameCharacterName());
		add(character2Name);
		character2Info.setSize(150, 50);
		character2Info.setLocation(290, 290);
		character2Info.setText(secondCharacterInfos.getGameCharacterInfo());
		add(character2Info);

		character3Name.setSize(100, 20);
		character3Name.setLocation(85, 530);
		character3Name.setForeground(Color.WHITE);
		character3Name.setText(thirdCharacterInfos.getGameCharacterName());
		add(character3Name);
		character3Info.setSize(150, 50);
		character3Info.setLocation(60, 560);
		character3Info.setText(thirdCharacterInfos.getGameCharacterInfo());
		add(character3Info);

		character4Name.setSize(100, 20);
		character4Name.setLocation(315, 530);
		character4Name.setForeground(Color.WHITE);
		character4Name.setText(fourthCharacterInfos.getGameCharacterName());
		add(character4Name);
		character4Info.setSize(150, 50);
		character4Info.setLocation(290, 560);
		character4Info.setText(fourthCharacterInfos.getGameCharacterInfo());
		add(character4Info);

	}

	private void gameCharacterUpdateComponents() {

		updateCharacter1Name.setSize(100, 20);
		updateCharacter1Name.setLocation(85, 260);
		updateCharacter1Name.setForeground(Color.white);
		updateCharacter1Name.setText(firstCharacterInfos.getGameCharacterName());
		add(updateCharacter1Name);
		updateCharacter1nfo.setSize(150, 50);
		updateCharacter1nfo.setLocation(60, 290);
		updateCharacter1nfo.setText(firstCharacterInfos.getGameCharacterInfo());
		add(updateCharacter1nfo);

		updateCharacter2Name.setSize(100, 20);
		updateCharacter2Name.setLocation(315, 260);
		updateCharacter2Name.setForeground(Color.white);
		updateCharacter2Name.setText(secondCharacterInfos.getGameCharacterName());
		add(updateCharacter2Name);
		updateCharacter2nfo.setSize(150, 50);
		updateCharacter2nfo.setLocation(290, 290);
		updateCharacter2nfo.setText(secondCharacterInfos.getGameCharacterInfo());
		add(updateCharacter2nfo);

		updateCharacter3Name.setSize(100, 20);
		updateCharacter3Name.setLocation(85, 530);
		updateCharacter3Name.setForeground(Color.white);
		updateCharacter3Name.setText(thirdCharacterInfos.getGameCharacterName());
		add(updateCharacter3Name);
		updateCharacter3nfo.setSize(150, 50);
		updateCharacter3nfo.setLocation(60, 560);
		updateCharacter3nfo.setText(thirdCharacterInfos.getGameCharacterInfo());
		add(updateCharacter3nfo);

		updateCharacter4Name.setSize(100, 20);
		updateCharacter4Name.setLocation(315, 530);
		updateCharacter4Name.setForeground(Color.white);
		updateCharacter4Name.setText(fourthCharacterInfos.getGameCharacterName());
		add(updateCharacter4Name);
		updateCharacter4nfo.setSize(150, 50);
		updateCharacter4nfo.setLocation(290, 560);
		updateCharacter4nfo.setText(fourthCharacterInfos.getGameCharacterInfo());
		add(updateCharacter4nfo);

	}
}
