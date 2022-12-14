package game_center.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import game_center.service.GameCenterHostService;

public class userSearch extends JFrame implements ActionListener {

	private JMenuBar bar = new JMenuBar();
	private JMenu screenMenu = new JMenu("유저 정보 조회");
	private JMenuItem allSelected = new JMenuItem("전체 조회");
	private JMenuItem choiceSelected = new JMenuItem("선택 조회");
	private JMenu hostAuthority = new JMenu("관리자 권한");
	private JMenuItem hostIn = new JMenuItem("관리자 임명");
	private JMenuItem hostOut = new JMenuItem("관리자 제명");
	private JMenuItem exit = new JMenuItem("닫기");

	private JTextArea search = new JTextArea();
	private JTextArea userField = new JTextArea();
	private JLabel define = new JLabel("[ ⓐ: 등급 / ⓑ : 아이디 / ⓒ : 비밀번호 / ⓓ : 이름 / ⓔ : 이메일  / ⓕ : 번호]");

	private GameCenterHostService gameCenterHostService = new GameCenterHostService();

	public userSearch() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setTitle("관리자 유저 정보");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(30, 40, 90));

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		screenMenu.add(allSelected);
		screenMenu.add(choiceSelected);
		screenMenu.addSeparator(); // 분리선 삽입
		screenMenu.add(exit);

		hostAuthority.add(hostIn);
		hostAuthority.add(hostOut);

		// 메뉴바에 메뉴 삽입
		bar.add(screenMenu); // 보기 메뉴 삽입
		bar.add(hostAuthority); // 보기 메뉴 삽입
		// 메뉴바를 프레임에 부착
		setJMenuBar(bar);

		search.setSize(400, 30);
		search.setLocation(50, 50);
		search.setFont(new Font("", Font.PLAIN, 20));
		add(search);

		define.setSize(400, 30);
		define.setLocation(50, 90);
		define.setForeground(Color.white);
		add(define);

		userField.setSize(400, 280);
		userField.setLocation(50, 120);
		add(userField);

	}

	private void addEventListener() {
		allSelected.addActionListener(this);
		choiceSelected.addActionListener(this);
		exit.addActionListener(this);
		hostIn.addActionListener(this);
		hostOut.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JMenuItem targetItem = (JMenuItem) e.getSource();
		if (targetItem.getText().equals(allSelected.getText())) {
			userField.setText(gameCenterHostService.selectAllUser().toString());
		} else if (targetItem.getText().equals(choiceSelected.getText())) {
			userField.setText(gameCenterHostService.selectUserById(search.getText()).toString());
		} else if (targetItem.getText().equals(exit.getText())) {
			this.setVisible(false);
		} else if (targetItem.getText().equals(hostIn.getText())) {
			gameCenterHostService.hostIn(search.getText());
			JOptionPane.showMessageDialog(this, "관리자로 임명되었습니다.");
		} else if (targetItem.getText().equals(hostOut.getText())) {
			gameCenterHostService.hostOut(search.getText());
			JOptionPane.showMessageDialog(this, "관리자에서 제명 되었습니다.");
		}
	}

}
