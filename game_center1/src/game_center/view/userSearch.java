package game_center.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game_center.service.GameCenterHostService;
import game_center.utils.Define;

public class userSearch extends JFrame implements ActionListener {

	private JMenuBar bar = new JMenuBar();
	private JMenu screenMenu = new JMenu("유저 정보 조회");
	private JMenuItem allSelected = new JMenuItem("전체 조회");
	private JMenuItem choiceSelected = new JMenuItem("선택 조회");
	private JMenuItem exit = new JMenuItem("닫기");

	private JTextArea search = new JTextArea();
	private JButton searchButton = new JButton(new ImageIcon(Define.IMAGE_PATH + "search.png"));
	private JTextArea userField = new JTextArea();

	GameCenterHostService gameCenterHostService = new GameCenterHostService();

	public userSearch() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setTitle("관리자 게임 정보");
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

		// 메뉴바에 메뉴 삽입
		bar.add(screenMenu); // 보기 메뉴 삽입
		// 메뉴바를 프레임에 부착
		setJMenuBar(bar);

		searchButton.setSize(30, 30);
		searchButton.setLocation(420, 50);
		searchButton.setBorderPainted(false); // 버튼 테두리
		searchButton.setContentAreaFilled(false); // 버튼 영역
		searchButton.setBackground(new Color(255, 255, 255)); // 버튼 영역
		add(searchButton);

		search.setSize(350, 30);
		search.setLocation(50, 50);
		search.setFont(new Font("", Font.PLAIN, 20));
		add(search);

		userField.setSize(400, 300);
		userField.setLocation(50, 100);
		add(userField);

	}

	private void addEventListener() {
		allSelected.addActionListener(this);
		choiceSelected.addActionListener(this);
		exit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem targetItem = (JMenuItem) e.getSource();
		if (targetItem.getText().equals(allSelected.getText())) {
			System.out.println("전체");
			userField.setText(gameCenterHostService.selectAllUser().toString());

		} else if (targetItem.getText().equals(choiceSelected.getText())) {
			System.out.println("선택");
			userField.setText(gameCenterHostService.selectUserById(search.getText()).toString());
		} else if (targetItem.getText().equals(exit.getText())) {
			System.out.println("나가기");
			this.setVisible(false);
		}

	}

	public static void main(String[] args) {
		new userSearch();
	}

}
