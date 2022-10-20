package game_center.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JScrollBar;

public class Scrollbar extends JFrame {

	JPanel p1 = new JPanel();

	JScrollBar scroll3 = new JScrollBar(1, 30, 0, 0,300); // 동쪽

	JPanel p2 = new JPanel();

	public Scrollbar() {

		p1.setLayout(new BorderLayout());

		add(p1);

		p1.add(scroll3, BorderLayout.EAST);

		p1.add(p2, BorderLayout.CENTER);

		p2.setLayout(null);

		// 10*150 사이즈는 여기서 수정하시길

		setSize(500, 500); // 프레임 사이즈

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 닫기 버튼 활성화

		setResizable(false); // 프레임 사이즈 고정

		setLocationRelativeTo(null); // 프레임 실행시 중앙 위치

		setVisible(true);

		// 프레임 보이기

	}

	public static void main(String args[]) {

		Scrollbar sc = new Scrollbar();

	}

}