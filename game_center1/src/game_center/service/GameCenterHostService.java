package game_center.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import game_center.dto.LoginUserInfo;
import game_center.dto.RequestGameCenter;
import game_center.dto.ResponseGameCenter;
import game_center.interfaces.IGameCenterHostService;
import game_center.utils.DBClient;

public class GameCenterHostService implements IGameCenterHostService {

	private DBClient client;
	private PreparedStatement ps;
	private ResultSet rs;
	private ResponseGameCenter responseGameCenter = new ResponseGameCenter();

	public GameCenterHostService() {
		client = DBClient.getInstance();
	}

	@Override
	public void hostIn(String userId) {

		String query = "update user set identityNum = 1 where userId = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public void hostOut(String userId) {
		String query = "update user set identityNum = 2 where userId = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);
			ps.setString(1, userId);
			ps.executeUpdate();
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

		System.out.println(gameInfo);
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
			System.out.println("탈퇴 (계정 삭제) 완료");

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
		System.out.println("try 전");
		try {
			System.out.println("try 후");
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

			System.out.println("rgc에 들어간 정보들");
			System.out.println(rgc.getPassword());
			System.out.println(rgc.getUserName());
			System.out.println(rgc.getEmail());
			System.out.println(rgc.getMobile());
			System.out.println(rgc.getUserId());
			System.out.println("+++++++++++++++++++");

			System.out.println("유저 인포에 들어간 정보들");
			System.out.println(userInfo.getPassword());
			System.out.println(userInfo.getUserName());
			System.out.println(userInfo.getEmail());
			System.out.println(userInfo.getMobile());
			System.out.println(userInfo.getUserId());

		} catch (SQLException e) {
			try {
				client.getConnection().rollback();
				System.out.println("롤백됐습니다.");
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				closeDB();
			}
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
				userInfo.setIdentityNum(1);
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
				System.out.println("롤백됐습니다.");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				client.connectionClose();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	public void updateGame(RequestGameCenter rgc, String name) {

		String query = "update gameInfo " + "set gameName = ? " + ", ageLimit = ? " + ", gameInfo = ? "
				+ "where gameName = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);

			ps.setString(1, rgc.getGameName());
			ps.setInt(2, rgc.getAgeLimit());
			ps.setString(3, rgc.getGameInfo());

			ps.setString(4, name);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public void updateCharacter(RequestGameCenter rgc, String name) {

		String query = "update gameCharacter " + " set gameCharacterName = ? " + ", gameCharacterInfo = ? "
				+ "where gameCharacterName = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);

			ps.setString(1, rgc.getGameCharacterName());
			ps.setString(2, rgc.getGameCharacterInfo());

			ps.setString(3, name);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	@Override
	public void updateMap(RequestGameCenter rgc, String name) {
		String query = "update gameMap " + "set gameMapName = ? " + ", gameMapInfo = ? " + "where gameMapName = ? ";

		try {
			ps = client.getConnection().prepareStatement(query);

			ps.setString(1, rgc.getGameMapName());
			ps.setString(2, rgc.getGameMapInfo());

			ps.setString(3, name);

			ps.executeUpdate();

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
			System.out.println(userId);
			rs = ps.executeQuery();
			System.out.println("rs : " + rs);
			while (rs.next()) {
				responseGameCenter.setIdentityNum(rs.getInt("identityNum"));

				System.out.println("번호 : " + identityNum);
				identityNum = responseGameCenter.getIdentityNum();
				System.out.println("번호1 : " + identityNum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return identityNum;
	}

	public static void main(String[] args) {

		RequestGameCenter center = new RequestGameCenter();
		GameCenterHostService service = new GameCenterHostService();

		service.hostIn("test1");

//      List<ResponseGameCenter> list = service.selectGame("test2");
//
//      System.out.println(list);

//      List<ResponseGameCenter> list = service.selectCharacter("우니");
//
//      System.out.println(list);

//      List<ResponseGameCenter> list = service.selectMap("소환사의 협곡");
//
//      System.out.println(list);

//      center.setUserId("test1");
//      center.setPassword("1234");
//      center.setUserName("test1");
//      center.setEmail("test@naver.com");
//      center.setMobile("010-1111-1111");
//
//      service.insertJoin(center);

//      center.setGameName("test");
//      center.setAgeLimit(19);
//      center.setGameInfo("크래프톤[15]의 자회사인 펍지 스튜디오[16]의 MMO 슈팅 게임이다. 공식 명칭은...");
//
//      service.insertGame(center);

//      service.deleteGame("test");
//      service.deleteCharater("야스오");
//      service.deleteMap("칼바람 나락");

//      center.setGameName("배틀그라운드");
//      center.setGameCharacterName("여자");
//      center.setGameCharacterInfo("없다.");
//
//      service.insertChracter(center);

//      center.setGameName("크레이지아케이드");
//      center.setGameMapName("아쿠아");
//      center.setGameMapInfo("무시무시한 상어가 살고 있는 바닷속 맵으로 상어에 닿아..");
//
//      service.insertMap(center);

//		service.logIn(center, "A", "asd123");
//		service.logIn(center, "A", "asd1234");

//      center.setGameName("test");
//      center.setAgeLimit(15);
//      center.setGameInfo("testText");
//
//      service.updateGame(center, "test");

//      center.setGameName("롤");
//      center.setGameCharacterName("룰루");
//      center.setGameCharacterInfo("씹련이다.");
//      
//      service.updateCharacter(center, "제드");

//      center.setGameMapName("소환사의 협곡");
//      center.setGameMapInfo("특별한 이벤트 형식이 아닌 이상 대부분의 공식대회에서 지원하는 사실상...");
//      
//      service.updateMap(center, "상점");

	}
}