import java.awt.event.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;

public class EncryptMessage extends JPanel
{
   EncrypterModel model = new EncrypterModel();
   EncrypterView view = new EncrypterView();
   JFrame frame = new JFrame();
       
   public EncryptMessage()
   {
       int width = 1090;
      int height = 650;
      frame.getContentPane().add(this);
      frame.setTitle("EncryptMessage!");
      frame.setSize(width, height);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
   }
   
    public void paintComponent(Graphics g)
   { 
      this.setLayout(null);
      //Draw Background
      
      view.DrawBackground(g);
      //Add Starter Page Button
      
      JButton starter_page = view.create_button("Starter Page",20,20,180,30);
      this.add(starter_page);
      starter_page.addActionListener(model.starter_page(frame));
      //Say Encrypt Message
      
       view.DrawString(g,"Encrypt Message!",50,330,50);
       //Draw String Write your message here
       
        view.DrawString(g,"Write your message here: ",25,90,90);
        //Field to write the message
        
       JTextArea message_area = view.create_text_area("",90,100,350,320,16);
        this.add(message_area);    
       //Draw String write your encryption key here
       
       view.DrawString(g,"Write your encryption key here: ",25,90,445);   
       //Field to write the encryption key
       
       JTextArea encryption_key_area = view.create_text_area("",90,450,350,30,20);
        this.add(encryption_key_area); 
        //only numbers
         encryption_key_area.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
            String value = encryption_key_area.getText();
            int length = value.length();
            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')||ke.getKeyChar()=='\b') 
            {
                 //Three digits only  
                if(value.length()>2)
                {  
                     //deleting
                     if(ke.getKeyChar() == '\b')
                     encryption_key_area.setEditable(true);
                     else
                     {
                           encryption_key_area.setEditable(false);
                           JOptionPane.showMessageDialog(null,"Three digets only");
                     }
                }
                else
                {
                boolean same=false;
                for(int i=0;i<length;i++)
                {
                  if(value.charAt(i) == ke.getKeyChar())
                  same=true;
                }
                if(same)
                {
                  encryption_key_area.setEditable(false);
                  JOptionPane.showMessageDialog(null,"Same numbers are not allowed");
                }  
                else
                  encryption_key_area.setEditable(true);
                }
            }
            else 
            {  
               //Not numbers not allowed
               encryption_key_area.setEditable(false);
            }
         }
      });   
      //Encryption Button
     JButton encrypt_button = view.create_button("Encrypt Message!", 460 ,300 ,180 ,30 );
        this.add(encrypt_button);
        
        //Field to write the encrypted message
        JTextArea encrypted_message_area = view.create_text_area("",660 ,100 ,350 ,500 ,16 );
        encrypted_message_area.setEditable(false);
        this.add(encrypted_message_area);    
        
        //Adding functionality to Encrypt Button
        encrypt_button.addActionListener(new ActionListener()
             {
                  public void actionPerformed(ActionEvent e)
                  {  
                     //Get message,encryption key
                      String message = message_area.getText();
                      String encryption_key_string = encryption_key_area.getText();
                      int encryption_key =  Integer.parseInt(encryption_key_area.getText());
                      //calculate rows
                      int rows;
                      int reminder = message.length()%3;  
                      if(reminder!=0)
                        rows = (message.length() /3)+1;
                      else
                        rows= message.length()/3;
                        if ((message==null)||message.equals("")) {
                         encrypted_message_area.setText("Please write the message");
                         }
                         else if (encryption_key_string.length()!=3) {
                         encrypted_message_area.setText("Please chech your encryption key");
                         }
                         else{
                             String return_message = model.encrypt_message(message, encryption_key, encryption_key_string,  rows,reminder);
                             //Set return message
                            encrypted_message_area.setText(return_message);
                        }
                  }  
             }
        );
    }
    
   public static void main(String[] args)
   {
      new EncryptMessage();
   }   
}