package game_center.view.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameInfoFrame extends JFrame implements ActionListener {

	private JLabel gameImage;
	private JLabel gameName;
	private JLabel ageLimit;
	private JLabel gameInfomation;

	private JMenuBar bar = new JMenuBar();
	private JMenu gameInfo = new JMenu("메뉴");
	private JMenuItem gameSelected = new JMenuItem("게임 정보 조회");
	private JMenuItem gameUpdate = new JMenuItem("게임 정보 수정");
	private JMenuItem gameDelete = new JMenuItem("게임 정보 삭제");
	private JMenuItem exit = new JMenuItem("나가기");

	private JMenu gameMapInfo = new JMenu("맵");
	private JMenuItem gameMapSelected = new JMenuItem("맵 조회");
	private JMenuItem gameMapUpdate = new JMenuItem("맵 수정");
	private JMenuItem gameMapDelete = new JMenuItem("맵 삭제");

	private JMenu gameCharacterInfo = new JMenu("캐릭터");
	private JMenuItem gameCharacterSelected = new JMenuItem("캐릭터 조회");
	private JMenuItem gameCharacterUpdate = new JMenuItem("캐릭터 수정");
	private JMenuItem gameCharacterDelete = new JMenuItem("캐릭터 삭제");

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
		getContentPane().setBackground(new Color(30, 40, 90));
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		gameInfo.add(gameSelected);
		gameInfo.add(gameUpdate);
		gameInfo.add(gameDelete);
		gameInfo.addSeparator(); // 분리선 삽입
		gameInfo.add(exit);

		gameMapInfo.add(gameMapSelected);
		gameMapInfo.add(gameMapUpdate);
		gameMapInfo.add(gameMapDelete);

		gameCharacterInfo.add(gameCharacterSelected);
		gameCharacterInfo.add(gameCharacterUpdate);
		gameCharacterInfo.add(gameCharacterDelete);

		bar.add(gameInfo);
		bar.add(gameMapInfo);
		bar.add(gameCharacterInfo);

		setJMenuBar(bar);

	}

	private void addEventListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		new GameInfoFrame();
	}
}
