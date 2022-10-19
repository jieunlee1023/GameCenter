package game_center.dto;

import lombok.Data;

@Data
public class RequestGameCenter {

	// user
	private final int IDENTITY_NUM_HOST = 1;
	private final int IDENTITY_NUM_USER = 2;
	private String userId;
	private String password;
	private String userName;
	private String email;
	private String mobile;

	// gameCenterInfo
	private String gameName;

	// gameInfo
//	private String gameName;
	private int ageLimit;
	private String gameInfo;

	// gameCharacter
//	private String gameName;
	private String gameCharacterName;
	private String gameCharacterInfo;

	// gameMap
//	private String gameName;
	private String gameMapName;
	private String gameMapInfo;

}
