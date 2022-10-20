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

public class JoinPage extends JFrame implements ActionListener {

	private JLabel join;
	private JLabel userId;
	private JTextField userIdField;
	private JButton userIdCheck;
	private JLabel password;
	private JPasswordField passwordField;
	private JLabel passwordCheck;
	private JPasswordField passwordFieldCheck;
	private JLabel userName;
	private JTextField userNameField;
	private JLabel email;
	private JTextField emailField;
	private JLabel mobile;
	private JTextField mobileField;
	private JButton save;
	private JButton exit;

	public JoinPage() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setTitle("회원가입창");
		setLocation(0, 0);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);

		join = new JLabel(new ImageIcon("images/logo2.png"));
		userId = new JLabel("아이디 : ");
		password = new JLabel("비밀번호 : ");
		passwordCheck = new JLabel("비밀번호 확인 : ");
		userName = new JLabel("이름 : ");
		email = new JLabel("이메일 : ");
		mobile = new JLabel("연락처 : ");

		userIdCheck = new JButton("확인");

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

		join.setSize(125, 30);
		join.setLocation(185, 25);
		add(join);

		userId.setSize(100, 20);
		userId.setLocation(90, 100);
		add(userId);

		userIdField.setSize(130, 25);
		userIdField.setLocation(180, 100);
		userIdField.setBackground(new Color(230, 230, 230));
		add(userIdField);

		userIdCheck.setSize(60, 25);
		userIdCheck.setLocation(320, 100);
		userIdCheck.setContentAreaFilled(false); // 버튼 영역
		userIdCheck.setFocusPainted(false); // 버튼 포커스
		userIdCheck.setForeground(new Color(185, 185, 185));
		add(userIdCheck);

		password.setSize(100, 20);
		password.setLocation(90, 150);
		add(password);

		passwordField.setSize(200, 25);
		passwordField.setLocation(180, 150);
		passwordField.setBackground(new Color(230, 230, 230));
		add(passwordField);

		passwordCheck.setSize(100, 20);
		passwordCheck.setLocation(90, 200);
		add(passwordCheck);

		passwordFieldCheck.setSize(200, 25);
		passwordFieldCheck.setLocation(180, 200);
		passwordFieldCheck.setBackground(new Color(230, 230, 230));
		add(passwordFieldCheck);

		userName.setSize(100, 20);
		userName.setLocation(90, 250);
		add(userName);

		userNameField.setSize(200, 25);
		userNameField.setLocation(180, 250);
		userNameField.setBackground(new Color(230, 230, 230));
		add(userNameField);

		email.setSize(100, 20);
		email.setLocation(90, 300);
		add(email);

		emailField.setSize(200, 25);
		emailField.setLocation(180, 300);
		emailField.setBackground(new Color(230, 230, 230));
		add(emailField);

		mobile.setSize(100, 20);
		mobile.setLocation(90, 350);
		add(mobile);

		mobileField.setSize(200, 25);
		mobileField.setLocation(180, 350);
		mobileField.setBackground(new Color(230, 230, 230));
		add(mobileField);

		save.setSize(70, 25);
		save.setLocation(300, 400);
		save.setBackground(new Color(230, 230, 230));
		save.setContentAreaFilled(false); // 버튼 영역
		save.setFocusPainted(false); // 버튼 포커스
		save.setForeground(new Color(185, 185, 185));
		add(save);

		exit.setSize(70, 25);
		exit.setLocation(380, 400);
		exit.setBackground(new Color(230, 230, 230));
		exit.setContentAreaFilled(false); // 버튼 영역
		exit.setForeground(new Color(185, 185, 185));
		add(exit);

	}

	private void addEventListener() {
		userIdCheck.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();

		if (targetButton.getText().equals(userIdCheck.getText())) {
			System.out.println("아이디확인");
		} else if (targetButton.getText().equals(save.getText())) {
			System.out.println("저장됨");
		} else if (targetButton.getText().equals(exit.getText())) {
			System.out.println("나가기");
			this.setVisible(false);
		}
	}
}
