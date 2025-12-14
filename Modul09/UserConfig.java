package Modul09;

import java.io.Serializable;

public class UserConfig implements Serializable {
    
    private static final long serialVersionUID = 1L; 

    private String username; 
    private int fontSize; 

    // 1. Constructor Kosong (Wajib ada untuk Serializable kadang-kadang)
    public UserConfig() {
    }

    // 2. Constructor dengan Parameter (INI PENTING AGAR APLIKASI UTAMA JALAN)
    public UserConfig(String username, int fontSize) {
        this.username = username;
        this.fontSize = fontSize;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // 3. Perhatikan huruf 'S' besar pada 'Size' agar cocok dengan AplikasiFileIO
    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    // Tambahan: toString agar saat muncul di dialog box terlihat rapi
    @Override
    public String toString() {
        return "User: " + username + ", Font Size: " + fontSize;
    }
}