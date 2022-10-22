package game_center.view.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game_center.utils.Define;

public class FIFAInfoFrame extends GameInfoFrame {

	public FIFAInfoFrame() {

		super();
		setInitLayout();
	}

	private void setInitLayout() {

		super.setGameImage(new JLabel(new ImageIcon(Define.FIFA_IMAGE_PATH + "main.png")));
		
	}

	public static void main(String[] args) {
		new FIFAInfoFrame();
	}
}
