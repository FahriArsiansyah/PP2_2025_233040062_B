package Modul08.model;

public class PersegiPanjangModel {
    // Atribut (Data)
    private double panjang;
    private double lebar;
    private double luas;
    private double keliling; // (Latihan 2) Variabel tambahan

    // LOGIKA BISNIS (Rumus) 

    // Method untuk menghitung luas
    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    }

    // (Latihan 2) Method untuk menghitung keliling
    public void hitungKeliling() {
        this.keliling = 2 * (this.panjang + this.lebar);
    }

    // SETTER (Untuk mengisi nilai)

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    // GETTER (Untuk mengambil hasil)

    public double getLuas() {
        return luas;
    }

    // (Latihan 2) Getter untuk mengambil nilai keliling
    public double getKeliling() {
        return keliling;
    }
}