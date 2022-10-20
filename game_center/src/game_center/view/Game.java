package game_center.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Game extends JFrame implements ActionListener {

	private JPanel mainPanel;
	private JScrollPane scroll;

	private JLabel logo;
	private RoundedButton join;
	private RoundedButton logIn;

	private JLabel allGame;
	private JButton gameButton1;
	private JButton gameButton2;
	private JButton gameButton3;

	public Game() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(1000, 900);
		setTitle("Game Center");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		scroll = new JScrollPane();

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		mainPanel.setSize(1000, 900);
		mainPanel.setLocation(0, 0);
		// mainPanel.setBackground(Color.white);
		add(mainPanel);

		scroll.setSize(1000, 1000);
		scroll.setLocation(0, 0);
		scroll.setBackground(Color.black);
		mainPanel.add(scroll);

	}

	private void addEventListener() {
//		join.addActionListener(this);
//		logIn.addActionListener(this);
//		gameButton1.addActionListener(this);
//		gameButton2.addActionListener(this);
//		gameButton3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();
		if (targetButton.getText().equals(join.getText())) {
			System.out.println("회원가입");
			new JoinPage();
		} else if (targetButton.getText().equals(logIn.getText())) {
			System.out.println("로그인");
			new LoginPage();
		} else if (targetButton.hashCode() == (gameButton1.hashCode())) {
			System.out.println("게임 1");
		} else if (targetButton.hashCode() == (gameButton2.hashCode())) {
			System.out.println("게임 2");
		} else if (targetButton.hashCode() == (gameButton3.hashCode())) {
			System.out.println("게임 3");
		}
	}

	public static void main(String[] args) {
		new Game();
	}
}
