package game_center.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import game_center.dto.RequestGameCenter;
import game_center.interfaces.IGameCenterHostService;
import game_center.service.GameCenterHostService;
import game_center.utils.DBClient;

public class LoginFrame extends JFrame implements ActionListener {

	IGameCenterHostService service;
	GameCenterHostService centerHostService = new GameCenterHostService();

	private JLabel logIn;
	private JLabel userId;
	private JTextField userIdField;
	private JLabel password;
	private JPasswordField passwordField;
	private RoundedButton logInButton;

	public LoginFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public LoginFrame(IGameCenterHostService service) {
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

	public void addEventListener() {
		logInButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		boolean flag = centerHostService.logIn(userIdField.getText(), passwordField.getText());

		JButton targetButton = (JButton) e.getSource();
		if (targetButton.getText().equals(logInButton.getText()) && flag) {
			System.out.println(userIdField.getText() + "로 로그인 성공");
			System.out.println("로그인 성공");
			this.setVisible(false);
//			new GameCenterFrame();

		} else {
			System.out.println("로그인 실패");
			JOptionPane.showMessageDialog(this, "일치하는 정보가 없습니다.");

		}
	}
}
