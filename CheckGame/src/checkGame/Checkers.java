package checkGame;

/*
 * Loje shahu guret e te ciles levizen manualisht.
 * Punoi : Nderim Kurti 
 * Dega : Informatike , Viti : 2
 * Grupi : C1
 * Data : 6/6/2016
*/


import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Checkers extends JFrame
{
   public Checkers(String title)
   {
	   
      super(title);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
       final JPanel panel = new JPanel();
       final JButton reset = new JButton("Reset");

      Board board = new Board();
      board.add(new Checker(CheckerType.SOLDIER, 1), 2, 1);
      board.add(new Checker(CheckerType.SOLDIER, 1), 2, 2);
      board.add(new Checker(CheckerType.SOLDIER, 1), 2, 3);
      board.add(new Checker(CheckerType.SOLDIER, 1), 2, 4);
      board.add(new Checker(CheckerType.SOLDIER, 1), 2, 5);
      board.add(new Checker(CheckerType.SOLDIER, 1), 2, 6);
      board.add(new Checker(CheckerType.SOLDIER, 1), 2, 7);
      board.add(new Checker(CheckerType.SOLDIER, 1), 2, 8);
      
      board.add(new Checker(CheckerType.TOWER, 1), 1, 1);
      board.add(new Checker(CheckerType.HORSE, 1), 1, 2);
      board.add(new Checker(CheckerType.OFFICER, 1), 1, 3);
      board.add(new Checker(CheckerType.QUEEN, 1), 1, 4);
      board.add(new Checker(CheckerType.KING, 1), 1, 5);
      board.add(new Checker(CheckerType.OFFICER, 1), 1, 6);
      board.add(new Checker(CheckerType.HORSE, 1), 1, 7);
      board.add(new Checker(CheckerType.TOWER, 1), 1, 8);
     

      
      board.add(new Checker(CheckerType.SOLDIER, 2), 7, 1);
      board.add(new Checker(CheckerType.SOLDIER, 2), 7, 2);
      board.add(new Checker(CheckerType.SOLDIER, 2), 7, 3);
      board.add(new Checker(CheckerType.SOLDIER, 2), 7, 4);
      board.add(new Checker(CheckerType.SOLDIER, 2), 7, 5);
      board.add(new Checker(CheckerType.SOLDIER, 2), 7, 6);
      board.add(new Checker(CheckerType.SOLDIER, 2), 7, 7);
      board.add(new Checker(CheckerType.SOLDIER, 2), 7, 8);
     
      board.add(new Checker(CheckerType.TOWER, 2), 8, 1);
      board.add(new Checker(CheckerType.HORSE, 2), 8, 2);
      board.add(new Checker(CheckerType.OFFICER, 2), 8, 3);
      board.add(new Checker(CheckerType.QUEEN, 2), 8, 4);
      board.add(new Checker(CheckerType.KING, 2), 8, 5);
      board.add(new Checker(CheckerType.OFFICER, 2), 8, 6);
      board.add(new Checker(CheckerType.HORSE, 2), 8, 7);
      board.add(new Checker(CheckerType.TOWER, 2), 8, 8);
      
     
      board.add(panel);
      

      setContentPane(board);

      pack();
      setVisible(true);
   }

   public static void main(String[] args)
   {
	   // Runnable interface duhet t implementohet nga cdo klase instancat e te ciles kane per qellim te 
	   // ekzekutohen nga nje thread (Praktike e mir programimi per lojrat)
      Runnable r = new Runnable()
                   {
                      @Override
                      public void run()
                      {
                         new Checkers("Checkers");
                      }
                   };
                   // (EventQueue) Klase e pavarur qe rradhit eventet
      EventQueue.invokeLater(r);
   }
}