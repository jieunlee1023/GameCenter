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
import game_center.view.game.CrazyArcadeInfoFrame;
import game_center.view.game.FIFAInfoFrame;
import game_center.view.game.LOLInfoFrame;
import lombok.Data;

@Data
public class GameCenterFrame extends JFrame implements ActionListener {

	IGameCenterHostService centerHostService;
	IGameCenterService centerService;
	GameCenterHostFrame centerHostFrame;

	private final int LOL = 0;
	private final int FIFA = 3;
	private final int CRAZY = 2;

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

	public GameCenterFrame(IGameCenterHostService centerHostService) {
		this.centerHostService = centerHostService;
		initData();
		setInitLayout();
		addEventListener();
	}

	public GameCenterFrame(IGameCenterService centerService) {
		this.centerService = centerService;
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(1000, 900);
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

		game1Name = new JLabel(centerHostService.selectGameName("롤"));
		game1Info = new JLabel(centerHostService.selectGameInfo("롤"));

		game2Name = new JLabel(centerHostService.selectGameName("피파온라인4"));
		game2Info = new JLabel(centerHostService.selectGameInfo("피파온라인4"));

		game3Name = new JLabel(centerHostService.selectGameName("크레이지아케이드"));
		game3Info = new JLabel(centerHostService.selectGameInfo("크레이지아케이드"));
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
		// back.setContentAreaFilled(false); // 버튼 영역
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
		add(game1Name);

		game1Info.setSize(300, 50);
		game1Info.setLocation(30, 510);
		game1Info.setForeground(Color.white);
		add(game1Info);

		game2Name.setSize(300, 20);
		game2Name.setLocation(340, 500);
		game2Name.setForeground(Color.white);
		add(game2Name);

		game2Info.setSize(300, 50);
		game2Info.setLocation(340, 510);
		game2Info.setForeground(Color.white);
		add(game2Info);

		game3Name.setSize(300, 20);
		game3Name.setLocation(650, 500);
		game3Name.setForeground(Color.white);
		add(game3Name);

		game3Info.setSize(300, 50);
		game3Info.setLocation(650, 510);
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
//		this.addMouseWheelListener(new MyListener());
		myInfo.addActionListener(this);
		logOut.addActionListener(this);
		back.addActionListener(this);
		gameButton1.addActionListener(this);
		gameButton2.addActionListener(this);
		gameButton3.addActionListener(this);
		searchButton.addActionListener(this);
//		scrollBar.addAdjustmentListener(new MyListener());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();

		List<GameInfo> list = centerHostService.GameInfo();

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
			if (list.get(LOL).getGameName().equals("롤")) {
				new LOLInfoFrame(list.get(LOL));
			}
		} else if (targetButton.hashCode() == (gameButton2.hashCode())) {
			System.out.println("게임 2");
			if (list.get(FIFA).getGameName().equals("피파온라인4")) {
				new FIFAInfoFrame(list.get(FIFA));
			}
		} else if (targetButton.hashCode() == (gameButton3.hashCode())) {
			System.out.println("게임 3");
			if (list.get(CRAZY).getGameName().equals("크레이지아케이드")) {
				new CrazyArcadeInfoFrame(list.get(CRAZY));
			}
//		} else if (targetButton.hashCode() == searchButton.hashCode()) {
//			if (search.getText().equals("롤")) {
//				if (list.get(LOL).getGameName().equals("롤")) {
//					new LOLInfoFrame(list.get(LOL));
//				}
//			} else if (search.getText().equals("피파온라인4")) {
//				if (list.get(FIFA).getGameName().equals("피파온라인4")) {
//					new FIFAInfoFrame(list.get(FIFA));
//				}
//			} else if (search.getText().equals("크레이지아케이드") || search.getText().equals("크아")
//					|| search.getText().equals("크레이지 아케이드")) {
//				if (list.get(CRAZY).getGameName().equals("크레이지아케이드")) {
//					new CrazyArcadeInfoFrame(list.get(CRAZY));
//				}
		} else {
			JOptionPane.showMessageDialog(this, "일치하는 정보가 없습니다.");
		}
	}
}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		JButton targetButton = (JButton) e.getSource();
//
//		if (targetButton.getText().equals(myInfo.getText())) {
//			System.out.println("내 정보");
//			new MyInfoFrame();
//		} else if (targetButton.hashCode() == (back.hashCode())) {
//			new LoginFrame();
//			this.setVisible(false);
//		} else if (targetButton.getText().equals(logOut.getText())) {
//			System.out.println("로그아웃");
//			System.exit(0);
//		} else if (targetButton.hashCode() == (gameButton1.hashCode())) {
//			System.out.println("게임 1");
//			new GameInfoFrame(gameInfo);
//			System.out.println(gameInfo);
//		} else if (targetButton.hashCode() == (gameButton2.hashCode())) {
//			System.out.println("게임 2");
//			new GameInfoFrame(gameInfo);
//			System.out.println(gameInfo);
//		} else if (targetButton.hashCode() == (gameButton3.hashCode())) {
//			System.out.println("게임 3");
//			new GameInfoFrame(gameInfo);
//			System.out.println(gameInfo);
//		} else if (targetButton.hashCode() == searchButton.hashCode()) {
//			if (search.getText() == "게임 아이디 등 검색할 정보") {
//				System.out.println("검색버튼");
//			}
//		}
//
//	}

//private class MyListener extends MouseAdapter implements AdjustmentListener {
//
//	JScrollBar vertical;
//	int currentStatus;
//
//	@Override
//	public void mouseWheelMoved(MouseWheelEvent e) {
//
//		int notches = e.getWheelRotation();
//		if (notches < 0) {
//			System.out.println("위");
//		} else {
//			System.out.println("아래");
//		}
//	}
//
//	@Override
//	public void adjustmentValueChanged(AdjustmentEvent e) {
//		System.out.println("1111111111111111111111111");
//
//		vertical = scrollPane.getVerticalScrollBar();
//		currentStatus = e.getValue();
//
//	}
//} // end of inner class
