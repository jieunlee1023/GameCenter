package game_center.view.game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import game_center.utils.Define;
import lombok.Data;

@Data
public class GameInfoFrame extends JFrame implements ActionListener {

	private JLabel mainImage = new JLabel(new ImageIcon(Define.IMAGE_PATH + "game.gif"));
	private JLabel logo = new JLabel(new ImageIcon(Define.IMAGE_PATH + "logo1.png"));
	private JLabel infomation = new JLabel("상단의 카테고리를 이용하여 원하시는 정보를 찾아보세요!");
	private JLabel memo = new JLabel("◎ 메모장");
	private JTextArea memoTextArea = new JTextArea();

	private JMenuBar bar = new JMenuBar();
	private JMenu menu = new JMenu("메뉴");
	private JMenu gameInfo = new JMenu("게임");
	private JMenuItem gameSelected = new JMenuItem("게임 정보 조회");
	private JMenuItem gameUpDate = new JMenuItem("게임 정보 수정");
	private JMenuItem gameSave = new JMenuItem("게임 정보 저장");
	private JMenuItem gameDelete = new JMenuItem("게임 정보 삭제");
	private JMenuItem exit = new JMenuItem("나가기");

	private JMenu gameMapInfo = new JMenu("맵");
	private JMenuItem gameMapSelected = new JMenuItem("맵 조회");
	private JMenuItem gameMapUpdate = new JMenuItem("맵 수정");
	private JMenuItem gameMapSave = new JMenuItem("맵 저장");
	private JMenuItem gameMapDelete = new JMenuItem("맵 삭제");

	private JMenu gameCharacterInfo = new JMenu("캐릭터");
	private JMenuItem gameCharacterSelected = new JMenuItem("캐릭터 조회");
	private JMenuItem gameCharacterUpdate = new JMenuItem("캐릭터 수정");
	private JMenuItem gameCharacterSave = new JMenuItem("캐릭터 저장");
	private JMenuItem gameCharacterDelete = new JMenuItem("캐릭터 삭제");

	private JLabel gameImage;

	private JLabel info = new JLabel("★ Game Info ★");
	private JLabel gameName = new JLabel(" 게임 이름 ~~ ");
	private JLabel ageLimit = new JLabel(" 연령제한 ~~");
	private JLabel gameInformation = new JLabel(" 게임 정보 ~~");

	// 수정시 사용 (관리자만 사용함)
	private JTextArea gameNameUpdate = new JTextArea();
	private JTextArea ageLimitUpdate = new JTextArea();
	private JTextArea gameInfomationUpdate = new JTextArea();

