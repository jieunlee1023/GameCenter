package game_center.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import game_center.interfaces.IGameCenterHostService;
import game_center.interfaces.IGameCenterService;
import game_center.utils.Define;
import lombok.Data;

@Data
public class GameCenterFrame extends JFrame implements ActionListener {

	IGameCenterHostService centerHostService;
	IGameCenterService centerService; 

	private JPanel mainPanel = new JPanel();
	private JScrollBar scrollBar = new JScrollBar();

	private JLabel logo;
	private RoundedButton myInfo;
	private RoundedButton logOut;

	private JLabel allGame;
	private JButton gameButton1;
	private JButton gameButton2;
	private JButton gameButton3;

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
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		scrollBar = new JScrollBar(JScrollBar.VERTICAL, 10, 10, 10, 1000);
		add(BorderLayout.EAST, mainPanel);

		mainPanel.setLayout(new GridLayout());
		mainPanel.add(scrollBar);

		logo = new JLabel(new ImageIcon(Define.IMAGE_PATH + "logo.png"));
		myInfo = new RoundedButton("내 정보");
		logOut = new RoundedButton("로그아웃");

		allGame = new JLabel("전체게임");

		gameButton1 = new JButton(new ImageIcon(Define.IMAGE_PATH + "btnImg1.png"));
		gameButton2 = new JButton(new ImageIcon(Define.IMAGE_PATH + "btnImg2.png"));
		gameButton3 = new JButton(new ImageIcon(Define.IMAGE_PATH + "btnImg3.png"));

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		logo.setSize(175, 60);
		logo.setLocation(420, 20);
		add(logo);

		myInfo.setSize(80, 35);
		myInfo.setLocation(780, 30);
		add(myInfo);

		logOut.setSize(80, 35);
		logOut.setLocation(870, 30);
		add(logOut);

		allGame.setSize(150, 50);
		allGame.setLocation(50, 120);
		allGame.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		add(allGame);

		gameButton1.setSize(300, 300);
		gameButton1.setLocation(30, 180);
		// gameButton1.setBorderPainted(false); // 버튼 테두리
		// gameButton1.setContentAreaFilled(false); // 버튼 영역
		// gameButton1.setFocusPainted(false); // 버튼 포커스
		add(gameButton1);

		gameButton2.setSize(300, 300);
		gameButton2.setLocation(340, 180);
		add(gameButton2);

		gameButton3.setSize(300, 300);
		gameButton3.setLocation(650, 180); // 양 옆 10씩 차이
		add(gameButton3);

	}

	private void addEventListener() {
		this.addMouseWheelListener(new MyMouseListener());
		myInfo.addActionListener(this);
		logOut.addActionListener(this);
		gameButton1.addActionListener(this);
		gameButton2.addActionListener(this);
		gameButton3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();
		if (targetButton.getText().equals(myInfo.getText())) {
			System.out.println("내 정보");
		} else if (targetButton.getText().equals(logOut.getText())) {
			System.out.println("로그아웃");
		} else if (targetButton.hashCode() == (gameButton1.hashCode())) {
			System.out.println("게임 1");
		} else if (targetButton.hashCode() == (gameButton2.hashCode())) {
			System.out.println("게임 2");
		} else if (targetButton.hashCode() == (gameButton3.hashCode())) {
			System.out.println("게임 3");
		}
	}

	private class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			if (e.getUnitsToScroll() == 3 || e.getUnitsToScroll() == 6) {
				System.out.println("내려가는 중");
				boolean flag = true;

			} else {
				System.out.println("위로가는중 중");
			}
		}
	} // end of inner class
}
