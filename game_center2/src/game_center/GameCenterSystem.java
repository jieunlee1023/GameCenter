package game_center;

import game_center.interfaces.IGameCenterHostService;
import game_center.view.GameCenterFrame;
import game_center.view.MyInfoFrame;
import game_center.view.LoginFrame;
import game_center.view.MyInfoFrame;

// ★★★ main 함수를 가지고 있는 녀석은 모든 주소를 알 수 있다.
public class GameCenterSystem {

	GameCenterFrame centerFrame;
	LoginFrame loginFrame;
	MyInfoFrame joinFrame;
	MyInfoFrame myInfoFrame;
	static IGameCenterHostService centerHostService;

	// 로그인 처리
	// 회원가입 처리
	// 게임선터 보여주기

	public void showLogin() {
		loginFrame = new LoginFrame();
	}

	public static void main(String[] args) {

		GameCenterSystem gameCenterSystem = new GameCenterSystem();
		gameCenterSystem.showLogin();

	}
}
