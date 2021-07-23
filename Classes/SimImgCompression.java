import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.Color;
import java.util.ArrayList;

public class SimImgCompression
{
 JFrame frame;
 AiProgram canvas;
 public static void main (String[] args)
 {
   String folderName = "Lofi";
   if(args.length > 0)
     folderName = args[0];
  SimImgCompression kt = new SimImgCompression();
  kt.Run(folderName);
 } // end main

 public void Run(String name) {
  frame = new JFrame("");
  frame.setSize(1050, 1050);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setResizable(true);
  canvas = new AiProgram(name);
  frame.getContentPane().add(canvas);

  frame.setVisible(true);
 }
}

/*
Class the runs the program
*/
class AiProgram extends JPanel{

private int[][] currentImage;

private ArrayList<Partical> particals;

private String exportPath;

 public AiProgram(String folderName) {
   particals = new ArrayList<Partical>();

   String dir = System.getProperty("user.dir");
   String mainPath = dir.substring(0, dir.length()-7);
   String newFolder = mainPath+"Output_Images/"+folderName+"Output";
   File folder = new File(mainPath+"Input_Images/"+folderName);
   new File(newFolder).mkdirs();
   exportPath = newFolder+"/";
   File[] listOfFiles = folder.listFiles();
   for(int i = 0; i < listOfFiles.length; i++)
   {
     if(listOfFiles[i].getName().indexOf("jpg") != -1)
     {
       String fileName = listOfFiles[i].getPath();
       Image picture = new Image(fileName);
       Pixel[][] tempImg = picture.getData();
       currentImage = new int[tempImg.length][tempImg[0].length];
       for(int row = 0; row < tempImg.length; row++)
         for(int col = 0; col < tempImg[0].length; col++)
            currentImage[row][col] = (tempImg[row][col].r + tempImg[row][col].g + tempImg[row][col].b)/3;
     }
   }
   for(int row = 0; row < currentImage.length; row++)
     for(int col = 0; col < currentImage[0].length; col++)
      for(int amt = 0; amt < currentImage[row][col]; amt += 50)
        particals.add(new Partical(new Vector2(col, row)));
   setFocusable(true);
   requestFocus();
  BallMover ballmover = new BallMover();
  Timer balltimer = new Timer(16, ballmover);//50
  balltimer.start();
 }

 private double randomRange(double min, double max){
   return min + Math.random() * (max - min);
 }

 class BallMover implements ActionListener {
  public void actionPerformed(ActionEvent e) {

    repaint();
    }
  }

   /*
   Draws the pixels on screen
   */
   public void paintComponent(Graphics g) {
     super.paintComponent(g);
     setBackground(Color.BLACK);
     /*for(int row = 0; row < currentImage.length; row++)
       for(int col = 0; col < currentImage[0].length; col++)
       {
         g.setColor(new Color(currentImage[row][col], currentImage[row][col], currentImage[row][col]));
         g.drawLine(col, row, col, row);
       }*/
   } // end paintComponent`

}
