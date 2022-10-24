package game_center.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import game_center.dto.GameInfo;
import game_center.interfaces.IGameCenterHostService;
import game_center.view.hostGameFrame.CrazyArcadeHostInfoFrame;
import game_center.view.hostGameFrame.FIFAHostInfoFrame;
import game_center.view.hostGameFrame.LOLHostInfoFrame;

public class GameCenterHostFrame extends GameCenterFrame implements ActionListener {

	private RoundedButton userSelect;
	private IGameCenterHostService centerService;

	public GameCenterHostFrame(IGameCenterHostService centerHostService) {
		super(centerHostService);
		this.centerService = centerHostService;
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		userSelect = new RoundedButton("유저 조회");

	}

	private void setInitLayout() {
		userSelect.setSize(80, 35);
		userSelect.setLocation(85, 25);
		add(userSelect);
	}

	private void addEventListener() {
		userSelect.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetButton = (JButton) e.getSource();
		List<GameInfo> list = centerService.GameInfo();

		if (targetButton.getText().equals(getMyInfo().getText())) {
			System.out.println("내 정보");
			new MyInfoFrame();
		} else if (targetButton.hashCode() == (getBack().hashCode())) {
			new LoginFrame();
			this.setVisible(false);
		} else if (targetButton.getText().equals(getLogOut().getText())) {
			System.out.println("로그아웃");
			System.exit(0);
		} else if (targetButton.hashCode() == (getGameButton1().hashCode())) {
			System.out.println("게임 1");
			new LOLHostInfoFrame(getFirstGameInfos());
		} else if (targetButton.hashCode() == (getGameButton2().hashCode())) {
			System.out.println("게임 2");
			new FIFAHostInfoFrame(getSecondGameInfos());
		} else if (targetButton.hashCode() == (getGameButton3().hashCode())) {
			System.out.println("게임 3");
			new CrazyArcadeHostInfoFrame(getThirdGameInfos());
		} else if (targetButton.hashCode() == getSearchButton().hashCode()) {
			if (getSearch().getText().equals(getFirstGameInfos().getGameName())) {
				new LOLHostInfoFrame(getFirstGameInfos());
			} else if (getSearch().getText().equals(getSecondGameInfos().getGameName())) {
				new FIFAHostInfoFrame(getSecondGameInfos());
			} else if (getSearch().getText().equals(getThirdGameInfos().getGameName())) {
				new CrazyArcadeHostInfoFrame(getThirdGameInfos());
			} else {
			}
		} else if (targetButton.getText().equals(userSelect.getText())) {
			System.out.println("유저 정보 조회");
			new userSearch();
		}
	}
}
