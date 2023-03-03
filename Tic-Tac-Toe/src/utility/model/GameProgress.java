package utility.model;

import javax.swing.JOptionPane;

public class GameProgress
{
   private int turn;
   private String x;
   private String o;
   
   public GameProgress()
   {
      turn = 0;
      x = "X";
      o = "O";
   }
   
   public String markSpot()
   {
      turn++;
      if(turn==9)
         JOptionPane.showMessageDialog(null, "Game over!");
      if(turn%2 == 0)
      {
         return o;
      }
      else return x;
   }
   
   public void resetGame()
   {
      turn = 0;
   }
}
