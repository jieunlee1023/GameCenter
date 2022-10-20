package game_center.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import game_center.dto.RequestGameCenter;
import game_center.dto.ResponseGameCenter;
import game_center.interfaces.IGameCenterService;
import game_center.utils.DBClient;

public class GameCenterUserService implements IGameCenterService {

   private DBClient dbClient;
   private PreparedStatement psmt;
   private ResultSet rs;

   public GameCenterUserService() {
      initData();
   }

   private void initData() {
      dbClient = dbClient.getInstance();
   }

      @Override
      public List<ResponseGameCenter> selectGame(String gameName) { // 게임 선택 (게임정보 나옴 + 캐릭터요약 + 맵요약)
         return null;
      }

      @Override
      public List<ResponseGameCenter> selectCharacter(String characterName) { // 게임 캐릭터 선택 (캐릭터상세)

         return null;
      }

      @Override

      public List<ResponseGameCenter> selectMap(String mapName) {

         return null;
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
            try {
               psmt.close();
               dbClient.connectionClose();
            } catch (SQLException e) {
               e.printStackTrace();
            }

         }
         return flag;
      }

      @Override
      public void logIn(RequestGameCenter rgc) { // 로그인

      }

      @Override
      public int update(RequestGameCenter rgc) { // 본인 정보 수정
         int result = 0;
         RequestGameCenter selectData = new RequestGameCenter(); // <---- select로 바꿔야함

         try {
            dbClient.getConnection().setAutoCommit(false);
            if (selectData != null) {
//            if(selectData = rgc.getUserId()) {
//               
//            }
               String query = "UPDATE user SET identityNum = 2, userId = ?, password = ?, userName = ?, email = ?, mobile = ? WHERE userId = ? ";
               psmt = dbClient.getConnection().prepareStatement(query);
            }
         } catch (SQLException e) {
            try {
               dbClient.getConnection().rollback();
            } catch (SQLException e1) {
               e1.printStackTrace();
            }
            System.out.println("롤백됐습니다.");
            e.printStackTrace();
         }
         return result;
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
   }
   
}