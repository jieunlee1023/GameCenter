package game_center.view;

import java.awt.Color;
import java.awt.Font;
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
import game_center.service.GameCenterUserService;

public class JoinFrame extends JFrame implements ActionListener {

	RequestGameCenter center = new RequestGameCenter();
	GameCenterUserService gameCenterUserService = new GameCenterUserService();

	private JLabel logo;
	private JLabel userId;
	private JLabel userIdComment;
	private JTextField userIdField;
	private JButton userIdCheckBtn;
	private JLabel password;
	private JPasswordField passwordField;
	private JLabel passwordCheck;
	private JPasswordField passwordFieldCheck;
	private JButton passwordCheckBtn;
	private JLabel diffrentPW;

	private JLabel userName;
	private JTextField userNameField;
	private JLabel email;
	private JTextField emailField;
	private JLabel mobile;
	private JTextField mobileField;
	private JButton save;
	private JButton exit;
	private boolean userIdCehck;
	private boolean userPasswordCehck;

	public JoinFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setTitle("회원가입");
		setLocation(0, 0);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(30, 40, 90));

		logo = new JLabel(new ImageIcon("images/logo2.png"));
		userId = new JLabel("아이디 : ");
		userIdComment = new JLabel("※ 아이디는 10글자까지 가능합니다.");
		password = new JLabel("비밀번호 : ");
		passwordCheck = new JLabel("비밀번호 확인 : ");
		diffrentPW = new JLabel("※ 비밀번호가 같지 않습니다. ");

		userName = new JLabel("이름 : ");
		email = new JLabel("이메일 : ");
		mobile = new JLabel("연락처 : ");

		userIdCheckBtn = new JButton("확인");
		passwordCheckBtn = new JButton("확인");

		userIdField = new JTextField();
		passwordField = new JPasswordField();
		passwordFieldCheck = new JPasswordField();
		userNameField = new JTextField();
		emailField = new JTextField();
		mobileField = new JTextField();

		save = new JButton("저장");
		exit = new JButton("나가기");

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		logo.setSize(80, 80);
		logo.setLocation(210, 10);
		add(logo);

		userId.setSize(100, 20);
		userId.setLocation(90, 100);
		userId.setForeground(new Color(230, 230, 230));
		add(userId);

		userIdComment.setSize(500, 25);
		userIdComment.setLocation(180, 120);
		userIdComment.setFont(new Font("맑은고딕", Font.PLAIN, 10));
		userIdComment.setForeground(new Color(230, 230, 230));
		add(userIdComment);

		userIdField.setSize(130, 25);
		userIdField.setLocation(180, 100);
		add(userIdField);

		userIdCheckBtn.setSize(60, 25);
		userIdCheckBtn.setLocation(320, 100);
		userIdCheckBtn.setContentAreaFilled(false); // 버튼 영역
		userIdCheckBtn.setFocusPainted(false); // 버튼 포커스
		userIdCheckBtn.setForeground(new Color(230, 230, 230));
		add(userIdCheckBtn);

		password.setSize(100, 20);
		password.setLocation(90, 150);
		password.setForeground(new Color(230, 230, 230));
		add(password);

		passwordField.setSize(130, 25);
		passwordField.setLocation(180, 150);
		add(passwordField);

		passwordCheck.setSize(100, 20);
		passwordCheck.setLocation(90, 200);
		passwordCheck.setForeground(new Color(230, 230, 230));
		add(passwordCheck);

		passwordFieldCheck.setSize(130, 25);
		passwordFieldCheck.setLocation(180, 200);
		add(passwordFieldCheck);

		passwordCheckBtn.setSize(60, 25);
		passwordCheckBtn.setLocation(320, 200);
		passwordCheckBtn.setContentAreaFilled(false); // 버튼 영역
		passwordCheckBtn.setFocusPainted(false); // 버튼 포커스
		passwordCheckBtn.setForeground(new Color(230, 230, 230));
		add(passwordCheckBtn);

		diffrentPW.setSize(500, 25);
		diffrentPW.setLocation(0, 0);
		diffrentPW.setFont(new Font("맑은고딕", Font.PLAIN, 10));
		diffrentPW.setForeground(new Color(230, 230, 230));

		userName.setSize(100, 20);
		userName.setLocation(90, 250);
		userName.setForeground(new Color(230, 230, 230));
		add(userName);

		userNameField.setSize(200, 25);
		userNameField.setLocation(180, 250);
		add(userNameField);

		email.setSize(100, 20);
		email.setLocation(90, 300);
		email.setForeground(new Color(230, 230, 230));
		add(email);

		emailField.setSize(200, 25);
		emailField.setLocation(180, 300);
		add(emailField);

		mobile.setSize(100, 20);
		mobile.setLocation(90, 350);
		mobile.setForeground(new Color(230, 230, 230));
		add(mobile);

		mobileField.setSize(200, 25);
		mobileField.setLocation(180, 350);
		add(mobileField);

		save.setSize(70, 25);
		save.setLocation(300, 400);
		save.setBackground(new Color(230, 230, 230));
		save.setContentAreaFilled(false); // 버튼 영역
		save.setFocusPainted(false); // 버튼 포커스
		save.setForeground(new Color(230, 230, 230));
		add(save);

		exit.setSize(70, 25);
		exit.setLocation(380, 400);
		exit.setBackground(new Color(230, 230, 230));
		exit.setContentAreaFilled(false); // 버튼 영역
		exit.setForeground(new Color(230, 230, 230));
		add(exit);

	}

	private void addEventListener() {
		userIdCheckBtn.addActionListener(this);
		passwordCheckBtn.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GameCenterUserService centerUserService = new GameCenterUserService();
		JButton targetButton = (JButton) e.getSource();

		if (targetButton.hashCode() == (userIdCheckBtn.hashCode())) {
			userIdCehck = gameCenterUserService.joinIdCheck(userIdField.getText());
			System.out.println("아이디 중복 체크 : " + userIdCehck);

		} else if (targetButton.hashCode() == passwordCheckBtn.hashCode()) {
			if (passwordField.getText().equals(passwordFieldCheck.getText())) {
				System.out.println("비밀번호 체크 완료");
				userPasswordCehck = true;
			} else if (passwordField.getText().isEmpty()) {
				System.out.println("비밀번호를 입력하세요.");
				userPasswordCehck = false;
			} else if (passwordFieldCheck.getText().isEmpty()) {
				System.out.println("비밀번호 확인을 입력하세요.");
				userPasswordCehck = false;
			} else {
				System.out.println("비밀번호를 확인하세요.");
				userPasswordCehck = false;
			}
		} else if (targetButton.getText().equals(save.getText()) && userIdCehck && userPasswordCehck) {

			center.setUserId(userIdField.getText());
			center.setPassword(passwordField.getText());
			center.setPasswordCheck(passwordFieldCheck.getText());
			center.setUserName(userNameField.getText());
			center.setEmail(emailField.getText());
			center.setMobile(mobileField.getText());

			if (userIdField.getText().isEmpty()) {
				System.out.println("아이디를 입력하세요");
			} else if (passwordField.getText().isEmpty()) {
				System.out.println("비밀번호를 입력하세요.");
			} else if (userNameField.getText().isEmpty()) {
				System.out.println("회원님의 이름을 입력하세요.");
			} else if (emailField.getText().isEmpty()) {
				System.out.println("회원님의 이메일을 입력하세요.");
			} else if (mobileField.getText().isEmpty()) {
				System.out.println("전화번호를 입력하세요.");
			} else {
				gameCenterUserService.insertJoin(center);
				System.out.println("회원가입 완료 !");
				JOptionPane.showMessageDialog(this, "회원가입이 완료 되었습니다.");
				this.setVisible(false);
			}
		} else if (targetButton.getText().equals(save.getText()) && !userIdCehck) {
			System.out.println("아이디 중복 체크를 확인하세요.");
		} else if (targetButton.getText().equals(save.getText()) && !userPasswordCehck) {
			System.out.println("비밀번호 확인 체크를 확인하세요.");
		} else if (targetButton.getText().equals(exit.getText())) {
			System.out.println("나가기");
			this.setVisible(false);
		}
	}
}
