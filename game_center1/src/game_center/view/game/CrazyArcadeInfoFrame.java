package game_center.view.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game_center.utils.Define;
import lombok.Data;

@Data
public class CrazyArcadeInfoFrame extends GameInfoFrame {

	private JLabel mainImg;

	// map 아이템들
	private JLabel MapInfo;

	private JLabel patretMap;
	private JLabel patretMapDetail;
	private JLabel patretMapName;
	private JLabel patretMapInfo;

	private JLabel campMap;
	private JLabel campMapDetail;
	private JLabel campMapName;
	private JLabel campMapInfo;

	private JLabel factoryMap;
	private JLabel factoryMapDetail;
	private JLabel factoryMapName;
	private JLabel factoryMapInfo;

	JTextField updatePatretMapName;
	JTextArea updatePatretMapInfo;

	JTextField updateCampMapName;
	JTextArea updateCampMapInfo;

	JTextField updateFactoryMapName;
	JTextField updateFactoryMapInfo;

	// 캐릭터 아이템

	JLabel caracterInfo;

	JLabel bazziImage;
	JLabel bazziIName;
	JLabel bazziIInfo;

	JLabel uniImage;
	JLabel uniName;
	JLabel uniInfo;

	JLabel kephiImage;
	JLabel kephiName;
	JLabel kephiInfo;

	JLabel daoImage;
	JLabel daoName;
	JLabel daoInfo;

	JTextField updatebazziName;
	JTextArea updatebazziInfo;

	JTextField updateUniName;
	JTextArea updateUniInfo;

	JTextField updatekephiImage;
	JTextField updatekephiInfo;

	JTextField updateDaoImage;
	JTextField updateDaoInfo;

	public CrazyArcadeInfoFrame() {

		super();
		initData();
	}

