package game_center.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import game_center.dto.RequestGameCenter;
import game_center.service.GameCenterUserService;

public class MyInfoFrame extends JFrame implements ActionListener {

	RequestGameCenter center = new RequestGameCenter();
	GameCenterUserService gameCenterUserService = new GameCenterUserService();

	private JLabel logo;
	private JLabel info;
	private JLabel userId;
	private JTextField userIdField;
	private JLabel password;
	private JPasswordField passwordField;
	private JLabel userName;
	private JTextField userNameField;
	private JLabel email;
	private JTextField emailField;
	private JLabel mobile;
	private JTextField mobileField;
	private JLabel saveComment;
	private JButton leave;
	private JButton save;
	private JButton exit;

	public MyInfoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setTitle("내 정보");
		setLocation(0, 0);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(30, 40, 90));

		logo = new JLabel(new ImageIcon("images/logo2.png"));
		info = new JLabel("[ My Profile ]");
		userId = new JLabel("아이디 : ");
		password = new JLabel("비밀번호 : ");
		userName = new JLabel("이름 : ");
		email = new JLabel("이메일 : ");
		mobile = new JLabel("연락처 : ");

		userIdField = new JTextField();
		passwordField = new JPasswordField();
		userNameField = new JTextField();
		emailField = new JTextField();
		mobileField = new JTextField();

		saveComment = new JLabel();

		leave = new JButton("탈퇴");
		save = new JButton("수정");
		exit = new JButton("나가기");

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		logo.setSize(80, 80);
		logo.setLocation(220, 20);
		add(logo);

		info.setSize(300, 50);
		info.setLocation(90, 60);
		info.setForeground(new Color(230, 230, 230));
		info.setFont(new Font("", Font.BOLD, 15));
		add(info);

		saveComment.setText("[ 정보 수정을 원하시면 변경 후 수정 버튼을 눌러주세요! ]");
		saveComment.setSize(300, 100);
		saveComment.setLocation(90, 55);
		saveComment.setForeground(new Color(230, 230, 230));
		saveComment.setFont(new Font("", Font.BOLD, 10));
		add(saveComment);

		userId.setSize(100, 20);
		userId.setLocation(90, 140);
		userId.setForeground(new Color(230, 230, 230));
		add(userId);

		userIdField.setSize(200, 25);
		userIdField.setLocation(180, 140);
		add(userIdField);

		password.setSize(100, 20);
		password.setLocation(90, 190);
		password.setForeground(new Color(230, 230, 230));
		add(password);

		passwordField.setSize(200, 25);
		passwordField.setLocation(180, 190);
		add(passwordField);

		userName.setSize(100, 20);
		userName.setLocation(90, 240);
		userName.setForeground(new Color(230, 230, 230));
		add(userName);

		userNameField.setSize(200, 25);
		userNameField.setLocation(180, 240);
		add(userNameField);

		email.setSize(100, 20);
		email.setLocation(90, 290);
		email.setForeground(new Color(230, 230, 230));
		add(email);

		emailField.setSize(200, 25);
		emailField.setLocation(180, 290);
		add(emailField);

		mobile.setSize(100, 20);
		mobile.setLocation(90, 340);
		mobile.setForeground(new Color(230, 230, 230));
		add(mobile);

		mobileField.setSize(200, 25);
		mobileField.setLocation(180, 340);
		add(mobileField);

		leave.setSize(70, 25);
		leave.setLocation(220, 400);
		leave.setBackground(new Color(230, 230, 230));
		leave.setContentAreaFilled(false); // 버튼 영역
		leave.setFocusPainted(false); // 버튼 포커스
		leave.setForeground(new Color(230, 230, 230));
		add(leave);

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
		save.addActionListener(this);
		exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetButton = (JButton) e.getSource();

		if (targetButton.getText().equals(save.getText())) {

		} else if (targetButton.getText().equals(exit.getText())) {
			System.out.println("나가기");
			this.setVisible(false);
		}
	}

}
