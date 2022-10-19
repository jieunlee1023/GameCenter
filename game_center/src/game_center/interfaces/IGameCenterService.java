package game_center.interfaces;

import java.util.List;

import game_center.dto.RequestGameCenter;
import game_center.dto.ResponseGameCenter;

public interface IGameCenterService {

	// 관리자와 사용자의 인터페이스

	List<ResponseGameCenter> selectGame(String gameName);

	List<ResponseGameCenter> selectCharacter(String characterName);

	List<ResponseGameCenter> selectMap(String mapName);

	boolean insertJoin(RequestGameCenter rgc); // 회원가입

	void logIn(RequestGameCenter rgc); // 로그인

	void update(String oldName, String newName); // 회원정보 수정

}