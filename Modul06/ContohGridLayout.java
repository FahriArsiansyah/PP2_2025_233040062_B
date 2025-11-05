package Modul06;

import javax.swing.*;

public class ContohGridLayout {
    public static void main(String [] args){
        // 1. Buat Frame (Window)
        JFrame frame = new JFrame("Contoh GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 2. Atur layout frame menjadi GridLayout 3 baris dan 2 kolom
        // Kita juga menambahkan jarak (gap) antar sel
        frame.setLayout(new java.awt.GridLayout(3, 2, 5, 5)); // 3 baris, 2 kolom, hgap=5, vgap=5

        // 3. Buat dan tambahkan komponen
        frame.add(new JLabel("Label 1"));
        frame.add(new JTextField());
        frame.add(new JLabel("Label 2")); 
        frame.add(new JPasswordField()); 
        frame.add(new JButton("Login"));
        frame.add(new JButton("Batal"));     

        // 4. Tampilkan Frame
        frame.setVisible(true); 
        
    }
}
