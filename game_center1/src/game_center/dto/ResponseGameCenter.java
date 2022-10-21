package game_center.dto;

import lombok.Data;

@Data
public class ResponseGameCenter {

	private int identityNum;
	private String userId;
	private String password;
	private String userName;
	private String email;
	private String mobile;

	private String gameName;
	private int ageLimit;
	private String gameInfo;

	private String gameCharacterName;
	private String gameCharacterInfo;

	private String gameMapName;
	private String gameMapInfo;

	public String toString() {

		return " ⓐ" + identityNum + " ⓑ " + userId + " ⓒ " + password + " ⓓ " + userName + " ⓔ " + email + " ⓕ "
				+ mobile;
	}
}