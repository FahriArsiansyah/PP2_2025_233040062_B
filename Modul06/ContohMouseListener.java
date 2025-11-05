package Modul06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author wdgus
 */
public class ContohMouseListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh MouseListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // 1. Buat komponen (Event Source)
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(200, 200));

        // 2. Buat Event Listener (Menggunakan MouseAdapter)
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // saat mouse masuk, ubah warna jadi biru
                panel.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // saat mouse keluar, kembalikan warna
                panel.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // saat diklik, tampilkan koordinat klik
                System.out.println("Mouse diklik di: (" + e.getX() + ", " + e.getY() + ")");
            }
        };

        // 3. Daftarkan listener ke source  
        panel.addMouseListener(adapter);

        // 4. Tambahkan panel ke frame dan tampilkan
        frame.add(panel);
        frame.setVisible(true);
    }
}
