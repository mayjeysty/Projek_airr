package Projek_airr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestGUI extends JFrame {

    public static void main(String[] args) {
        new TestGUI();
    }

    JTextField txtNama, txtNomor, txtPemakaian, txtTelat;
    JButton btnHitung;

    public TestGUI() {
        setTitle("Pembayaran Air");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(9, 1, 5, 5));

        panel.add(new JLabel("Nama Pelanggan"));
        txtNama = new JTextField();
        panel.add(txtNama);

        panel.add(new JLabel("Nomor Pelanggan"));
        txtNomor = new JTextField();
        panel.add(txtNomor);

        panel.add(new JLabel("Pemakaian Air (m³)"));
        txtPemakaian = new JTextField();
        panel.add(txtPemakaian);

        panel.add(new JLabel("Keterlambatan (hari)"));
        txtTelat = new JTextField();
        panel.add(txtTelat);

        btnHitung = new JButton("Hitung Tagihan");
        panel.add(btnHitung);

        add(panel, BorderLayout.CENTER);

        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prosesHitung();
            }
        }
    );

        setVisible(true);
    }

    private void prosesHitung() {
        try {
            Tagihan t = new Tagihan();

            t.setNamaPelanggan(txtNama.getText());
            t.setNomorPelanggan(txtNomor.getText());

            int pemakaian = Integer.parseInt(txtPemakaian.getText());
            int telat = Integer.parseInt(txtTelat.getText());

            t.setPemakaian(pemakaian);
            t.setKeterlambatan(telat);
            t.hitungTagihan(telat);

            JOptionPane.showMessageDialog(
                this,
                "Nama Pelanggan  : " + t.namaPelanggan +
                "\nNomor Pelanggan : " + t.nomorPelanggan +
                "\nPemakaian Air   : " + t.pemakaian + " m³" +
                "\nTotal Tagihan   : Rp " + t.totalTagihan +
                "\nBiaya Admin     : Rp " + t.biayaAdmin +
                "\nDenda           : Rp " + t.denda +
                "\n---------------------------" +
                "\nTotal Bayar     : Rp " + t.totalBayar,
                "Hasil Pembayaran",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "Pemakaian dan keterlambatan harus angka!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
