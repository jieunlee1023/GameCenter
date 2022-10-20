package game_center.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import game_center.dto.RequestGameCenter;
import game_center.dto.ResponseGameCenter;
import game_center.interfaces.IGameCenterService;
import game_center.utils.DBClient;

public class GameCenterUserService implements IGameCenterService {

	private DBClient dbClient;
	private PreparedStatement psmt;
	private ResultSet rs;
	private ResponseGameCenter responseGameCenter = new ResponseGameCenter();

	public GameCenterUserService() {
		initData();
	}

	private void initData() {
		dbClient = dbClient.getInstance();
	}

	@Override
	public List<ResponseGameCenter> selectGame(String gameName) { // 게임 선택 (게임정보 나옴 + 캐릭터요약 + 맵요약)
		List<ResponseGameCenter> list = new ArrayList<>();
		String query = "select * " + "from gameInfo " + "where gameName = ? ";

		try {
			psmt = dbClient.getConnection().prepareStatement(query);
			psmt.setString(1, gameName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				responseGameCenter.setGameName(rs.getString("gameName"));
				responseGameCenter.setAgeLimit(rs.getInt("ageLimit"));
				responseGameCenter.setGameInfo(rs.getString("gameInfo"));

				list.add(responseGameCenter);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			memoryClose();
		}

		return list;
	}

	@Override
	public List<ResponseGameCenter> selectCharacter(String characterName) { // 게임 캐릭터 선택 (캐릭터상세)
		List<ResponseGameCenter> list = new ArrayList<>();

		String query = "select * " + "from gameCharacter " + "where gameCharacterName = ? ";

		try {
			psmt = dbClient.getConnection().prepareStatement(query);
			psmt.setString(1, characterName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				responseGameCenter.setGameCharacterName(rs.getString("gameCharacterName"));
				responseGameCenter.setGameName(rs.getString("gameName"));
				responseGameCenter.setGameCharacterInfo(rs.getString("gameCharacterInfo"));

				list.add(responseGameCenter);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			memoryClose();
		}

		return list;
	}

	private void memoryClose() {
		try {
			rs.close();
			psmt.close();
			dbClient.connectionClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ResponseGameCenter> selectMap(String mapName) {
		List<ResponseGameCenter> list = new ArrayList<>();

		String query = "select * " + "from gameMap " + "where gameMapName = ? ";

		try {
			psmt = dbClient.getConnection().prepareStatement(query);
			psmt.setString(1, mapName);
			rs = psmt.executeQuery();

			while (rs.next()) {
				responseGameCenter.setGameMapName(rs.getString("gameMapName"));
				responseGameCenter.setGameName(rs.getString("gameName"));
				responseGameCenter.setGameMapInfo(rs.getString("gameMapInfo"));

				list.add(responseGameCenter);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			memoryClose();
		}

		return list;
	}

	@Override
	public boolean insertJoin(RequestGameCenter rgc) { // 회원가입
		boolean flag = true;
		try {
			dbClient.getConnection().setAutoCommit(false);
			String query = "INSERT INTO user VALUES (2, ?, ?, ?, ?, ?) ";
			psmt = dbClient.getConnection().prepareStatement(query);
			psmt.setString(1, rgc.getUserId());
			psmt.setString(2, rgc.getPassword());
			psmt.setString(3, rgc.getUserName());
			psmt.setString(4, rgc.getEmail());
			psmt.setString(5, rgc.getMobile());
			psmt.executeUpdate();
			dbClient.getConnection().commit();
			dbClient.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			try {
				dbClient.getConnection().rollback();
				System.out.println("롤백됐습니다.");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			memoryClose();
		}
		return flag;
	}

	@Override
	public List<String> selectUserId() {
		List<String> list = new ArrayList<>();

		String query = "select userId from user";

		try {
			psmt = dbClient.getConnection().prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				responseGameCenter.setUserId(rs.getString("userId"));

				list.add(responseGameCenter.getUserId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			memoryClose();
		}

		return list;
	}

	@Override
	public int logInId(RequestGameCenter rgc) {
		int loginPass = 0;

		List<String> list = selectUserId();

		for (String userId : list) {
			if (rgc.getUserId().equals(userId)) {
				loginPass = list.indexOf(userId);
				System.out.println("Id 성공");
				return loginPass;
			} else {
				System.out.println("Id 실패");
			}
		}
		return loginPass;
	}

	@Override
	public int logInPassword(RequestGameCenter rgc) {
		int loginPass = 1;

		List<String> list = selectUserPassword();

		for (String userPassword : list) {
			if (rgc.getPassword().equals(userPassword)) {
				loginPass = list.indexOf(userPassword);
				System.out.println("password 성공");
				return loginPass;
			} else {
				System.out.println("password 실패");
			}
		}
		return loginPass;
	}

	@Override
	public boolean logIn(RequestGameCenter rgc, String Id, String pw) {

		rgc.setUserId(Id);
		rgc.setPassword(pw);

		int id = logInId(rgc);
		int password = logInPassword(rgc);

		if (id == password) {
			System.out.println("로그인 성공 !");
			return true;
		} else {
			System.out.println("로그인 실패 ㅠㅠ");
			return false;
		}
	}

	@Override
	public List<String> selectUserPassword() {
		List<String> list = new ArrayList<>();

		String query = "select password from user";

		try {
			psmt = dbClient.getConnection().prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				responseGameCenter.setUserId(rs.getString("password"));

				list.add(responseGameCenter.getUserId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			memoryClose();
		}

		return list;
	}

	@Override
	public void update(RequestGameCenter rgc) { // 본인 정보 수정
		String query = "UPDATE user SET identityNum = 2, password = ?, userName = ?, email = ?, mobile = ? WHERE userId = ? ";
		try {
			psmt = dbClient.getConnection().prepareStatement(query);
			psmt.setString(1, rgc.getPassword());
			psmt.setString(2, rgc.getUserName());
			psmt.setString(3, rgc.getEmail());
			psmt.setString(4, rgc.getMobile());
			psmt.setString(5, rgc.getUserId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			try {
				dbClient.getConnection().rollback();
				System.out.println("롤백됐습니다.");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public List<ResponseGameCenter> selectUserById(String userId) {
		String query = "SELECT * FROM user WHERE userId = ? ";
		List<ResponseGameCenter> list = new ArrayList<>();
		try {
			dbClient.getConnection().setAutoCommit(false);
			psmt = dbClient.getConnection().prepareStatement(query);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ResponseGameCenter userInfo = new ResponseGameCenter();
				userInfo.setIdentityNum("2");
				userInfo.setUserId(rs.getString("userId"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setUserName(rs.getString("userName"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setMobile(rs.getString("mobile"));
				list.add(userInfo);
			}
			dbClient.getConnection().commit();
			dbClient.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			try {
				dbClient.getConnection().rollback();
				System.out.println("롤백됐습니다.");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				dbClient.connectionClose();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public static void main(String[] args) {
		RequestGameCenter rgc = new RequestGameCenter();
		GameCenterUserService a = new GameCenterUserService();

//      rgc.setUserId("bins");
//      rgc.setPassword("1234");
//      rgc.setUserName("강빈");
//      rgc.setEmail("adasd@sadasd.com");
//      rgc.setMobile("010-9432-9080");
//      a.insertJoin(rgc);

		// selectbyId
		List<ResponseGameCenter> select = a.selectUserById("bins");
		if (select == null) {
			System.out.println("없는 ID 입니다.");
		} else {
			System.out.println(rgc.getIDENTITY_NUM_USER());
			System.out.println(select.toString());
		}
		// 2 bins 1234 강빈 adasd@sadasd.com 010-9432-9080
		rgc.setPassword("1212");
		rgc.setUserName("binbi");
		rgc.setEmail(null);
		rgc.setMobile(null);
		rgc.setUserId("bins");

		a.update(rgc);

	}

}