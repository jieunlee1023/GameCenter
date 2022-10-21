package game_center.dto;

import lombok.Data;

@Data
public class UserInfo {

	public static boolean isLogin = false;

	private String userId;
	private String userName;
	private String password;
	private String email;
	private String mobile;

	private UserInfo() {

	}

	private static UserInfo instance = new UserInfo();

	public static UserInfo getInstance() {
		if (instance == null) {
			instance = new UserInfo();
		}
		return instance;
	}
}
