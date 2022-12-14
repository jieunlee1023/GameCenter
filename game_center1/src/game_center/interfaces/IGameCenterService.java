package game_center.interfaces;

import java.util.List;

import game_center.dto.CharacterInfo;
import game_center.dto.GameInfo;
import game_center.dto.MapInfo;
import game_center.dto.RequestGameCenter;
import game_center.dto.ResponseGameCenter;

public interface IGameCenterService {

	// 관리자와 사용자의 인터페이스

	List<ResponseGameCenter> selectGame(String gameName); // 게임 선택 (게임정보 나옴 + 캐릭터요약 + 맵요약)

	List<ResponseGameCenter> selectCharacter(String characterName); // 게임 캐릭터 선택 (캐릭터상세)

	List<ResponseGameCenter> selectMap(String mapName); // 게임 맵 선택 (맵상세)

	String selectGameName(String name);

	String selectGameInfo(String name);

	String selectCharacterName(String name);

	String selectMapName(String name);

	List<String> selectAllUser(); // 전체 조회

	List<String> selectUserId();

	List<String> selectUserPassword();

	boolean insertJoin(RequestGameCenter rgc); // 회원가입

	boolean joinIdCheck(String id);

	boolean logIn(String Id, String pw);

	void update(RequestGameCenter rgc); // 회원정보 수정

	void delete(String userId);

	List<ResponseGameCenter> selectUserById(String userId);

	List<GameInfo> GameInfo();

	List<MapInfo> MapInfo();

	List<CharacterInfo> CharacterInfo();
}