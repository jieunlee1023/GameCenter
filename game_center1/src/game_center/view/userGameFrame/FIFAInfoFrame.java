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

		map1 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "map1.png"));
		map1Name = new JLabel("111맵 이름");
		map1Info = new JTextArea("111맵 정보");

		map2 = new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "map2.png"));
		map2Name = new JLabel("222맵 이름");
		map2Info = new JTextArea("222맵 정보");

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
		map1Info.setLineWrap(true);
		add(map1Info);

		map2Name.setSize(150, 20);
		map2Name.setLocation(70, 565);
		map2Name.setForeground(Color.white);
		add(map2Name);

		map2Info.setSize(360, 25);
		map2Info.setLocation(70, 590);
		map2Info.setLineWrap(true);
		add(map2Info);

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
		character1Info.setLineWrap(true);
		add(character1Info);

		character2Name.setSize(100, 20);
		character2Name.setLocation(270, 210);
		character2Name.setForeground(Color.WHITE);
		add(character2Name);
		character2Info.setSize(300, 80);
		character2Info.setLocation(70, 240);
		character2Info.setLineWrap(true);
		add(character2Info);

		character3Name.setSize(100, 20);
		character3Name.setLocation(150, 340);
		character3Name.setForeground(Color.WHITE);
		add(character3Name);
		character3Info.setSize(300, 80);
		character3Info.setLocation(150, 370);
		character3Info.setLineWrap(true);
		add(character3Info);

		character4Name.setSize(100, 20);
		character4Name.setLocation(270, 470);
		character4Name.setForeground(Color.WHITE);
		add(character4Name);
		character4Info.setSize(300, 80);
		character4Info.setLocation(70, 500);
		character4Info.setLineWrap(true);
		add(character4Info);

	}

}
