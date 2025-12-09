package Modul08.controller;

import Modul08.model.PersegiPanjangModel;
import Modul08.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        // Menghubungkan tombol VIEW dengan logika di CONTROLLER
        this.view.addHitungListener(new HitungListener());
        this.view.addResetListener(new ResetListener()); // (Latihan 3)
    }

    // Inner Class: Logika saat tombol HITUNG diklik
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // 1. Ambil data dari View
                double p = view.getPanjang();
                double l = view.getLebar();

                // 2. Kirim data ke Model
                model.setPanjang(p);
                model.setLebar(l);

                // 3. Perintahkan Model menghitung (Luas & Keliling)
                model.hitungLuas();
                model.hitungKeliling(); // (Latihan 2)

                // 4. Ambil hasil dari Model dan tampilkan di View
                view.setHasilLuas(model.getLuas());
                view.setHasilKeliling(model.getKeliling()); // (Latihan 2)

            } catch (NumberFormatException ex) {
                // Jika input bukan angka
                view.tampilkanPesanError("Masukkan angka yang benar!");
            }
        }
    }

    // Inner Class: Logika saat tombol RESET diklik (Latihan 3) 
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Panggil fungsi reset yang ada di View
            view.resetForm();
        }
    }
}