package utility.model;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TUI extends JFrame
{
   private JPanel field;
   private JPanel selector;
   private JComboBox<String> x;
   private JComboBox<String> y;
   private JTextField x1y1;
   private JTextField x1y2;
   private JTextField x1y3;
   private JTextField x2y1;
   private JTextField x2y2;
   private JTextField x2y3;
   private JTextField x3y1;
   private JTextField x3y2;
   private JTextField x3y3;
   private JLabel a;
   private JLabel b;
   private JButton ok;
   private JButton reset;
   private GameProgress prog;
   private WinningCondition win;

   
   public TUI()
   {
      super("TicTacToe");
      setSize(400, 200);
      setVisible(true);
      setLayout(new FlowLayout());
      Button press = new Button();
      
      String[] options = {"1", "2", "3"};
      
      field = new JPanel();
      field.setLayout(new GridLayout(3, 3));
      x1y1 = new JTextField(1);
      field.add(x1y1);
      x2y1 = new JTextField(1);
      field.add(x2y1);
      x3y1 = new JTextField(1);
      field.add(x3y1);
      x1y2 = new JTextField(1);
      field.add(x1y2);
      x2y2 = new JTextField(1);
      field.add(x2y2);
      x3y2 = new JTextField(1);
      field.add(x3y2);
      x1y3 = new JTextField(1);
      field.add(x1y3);
      x2y3 = new JTextField(1);
      field.add(x2y3);
      x3y3 = new JTextField(1);
      field.add(x3y3);
      field.setSize(300, 300);
      add(field);
      
      selector = new JPanel();
      selector.setLayout(new GridLayout(3, 2));
      a = new JLabel("X: ");
      b = new JLabel("Y: ");
      x = new JComboBox<String>(options);
      y = new JComboBox<String>(options);
      selector.add(a);
      selector.add(x);
      selector.add(b);
      selector.add(y);
      ok = new JButton("Mark");
      ok.addActionListener(press);
      selector.add(ok);
      reset = new JButton("Reset");
      reset.addActionListener(press);
      selector.add(reset);
      selector.setSize(100, 100);
      add(selector);
      
      prog = new GameProgress();
   }
   
   private class Button implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource() == ok)
         {
            if(x.getSelectedItem().equals("1") && y.getSelectedItem().equals("1"))
            {
               x1y1.setText(prog.markSpot());
               win = new WinningCondition(x1y1.getText(), x1y2.getText(), x1y3.getText(), x2y1.getText(), x2y2.getText(), x2y3.getText(), x3y1.getText(), x3y2.getText(), x3y3.getText());
               if(win.checkForWin())
                  JOptionPane.showMessageDialog(null, "Victory!");
            }
            
            if(x.getSelectedItem().equals("1") && y.getSelectedItem().equals("2"))
            {
               x1y2.setText(prog.markSpot());
               win = new WinningCondition(x1y1.getText(), x1y2.getText(), x1y3.getText(), x2y1.getText(), x2y2.getText(), x2y3.getText(), x3y1.getText(), x3y2.getText(), x3y3.getText());
               if(win.checkForWin())
                  JOptionPane.showMessageDialog(null, "Victory!");
            }
            
            if(x.getSelectedItem().equals("1") && y.getSelectedItem().equals("3"))
            {
               x1y3.setText(prog.markSpot());
               win = new WinningCondition(x1y1.getText(), x1y2.getText(), x1y3.getText(), x2y1.getText(), x2y2.getText(), x2y3.getText(), x3y1.getText(), x3y2.getText(), x3y3.getText());
               if(win.checkForWin())
                  JOptionPane.showMessageDialog(null, "Victory!");
            }
            
            if(x.getSelectedItem().equals("2") && y.getSelectedItem().equals("1"))
            {
               x2y1.setText(prog.markSpot());
               win = new WinningCondition(x1y1.getText(), x1y2.getText(), x1y3.getText(), x2y1.getText(), x2y2.getText(), x2y3.getText(), x3y1.getText(), x3y2.getText(), x3y3.getText());
               if(win.checkForWin())
                  JOptionPane.showMessageDialog(null, "Victory!");
            }
            
            if(x.getSelectedItem().equals("2") && y.getSelectedItem().equals("2"))
            {
               x2y2.setText(prog.markSpot());
               win = new WinningCondition(x1y1.getText(), x1y2.getText(), x1y3.getText(), x2y1.getText(), x2y2.getText(), x2y3.getText(), x3y1.getText(), x3y2.getText(), x3y3.getText());
               if(win.checkForWin())
                  JOptionPane.showMessageDialog(null, "Victory!");
            }
            
            if(x.getSelectedItem().equals("2") && y.getSelectedItem().equals("3"))
            {
               x2y3.setText(prog.markSpot());
               win = new WinningCondition(x1y1.getText(), x1y2.getText(), x1y3.getText(), x2y1.getText(), x2y2.getText(), x2y3.getText(), x3y1.getText(), x3y2.getText(), x3y3.getText());
               if(win.checkForWin())
                  JOptionPane.showMessageDialog(null, "Victory!");
            }
            
            if(x.getSelectedItem().equals("3") && y.getSelectedItem().equals("1"))
            {
               x3y1.setText(prog.markSpot());
               win = new WinningCondition(x1y1.getText(), x1y2.getText(), x1y3.getText(), x2y1.getText(), x2y2.getText(), x2y3.getText(), x3y1.getText(), x3y2.getText(), x3y3.getText());
               if(win.checkForWin())
                  JOptionPane.showMessageDialog(null, "Victory!");
            }
            
            if(x.getSelectedItem().equals("3") && y.getSelectedItem().equals("2"))
            {
               x3y2.setText(prog.markSpot());
               win = new WinningCondition(x1y1.getText(), x1y2.getText(), x1y3.getText(), x2y1.getText(), x2y2.getText(), x2y3.getText(), x3y1.getText(), x3y2.getText(), x3y3.getText());
               if(win.checkForWin())
                  JOptionPane.showMessageDialog(null, "Victory!");
            }
            
            if(x.getSelectedItem().equals("3") && y.getSelectedItem().equals("3"))
            {
               x3y3.setText(prog.markSpot());
               win = new WinningCondition(x1y1.getText(), x1y2.getText(), x1y3.getText(), x2y1.getText(), x2y2.getText(), x2y3.getText(), x3y1.getText(), x3y2.getText(), x3y3.getText());
               if(win.checkForWin())
                  JOptionPane.showMessageDialog(null, "Victory!");
            }
         }
         if(e.getSource() == reset)
         {
            prog.resetGame();
            x1y1.setText(null);
            x1y2.setText(null);
            x1y3.setText(null);
            x2y1.setText(null);
            x2y2.setText(null);
            x2y3.setText(null);
            x3y1.setText(null);
            x3y2.setText(null);
            x3y3.setText(null);
         }
      }
   }
}
