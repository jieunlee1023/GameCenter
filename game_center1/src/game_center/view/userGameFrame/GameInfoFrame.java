package game_center.view.userGameFrame;

import java.awt.Color;
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

import game_center.dto.GameInfo;
import game_center.dto.RequestGameCenter;
import game_center.service.GameCenterHostService;
import game_center.utils.Define;
import lombok.Data;

@Data
public class GameInfoFrame extends JFrame implements ActionListener {

	GameCenterHostService centerHostService = new GameCenterHostService();
	RequestGameCenter rgc = new RequestGameCenter();
	private JLabel mainImage = new JLabel(new ImageIcon(Define.IMAGE_PATH + "game.gif"));
	private JLabel logo = new JLabel(new ImageIcon(Define.IMAGE_PATH + "logo1.png"));
	private JLabel infomation = new JLabel("상단의 카테고리를 이용하여 원하시는 정보를 찾아보세요!");
	private JLabel memo = new JLabel("◎ 메모장");
	private JTextArea memoTextArea = new JTextArea();

	private JMenuBar bar = new JMenuBar();
	private JMenu menu = new JMenu("메뉴");
	private JMenuItem exit = new JMenuItem("나가기");
	private JMenu gameInfo = new JMenu("게임");
	private JMenuItem gameSelected = new JMenuItem("게임 정보 조회");

	private JMenu gameMapInfo = new JMenu("맵");
	private JMenuItem gameMapSelected = new JMenuItem("맵 조회");

	private JMenu gameCharacterInfo = new JMenu("캐릭터");
	private JMenuItem gameCharacterSelected = new JMenuItem("캐릭터 조회");

	private JLabel gameImage;

	private JLabel info = new JLabel("★ Game Info ★");
	private JLabel gameName = new JLabel();
	private JLabel ageLimit = new JLabel();
	private JLabel ageLimitInfo = new JLabel("연령 제한 : ");
	private JTextArea gameInformation = new JTextArea();

	private GameInfo gameInfoClass;

	public GameInfoFrame(GameInfo gameInfo) {
		this.gameInfoClass = gameInfo;
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

		menu.add(exit);

		gameInfo.add(gameSelected);

		gameMapInfo.add(gameMapSelected);

		gameCharacterInfo.add(gameCharacterSelected);

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
		exit.addActionListener(this);
		gameMapSelected.addActionListener(this);
		gameCharacterSelected.addActionListener(this);
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
			remove(ageLimitInfo);
			remove(gameInformation);

			gameSelectComponents();

			repaint();

		} else if (targetItem.getText().equals(exit.getText())) {
			System.out.println("나가기");
			this.setVisible(false);
		} else if (targetItem.getText().equals(gameMapSelected.getText())) {

			System.out.println("맵 조회 ");
		} else if (targetItem.getText().equals(gameCharacterSelected.getText())) {

			System.out.println("캐릭터 조회 ");
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

		gameName.setSize(400, 30);
		gameName.setLocation(40, 350);
		gameName.setForeground(Color.white);
		gameName.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		gameName.setText(gameInfoClass.getGameName());
		add(gameName);

		ageLimit.setSize(80, 20);
		ageLimit.setLocation(410, 360);
		ageLimit.setForeground(Color.red);
		ageLimit.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		ageLimit.setText(gameInfoClass.getAgeLimit());
		add(ageLimit);

		ageLimitInfo.setSize(100, 20);
		ageLimitInfo.setLocation(340, 360);
		ageLimitInfo.setForeground(Color.white);
		ageLimitInfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		add(ageLimitInfo);

		gameInformation.setSize(400, 200);
		gameInformation.setLocation(40, 400);
		gameInformation.setText(gameInfoClass.getGameInfo());
		gameInformation.setLineWrap(true);
		add(gameInformation);
	}
}
