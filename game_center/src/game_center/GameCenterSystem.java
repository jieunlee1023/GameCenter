package game_center;

import game_center.view.GameCenterFrame;
import game_center.view.JoinFrame;
import game_center.view.LoginFrame;

// ******* main 함수를 가지고 있는 녀석은 모든 주소를 알 수 있다.
public class GameCenterSystem {

	GameCenterFrame centerFrame;
	LoginFrame loginFrame;
	JoinFrame joinFrame;

	// 로그인 처리
	// 회원가입 처리
	// 게임선터 보여주기

	public void showLogin() {
		loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
		loginFrame.addEventListener();
	}

	public static void main(String[] args) {

		GameCenterSystem gameCenterSystem = new GameCenterSystem();
		gameCenterSystem.showLogin();

		// new GameCenterHostService();

	}
}
