package page;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class HomePage extends JFrame implements ActionListener{
    JLabel labelSelamatDatang = new JLabel();
    JLabel label1 = new JLabel();
    JButton buttonMajalahAnak = new JButton("Majalah Anak");
    JButton buttonMajalahRemaja = new JButton("Majalah Remaja");
    JButton buttonMajalahDewasa = new JButton("Majalah Dewasa");

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();


    HomePage(String username) {

      panel.setBackground(Color.WHITE);
      setBackground(Color.WHITE);
      add(panel);
      setVisible(true);
      setSize(500, 500);
      setTitle("Home");
      setLocationRelativeTo(null);
      setAlwaysOnTop(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      labelSelamatDatang.setText("Selamat Datang,  " + username);
      labelSelamatDatang.setFont(new Font("Arial", Font.BOLD, 17));
      label1.setText("Silahkan pilih menu di bawah untuk membeli majalah");

      buttonMajalahAnak.setPreferredSize(new Dimension(300, 30));
      buttonMajalahRemaja.setPreferredSize(new Dimension(300, 30));
      buttonMajalahDewasa.setPreferredSize(new Dimension(300, 30));

      gbc.insets = new Insets(10, 10, 10, 10);
      gbc.gridx = 0;
      gbc.gridy = 1;
      panel.add(labelSelamatDatang, gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      panel.add(label1, gbc);

      gbc.gridx = 0;
      gbc.gridy = 3;
      panel.add(buttonMajalahAnak, gbc);

      gbc.gridx = 0;
      gbc.gridy = 4;
      panel.add(buttonMajalahRemaja, gbc);

      gbc.gridx = 0;
      gbc.gridy = 5;
      panel.add(buttonMajalahDewasa, gbc);

      gbc.gridx = 0;
      gbc.gridy = 6;

      buttonMajalahAnak.addActionListener(this); // jangan lupa tambahin ini
      buttonMajalahRemaja.addActionListener(this); // jangan lupa tambahin ini
      buttonMajalahDewasa.addActionListener(this); // jangan lupa tambahin ini
    }



  @Override
  public void actionPerformed(ActionEvent e) {
      try {
          if(e.getSource() == buttonMajalahAnak) {
            new PurchasePage("Anak");   
          } else if (e.getSource() == buttonMajalahRemaja) {
            new PurchasePage("Remaja");   
               
          } else if (e.getSource() == buttonMajalahDewasa) {
            new PurchasePage("Dewasa");   
               
          }
          dispose();
      }catch(Exception error) {
          JOptionPane.showMessageDialog(this, error.getMessage());
      }
  }


}