	public GameInfoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 700);
		setTitle("게임 정보창");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(1, 51, 104));

		gameImage = new JLabel();
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		gameInfo.add(gameSelected);
		gameInfo.add(gameUpDate);
		gameInfo.add(gameSave);
		gameInfo.add(gameDelete);
		gameInfo.addSeparator(); // 분리선 삽입
		gameInfo.add(exit);

		gameMapInfo.add(gameMapSelected);
		gameMapInfo.add(gameMapUpdate);
		gameMapInfo.add(gameMapSave);
		gameMapInfo.add(gameMapDelete);

		gameCharacterInfo.add(gameCharacterSelected);
		gameCharacterInfo.add(gameCharacterUpdate);
		gameCharacterInfo.add(gameCharacterSave);
		gameCharacterInfo.add(gameCharacterDelete);

		bar.add(menu);
		bar.add(gameInfo);
		bar.add(gameMapInfo);
		bar.add(gameCharacterInfo);

		setJMenuBar(bar);

		mainImage.setSize(500, 350);
		mainImage.setLocation(-21, 110);
		add(mainImage);

		logo.setSize(80, 80);
		logo.setLocation(210, 30);
		add(logo);

		infomation.setSize(400, 20);
		infomation.setLocation(90, 420);
		infomation.setForeground(Color.white);
		add(infomation);

		gameInformation.setSize(400, 200);
		gameInformation.setLocation(50, 300);
		gameInformation.setForeground(Color.white);
		add(gameInformation);
		memo.setSize(400, 20);
		memo.setLocation(50, 460);
		memo.setForeground(Color.white);
		add(memo);

		memoTextArea.setSize(400, 120);
		memoTextArea.setLocation(50, 480);
		memoTextArea.setForeground(Color.white);
		memoTextArea.setBackground(new Color(0, 30, 70));
		add(memoTextArea);

	}

	private void addEventListener() {
		gameSelected.addActionListener(this);
		gameUpDate.addActionListener(this);
		gameSave.addActionListener(this);
		gameDelete.addActionListener(this);
		exit.addActionListener(this);
		gameMapSelected.addActionListener(this);
		gameMapUpdate.addActionListener(this);
		gameMapDelete.addActionListener(this);
		gameMapSave.addActionListener(this);
		gameCharacterSelected.addActionListener(this);
		gameCharacterUpdate.addActionListener(this);
		gameCharacterDelete.addActionListener(this);
		gameCharacterSave.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JMenuItem targetItem = (JMenuItem) e.getSource();

		if (targetItem.getText().equals(gameSelected.getText())) {

			remove(mainImage);
			remove(logo);
			remove(infomation);
			remove(memo);
			remove(memoTextArea);
			remove(gameImage);
			remove(gameName);
			remove(ageLimit);
			remove(gameInformation);
			remove(gameNameUpdate);
			remove(ageLimitUpdate);
			remove(gameInfomationUpdate);

			gameSelectComponents();

			repaint();

		} else if (targetItem.getText().equals(gameUpDate.getText())) {

			remove(mainImage);
			remove(logo);
			remove(infomation);
			remove(memo);
			remove(memoTextArea);
			remove(gameImage);
			remove(gameName);
			remove(ageLimit);
			remove(gameInformation);

			System.out.println("게임 정보 수정");
			gameUpdateComponents();
			repaint();

		} else if (targetItem.getText().equals(gameSave.getText())) {
			System.out.println("게임 저장 ");
		} else if (targetItem.getText().equals(gameDelete.getText())) {
			System.out.println("게임 삭제 ");
		} else if (targetItem.getText().equals(exit.getText())) {
			System.out.println("나가기");
			this.setVisible(false);
		} else if (targetItem.getText().equals(gameMapSelected.getText())) {
			System.out.println("맵 조회 ");
		} else if (targetItem.getText().equals(gameMapUpdate.getText())) {
			System.out.println("맵 수정 ");
		} else if (targetItem.getText().equals(gameMapSave.getText())) {
			System.out.println("맵 저장 ");
		} else if (targetItem.getText().equals(gameMapDelete.getText())) {
			System.out.println("맵 삭제 ");
		} else if (targetItem.getText().equals(gameCharacterSelected.getText())) {
			System.out.println("캐릭터 조회 ");
		} else if (targetItem.getText().equals(gameCharacterUpdate.getText())) {
			System.out.println("캐릭터 수정 ");
		} else if (targetItem.getText().equals(gameCharacterSave.getText())) {
			System.out.println("캐릭터 저장");
		} else if (targetItem.getText().equals(gameCharacterDelete.getText())) {
			System.out.println("캐릭터 삭제 ");
		}
	}

	private void gameSelectComponents() {

		info.setSize(500, 50);
		info.setLocation(140, 20);
		info.setFont(new Font("", Font.BOLD, 30));
		info.setForeground(Color.white);
		add(info);

		gameImage.setSize(400, 400);
		gameImage.setLocation(40, 0);
		gameImage.setBackground(Color.white);
		add(gameImage);

		gameName.setSize(400, 20);
		gameName.setLocation(40, 360);
		gameName.setForeground(Color.white);
		add(gameName);

		ageLimit.setSize(400, 20);
		ageLimit.setLocation(350, 360);
		ageLimit.setForeground(Color.white);
		add(ageLimit);

		gameInformation.setSize(400, 200);
		gameInformation.setLocation(50, 300);
		gameInformation.setLocation(40, 300);
		gameInformation.setForeground(Color.white);
		add(gameInformation);
	}

	private void gameUpdateComponents() {
		gameImage.setSize(400, 400);
		gameImage.setLocation(40, 0);
		gameImage.setBackground(Color.white);
		add(gameImage);

		gameNameUpdate.setSize(300, 20);
		gameNameUpdate.setLocation(40, 370);
		add(gameNameUpdate);

		ageLimitUpdate.setSize(80, 20);
		ageLimitUpdate.setLocation(360, 370);
		add(ageLimitUpdate);

		gameInfomationUpdate.setSize(400, 200);
		gameInfomationUpdate.setLocation(40, 400);
		add(gameInfomationUpdate);

	}

}
