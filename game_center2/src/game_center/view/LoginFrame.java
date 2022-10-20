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
import game_center.service.GameCenterUserService;

public class LoginFrame extends JFrame implements ActionListener {

	IGameCenterHostService centerHostService;
	RequestGameCenter center = new RequestGameCenter();
	GameCenterHostService gameCenterHostService = new GameCenterHostService();
	GameCenterUserService gameCenterUserService = new GameCenterUserService();

	private JLabel logIn;
	private JLabel userId;
	private JTextField userIdField;
	private JLabel password;
	private JPasswordField passwordField;
	private RoundedButton joinButton;
	private RoundedButton logInButton;

	public LoginFrame() {
		// 매개변수로 인터페이스의 주소값을 받아서 기능을 호출한다
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 300);
		setTitle("회원가입");
		setLocation(0, 0);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		logIn = new JLabel(new ImageIcon("images/logo2.png"));
		userId = new JLabel("아이디 : ");
		password = new JLabel("비밀번호 : ");

		userIdField = new JTextField();
		passwordField = new JPasswordField();

		joinButton = new RoundedButton("회 원 가 입");
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

		joinButton.setSize(150, 50);
		joinButton.setLocation(90, 180);
		add(joinButton);

		logInButton.setSize(150, 50);
		logInButton.setLocation(250, 180);
		add(logInButton);

	}

	public void addEventListener() {
		joinButton.addActionListener(this);
		logInButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();

		if (targetButton.getText() != joinButton.getText()) {

			boolean flag = gameCenterHostService.logIn(center, userIdField.getText(), passwordField.getText());

			if (targetButton.getText().equals(logInButton.getText()) && flag) {
				if (gameCenterHostService.identityNum(userIdField.getText()) == 1) {
					System.out.println(" 관리자 로그인 성공");
					new GameCenterFrame(centerHostService);
					this.setVisible(false);
				} else {
					System.out.println(" 사용자 로그인 성공");
					new GameCenterFrame(centerHostService);
					this.setVisible(false);
				}
			} else {
				System.out.println("로그인 실패");
				JOptionPane.showMessageDialog(this, "일치하는 정보가 없습니다.");
			}

		} else {
			System.out.println("회원가입 창");
			new JoinFrame();
		}

	}
}
