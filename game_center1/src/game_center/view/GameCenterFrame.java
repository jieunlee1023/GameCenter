package game_center.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import game_center.dto.GameInfo;
import game_center.interfaces.IGameCenterHostService;
import game_center.interfaces.IGameCenterService;
import game_center.utils.Define;
import game_center.view.userGameFrame.CrazyArcadeInfoFrame;
import game_center.view.userGameFrame.FIFAInfoFrame;
import game_center.view.userGameFrame.LOLInfoFrame;
import lombok.Data;

@Data
public class GameCenterFrame extends JFrame implements ActionListener {

	private IGameCenterService centerService;

	private List<GameInfo> gameInfos;
	private GameInfo firstGameInfos;
	private GameInfo secondGameInfos;
	private GameInfo thirdGameInfos;

	private final int LOL = 0;
	private final int CRAZY = 1;
	private final int FIFA = 2;

	private JPanel mainPanel = new JPanel();
	private JScrollBar scrollBar = new JScrollBar();
	private JScrollPane scrollPane = new JScrollPane();

	private JLabel logo;
	private RoundedButton myInfo;
	private RoundedButton logOut;
	private JButton back;

	private JLabel allGame;
	private JButton gameButton1;
	private JButton gameButton2;
	private JButton gameButton3;

	private JTextArea search;
	private JButton searchButton;

	private JLabel game1Name;
	private JLabel game1Info;

	private JLabel game2Name;
	private JLabel game2Info;

	private JLabel game3Name;
	private JLabel game3Info;

	public GameCenterFrame(IGameCenterService centerService) {
		this.centerService = centerService;
		gameInfo();
		initData();
		setInitLayout();
		addEventListener();
	}

	private void gameInfo() {
		gameInfos = centerService.GameInfo();
		for (GameInfo gameInfo : gameInfos) {
			if (gameInfo.getGameName().equals("롤")) {
				firstGameInfos = gameInfo;
			} else if (gameInfo.getGameName().equals("피파온라인4")) {
				secondGameInfos = gameInfo;
			} else if (gameInfo.getGameName().equals("크레이지아케이드")) {
				thirdGameInfos = gameInfo;
			}
		}
	}

	private void initData() {
		setSize(1000, 650);
		setTitle("Game Center");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(30, 40, 90));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		scrollBar = new JScrollBar(JScrollBar.VERTICAL, 10, 100, 10, 1000);
		add(BorderLayout.EAST, mainPanel);

		mainPanel.setLayout(new GridLayout());
		mainPanel.add(scrollBar);
		mainPanel.setEnabled(false);

		logo = new JLabel(new ImageIcon(Define.IMAGE_PATH + "logo1.png"));
		myInfo = new RoundedButton("내 정보");
		logOut = new RoundedButton("로그아웃");
		back = new JButton(new ImageIcon(Define.IMAGE_PATH + "back.png"));

		allGame = new JLabel("· 전체게임");

		gameButton1 = new JButton(new ImageIcon(Define.IMAGE_PATH + "btnImg1.png"));
		gameButton2 = new JButton(new ImageIcon(Define.IMAGE_PATH + "btnImg2.png"));
		gameButton3 = new JButton(new ImageIcon(Define.IMAGE_PATH + "btnImg3.png"));

		search = new JTextArea();
		searchButton = new JButton(new ImageIcon(Define.IMAGE_PATH + "search.png"));

		game1Name = new JLabel(firstGameInfos.getGameName());
		game1Info = new JLabel(firstGameInfos.getGameInfo());

		game2Name = new JLabel(secondGameInfos.getGameName());
		game2Info = new JLabel(secondGameInfos.getGameInfo());

		game3Name = new JLabel(thirdGameInfos.getGameName());
		game3Info = new JLabel(thirdGameInfos.getGameInfo());
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		logo.setSize(80, 80);
		logo.setLocation(450, 20);
		add(logo);

		myInfo.setSize(80, 35);
		myInfo.setLocation(780, 20);
		add(myInfo);

