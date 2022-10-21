package game_center.dto;

import lombok.Data;

@Data
public class LoginUserInfo {

	public static boolean isLogin = false;

	private String userId;
	private String userName;
	private String password;
	private String email;
	private String mobile;

	private LoginUserInfo() {

	}

	private static LoginUserInfo instance = new LoginUserInfo();

	public static LoginUserInfo getInstance() {
		if (instance == null) {
			instance = new LoginUserInfo();
		}
		return instance;
	}
}
