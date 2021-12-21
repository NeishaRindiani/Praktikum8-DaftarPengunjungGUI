/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Asus
 */
public class GUI {
    public GUI() {
        Absen absen = new Absen();
        JFrame frame = new JFrame("Absen Pengunjung");
        frame.setSize(400, 400);

        JPanel panelNamaLengkap = new JPanel();

        JTextField fieldNamaLengkap = new JTextField(20);
        JTextField fieldAsalKota = new JTextField(20);
        JTextField fieldNomorPonsel = new JTextField(20);
        JTextField fieldEmail = new JTextField(20);
        JButton tombolSubmit = new JButton("Absen");

        panelNamaLengkap.add(new JLabel("Nama lengkap:"));
        panelNamaLengkap.add(fieldNamaLengkap);
        frame.add(panelNamaLengkap);

        frame.add(new JLabel("Asal kota:"));
        frame.add(fieldAsalKota);

        frame.add(new JLabel("Nomor ponsel:"));
        frame.add(fieldNomorPonsel);
        frame.add(new JLabel("Email:"));
        frame.add(fieldEmail);
        frame.add(tombolSubmit);

        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setVisible(true);

        tombolSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fieldNamaLengkap.getText().equals("")
                        || fieldAsalKota.getText().equals("")
                        || fieldNomorPonsel.getText().equals("")
                        || fieldEmail.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Ada isian yg belum diisi!");
                    return;
                }
                String namaLengkap = fieldNamaLengkap.getText();
                String asalKota = fieldAsalKota.getText();
                String nomorPonsel = fieldNomorPonsel.getText();
                String email = fieldEmail.getText();

                if (absen.cekDuplikat(namaLengkap)) {
                    JOptionPane.showMessageDialog(frame, "Ada duplikat!");
                    return;
                }

                //...

                absen.listPengunjung.add(new Pengunjung(namaLengkap, asalKota, nomorPonsel, email));


            }
        });
    }
}
