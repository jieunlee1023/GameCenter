package game_center.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;

import game_center.interfaces.IGameCenterHostService;

public class GameCenterHostFrame extends GameCenterFrame implements ActionListener {

	private RoundedButton userSelect;
	private RoundedButton gameInsert;
	private RoundedButton gameUpdate;
	private RoundedButton gameDelete;

	public GameCenterHostFrame(IGameCenterHostService centerHostService) {
		super(centerHostService);
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		userSelect = new RoundedButton("유저 조회");
		gameInsert = new RoundedButton("게임 추가");
		gameUpdate = new RoundedButton("게임 수정");
		gameDelete = new RoundedButton("게임 삭제");

	}

	private void setInitLayout() {
		userSelect.setSize(80, 35);
		userSelect.setLocation(90, 20);
		add(userSelect);

		gameInsert.setSize(80, 35);
		gameInsert.setLocation(690, 70);
		add(gameInsert);

		gameUpdate.setSize(80, 35);
		gameUpdate.setLocation(780, 70);
		add(gameUpdate);

		gameDelete.setSize(80, 35);
		gameDelete.setLocation(870, 70);
		add(gameDelete);
	}

	private void addEventListener() {
		userSelect.addActionListener(this);
		gameInsert.addActionListener(this);
		gameUpdate.addActionListener(this);
		gameDelete.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		JButton targetButton = (JButton) e.getSource();
		if (targetButton.getText().equals(userSelect.getText())) {
			System.out.println("유저 정보 조회");
			new userSearch();
		} else if (targetButton.getText().equals(gameInsert.getText())) {
			System.out.println("게임 추가");

		} else if (targetButton.getText().equals(gameUpdate.getText())) {
			System.out.println("게임 수정");

		} else if (targetButton.getText().equals(gameDelete.getText())) {
			System.out.println("게임 삭제");

		}
	}
}
