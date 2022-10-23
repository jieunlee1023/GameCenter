package game_center.view.userGameFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game_center.dto.GameInfo;
import game_center.utils.Define;

public class FIFAInfoFrame extends GameItem {

	public FIFAInfoFrame(GameInfo gameInfo) {
		super(gameInfo);
		initData();
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

		} else if (targetItem.getText().equals(super.getGameMapSelected().getText())) {

			superRemove();
			thisMapUpdateRemove();
			gameMapImageComponents();
			gameMapSelectComponents();

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

		map1 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "map1.png"));
		map1Name = new JLabel("111맵 이름");
		map1Info = new JTextArea("111맵 정보");

		map2 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "map2.png"));
		map2Name = new JLabel("222맵 이름");
		map2Info = new JTextArea("222맵 정보");

		updateMap1Name = new JLabel();
		updateMap1Info = new JTextArea();

		updateMap2Name = new JLabel();
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
		add(map1Name);

		map1Info.setSize(360, 25);
		map1Info.setLocation(70, 310);
		map1Info.setForeground(Color.white);
		add(map1Info);

		map2Name.setSize(150, 20);
		map2Name.setLocation(70, 565);
		map2Name.setForeground(Color.white);
		add(map2Name);

		map2Info.setSize(360, 25);
		map2Info.setLocation(70, 590);
		map2Info.setForeground(Color.white);
		add(map2Info);

	}

	private void gameMapUpdateComponents() {

		updateMap1Name.setSize(150, 20);
		updateMap1Name.setLocation(70, 285);
		updateMap1Name.setForeground(Color.white);
		add(updateMap1Name);

		updateMap1Info.setSize(360, 25);
		updateMap1Info.setLocation(70, 310);
		add(updateMap1Info);

		updateMap2Name.setSize(150, 20);
		updateMap2Name.setLocation(70, 565);
		updateMap2Name.setForeground(Color.white);
		add(updateMap2Name);

		updateMap2Info.setSize(360, 25);
		updateMap2Info.setLocation(70, 590);
		add(updateMap2Info);

	}

	// character

	private void characterItem() {

		caracterInfo = new JLabel("★ Character Info ★");

		character1 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "ca1.png"));
		character1Name = new JLabel("캐릭터 이름");
		character1Info = new JLabel("캐릭터 소개");

		character2 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "ca2.png"));
		character2Name = new JLabel("캐릭터 이름");
		character2Info = new JLabel("캐릭터 소개");

		character3 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "ca3.png"));
		character3Name = new JLabel("캐릭터 이름");
		character3Info = new JLabel("캐릭터 소개");

		character4 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "ca4.png"));
		character4Name = new JLabel("캐릭터 이름");
		character4Info = new JLabel("캐릭터 소개");

		updateCharacter1Name = new JLabel();
		updateCharacter1nfo = new JTextArea();

		updateCharacter2Name = new JLabel();
		updateCharacter2nfo = new JTextArea();

		updateCharacter3Name = new JLabel();
		updateCharacter3nfo = new JTextField();

		updateCharacter4Name = new JLabel();
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
		add(character1Name);
		character1Info.setSize(300, 80);
		character1Info.setLocation(150, 110);
		character1Info.setForeground(Color.WHITE);
		add(character1Info);

		character2Name.setSize(100, 20);
		character2Name.setLocation(270, 210);
		character2Name.setForeground(Color.WHITE);
		add(character2Name);
		character2Info.setSize(300, 80);
		character2Info.setLocation(70, 240);
		character2Info.setForeground(Color.WHITE);
		add(character2Info);

		character3Name.setSize(100, 20);
		character3Name.setLocation(150, 340);
		character3Name.setForeground(Color.WHITE);
		add(character3Name);
		character3Info.setSize(300, 80);
		character3Info.setLocation(150, 370);
		character3Name.setForeground(Color.WHITE);
		add(character3Info);

		character4Name.setSize(100, 20);
		character4Name.setLocation(270, 470);
		character4Name.setForeground(Color.WHITE);
		add(character4Name);
		character4Info.setSize(300, 80);
		character4Info.setLocation(70, 500);
		character4Info.setForeground(Color.WHITE);
		add(character4Info);

	}

	private void gameCharacterUpdateComponents() {

		updateCharacter1Name.setSize(100, 20);
		updateCharacter1Name.setLocation(150, 80);
		updateCharacter1Name.setForeground(Color.white);
		add(updateCharacter1Name);
		updateCharacter1nfo.setSize(300, 80);
		updateCharacter1nfo.setLocation(150, 110);
		add(updateCharacter1nfo);

		updateCharacter2Name.setSize(100, 20);
		updateCharacter2Name.setLocation(270, 210);
		updateCharacter2Name.setForeground(Color.white);
		add(updateCharacter2Name);
		updateCharacter2nfo.setSize(300, 80);
		updateCharacter2nfo.setLocation(70, 240);
		add(updateCharacter2nfo);

		updateCharacter3Name.setSize(100, 20);
		updateCharacter3Name.setLocation(150, 340);
		updateCharacter3Name.setForeground(Color.white);
		add(updateCharacter3Name);
		updateCharacter3nfo.setSize(300, 80);
		updateCharacter3nfo.setLocation(150, 370);
		add(updateCharacter3nfo);

		updateCharacter4Name.setSize(100, 20);
		updateCharacter4Name.setLocation(270, 470);
		updateCharacter4Name.setForeground(Color.white);
		add(updateCharacter4Name);
		updateCharacter4nfo.setSize(300, 80);
		updateCharacter4nfo.setLocation(70, 500);
		add(updateCharacter4nfo);

	}
}