		logOut.setSize(80, 35);
		logOut.setLocation(870, 20);
		add(logOut);

		back.setSize(50, 50);
		back.setLocation(20, 20);
		back.setBorderPainted(false); // 버튼 테두리
		back.setFocusPainted(false); // 버튼 포커스
		back.setBackground(new Color(30, 40, 90));
		add(back);

		searchButton.setSize(30, 30);
		searchButton.setLocation(920, 130);
		searchButton.setBorderPainted(false); // 버튼 테두리
		searchButton.setContentAreaFilled(false); // 버튼 영역
		searchButton.setBackground(new Color(255, 255, 255)); // 버튼 영역
		add(searchButton);

		search.setSize(210, 30);
		search.setLocation(700, 130);
		search.setBackground(new Color(230, 230, 230));
		search.setFont(new Font("", Font.PLAIN, 15));
		add(search);

		allGame.setSize(150, 50);
		allGame.setLocation(35, 120);
		allGame.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		allGame.setForeground(new Color(230, 230, 230));
		add(allGame);

		gameButton1.setSize(300, 300);
		gameButton1.setLocation(30, 180);
		gameButton1.setBorderPainted(false); // 버튼 테두리
		gameButton1.setContentAreaFilled(false); // 버튼 영역
		add(gameButton1);

		game1Name.setSize(300, 20);
		game1Name.setLocation(30, 500);
		game1Name.setForeground(Color.white);
		game1Name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(game1Name);

		game1Info.setSize(300, 50);
		game1Info.setLocation(25, 510);
		game1Info.setForeground(Color.white);
		add(game1Info);

		game2Name.setSize(300, 20);
		game2Name.setLocation(340, 500);
		game2Name.setForeground(Color.white);
		game2Name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(game2Name);

		game2Info.setSize(300, 50);
		game2Info.setLocation(335, 510);
		game2Info.setForeground(Color.white);
		add(game2Info);

		game3Name.setSize(300, 20);
		game3Name.setLocation(650, 500);
		game3Name.setForeground(Color.white);
		game3Name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(game3Name);

		game3Info.setSize(300, 50);
		game3Info.setLocation(655, 510);
		game3Info.setForeground(Color.white);
		add(game3Info);

		gameButton2.setSize(300, 300);
		gameButton2.setLocation(340, 180);
		gameButton2.setBorderPainted(false); // 버튼 테두리
		gameButton2.setContentAreaFilled(false); // 버튼 영역
		add(gameButton2);

		gameButton3.setSize(300, 300);
		gameButton3.setLocation(650, 180); // 양 옆 10씩 차이
		gameButton3.setBorderPainted(false); // 버튼 테두리
		gameButton3.setContentAreaFilled(false); // 버튼 영역
		add(gameButton3);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);

	}

	private void addEventListener() {
		myInfo.addActionListener(this);
		logOut.addActionListener(this);
		back.addActionListener(this);
		gameButton1.addActionListener(this);
		gameButton2.addActionListener(this);
		gameButton3.addActionListener(this);
		searchButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();

		List<GameInfo> list = centerService.GameInfo();

		if (targetButton.getText().equals(myInfo.getText())) {
			System.out.println("내 정보");
			new MyInfoFrame();
		} else if (targetButton.hashCode() == (back.hashCode())) {
			new LoginFrame();
			this.setVisible(false);
		} else if (targetButton.getText().equals(logOut.getText())) {
			System.out.println("로그아웃");
			System.exit(0);
		} else if (targetButton.hashCode() == (gameButton1.hashCode())) {
			System.out.println("게임 1");
			new LOLInfoFrame(firstGameInfos);
		} else if (targetButton.hashCode() == (gameButton2.hashCode())) {
			System.out.println("게임 2");
			new FIFAInfoFrame(secondGameInfos);
		} else if (targetButton.hashCode() == (gameButton3.hashCode())) {
			System.out.println("게임 3");
			new CrazyArcadeInfoFrame(thirdGameInfos);
		}
	}
}
