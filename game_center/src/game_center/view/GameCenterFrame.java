package game_center.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import game_center.utils.RoundedButton;

public class GameCenterFrame extends JFrame implements ActionListener {

	JScrollPane scroll = new JScrollPane();

	private JLabel logo;
	private RoundedButton join;
	private RoundedButton logIn;

	private JLabel allGame;
	private JButton gameButton1;
	private JButton gameButton2;
	private JButton gameButton3;
	private JButton gameButton4;
	private JButton gameButton5;
	private JButton gameButton6;
	private JButton gameButton7;
	private JButton gameButton8;

	public GameCenterFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(1000, 800);
		setTitle("Game Center");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		logo = new JLabel(new ImageIcon("images/logo.png"));
		join = new RoundedButton("회원가입");
		logIn = new RoundedButton("로그인");

		allGame = new JLabel("전체게임");

		gameButton1 = new JButton(new ImageIcon("images/btnImg1.png"));
		gameButton2 = new JButton(new ImageIcon("images/btnImg2.png"));
		gameButton3 = new JButton(new ImageIcon("images/btnImg3.png"));
		gameButton4 = new JButton(new ImageIcon("images/btnImg4.png"));

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		add(scroll);

		logo.setSize(175, 60);
		logo.setLocation(420, 20);
		add(logo);

		join.setSize(80, 35);
		join.setLocation(780, 30);
		add(join);

		logIn.setSize(80, 35);
		logIn.setLocation(870, 30);
		add(logIn);

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

		gameButton4.setSize(300, 300);
		gameButton4.setLocation(30, 500); // 위아래 20씩 차이
		add(gameButton4);

	}

	private void addEventListener() {

	}

	public static void main(String[] args) {
		new GameCenterFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();
		if (targetButton.getText().equals(join.getText())) {
			System.out.println("회원가입");
		} else if (targetButton.getText().equals(logIn.getText())) {
			System.out.println("로그인");
		} else if (targetButton.getText().equals(gameButton1.getText())) {
			System.out.println("게임 1");
		} else if (targetButton.getText().equals(gameButton2.getText())) {
			System.out.println("게임 2");
		}
	}

}
