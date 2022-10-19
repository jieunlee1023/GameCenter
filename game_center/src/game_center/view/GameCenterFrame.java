package game_center.view;

import javax.swing.JFrame;

public class GameCenterFrame extends JFrame {

	public GameCenterFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(1300, 1000);
		setTitle("Movie");
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void setInitLayout() {
		setVisible(true);
	}

	private void addEventListener() {

	}

}
