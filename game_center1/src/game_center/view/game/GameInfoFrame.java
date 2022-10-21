package game_center.view.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import game_center.utils.Define;

public class GameInfoFrame extends JFrame implements ActionListener {

   private JMenuBar bar = new JMenuBar();
   private JMenu gameInfo = new JMenu("메뉴");
   private JMenuItem gameSelected = new JMenuItem("게임 정보 조회");
   private JMenuItem gameUpdate = new JMenuItem("게임 정보 수정");
   private JMenuItem gameDelete = new JMenuItem("게임 정보 삭제");
   private JMenuItem exit = new JMenuItem("나가기");

   private JMenu gameMapInfo = new JMenu("맵");
   private JMenuItem gameMapSelected = new JMenuItem("맵 조회");
   private JMenuItem gameMapUpdate = new JMenuItem("맵 수정");
   private JMenuItem gameMapDelete = new JMenuItem("맵 삭제");

   private JMenu gameCharacterInfo = new JMenu("캐릭터");
   private JMenuItem gameCharacterSelected = new JMenuItem("캐릭터 조회");
   private JMenuItem gameCharacterUpdate = new JMenuItem("캐릭터 수정");
   private JMenuItem gameCharacterDelete = new JMenuItem("캐릭터 삭제");

   private JLabel gameImage = new JLabel(new ImageIcon(Define.IMAGE_PATH + "bg.png"));

   private JLabel gameName = new JLabel(" 게임 이름 ~~ ");
   private JLabel ageLimit = new JLabel(" 연령제한 ~~");
   private JLabel gameInfomation = new JLabel(" 게임 정보 ~~");

   // 수정시 사용 (관리자만 사용함)
   private JTextArea gameNameUpdate = new JTextArea();
   private JTextArea ageLimitUpdate = new JTextArea();
   private JTextArea gameInfomationUpdate = new JTextArea();

   public GameInfoFrame() {
      initData();
      setInitLayout();
      addEventListener();
   }

   private void initData() {
      setSize(500, 700);
      setTitle("게임 정보창");
      setResizable(false);
      setLocationRelativeTo(null);
      getContentPane().setBackground(new Color(30, 40, 90));
   }

   private void setInitLayout() {
      setVisible(true);
      setLayout(null);

      gameInfo.add(gameSelected);
      gameInfo.add(gameUpdate);
      gameInfo.add(gameDelete);
      gameInfo.addSeparator(); // 분리선 삽입
      gameInfo.add(exit);

      gameMapInfo.add(gameMapSelected);
      gameMapInfo.add(gameMapUpdate);
      gameMapInfo.add(gameMapDelete);

      gameCharacterInfo.add(gameCharacterSelected);
      gameCharacterInfo.add(gameCharacterUpdate);
      gameCharacterInfo.add(gameCharacterDelete);

      bar.add(gameInfo);
      bar.add(gameMapInfo);
      bar.add(gameCharacterInfo);

      setJMenuBar(bar);
      
      gameImage.setSize(400, 400);
      gameImage.setLocation(50, 0);
      gameImage.setBackground(Color.white);
      add(gameImage);

      gameName.setSize(400, 20);
      gameName.setLocation(50, 360);
      gameName.setForeground(Color.white);
      add(gameName);

      ageLimit.setSize(400, 20);
      ageLimit.setLocation(370, 360);
      ageLimit.setForeground(Color.white);
      add(ageLimit);

      gameInfomation.setSize(400, 200);
      gameInfomation.setLocation(50, 300);
      gameInfomation.setForeground(Color.white);
      add(gameInfomation);
   }

   private void addEventListener() {
      gameSelected.addActionListener(this);
      gameUpdate.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {

      JMenuItem targetItem = (JMenuItem) e.getSource();
      if (targetItem.getText().equals(gameSelected.getText())) {

         remove(gameImage);
         remove(gameNameUpdate);
         remove(ageLimitUpdate);
         remove(gameInfomationUpdate);

         System.out.println("게임정보조회");
         gameImage.setSize(400, 400);
         gameImage.setLocation(50, 0);
         gameImage.setBackground(Color.white);
         add(gameImage);

         gameName.setSize(400, 20);
         gameName.setLocation(50, 360);
         gameName.setForeground(Color.white);
         add(gameName);

         ageLimit.setSize(400, 20);
         ageLimit.setLocation(370, 360);
         ageLimit.setForeground(Color.white);
         add(ageLimit);

         gameInfomation.setSize(400, 200);
         gameInfomation.setLocation(50, 300);
         gameInfomation.setForeground(Color.white);
         add(gameInfomation);

         repaint();

      } else if (targetItem.getText().equals(gameUpdate.getText())) {

         remove(gameImage);
         remove(gameName);
         remove(ageLimit);
         remove(gameInfomation);

         System.out.println("게임 정보 수정");

         gameImage.setSize(400, 400);
         gameImage.setLocation(50, 0);
         gameImage.setBackground(Color.white);
         add(gameImage);

         gameNameUpdate.setSize(300, 20);
         gameNameUpdate.setLocation(50, 370);
         add(gameNameUpdate);

         ageLimitUpdate.setSize(80, 20);
         ageLimitUpdate.setLocation(370, 370);
         add(ageLimitUpdate);

         gameInfomationUpdate.setSize(400, 200);
         gameInfomationUpdate.setLocation(50, 400);
         add(gameInfomationUpdate);

         repaint();
      }
   }

   public static void main(String[] args) {
      new GameInfoFrame();
   }
}