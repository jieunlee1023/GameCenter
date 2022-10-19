package game_center.interfaces;

import java.util.List;

import game_center.dto.RequestGameCenter;
import game_center.dto.ResponseGameCenter;

public interface IGameCenterService {
	
	//관리자와 사용자의 인터페이스
	
	List<ResponseGameCenter> selectGame(String gameName); //게임 선택 (게임정보 나옴 + 캐릭터요약 + 맵요약)
	List<ResponseGameCenter> selectCharacter(String characterName); //게임 캐릭터 선택 (캐릭터상세)
	List<ResponseGameCenter> selectMap(String mapName); // 게임 맵 선택 (맵상세)
	
	boolean insertJoin(RequestGameCenter rgc); // 회원가입
	void logIn (RequestGameCenter rgc); // 로그인
	void update(String oldName, String newName); // 회원정보 수정
	
}