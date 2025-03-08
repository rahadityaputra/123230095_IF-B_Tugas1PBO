package page;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PurchaseSuccessPage extends JFrame implements ActionListener {
    private int totalBelanja;
    private JLabel labelIsiTotalBelanja, labelIsiHargaSatuan, labelIsiJumlah;
    private JButton btnKembali;
    
    public PurchaseSuccessPage(int hargaMajalah, int jumlahPembelian) {
        totalBelanja = hitungTotalBelanja(hargaMajalah, jumlahPembelian);
        
        // Konfigurasi Frame
        setTitle("Purchase Success");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        // Panel utama dengan layout GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Judul
        JLabel labelJudul = new JLabel("Pembelian Berhasil");
        labelJudul.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(labelJudul, gbc);
        
        // Label dan Isi
        tambahLabel(panel, gbc, "Total Belanja:", "Rp " + totalBelanja, 1);
        tambahLabel(panel, gbc, "Harga Satuan:", "Rp " + hargaMajalah, 2);
        tambahLabel(panel, gbc, "Jumlah:", String.valueOf(jumlahPembelian), 3);
        

        JLabel labelTerimaKasih = new JLabel("Terima Kasih Sudah Membeli");
        labelTerimaKasih.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        panel.add(labelTerimaKasih, gbc);
        
        // Tombol Kembali
        btnKembali = new JButton("OKE");
        btnKembali.setFont(new Font("Arial", Font.PLAIN, 14));
        btnKembali.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(btnKembali, gbc);
        
        // Tambahkan panel ke frame
        add(panel);
        setVisible(true);
    }
    
    private void tambahLabel(JPanel panel, GridBagConstraints gbc, String text, String value, int row) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        panel.add(label, gbc);
        
        JLabel labelValue = new JLabel(value);
        labelValue.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 1;
        panel.add(labelValue, gbc);
    }
    
    private int hitungTotalBelanja(int hargaMajalah, int jumlahPembelian) {
        return hargaMajalah * jumlahPembelian;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKembali) {
            dispose(); // Tutup jendela
        }
    }

}
