package Modul05;

import javax.swing.*;
import java.awt.*;

public class TUGAS {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Atur Layout Manager ke BorderLayout
                frame.setLayout(new BorderLayout());

                // Buat komponen utama
                JLabel label = new JLabel("AREA (NORTH)", SwingConstants.CENTER);
                JButton buttonSouth = new JButton("AREA (SOUTH)");
                JButton buttonWest = new JButton("Tombol WEST");
                JButton buttonEast = new JButton("Tombol EAST");
                JButton buttonCenter = new JButton("Tombol CENTER");

                // Tambahkan aksi ke masing-masing tombol
                buttonSouth.addActionListener(e -> label.setText("Tombol SOUTH diklik!"));
                buttonWest.addActionListener(e -> label.setText("Tombol WEST diklik!"));
                buttonEast.addActionListener(e -> label.setText("Tombol EAST diklik!"));
                buttonCenter.addActionListener(e -> label.setText("Tombol CENTER diklik!"));

                // Tambahkan komponen ke frame DENGAN POSISI
                frame.add(label, BorderLayout.NORTH);
                frame.add(buttonSouth, BorderLayout.SOUTH);
                frame.add(buttonWest, BorderLayout.WEST);
                frame.add(buttonEast, BorderLayout.EAST);
                frame.add(buttonCenter, BorderLayout.CENTER);

                frame.setVisible(true);
            }
        });
    }
}
