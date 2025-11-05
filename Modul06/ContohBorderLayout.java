package Modul06;

import javax.swing.*;

public class ContohBorderLayout {
    public static void main(String [] args){
        // 1. Buat Frame (Window)
        JFrame frame = new JFrame("Contoh BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 2. Buat Panel (Container) dengan BorderLayout
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.BorderLayout());

        // 3. Buat dan tambahkan komponen di setiap region BorderLayout
        panel.add(new JButton("NORTH"), java.awt.BorderLayout.NORTH);
        panel.add(new JButton("SOUTH"), java.awt.BorderLayout.SOUTH);
        panel.add(new JButton("EAST"), java.awt.BorderLayout.EAST);
        panel.add(new JButton("WEST"), java.awt.BorderLayout.WEST);
        panel.add(new JButton("CENTER"), java.awt.BorderLayout.CENTER);

        // 4. Tambahkan panel ke frame
        frame.add(panel);   

        // 5. Tampilkan Frame
        frame.setVisible(true); 
        
    }   
}
