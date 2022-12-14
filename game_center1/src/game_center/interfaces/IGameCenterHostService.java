package game_center.interfaces;

import java.util.List;

import game_center.dto.CharacterInfo;
import game_center.dto.GameInfo;
import game_center.dto.MapInfo;
import game_center.dto.RequestGameCenter;

public interface IGameCenterHostService extends IGameCenterService {

	// 관리자의 인터페이스

	int identityNum(String userId);

	boolean insertGameCenter(String gameName); // 게임 등록

	boolean insertGame(RequestGameCenter rgc); // 게임 등록

	boolean insertChracter(RequestGameCenter rgc); // 게임 등록

	boolean insertMap(RequestGameCenter rgc); // 게임 등록

	void updateGame(RequestGameCenter rgc, GameInfo gameInfo); // 게임 정보 수정

	void updateCharacter(RequestGameCenter rgc, CharacterInfo characterInfo); // 게임 캐릭터 수정

	void updateMap(RequestGameCenter rgc, MapInfo mapInfo); // 게임 맵 수정

	void deleteGame(String gameName); // 게임 삭제

	void deleteCharater(String charaterName); // 게임 삭제

	void deleteMap(String MapName); // 게임 삭제

	void hostIn(String userId);

	void hostOut(String userId);

}