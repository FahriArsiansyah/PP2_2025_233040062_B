package Modul09;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AplikasiFileIO extends JFrame {

    // Komponen UI 
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText;
    private JButton btnSaveBinary, btnLoadBinary, btnAppendText; 
    private JButton btnSaveObj, btnLoadObj; // Tambahan Latihan 3
    private JFileChooser fileChooser;

    public AplikasiFileIO() {
        super("Tutorial File IO & Exception Handling");
        setSize(600, 450); // Lebarin dikit biar muat
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        // Inisialisasi komponen
        textArea = new JTextArea();
        textArea.setFont (new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();

        // Panel tombol
        JPanel panelTombol = new JPanel(new GridLayout(2, 4, 5, 5)); 
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan Text");
        btnAppendText = new JButton("Append Text"); 
        
        btnSaveBinary = new JButton("Simpan Bin");
        btnLoadBinary = new JButton("Muat Bin");
        
        // Tambahan Latihan 3
        btnSaveObj = new JButton("Simpan Obj");
        btnLoadObj = new JButton("Muat Obj");

        panelTombol.add(btnOpenText);
        panelTombol.add(btnSaveText);
        panelTombol.add(btnAppendText);
        panelTombol.add(new JLabel("")); // Spacer
        panelTombol.add(btnSaveBinary);
        panelTombol.add(btnLoadBinary);
        panelTombol.add(btnSaveObj);
        panelTombol.add(btnLoadObj);

        // Layout
        add (new JScrollPane(textArea), BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);

        // -- Event Handling --
        btnOpenText.addActionListener(e -> bukaFileText());
        btnSaveText.addActionListener(e -> simpanFileTeks());
        btnAppendText.addActionListener(e -> simpanFileTeksAppend());
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
        
        // Event Latihan 3
        btnSaveObj.addActionListener(e -> simpanUserConfig());
        btnLoadObj.addActionListener(e -> muatUserConfig());
        
        // Latihan 2: Auto load
        bacaOtomatisLastNotes();
    }
    
    private void bacaOtomatisLastNotes() {
        File file = new File("last_notes.txt");
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.setText(""); 
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException ex) {
            // Silent catch
        }
    }

    private void bukaFileText() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.setText(""); 
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                JOptionPane.showMessageDialog(this, "File dimuat!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    private void simpanFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File disimpan!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    private void simpanFileTeksAppend() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write("\n" + textArea.getText());
                JOptionPane.showMessageDialog(this, "Text di-append!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    private void simpanConfigBinary() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("config.bin"))) {
            dos.writeInt(textArea.getFont().getSize());
            JOptionPane.showMessageDialog(this, "Font size disimpan ke config.bin");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void muatConfigBinary() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("config.bin"))) {
            int fontSize = dis.readInt();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
            JOptionPane.showMessageDialog(this, "Font size diubah: " + fontSize);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal baca config.bin");
        }
    }

    // --- Latihan 3: Simpan Objek ---
    private void simpanUserConfig() {
        String username = JOptionPane.showInputDialog(this, "Masukkan Username:");
        if (username == null || username.isEmpty()) return;
        
        UserConfig config = new UserConfig(username, textArea.getFont().getSize());

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
            oos.writeObject(config);
            JOptionPane.showMessageDialog(this, "Objek disimpan: " + config);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // --- Latihan 3: Muat Objek ---
    private void muatUserConfig() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
            UserConfig config = (UserConfig) ois.readObject();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, config.getFontSize()));
            JOptionPane.showMessageDialog(this, "Objek dimuat!\n" + config);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AplikasiFileIO().setVisible(true));
    }
}