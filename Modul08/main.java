package Modul08;

import Modul08.controller.PersegiPanjangController;
import Modul08.model.PersegiPanjangModel;   
import Modul08.view.PersegiPanjangView;

public class main {
    public static void main(String[] args) {
        // 1. Inisialisasi Model
        PersegiPanjangModel model = new PersegiPanjangModel();

        // 2. Inisialisasi View
        PersegiPanjangView view = new PersegiPanjangView();

        // 3. Inisialisasi Controller (Hubungkan model & view)
        PersegiPanjangController controller = new PersegiPanjangController(model, view);
        
        // 4. Tampilkan View
        view.setVisible(true);
    }
}
