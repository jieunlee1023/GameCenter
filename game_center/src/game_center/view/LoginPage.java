package game_center.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import game_center.interfaces.IGameCenterHostService;

public class LoginPage extends JFrame implements ActionListener {

	IGameCenterHostService service;

	private JLabel logIn;
	private JLabel userId;
	private JTextField userIdField;
	private JLabel password;
	private JPasswordField passwordField;
	private RoundedButton logInButton;

	public LoginPage(IGameCenterHostService service) {
		// 매개변수로 인터페이스의 주소값을 받아서 기능을 호출한다
		this.service = service; // 주소값을 넘겨받는 과정
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 300);
		setTitle("회원가입창");
		setLocation(0, 0);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);

		logIn = new JLabel(new ImageIcon("images/logo2.png"));
		userId = new JLabel("아이디 : ");
		password = new JLabel("비밀번호 : ");

		userIdField = new JTextField();
		passwordField = new JPasswordField();

		logInButton = new RoundedButton("로 그 인");

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		logIn.setSize(125, 30);
		logIn.setLocation(185, 25);
		add(logIn);

		userId.setSize(100, 20);
		userId.setLocation(90, 80);
		add(userId);

		userIdField.setSize(200, 25);
		userIdField.setLocation(180, 80);
		userIdField.setBackground(new Color(230, 230, 230));
		add(userIdField);

		password.setSize(100, 20);
		password.setLocation(90, 130);
		add(password);

		passwordField.setSize(200, 25);
		passwordField.setLocation(180, 130);
		passwordField.setBackground(new Color(230, 230, 230));
		add(passwordField);

		logInButton.setSize(300, 50);
		logInButton.setLocation(100, 180);
		add(logInButton);

	}

	private void addEventListener() {
		logInButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();
		if (targetButton.getText().equals(logInButton.getText())) {
			System.out.println("로그인 버튼 누름");
		}

	}

}
