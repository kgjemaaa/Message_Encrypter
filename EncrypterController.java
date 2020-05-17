import javax.swing.*;
import java.awt.*;

public class EncrypterController extends JPanel
{   
   EncrypterModel model = new EncrypterModel();
   EncrypterView view = new EncrypterView();
   JFrame frame = new JFrame();
   public EncrypterController()
   { 
      int width = 1090;
      int height = 650;
      frame.getContentPane().add(this);
      frame.setTitle("Welcome!");
      frame.setSize(width, height);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
   }
   public void paintComponent(Graphics g)
   { 
      //Draw Background
      view.DrawBackground(g);
      
      //Say Welcome
      view.DrawString(g,"Welcome!",50,430,200);
      
      //Encrypt Button
      this.setLayout(null);
      JButton encrypt_button = view.create_button("Encrypt Message!",360,240,180,30);
      this.add(encrypt_button);
      //Decrypt Button
      JButton decrypt_button = view.create_button("Decrypt Message!",550,240,180,30); 
      this.add(decrypt_button);
     
      //Adding functionality to encrypt_button
      encrypt_button.addActionListener(model.encrypt_message(frame));
      
       //Adding functionality to decrypt_button
      decrypt_button.addActionListener(model.decrypt_message(frame));
      
   }
   
   public static void main(String[] args)
   {
      new EncrypterController();
   }   
   }