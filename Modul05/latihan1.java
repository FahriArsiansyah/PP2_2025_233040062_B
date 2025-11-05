package Modul05;
import  javax.swing.*;
public class latihan1 {
     public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable(){
        public void run(){
            // 1. Buat objek Jframe
            JFrame frame = new JFrame("Jendela Pertamaku");
            
            // 2. Atur Ukuran jendela (lebar 400, tinggi 300)
            frame.setSize(400, 300);
            
            // 3. Atur aksi saat tombol close (X) ditekan
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // 4. Buat jendela terlihat
            frame.setVisible(true);
            
        }
        
         });
}

}