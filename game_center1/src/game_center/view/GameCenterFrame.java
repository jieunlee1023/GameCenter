package game_center.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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
	private JScrollPane scrollPane = new JScrollPane();

	private JLabel logo;
	private RoundedButton myInfo;
	private RoundedButton logOut;
	private JButton back;

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

		allGame = new JLabel("전체게임");

		gameButton1 = new JButton(new ImageIcon(Define.IMAGE_PATH + "btnImg1.png"));
		gameButton2 = new JButton(new ImageIcon(Define.IMAGE_PATH + "btnImg2.png"));
		gameButton3 = new JButton(new ImageIcon(Define.IMAGE_PATH + "btnImg3.png"));

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

		allGame.setSize(150, 50);
		allGame.setLocation(50, 120);
		allGame.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		allGame.setForeground(new Color(230, 230, 230));
		add(allGame);

		gameButton1.setSize(300, 300);
		gameButton1.setLocation(30, 180);
		gameButton1.setBorderPainted(false); // 버튼 테두리
		gameButton1.setContentAreaFilled(false); // 버튼 영역
		add(gameButton1);

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
		this.addMouseWheelListener(new MyListener());
		myInfo.addActionListener(this);
		logOut.addActionListener(this);
		back.addActionListener(this);
		gameButton1.addActionListener(this);
		gameButton2.addActionListener(this);
		gameButton3.addActionListener(this);
		scrollBar.addAdjustmentListener(new MyListener());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();
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
		} else if (targetButton.hashCode() == (gameButton2.hashCode())) {
			System.out.println("게임 2");
		} else if (targetButton.hashCode() == (gameButton3.hashCode())) {
			System.out.println("게임 3");
		}
	}

	private class MyListener extends MouseAdapter implements AdjustmentListener {

		JScrollBar vertical;
		int currentStatus;

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {

			int notches = e.getWheelRotation();
			if (notches < 0) {
				System.out.println("위");
			} else {
				System.out.println("아래");
			}
		}

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			System.out.println("1111111111111111111111111");

			vertical = scrollPane.getVerticalScrollBar();
			currentStatus = e.getValue();

		}
	} // end of inner class

}
