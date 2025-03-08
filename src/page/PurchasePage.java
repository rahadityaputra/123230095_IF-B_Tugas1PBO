package page;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class PurchasePage extends JFrame implements ActionListener{
  JLabel labelCheckOut = new JLabel("CheckOut");
  JLabel labelKategori = new JLabel("Ketegori");
  JLabel labelPilihKategori = new JLabel();
  JLabel labelIsiHarga = new JLabel();
  JLabel labelHarga = new JLabel("Harga");
  JLabel labelJumlah = new JLabel("Jumlah");
  JTextField inputJumlahPembelian = new JTextField();
  int jumlahPembelian;    
  
  JButton buttonKembali = new JButton("Kembali");
  JButton buttonBeli = new JButton("Beli");
  int hargaMajalah;
  JPanel panel = new JPanel(new GridBagLayout());
  GridBagConstraints gbc = new GridBagConstraints();

 PurchasePage(String jenisMajalah) {

   panel.setBackground(Color.WHITE);
    setBackground(Color.WHITE);
    add(panel);
    setVisible(true);
    setTitle("CheckOut");
    setLocationRelativeTo(null);
    setAlwaysOnTop(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);

    labelPilihKategori.setText("Majalah " + jenisMajalah);


    if (jenisMajalah.equals("Anak")) {
      hargaMajalah = 10800;
      labelIsiHarga.setText("Rp 10.800 / pcs");
    } else if (jenisMajalah.equals("Remaja")) {
      hargaMajalah = 15200;
      labelIsiHarga.setText("Rp 15.200 / pcs");

    } else {
      hargaMajalah = 25400;
      labelIsiHarga.setText("Rp 25.400 / pcs");
    }

    
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    panel.add(labelCheckOut, gbc);
    labelCheckOut.setFont(new Font("Arial", Font.BOLD, 17));

    gbc.gridwidth = 1;
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.WEST;
    panel.add(labelKategori, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    panel.add(labelPilihKategori, gbc);


    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.anchor = GridBagConstraints.WEST;
    panel.add(labelHarga, gbc);

    gbc.gridx = 1;
    gbc.gridy = 3;
    panel.add(labelIsiHarga, gbc);

    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.anchor = GridBagConstraints.WEST;
    panel.add(labelJumlah, gbc);

    gbc.gridx = 1;
    gbc.gridy = 4;
    panel.add(inputJumlahPembelian, gbc);
    inputJumlahPembelian.setPreferredSize(new Dimension(300, 30));

    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = 2;
    panel.add(buttonKembali, gbc);
    buttonKembali.setPreferredSize(new Dimension(300, 30));

    gbc.gridwidth = 1;

    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 2;
    panel.add(buttonBeli, gbc);
    buttonBeli.setPreferredSize(new Dimension(300, 30));

    buttonKembali.addActionListener(this);
    buttonBeli.addActionListener(this);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
      try {
        if (e.getSource() == buttonKembali) {
          new HomePage("123230095");
          dispose();
        } else if (e.getSource() == buttonBeli) {
          try {
              jumlahPembelian = Integer.parseInt(inputJumlahPembelian.getText());
              if (jumlahPembelian <= 0) throw new NumberFormatException();
              new PurchaseSuccessPage(hargaMajalah, jumlahPembelian);
              dispose();
          } catch (NumberFormatException ex) {
              JOptionPane.showMessageDialog(this, "Masukkan jumlah pembelian yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
          }
        }

      }catch(Exception error) {
        error.printStackTrace();
      }
  }

}
