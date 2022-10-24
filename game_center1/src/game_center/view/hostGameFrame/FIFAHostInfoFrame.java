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

public class FIFAHostInfoFrame extends GameHostItem {

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

	public FIFAHostInfoFrame(GameInfo gameInfo) {
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
			if (characterInfo.getGameCharacterName().equals("호나우두")) {
				firstCharacterInfos = characterInfo;
			} else if (characterInfo.getGameCharacterName().equals("리오넬 메시")) {
				secondCharacterInfos = characterInfo;
			} else if (characterInfo.getGameCharacterName().equals("카림 벤제마")) {
				thirdCharacterInfos = characterInfo;
			} else if (characterInfo.getGameCharacterName().equals("손흥민")) {
				fourthCharacterInfos = characterInfo;
			}
		}
	}

	private void mapInfo() {
		for (MapInfo mapInfoClass : mapInfoClass) {
			if (mapInfoClass.getGameMapName().equals("에스타디오 산티아고 베르나베우")) {
				firstMapInfos = mapInfoClass;
			} else if (mapInfoClass.getGameMapName().equals("올드 트래포드")) {
				secondMapInfos = mapInfoClass;
			}
		}
	}

	private void initData() {
		setTitle("피파 정보창");

		mainImg = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "main.png"));
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

		} else if (targetItem.getText().equals(super.getGameCharacterSelected().getText())) {

			superRemove();
			thisMapImgRemove();
			thisMapSelectRemove();
			thisMapUpdateRemove();

			gameCharacterImageComponents();
			gameCharacterSelectComponents();

			thisCharacterUpdateRemove();
			repaint();

		} else if (targetItem.getText().equals(super.getGameMapSave().getText())) {

			rgc.setGameMapInfo(updateMap1Info.getText());
			gchs.updateMap(rgc, firstMapInfos);

			rgc.setGameMapInfo(updateMap2Info.getText());
			gchs.updateMap(rgc, secondMapInfos);

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

		map1 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "map1.png"));
		map1Name = new JLabel("111맵 이름");
		map1Info = new JTextArea("111맵 정보");

		map2 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "map2.png"));
		map2Name = new JLabel("222맵 이름");
		map2Info = new JTextArea("222맵 정보");

		updateMap1Name = new JLabel("11맵수정");
		updateMap1Info = new JTextArea();

		updateMap2Name = new JLabel("맵수정22");
		updateMap2Info = new JTextArea();
	}

	private void thisMapImgRemove() {
		remove(mapInfo);
		remove(map1);
		remove(map2);

	}

	private void thisMapSelectRemove() {

		remove(map1Name);
		remove(map1Info);
		remove(map2Name);
		remove(map2Info);
	}

	private void thisMapUpdateRemove() {

		remove(updateMap1Name);
		remove(updateMap1Info);
		remove(updateMap2Name);
		remove(updateMap2Info);
	}

	private void gameMapImageComponents() {

		mapInfo.setSize(500, 50);
		mapInfo.setLocation(140, 10);
		mapInfo.setFont(new Font("", Font.BOLD, 30));
		mapInfo.setForeground(Color.white);
		add(mapInfo);

		map1.setSize(400, 220);
		map1.setLocation(50, 60);
		add(map1);

		map2.setSize(400, 220);
		map2.setLocation(50, 340);
		add(map2);

	}

	private void gameMapSelectComponents() {

		map1Name.setSize(150, 20);
		map1Name.setLocation(70, 285);
		map1Name.setForeground(Color.white);
		map1Name.setText(firstMapInfos.getGameMapName());
		add(map1Name);

		map1Info.setSize(360, 25);
		map1Info.setLocation(70, 310);
		map1Info.setText(firstMapInfos.getGameMapInfo());
		map1Info.setLineWrap(true);
		add(map1Info);

		map2Name.setSize(150, 20);
		map2Name.setLocation(70, 565);
		map2Name.setForeground(Color.white);
		map2Name.setText(secondMapInfos.getGameMapName());
		add(map2Name);

		map2Info.setSize(360, 25);
		map2Info.setLocation(70, 590);
		map2Info.setText(secondMapInfos.getGameMapInfo());
		map2Info.setLineWrap(true);
		add(map2Info);

	}

	private void gameMapUpdateComponents() {

		updateMap1Name.setSize(150, 20);
		updateMap1Name.setLocation(70, 285);
		updateMap1Name.setForeground(Color.white);
		updateMap1Name.setText(firstMapInfos.getGameMapName());
		add(updateMap1Name);

		updateMap1Info.setSize(360, 25);
		updateMap1Info.setLocation(70, 310);
		updateMap1Info.setText(firstMapInfos.getGameMapInfo());
		add(updateMap1Info);

		updateMap2Name.setSize(150, 20);
		updateMap2Name.setLocation(70, 565);
		updateMap2Name.setForeground(Color.white);
		updateMap2Name.setText(secondMapInfos.getGameMapName());
		add(updateMap2Name);

		updateMap2Info.setSize(360, 25);
		updateMap2Info.setLocation(70, 590);
		updateMap2Info.setText(secondMapInfos.getGameMapInfo());
		add(updateMap2Info);

	}

	// character

	private void characterItem() {

		caracterInfo = new JLabel("★ Character Info ★");

		character1 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "ca1.png"));
		character1Name = new JLabel("캐릭터 이름");
		character1Info = new JTextArea("캐릭터 소개");

		character2 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "ca2.png"));
		character2Name = new JLabel("캐릭터 이름");
		character2Info = new JTextArea("캐릭터 소개");

		character3 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "ca3.png"));
		character3Name = new JLabel("캐릭터 이름");
		character3Info = new JTextArea("캐릭터 소개");

		character4 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "ca4.png"));
		character4Name = new JLabel("캐릭터 이름");
		character4Info = new JTextArea("캐릭터 소개");

		updateCharacter1Name = new JLabel("1111");
		updateCharacter1nfo = new JTextArea();

		updateCharacter2Name = new JLabel("2222");
		updateCharacter2nfo = new JTextArea();

		updateCharacter3Name = new JLabel("3333");
		updateCharacter3nfo = new JTextArea();

		updateCharacter4Name = new JLabel("4444");
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

		character1.setSize(90, 150);
		character1.setLocation(40, 60);
		add(character1);

		character2.setSize(90, 150);
		character2.setLocation(380, 200);
		add(character2);

		character3.setSize(90, 150);
		character3.setLocation(40, 330);
		add(character3);

		character4.setSize(90, 150);
		character4.setLocation(380, 460);
		add(character4);

	}

	private void gameCharacterSelectComponents() {

		character1Name.setSize(100, 20);
		character1Name.setLocation(150, 80);
		character1Name.setForeground(Color.WHITE);
		character1Name.setText(firstCharacterInfos.getGameCharacterName());
		add(character1Name);
		character1Info.setSize(300, 80);
		character1Info.setLocation(150, 110);
		character1Info.setText(firstCharacterInfos.getGameCharacterInfo());
		character1Info.setLineWrap(true);
		add(character1Info);

		character2Name.setSize(100, 20);
		character2Name.setLocation(270, 210);
		character2Name.setForeground(Color.WHITE);
		character2Name.setText(secondCharacterInfos.getGameCharacterName());
		add(character2Name);
		character2Info.setSize(300, 80);
		character2Info.setLocation(70, 240);
		character2Info.setText(secondCharacterInfos.getGameCharacterInfo());
		character2Info.setLineWrap(true);
		add(character2Info);

		character3Name.setSize(100, 20);
		character3Name.setLocation(150, 340);
		character3Name.setForeground(Color.WHITE);
		character3Name.setText(thirdCharacterInfos.getGameCharacterName());
		add(character3Name);
		character3Info.setSize(300, 80);
		character3Info.setLocation(150, 370);
		character3Info.setText(thirdCharacterInfos.getGameCharacterInfo());
		character3Info.setLineWrap(true);
		add(character3Info);

		character4Name.setSize(100, 20);
		character4Name.setLocation(270, 470);
		character4Name.setForeground(Color.WHITE);
		character4Name.setText(fourthCharacterInfos.getGameCharacterName());
		add(character4Name);
		character4Info.setSize(300, 80);
		character4Info.setLocation(70, 500);
		character4Info.setText(fourthCharacterInfos.getGameCharacterInfo());
		character4Info.setLineWrap(true);
		add(character4Info);

	}

	private void gameCharacterUpdateComponents() {

		updateCharacter1Name.setSize(100, 20);
		updateCharacter1Name.setLocation(150, 80);
		updateCharacter1Name.setForeground(Color.white);
		updateCharacter1Name.setText(firstCharacterInfos.getGameCharacterName());
		add(updateCharacter1Name);
		updateCharacter1nfo.setSize(300, 80);
		updateCharacter1nfo.setLocation(150, 110);
		updateCharacter1nfo.setText(firstCharacterInfos.getGameCharacterInfo());
		add(updateCharacter1nfo);

		updateCharacter2Name.setSize(100, 20);
		updateCharacter2Name.setLocation(270, 210);
		updateCharacter2Name.setForeground(Color.white);
		updateCharacter2Name.setText(secondCharacterInfos.getGameCharacterName());
		add(updateCharacter2Name);
		updateCharacter2nfo.setSize(300, 80);
		updateCharacter2nfo.setLocation(70, 240);
		updateCharacter2nfo.setText(secondCharacterInfos.getGameCharacterInfo());
		add(updateCharacter2nfo);

		updateCharacter3Name.setSize(100, 20);
		updateCharacter3Name.setLocation(150, 340);
		updateCharacter3Name.setForeground(Color.white);
		updateCharacter3Name.setText(thirdCharacterInfos.getGameCharacterName());
		add(updateCharacter3Name);
		updateCharacter3nfo.setSize(300, 80);
		updateCharacter3nfo.setLocation(150, 370);
		updateCharacter3nfo.setText(thirdCharacterInfos.getGameCharacterInfo());
		add(updateCharacter3nfo);

		updateCharacter4Name.setSize(100, 20);
		updateCharacter4Name.setLocation(270, 470);
		updateCharacter4Name.setForeground(Color.white);
		updateCharacter3nfo.setText(thirdCharacterInfos.getGameCharacterInfo());
		add(updateCharacter4Name);
		updateCharacter4nfo.setSize(300, 80);
		updateCharacter4nfo.setLocation(70, 500);
		updateCharacter4nfo.setText(fourthCharacterInfos.getGameCharacterInfo());
		add(updateCharacter4nfo);

	}
}
