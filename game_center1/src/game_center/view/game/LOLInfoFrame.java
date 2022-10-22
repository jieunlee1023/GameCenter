package game_center.view.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game_center.dto.GameInfo;
import game_center.dto.RequestGameCenter;
import game_center.service.GameCenterHostService;
import game_center.utils.Define;

public class LOLInfoFrame extends GameItem {

	GameCenterHostService gchs;
	RequestGameCenter rgc;

	public LOLInfoFrame(GameInfo gameInfo) {
		super(gameInfo);
		gchs = super.centerHostService;
		rgc = super.rgc;
		initData();
		setInitLayout();
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
		map1Info = new JLabel("111맵정보");

		map2 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "map2.png"));
		map2Name = new JLabel("222맵 이름");
		map2Info = new JLabel("222맵정보");

		map3 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "map3.png"));
		map3Name = new JLabel("333맵 이름");
		map3pInfo = new JLabel("333맵정보");

		updateMap1Name = new JTextField();
		updateMap1Info = new JTextArea();

		updateMap2Name = new JTextField();
		updateMap2Info = new JTextArea();

		updateMap3Name = new JTextField();
		updateMap3Info = new JTextField();
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
		remove(map3pInfo);
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
		add(map1Name);

		map1Info.setSize(290, 20);
		map1Info.setLocation(160, 280);
		map1Info.setForeground(Color.white);
		add(map1Info);

		map2Name.setSize(140, 20);
		map2Name.setLocation(310, 325);
		map2Name.setForeground(Color.white);
		add(map2Name);

		map2Info.setSize(140, 100);
		map2Info.setLocation(310, 355);
		map2Info.setForeground(Color.white);
		add(map2Info);

		map3Name.setSize(140, 20);
		map3Name.setLocation(310, 475);
		map3Name.setForeground(Color.white);
		add(map3Name);

		map3pInfo.setSize(140, 100);
		map3pInfo.setLocation(310, 505);
		map3pInfo.setForeground(Color.white);
		add(map3pInfo);

		gchs.MapInfo();

	}

	private void gameMapUpdateComponents() {
		updateMap1Name.setSize(100, 20);
		updateMap1Name.setLocation(50, 280);
		add(updateMap1Name);

		updateMap1Info.setSize(290, 20);
		updateMap1Info.setLocation(160, 280);
		add(updateMap1Info);

		updateMap2Name.setSize(140, 20);
		updateMap2Name.setLocation(310, 325);
		add(updateMap2Name);

		updateMap2Info.setSize(140, 100);
		updateMap2Info.setLocation(310, 355);
		add(updateMap2Info);

		updateMap3Name.setSize(140, 20);
		updateMap3Name.setLocation(310, 475);
		add(updateMap3Name);

		updateMap3Info.setSize(140, 100);
		updateMap3Info.setLocation(310, 505);
		add(updateMap3Info);

	}

	// character

	private void characterItem() {

		caracterInfo = new JLabel("★ Character Info ★");

		character1 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "ca1.png"));
		character1Name = new JLabel("캐릭터 이름");
		character1Info = new JLabel("캐릭터 소개");

		character2 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "ca2.png"));
		character2Name = new JLabel("캐릭터 이름");
		character2Info = new JLabel("캐릭터 소개");

		character3 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "ca3.png"));
		character3Name = new JLabel("캐릭터 이름");
		character3Info = new JLabel("캐릭터 소개");

		character4 = new JLabel(new ImageIcon(Define.LOL_IMAGE_PATH + "ca4.png"));
		character4Name = new JLabel("캐릭터 이름");
		character4Info = new JLabel("캐릭터 소개");

		updateCharacter1Name = new JTextField();
		updateCharacter1nfo = new JTextArea();

		updateCharacter2Name = new JTextField();
		updateCharacter2nfo = new JTextArea();

		updateCharacter3Name = new JTextField();
		updateCharacter3nfo = new JTextField();

		updateCharacter4Name = new JTextField();
		updateCharacter4nfo = new JTextField();
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
		add(character1Name);
		character1Info.setSize(150, 50);
		character1Info.setLocation(60, 290);
		character1Info.setForeground(Color.WHITE);
		add(character1Info);

		character2Name.setSize(100, 20);
		character2Name.setLocation(315, 260);
		character2Name.setForeground(Color.WHITE);
		add(character2Name);
		character2Info.setSize(150, 50);
		character2Info.setLocation(290, 290);
		character2Info.setForeground(Color.WHITE);
		add(character2Info);

		character3Name.setSize(100, 20);
		character3Name.setLocation(85, 530);
		character3Name.setForeground(Color.WHITE);
		add(character3Name);
		character3Info.setSize(150, 50);
		character3Info.setLocation(60, 560);
		character3Info.setForeground(Color.WHITE);
		add(character3Info);

		character4Name.setSize(100, 20);
		character4Name.setLocation(315, 530);
		character4Name.setForeground(Color.WHITE);
		add(character4Name);
		character4Info.setSize(150, 50);
		character4Info.setLocation(290, 560);
		character4Info.setForeground(Color.WHITE);
		add(character4Info);

	}

	private void gameCharacterUpdateComponents() {

		updateCharacter1Name.setSize(100, 20);
		updateCharacter1Name.setLocation(85, 260);
		add(updateCharacter1Name);
		updateCharacter1nfo.setSize(150, 50);
		updateCharacter1nfo.setLocation(60, 290);
		add(updateCharacter1nfo);

		updateCharacter2Name.setSize(100, 20);
		updateCharacter2Name.setLocation(315, 260);
		add(updateCharacter2Name);
		updateCharacter2nfo.setSize(150, 50);
		updateCharacter2nfo.setLocation(290, 290);
		add(updateCharacter2nfo);

		updateCharacter3Name.setSize(100, 20);
		updateCharacter3Name.setLocation(85, 530);
		add(updateCharacter3Name);
		updateCharacter3nfo.setSize(150, 50);
		updateCharacter3nfo.setLocation(60, 560);
		add(updateCharacter3nfo);

		updateCharacter4Name.setSize(100, 20);
		updateCharacter4Name.setLocation(315, 530);
		add(updateCharacter4Name);
		updateCharacter4nfo.setSize(150, 50);
		updateCharacter4nfo.setLocation(290, 560);
		add(updateCharacter4nfo);

	}
}