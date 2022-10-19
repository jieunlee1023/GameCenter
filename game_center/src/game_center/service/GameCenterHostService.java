package game_center.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import game_center.dto.RequestGameCenter;
import game_center.dto.ResponseGameCenter;
import game_center.interfaces.IGameCenterHostService;
import game_center.utils.DBClient;

public class GameCenterHostService implements IGameCenterHostService {

	private DBClient client;
	private PreparedStatement ps;
	private ResultSet rs;
	private ResponseGameCenter responseGameCenter = new ResponseGameCenter();;

	public GameCenterHostService() {
		client = DBClient.getInstance();
	}

	@Override
	public List<ResponseGameCenter> selectGame(String gameName) {

		List<ResponseGameCenter> list = new ArrayList<>();

		String query = "select * " + "from gameInfo " + "where gameName = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, gameName);
			rs = ps.executeQuery();

			while (rs.next()) {
				responseGameCenter.setGameName(rs.getString("gameName"));
				responseGameCenter.setAgeLimit(rs.getInt("ageLimit"));
				responseGameCenter.setGameInfo(rs.getString("gameInfo"));

				list.add(responseGameCenter);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return list;
	}

	@Override
	public List<ResponseGameCenter> selectCharacter(String characterName) {

		List<ResponseGameCenter> list = new ArrayList<>();

		String query = "select * " + "from gameCharacter " + "where gameCharacterName = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, characterName);
			rs = ps.executeQuery();

			while (rs.next()) {
				responseGameCenter.setGameCharacterName(rs.getString("gameCharacterName"));
				responseGameCenter.setGameName(rs.getString("gameName"));
				responseGameCenter.setGameCharacterInfo(rs.getString("gameCharacterInfo"));

				list.add(responseGameCenter);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return list;
	}

	@Override
	public List<ResponseGameCenter> selectMap(String mapName) {

		List<ResponseGameCenter> list = new ArrayList<>();

		String query = "select * " + "from gameMap " + "where gameMapName = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, mapName);
			rs = ps.executeQuery();

			while (rs.next()) {
				responseGameCenter.setGameMapName(rs.getString("gameMapName"));
				responseGameCenter.setGameName(rs.getString("gameName"));
				responseGameCenter.setGameMapInfo(rs.getString("gameMapInfo"));

				list.add(responseGameCenter);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return list;
	}

	@Override
	public boolean insertJoin(RequestGameCenter rgc) {

		String query = "insert into user values (?, ?, ?, ?, ?, ?)";

		try {
			client.getConnection().setAutoCommit(false);

			ps = client.getConnection().prepareStatement(query);

			ps.setInt(1, rgc.getIDENTITY_NUM_HOST());
			ps.setString(2, rgc.getUserId());
			ps.setString(3, rgc.getPassword());
			ps.setString(4, rgc.getUserName());
			ps.setString(5, rgc.getEmail());
			ps.setString(6, rgc.getMobile());
			ps.executeUpdate();

			client.getConnection().commit();
			client.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			try {
				System.err.println("롤백 했다 !! 뭐함 ;;");
				client.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return true;
	}

	@Override
	public void logIn(RequestGameCenter rgc) {

	}

	@Override
	public void update(String oldName, String newName) {

	}

	@Override
	public boolean insertGameCenter(String gameName) {

		String query = "insert into gamecenterinfo values (?)";

		try {
			client.getConnection().setAutoCommit(false);
			ps = client.getConnection().prepareStatement(query);

			ps.setString(1, gameName);
			ps.executeUpdate();

			client.getConnection().commit();
			client.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			try {
				System.err.println("롤백 했다 !! 뭐함 ;;");
				client.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return true;
	}

	@Override
	// 메인화면에 보이는 게임의 정보를 넣는게 아닌 게임 자체의 정보를 넣어야함.
	public boolean insertGame(RequestGameCenter rgc) {

		try {
			getSelectGameName(rgc);

			String query = "insert into gameInfo values (?, ?, ?)";
			client.getConnection().setAutoCommit(false);

			ps = client.getConnection().prepareStatement(query);

			ps.setString(1, rgc.getGameName());
			ps.setInt(2, rgc.getAgeLimit());
			ps.setString(3, rgc.getGameInfo());
			ps.executeUpdate();

			client.getConnection().commit();
			client.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			try {
				System.err.println("롤백 했다 !! 뭐함 ;;");
				client.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return true;
	}

	public void getSelectGameName(RequestGameCenter rgc) throws SQLException {

		String result = null;
		String query = "select gameName from gameinfo where gameName = ?";

		ps = client.getConnection().prepareStatement(query);
		ps.setString(1, rgc.getGameName());
		rs = ps.executeQuery();

		while (rs.next()) {
			result = rs.getString("gameName");

			rgc.setGameName(result);
		}
	}

	@Override
	public boolean insertChracter(RequestGameCenter rgc) {

		try {
			getSelectGameName(rgc);

			String query = "insert into gamecharacter values (?, ?, ?)";

			client.getConnection().setAutoCommit(false);
			ps = client.getConnection().prepareStatement(query);

			ps.setString(1, rgc.getGameName());
			ps.setString(2, rgc.getGameCharacterName());
			ps.setString(3, rgc.getGameCharacterInfo());
			ps.executeUpdate();

			client.getConnection().commit();
			client.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			try {
				System.err.println("캐릭터 롤백 했다 !! 뭐함 ;;");
				client.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return true;
	}

	@Override
	public boolean insertMap(RequestGameCenter rgc) {

		try {
			getSelectGameName(rgc);

			String query = "insert into gameMap values (?, ?, ?)";

			client.getConnection().setAutoCommit(false);
			ps = client.getConnection().prepareStatement(query);

			ps.setString(1, rgc.getGameName());
			ps.setString(2, rgc.getGameMapName());
			ps.setString(3, rgc.getGameMapInfo());
			ps.executeUpdate();

			client.getConnection().commit();
			client.getConnection().setAutoCommit(true);

		} catch (SQLException e) {
			try {
				System.out.println("야.. 인설트 맵 롤백 했잖아 ;;");
				client.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return false;
	}

	@Override
	public void updateGame(String oldGameName, String newGameName) {

	}

	@Override
	public void updateCharacter(String oldCharacterName, String newCharacterName) {

	}

	@Override
	public void updateMap(String oldMapName, String newMapName) {

	}

	@Override
	public void deleteGame(String gameName) {

		String query = "delete from gameInfo where gameName = ?";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, gameName);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public void deleteCharater(String charaterName) {

		String query = "delete from gameCharacter where gameCharacterName = ?";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, charaterName);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public void deleteMap(String MapName) {

		String query = "delete from gameMap where gameMapName = ?";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, MapName);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	private void closeDB() {
		try {
			ps.close();
			client.connectionClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		GameCenterHostService service = new GameCenterHostService();
		RequestGameCenter center = new RequestGameCenter();
//		List<ResponseGameCenter> list = service.selectGame("롤");
//
//		System.out.println(list);

//		List<ResponseGameCenter> list = service.selectCharacter("우니");
//
//		System.out.println(list);

//		List<ResponseGameCenter> list = service.selectMap("소환사의 협곡");
//
//		System.out.println(list);

//		center.setUserId("test1");
//		center.setPassword("1234");
//		center.setUserName("test1");
//		center.setEmail("test@naver.com");
//		center.setMobile("010-1111-1111");
//
//		service.insertJoin(center);

//		center.setGameName("test");
//		center.setAgeLimit(19);
//		center.setGameInfo("크래프톤[15]의 자회사인 펍지 스튜디오[16]의 MMO 슈팅 게임이다. 공식 명칭은...");
//
//		service.insertGame(center);

//		service.deleteGame("test");
//		service.deleteCharater("야스오");
//		service.deleteMap("칼바람 나락");

//		center.setGameName("배틀그라운드");
//		center.setGameCharacterName("남자");
//		center.setGameCharacterInfo("없다.");
//
//		service.insertChracter(center);

//		center.setGameName("크레이지아케이드");
//		center.setGameMapName("아쿠아");
//		center.setGameMapInfo("무시무시한 상어가 살고 있는 바닷속 맵으로 상어에 닿아..");
//
//		service.insertMap(center);
	}
}
