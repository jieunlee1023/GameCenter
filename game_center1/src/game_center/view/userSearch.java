package game_center.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class userSearch extends JFrame implements ActionListener {

	private JMenuBar bar = new JMenuBar();
	private JMenu screenMenu = new JMenu("유저 정보 조회");
	private JMenuItem allSelected = new JMenuItem("전체 조회");
	private JMenuItem choiceSelected = new JMenuItem("선택 조회");
	private JMenuItem exit = new JMenuItem("닫기");

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		} else if (targetItem.getText().equals(choiceSelected.getText())) {
			System.out.println("선택");
		} else if (targetItem.getText().equals(exit.getText())) {
			System.out.println("나가기");
			this.setVisible(false);
		}

	}

	public static void main(String[] args) {
		new userSearch();
	}

}
