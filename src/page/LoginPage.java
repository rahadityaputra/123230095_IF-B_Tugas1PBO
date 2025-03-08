package page;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LoginPage extends JFrame implements ActionListener{

  //label
  JLabel labelSelamatDatang = new JLabel("Selamat Datang");
  JLabel usernameLabel = new JLabel("Username : ");
  JLabel passwordLabel = new JLabel("Password : ");

  //input
  JTextField usernameTextField = new JTextField();
  JTextField passwordTextField = new JTextField();

  // tombol
  JButton buttonLogin = new JButton("Login");
  JButton resetLogin = new JButton("Reset");
  
  //panel 
  JPanel panel = new JPanel(new GridBagLayout());

  GridBagConstraints gbc = new GridBagConstraints();

  LoginPage() {

    panel.setBackground(Color.WHITE);

    add(panel);
    setBackground(Color.WHITE);
    setVisible(true);
    setSize(500, 500);

    setTitle("Login");
    setLocationRelativeTo(null);
    setAlwaysOnTop(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    


    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.gridx = 0;
    gbc.gridy = 1;
    panel.add(labelSelamatDatang, gbc);
    labelSelamatDatang.setFont(new Font("Arial", Font.BOLD, 17));


    gbc.gridx = 0;
    gbc.gridy = 2;
    panel.add(usernameLabel, gbc);


    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.weightx = 1;
    usernameTextField.setPreferredSize(new Dimension(200, 30));
    panel.add(usernameTextField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.weightx = 1;
    panel.add(passwordLabel, gbc);

    gbc.gridx = 0;
    gbc.gridy = 5;
    passwordTextField.setPreferredSize(new Dimension(200, 30));
    panel.add(passwordTextField, gbc);


    gbc.gridx = 0;
    gbc.gridy = 6;
    panel.add(buttonLogin, gbc);
    buttonLogin.setBackground(Color.BLACK);
    buttonLogin.setForeground(Color.WHITE);

    
    buttonLogin.addActionListener(this);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
      try {
          if(e.getSource() == buttonLogin) {
              String username = usernameTextField.getText();
              String password = passwordTextField.getText();
          
              if (username.equals("123230095") && password.equals("pass12345")) {
                  new HomePage(username);
                  dispose();
              } else {
                  JOptionPane.showMessageDialog(this, "Login gagal !");
              }
          }          
      }catch(Exception error) {
          JOptionPane.showMessageDialog(this, error.getMessage());
      }
  }

}