	private void initData() {
		setTitle("크레이지아케이드 정보창");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		mainImg = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "main.png"));
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

		MapInfo = new JLabel("★ Map Info ★");

		patretMap = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "m1.png"));
		patretMapDetail = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "map1.png"));
		patretMapName = new JLabel("111게임 이름");
		patretMapInfo = new JLabel("111게임정보");

		campMap = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "m2.png"));
		campMapDetail = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "map2.png"));
		campMapName = new JLabel("222게임 이름");
		campMapInfo = new JLabel("222게임정보");

		factoryMap = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "m3.png"));
		factoryMapDetail = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "map3.png"));
		factoryMapName = new JLabel("333게임 이름");
		factoryMapInfo = new JLabel("333게임정보");

		updatePatretMapName = new JTextField();
		updatePatretMapInfo = new JTextArea();

		updateCampMapName = new JTextField();
		updateCampMapInfo = new JTextArea();

		updateFactoryMapName = new JTextField();
		updateFactoryMapInfo = new JTextField();
	}

	private void thisMapImgRemove() {
		remove(MapInfo);
		remove(patretMap);
		remove(patretMapDetail);
		remove(campMap);
		remove(campMapDetail);
		remove(factoryMap);
		remove(factoryMapDetail);

	}

	private void thisMapSelectRemove() {

		remove(patretMapName);
		remove(patretMapInfo);
		remove(campMapName);
		remove(campMapInfo);
		remove(factoryMapName);
		remove(factoryMapInfo);
	}

	private void thisMapUpdateRemove() {

		remove(updatePatretMapName);
		remove(updatePatretMapInfo);
		remove(updateCampMapName);
		remove(updateCampMapInfo);
		remove(updateFactoryMapName);
		remove(updateFactoryMapInfo);
	}

	private void gameMapImageComponents() {

		MapInfo.setSize(500, 50);
		MapInfo.setLocation(140, 20);
		MapInfo.setFont(new Font("", Font.BOLD, 30));
		MapInfo.setForeground(Color.white);
		add(MapInfo);

		patretMap.setSize(100, 105);
		patretMap.setLocation(50, 80);
		add(patretMap);

		patretMapDetail.setSize(135, 120);
		patretMapDetail.setLocation(30, 480);
		add(patretMapDetail);

		campMap.setSize(100, 105);
		campMap.setLocation(200, 80);
		add(campMap);

		campMapDetail.setSize(135, 120);
		campMapDetail.setLocation(175, 480);
		add(campMapDetail);

		factoryMap.setSize(100, 105);
		factoryMap.setLocation(345, 80);
		add(factoryMap);

		factoryMapDetail.setSize(135, 120);
		factoryMapDetail.setLocation(320, 480);
		add(factoryMapDetail);

	}

	private void gameMapSelectComponents() {

		patretMapName.setSize(100, 30);
		patretMapName.setLocation(60, 200);
		patretMapName.setForeground(Color.white);
		add(patretMapName);

		patretMapInfo.setSize(100, 230);
		patretMapInfo.setLocation(60, 230);
		patretMapInfo.setForeground(Color.white);
		add(patretMapInfo);

		campMapName.setSize(100, 30);
		campMapName.setLocation(210, 200);
		campMapName.setForeground(Color.white);
		add(campMapName);

		campMapInfo.setSize(100, 230);
		campMapInfo.setLocation(210, 230);
		campMapInfo.setForeground(Color.white);
		add(campMapInfo);

		factoryMapName.setSize(100, 30);
		factoryMapName.setLocation(360, 200);
		factoryMapName.setForeground(Color.white);
		add(factoryMapName);

		factoryMapInfo.setSize(100, 230);
		factoryMapInfo.setLocation(360, 230);
		factoryMapInfo.setForeground(Color.white);
		add(factoryMapInfo);

	}

	private void gameMapUpdateComponents() {
		updatePatretMapName.setSize(100, 20);
		updatePatretMapName.setLocation(50, 200);
		updatePatretMapName.setForeground(Color.white);
		add(updatePatretMapName);

		updatePatretMapInfo.setSize(100, 230);
		updatePatretMapInfo.setLocation(50, 230);
		updatePatretMapInfo.setForeground(Color.white);
		add(updatePatretMapInfo);

		updateCampMapName.setSize(100, 20);
		updateCampMapName.setLocation(200, 200);
		updateCampMapName.setForeground(Color.white);
		add(updateCampMapName);

		updateCampMapInfo.setSize(100, 230);
		updateCampMapInfo.setLocation(200, 230);
		updateCampMapInfo.setForeground(Color.white);
		add(updateCampMapInfo);

		updateFactoryMapName.setSize(100, 20);
		updateFactoryMapName.setLocation(350, 200);
		updateFactoryMapName.setForeground(Color.white);
		add(updateFactoryMapName);

		updateFactoryMapInfo.setSize(100, 230);
		updateFactoryMapInfo.setLocation(350, 230);
		updateFactoryMapInfo.setForeground(Color.white);
		add(updateFactoryMapInfo);

	}

	// character

	private void characterItem() {

		caracterInfo = new JLabel("★ Character Info ★");

		bazziImage = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "ca1.png"));
		bazziIName = new JLabel("캐릭터 이름");
		bazziIInfo = new JLabel("캐릭터 소개");

		uniImage = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "ca2.png"));
		uniName = new JLabel("캐릭터 이름");
		uniInfo = new JLabel("캐릭터 소개");

		kephiImage = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "ca3.png"));
		kephiName = new JLabel("캐릭터 이름");
		kephiInfo = new JLabel("캐릭터 소개");

		daoImage = new JLabel(new ImageIcon(Define.CRAZY_IMAGE_PATH + "ca4.png"));
		daoName = new JLabel("캐릭터 이름");
		daoInfo = new JLabel("캐릭터 소개");

		updatebazziName = new JTextField();
		updatebazziInfo = new JTextArea();

		updateUniName = new JTextField();
		updateUniInfo = new JTextArea();

		updatekephiImage = new JTextField();
		updatekephiInfo = new JTextField();

		updateDaoImage = new JTextField();
		updateDaoInfo = new JTextField();
	}

	private void thisCharacterImgRemove() {

		remove(caracterInfo);
		remove(bazziImage);
		remove(uniImage);
		remove(kephiImage);
		remove(daoImage);
	}

	private void thisCharacterSelectRemove() {

		remove(bazziIName);
		remove(bazziIInfo);
		remove(uniName);
		remove(uniInfo);
		remove(kephiName);
		remove(kephiInfo);
		remove(daoName);
		remove(daoInfo);
	}

	private void thisCharacterUpdateRemove() {
		remove(updatebazziName);
		remove(updatebazziInfo);
		remove(updateUniName);
		remove(updateUniInfo);
		remove(updatekephiImage);
		remove(updatekephiInfo);
		remove(updateDaoImage);
		remove(updateDaoInfo);
	}

	private void gameCharacterImageComponents() {
		caracterInfo.setSize(500, 50);
		caracterInfo.setLocation(105, 20);
		caracterInfo.setFont(new Font("", Font.BOLD, 30));
		caracterInfo.setForeground(Color.white);
		add(caracterInfo);

		bazziImage.setSize(170, 165);
		bazziImage.setLocation(50, 100);
		add(bazziImage);

		uniImage.setSize(170, 165);
		uniImage.setLocation(280, 100);
		add(uniImage);

		kephiImage.setSize(170, 165);
		kephiImage.setLocation(50, 360);
		add(kephiImage);

		daoImage.setSize(170, 165);
		daoImage.setLocation(280, 360);
		add(daoImage);

	}

	private void gameCharacterSelectComponents() {

		bazziIName.setSize(100, 20);
		bazziIName.setLocation(85, 270);
		bazziIName.setForeground(Color.WHITE);
		add(bazziIName);
		bazziIInfo.setSize(150, 50);
		bazziIInfo.setLocation(60, 300);
		bazziIInfo.setForeground(Color.WHITE);
		add(bazziIInfo);

		uniName.setSize(100, 20);
		uniName.setLocation(315, 270);
		uniName.setForeground(Color.WHITE);
		add(uniName);
		uniInfo.setSize(150, 50);
		uniInfo.setLocation(290, 300);
		uniInfo.setForeground(Color.WHITE);
		add(uniInfo);

		kephiName.setSize(100, 20);
		kephiName.setLocation(85, 530);
		kephiName.setForeground(Color.WHITE);
		add(kephiName);
		kephiInfo.setSize(150, 50);
		kephiInfo.setLocation(60, 560);
		kephiInfo.setForeground(Color.WHITE);
		add(kephiInfo);

		daoName.setSize(100, 20);
		daoName.setLocation(315, 530);
		daoName.setForeground(Color.WHITE);
		add(daoName);
		daoInfo.setSize(150, 50);
		daoInfo.setLocation(290, 560);
		daoInfo.setForeground(Color.WHITE);
		add(daoInfo);

	}

	private void gameCharacterUpdateComponents() {

		updatebazziName.setSize(100, 20);
		updatebazziName.setLocation(85, 270);
		add(updatebazziName);
		updatebazziInfo.setSize(150, 50);
		updatebazziInfo.setLocation(60, 300);
		add(updatebazziInfo);

		updateUniName.setSize(100, 20);
		updateUniName.setLocation(315, 270);
		add(updateUniName);
		updateUniInfo.setSize(150, 50);
		updateUniInfo.setLocation(290, 300);
		add(updateUniInfo);

		updatekephiImage.setSize(100, 20);
		updatekephiImage.setLocation(85, 530);
		add(updatekephiImage);
		updatekephiInfo.setSize(150, 50);
		updatekephiInfo.setLocation(60, 560);
		add(updatekephiInfo);

		updateDaoImage.setSize(100, 20);
		updateDaoImage.setLocation(315, 530);
		add(updateDaoImage);
		updateDaoInfo.setSize(150, 50);
		updateDaoInfo.setLocation(290, 560);
		add(updateDaoInfo);

	}

	public static void main(String[] args) {
		new CrazyArcadeInfoFrame();
	}

}
