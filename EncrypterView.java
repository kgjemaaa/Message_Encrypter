import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class EncrypterView 
{
  public static void main(String[] args)
   {
      System.out.println("Hello View");
   }
     //DrawString Method 
 public  void DrawString(Graphics g,String Message, int font_size, int  x_coordinate, int  y_coordinate)   
 {
      g.setColor(Color.black);
      g.setFont(new Font("Indica", Font.PLAIN, font_size));
      g.drawString(Message, x_coordinate, y_coordinate);      
 }
 //DrawBackground Mehod
 public void DrawBackground(Graphics g)
 {
      g.setColor(Color.gray);
      g.fillRect(0,0,1090,650);
      for(int i=15;i<1075;i=i+35)
      {
         for(int j=15;j<650;j=j+35)
         {
            g.setFont(new Font("Indica", Font.PLAIN, 20));
            g.setColor(Color.LIGHT_GRAY);
            g.drawString("#",i,j);
         }
      }
     
 }
 //Create buttons
 public JButton create_button(String text,int x_coordinate,int y_coordinate,int width,int height)
 {
       JButton button = new JButton(text);
      button.setBounds(x_coordinate,y_coordinate, width, height);
      button.setBackground(Color.gray);
      button.setForeground(Color.black);
      button.setBorder(BorderFactory.createLineBorder(Color.black, 1));
      button.setMargin(new Insets(0, 0, 0, 0));
      button.setFont(new Font("Indica", Font.PLAIN, 20));
      return button;
 }
 //create textarea
 public JTextArea create_text_area(String first_text ,int x_coordinate,int  y_coordinate,int width,int height,int font_size){
       JTextArea text_area = new JTextArea(first_text, 5,5);
       text_area.setBounds(x_coordinate,y_coordinate,width,height);
       text_area.setLineWrap(true);  //this tells it to break the string to fit the TextArea
       text_area.setWrapStyleWord(true); //this tells it to break the words and not the word
       Font text_area_font = new Font("Indica", Font.PLAIN, font_size);
       text_area.setFont(text_area_font);
       return text_area;
       }
       
}