package game_center.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GameInfoFrame extends JFrame implements ActionListener {

	public GameInfoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 700);
		setTitle("게임 정보창");
		setLocation(0, 0);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(30, 40, 90));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
	}

	private void addEventListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		new GameInfoFrame();
	}
}
