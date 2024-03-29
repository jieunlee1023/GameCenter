package game_center.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import game_center.dto.CharacterInfo;
import game_center.dto.GameInfo;
import game_center.dto.LoginUserInfo;
import game_center.dto.MapInfo;
import game_center.dto.RequestGameCenter;
import game_center.dto.ResponseGameCenter;
import game_center.interfaces.IGameCenterHostService;
import game_center.utils.DBClient;
import lombok.Data;

@Data
public class GameCenterHostService implements IGameCenterHostService {

	private DBClient client;
	private PreparedStatement ps;
	private ResultSet rs;
	private ResponseGameCenter responseGameCenter = new ResponseGameCenter();

	public GameCenterHostService() {
		client = DBClient.getInstance();
	}

	@Override
	public List<GameInfo> GameInfo() {

		List<GameInfo> list = new ArrayList<>();

		String query = "select * from gameInfo";

		try {
			ps = client.getConnection().prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				GameInfo gameInfo = new GameInfo();
				gameInfo.setGameName(rs.getString("gamename"));
				gameInfo.setAgeLimit(rs.getString("ageLimit"));
				gameInfo.setGameInfo(rs.getString("gameInfo"));

				list.add(gameInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return list;
	}

	@Override
	public List<CharacterInfo> CharacterInfo() {
		List<CharacterInfo> list = new ArrayList<>();

		String query = "select * from gameCharacter";

		try {
			ps = client.getConnection().prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				CharacterInfo characterInfo = new CharacterInfo();
				characterInfo.setGameName(rs.getString("gamename"));
				characterInfo.setGameCharacterName(rs.getString("gameCharacterName"));
				characterInfo.setGameCharacterInfo(rs.getString("gameCharacterInfo"));

				list.add(characterInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return list;
	}

	@Override
	public List<MapInfo> MapInfo() {
		List<MapInfo> list = new ArrayList<>();

		String query = "select * from gamemap";

		try {
			ps = client.getConnection().prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				MapInfo mapInfo = new MapInfo();
				mapInfo.setGameName(rs.getString("gamename"));
				mapInfo.setGameMapName(rs.getString("gameMapName"));
				mapInfo.setGameMapInfo(rs.getString("gameMapInfo"));

				list.add(mapInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return list;
	}

	@Override
	public void hostIn(String userId) {
		LoginUserInfo userInfo = LoginUserInfo.getInstance();
		String query = "update user set identityNum = 1 where userId = ? ";
		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, userId);
			ps.executeUpdate();

			userInfo.setIdentity(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public void hostOut(String userId) {
		LoginUserInfo userInfo = LoginUserInfo.getInstance();
		String query = "update user set identityNum = 2 where userId = ? ";
		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, userId);
			ps.executeUpdate();
			userInfo.setIdentity(2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public String selectGameName(String name) {

		String query = "select gameName from gamecenterinfo where gameName = ? ";
		String gameName = null;
		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {

				responseGameCenter.setUserName(rs.getString("gameName"));
			}
			gameName = responseGameCenter.getUserName();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return gameName;
	}

	@Override
	public String selectGameInfo(String name) {
		String query = "select gameInfo from gameinfo where gameName = ? ";
		String gameInfo = null;
		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				responseGameCenter.setGameInfo(rs.getString("gameInfo"));
			}
			gameInfo = responseGameCenter.getGameInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return gameInfo;
	}

	@Override
	public String selectCharacterName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectMapName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String userId) {

		LoginUserInfo userInfo = LoginUserInfo.getInstance();

		String query = " delete from user where userId = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, userId);
			ps.executeUpdate();

			LoginUserInfo.isLogin = false;
			userInfo = null;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public void update(RequestGameCenter rgc) {

		LoginUserInfo userInfo = LoginUserInfo.getInstance();

		String query = "UPDATE user SET password = ?, userName = ?, email = ?, mobile = ? WHERE userId = ? ";
		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, rgc.getPassword());
			ps.setString(2, rgc.getUserName());
			ps.setString(3, rgc.getEmail());
			ps.setString(4, rgc.getMobile());
			ps.setString(5, rgc.getUserId());
			ps.executeUpdate();

			userInfo.setPassword(rgc.getPassword());
			userInfo.setUserName(rgc.getUserName());
			userInfo.setEmail(rgc.getEmail());
			userInfo.setMobile(rgc.getMobile());
			userInfo.setUserId(rgc.getUserId());

		} catch (SQLException e1) {
			try {
				client.getConnection().rollback();
				System.out.println("롤백됐습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public List<ResponseGameCenter> selectUserById(String userId) {
		String query = "SELECT * FROM user WHERE userId = ? ";
		List<ResponseGameCenter> list = new ArrayList<>();
		try {
			client.getConnection().setAutoCommit(false);
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				ResponseGameCenter userInfo = new ResponseGameCenter();
				userInfo.setIdentityNum(rs.getInt("identityNum"));
				userInfo.setUserId(rs.getString("userId"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setUserName(rs.getString("userName"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setMobile(rs.getString("mobile"));
				list.add(userInfo);
			}
			client.getConnection().commit();
			client.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			try {
				client.getConnection().rollback();
				System.err.println("롤백됐습니다.");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return list;
	}

	@Override
	public List<String> selectUserId() {

		List<String> list = new ArrayList<>();

		String query = "select userId from user";

		try {
			ps = client.getConnection().prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				responseGameCenter.setUserId(rs.getString("userId"));

				list.add(responseGameCenter.getUserId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return list;
	}

	@Override
	public List<String> selectAllUser() {

		List<String> list = new ArrayList<>();

		String query = "select * from user";

		try {
			ps = client.getConnection().prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				responseGameCenter.setIdentityNum(rs.getInt("identityNum"));
				responseGameCenter.setUserId(rs.getString("userId"));
				responseGameCenter.setPassword(rs.getString("password"));
				responseGameCenter.setUserName(rs.getString("userName"));
				responseGameCenter.setEmail(rs.getString("email"));
				responseGameCenter.setMobile(rs.getString("mobile"));

				list.add(responseGameCenter.toString() + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return list;
	}

	@Override
	public List<String> selectUserPassword() {
		List<String> list = new ArrayList<>();

		String query = "select password from user";

		try {
			ps = client.getConnection().prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				responseGameCenter.setUserId(rs.getString("password"));

				list.add(responseGameCenter.getUserId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return list;
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
				responseGameCenter.setAgeLimit(rs.getString("ageLimit"));
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

		} catch (SQLException e) {
			try {
				System.err.println("join에서 롤백 했다 !! 뭐함 ;;");
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
	public boolean joinIdCheck(String id) {

		List<String> list = selectUserId();

		for (String string : list) {
			if (id.equals(string)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean logIn(String Id, String pw) {

		LoginUserInfo userInfo = LoginUserInfo.getInstance();

		String query = " select * from user where userId = ? and password = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, Id);
			ps.setString(2, pw);

			if (!Id.isEmpty() && !pw.isEmpty()) {
				rs = ps.executeQuery();
				while (rs.next()) {
					LoginUserInfo.isLogin = true;
					userInfo.setIdentity(rs.getInt("identityNum"));
					userInfo.setUserId(rs.getString("userId"));
					userInfo.setUserName(rs.getString("userName"));
					userInfo.setPassword(rs.getString("password"));
					userInfo.setEmail(rs.getString("email"));
					userInfo.setMobile(rs.getString("mobile"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return LoginUserInfo.isLogin;
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
			ps.setString(2, rgc.getAgeLimit());
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

	public void getSelectGameName(RequestGameCenter rgc) {

		String result = null;
		String query = "select gameName from gameinfo where gameName = ?";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, rgc.getGameName());
			rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getString("gameName");

				rgc.setGameName(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
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
	public void updateGame(RequestGameCenter rgc, GameInfo gameInfo) {

		String query = "update gameInfo set ageLimit = ? , gameInfo = ? where gameName = ? ";
		try {
			ps = client.getConnection().prepareStatement(query);

			gameInfo.setAgeLimit(rgc.getAgeLimit());
			gameInfo.setGameInfo(rgc.getGameInfo());

			ps.setString(1, rgc.getAgeLimit());
			ps.setString(2, rgc.getGameInfo());
			ps.setString(3, gameInfo.getGameName());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public void updateCharacter(RequestGameCenter rgc, CharacterInfo characterInfo) {

		String query = "update gameCharacter set  gameCharacterInfo = ? where gameCharacterName = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);

			ps.setString(1, rgc.getGameCharacterInfo());
			ps.setString(2, characterInfo.getGameCharacterName());
			ps.executeUpdate();

			characterInfo.setGameCharacterInfo(rgc.getGameCharacterInfo());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public void updateMap(RequestGameCenter rgc, MapInfo mapInfo) {
		String query = "update gameMap set gameMapInfo = ? where gameMapName = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);

			ps.setString(1, rgc.getGameMapInfo());
			ps.setString(2, mapInfo.getGameMapName());
			ps.executeUpdate();

			mapInfo.setGameMapInfo(rgc.getGameMapInfo());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
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

	@Override
	public int identityNum(String userId) {
		int identityNum = 0;

		String query = "select identityNum from user where userId =  ?";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				responseGameCenter.setIdentityNum(rs.getInt("identityNum"));

				identityNum = responseGameCenter.getIdentityNum();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return identityNum;
	}
}