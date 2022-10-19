package game_center.service;

import java.util.List;

import game_center.dto.RequestGameCenter;
import game_center.dto.ResponseGameCenter;
import game_center.interfaces.IGameCenterService;

public class GameCenterUserService implements IGameCenterService {

	@Override
	public List<ResponseGameCenter> selectGame(String gameName) {

		return null;
	}

	@Override
	public List<ResponseGameCenter> selectCharacter(String characterName) {

		return null;
	}

	@Override
	public List<ResponseGameCenter> selectMap(String mapName) {

		return null;
	}

	@Override
	public boolean insertJoin(RequestGameCenter rgc) {

		return false;
	}

	@Override
	public void logIn(RequestGameCenter rgc) {

	}

	@Override
	public void update(String oldName, String newName) {

	}
}
