package game_center.interfaces;

import game_center.dto.RequestGameCenter;

public interface IGameCenterHostService extends IGameCenterService {

	// 관리자의 인터페이스

	boolean insertGameCenter(String gameName); // 게임 등록

	boolean insertGame(RequestGameCenter rgc); // 게임 등록

	boolean insertChracter(RequestGameCenter rgc); // 게임 등록

	boolean insertMap(RequestGameCenter rgc); // 게임 등록

	void updateGame(String oldGameName, String newGameName); // 게임 정보 수정

	void updateCharacter(String oldCharacterName, String newCharacterName); // 게임 캐릭터 수정

	void updateMap(String oldMapName, String newMapName); // 게임 맵 수정

	void deleteGame(String gameName); // 게임 삭제

	void deleteCharater(String charaterName); // 게임 삭제

	void deleteMap(String MapName); // 게임 삭제
}
