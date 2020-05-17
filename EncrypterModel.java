import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class EncrypterModel
{
    public static void main(String[] args)
    {

    }
     //Encrypt Button Action Listener
    public ActionListener encrypt_message(JFrame frame)
    {
       ActionListener listener =  new ActionListener()
       {  
          public void actionPerformed(ActionEvent e)
          {  
            new EncryptMessage();
            frame.dispose();
          }  
       };
       return listener; 
    }
     //Decrypt Button Action Listener
    public ActionListener decrypt_message(JFrame frame)
    {
       ActionListener listener =  new ActionListener()
      {  
         public void actionPerformed(ActionEvent e)
            {  
               new DecryptMessage();
               frame.dispose();
             }  
       };
       return listener; 
      } 
      //Starter Page Button Action Listener
     public ActionListener starter_page(JFrame frame)
      {
         ActionListener listener =  new ActionListener()
          {  
             public void actionPerformed(ActionEvent e)
                {  
                   new EncrypterController();
                   frame.dispose();
                 }  
           };
           return listener; 
         }
       //Method that encrypts the message
       public String encrypt_message(String message,int encryption_key,String key_string,int rows,int reminder)
       {
         int first = Integer.parseInt(Character.toString(key_string.charAt(0)));
         int second = Integer.parseInt(Character.toString(key_string.charAt(1)));
         int third = Integer.parseInt(Character.toString(key_string.charAt(2)));
         String[][] message_array = new String[rows][10];
         String return_message="";
          switch(reminder){ 
            case 0: 
            for(int i=0;i<rows;i++)
             {
                message_array[i][first]=Character.toString(message.charAt(i));
                message_array[i][second]=Character.toString(message.charAt(rows+i));
                message_array[i][third]=Character.toString(message.charAt((rows*2)+i));
             }
               break;  
            case 1: 
               for (int i=0;i<rows;i++) {
                  message_array[i][first]=Character.toString(message.charAt(i));
                  message_array[i][second]=Character.toString(message.charAt(rows+i));
                }
                for (int i=0;i<rows-2;i++) {
                  message_array[i][third]=Character.toString(message.charAt(rows*2+i)); 
                }
                message_array[rows-2][third]="$";
                message_array[rows-1][third]="$";
               break;  
            case 2:                                     
                for(int i=0;i<rows;i++) {
                  message_array[i][first]=Character.toString(message.charAt(i));
                  message_array[i][second]=Character.toString(message.charAt(rows+i));
                }
                for(int i=0;i<rows-1;i++){
                  message_array[i][third]=Character.toString(message.charAt(rows*2+i)); 
                }
                message_array[rows-1][third]="$";
               break;  
            default: System.out.println("Error");  
    }  
         for(int i=0;i<rows;i++)
         {
            for(int j=0;j<10;j++)
            {
              if(message_array[i][j]==null)
              {   } 
              else if(message_array[i][j].equals(" "))
              return_message=return_message+"#";
              else if(message_array[i][j].equals(","))
              return_message=return_message+"%";
              else
              return_message=return_message+message_array[i][j];
            }
            if(i!=rows-1)
            return_message=return_message+", ";
         }
         
         return return_message;
       }
   //Method that decrypts the message
   public String decrypt_message(String message,int key,String key_string)
   {
      int first = Integer.parseInt(Character.toString(key_string.charAt(0)));
      int second = Integer.parseInt(Character.toString(key_string.charAt(1)));
      int third = Integer.parseInt(Character.toString(key_string.charAt(2)));
      Integer[] key_array= new Integer[3];
      String return_message="";
      key_array[0]=first;key_array[1]=second;key_array[2]=third;
      Collections.sort(Arrays.asList(key_array));
      int rows=1;
      for(int i=0;i<message.length();i++)
      {
         if(message.charAt(i)==',')
         rows++;
      }
      String[][] message_array=new String[rows][10];
      for(int i=0;i<rows;i++)
      {
        for(int j=0;j<3;j++)
        {
            message_array[i][key_array[j]]=Character.toString(message.charAt(j+5*i)); 
        }
      }
   
         for(int j=0;j<rows;j++)
         {
         if(message_array[j][first].equals("#"))
         return_message=return_message+" ";
         else if(message_array[j][first].equals("%"))
         return_message=return_message+",";
         else
         return_message=return_message+message_array[j][first];
         }
       for(int j=0;j<rows;j++)
         {
            if(message_array[j][second].equals("#"))
            return_message=return_message+" ";
            else if(message_array[j][second].equals("%"))
            return_message=return_message+",";
            else
            return_message=return_message+message_array[j][second];
         }
          for(int j=0;j<rows;j++)
         {
            if(message_array[j][third].equals("#"))
            return_message=return_message+" ";
            else if(message_array[j][third].equals("%"))
            return_message=return_message+",";
            else if(message_array[j][third].equals("$"))
            { }
            else
            return_message=return_message+message_array[j][third];
         }
     return return_message; 
   }      

    
}