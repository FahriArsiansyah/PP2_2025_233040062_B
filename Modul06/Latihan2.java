package Modul06;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Latihan2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel labelC = new JLabel("Celcius:");
        JTextField inputC = new JTextField(10);
        JButton btnKonversi = new JButton("Konversi");
        JLabel labelF = new JLabel("Fahrenheit:");
        JLabel hasilF = new JLabel(" ");

        btnKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celcius = Double.parseDouble(inputC.getText());
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    hasilF.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex) {
                    hasilF.setText("Input tidak valid!");
                }
            }
        });

        frame.add(labelC);
        frame.add(inputC);
        frame.add(btnKonversi);
        frame.add(labelF);
        frame.add(hasilF);

        frame.setVisible(true);
    }
}
