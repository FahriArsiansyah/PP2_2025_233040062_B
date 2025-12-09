package Modul08.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {
    // Komponen UI
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasilLuas = new JLabel("-");
    
    // (Latihan 2) Label untuk Keliling
    private JLabel lblHasilKeliling = new JLabel("-"); 

    private JButton btnHitung = new JButton("Hitung");
    
    // (Latihan 3)  Tombol Reset
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        // Setup Window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250); 
        this.setLayout(new GridLayout(5, 2, 10, 10)); // Grid 5 baris
        this.setTitle("MVC Latihan");

        // Baris 1: Input Panjang
        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        
        // Baris 2: Input Lebar
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        
        // Baris 3: Output Luas
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasilLuas);
        
        // Baris 4: Output Keliling (Latihan 2)
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblHasilKeliling);
        
        // Baris 5: Tombol
        this.add(btnHitung);
        this.add(btnReset); // (Latihan 3)
    }

    // Getter (Ambil nilai dari kotak input)
    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    // Setter (Tampilkan hasil ke layar)
    public void setHasilLuas(double luas) {
        lblHasilLuas.setText(String.valueOf(luas));
    }
    
    // (Latihan 2) Tampilkan hasil keliling
    public void setHasilKeliling(double keliling) {
        lblHasilKeliling.setText(String.valueOf(keliling));
    }

    // Fitur Reset (Latihan 3)
    public void resetForm() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasilLuas.setText("-");
        lblHasilKeliling.setText("-");
        txtPanjang.requestFocus(); // Balikin kursor ke kolom panjang
    }

    // Helper (Pesan Error)
    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    // Listeners (Sambungan ke Controller)
    
    // Untuk tombol Hitung
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }
    
    // Untuk tombol Reset [Latihan 3]
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}