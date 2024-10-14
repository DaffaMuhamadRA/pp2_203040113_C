package LatihanT3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormBiodata extends JFrame {

    // Komponen-komponen GUI
    private JTextField namaField, nomorHpField;
    private JRadioButton lakiLakiRadio, perempuanRadio;
    private JCheckBox wargaNegaraAsingCheckbox;
    private JButton simpanButton;

    public FormBiodata() {
        // Set judul jendela
        setTitle("Form Biodata");

        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Label dan text field untuk nama
        JLabel namaLabel = new JLabel("Nama:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(namaLabel, gbc);
        
        namaField = new JTextField(15);
        gbc.gridx = 1;
        add(namaField, gbc);
        
        // Label dan radio button untuk jenis kelamin
        JLabel jenisKelaminLabel = new JLabel("Jenis Kelamin:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(jenisKelaminLabel, gbc);
        
        lakiLakiRadio = new JRadioButton("Laki-Laki");
        perempuanRadio = new JRadioButton("Perempuan");
        ButtonGroup jenisKelaminGroup = new ButtonGroup();
        jenisKelaminGroup.add(lakiLakiRadio);
        jenisKelaminGroup.add(perempuanRadio);
        
        JPanel jenisKelaminPanel = new JPanel();
        jenisKelaminPanel.add(lakiLakiRadio);
        jenisKelaminPanel.add(perempuanRadio);
        
        gbc.gridx = 1;
        add(jenisKelaminPanel, gbc);
        
        // Label dan text field untuk nomor HP
        JLabel nomorHpLabel = new JLabel("Nomor HP:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(nomorHpLabel, gbc);
        
        nomorHpField = new JTextField(15);
        gbc.gridx = 1;
        add(nomorHpField, gbc);
        
        // Checkbox untuk Warga Negara Asing
        wargaNegaraAsingCheckbox = new JCheckBox("Warga Negara Asing");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(wargaNegaraAsingCheckbox, gbc);
        
        // Tombol simpan
        simpanButton = new JButton("Simpan");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(simpanButton, gbc);
        
        // Action listener untuk tombol simpan
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = namaField.getText();
                String nomorHp = nomorHpField.getText();
                String jenisKelamin = lakiLakiRadio.isSelected() ? "Laki-Laki" : "Perempuan";
                boolean wargaAsing = wargaNegaraAsingCheckbox.isSelected();
                
                // Tampilkan data yang diinput
                String message = String.format("Nama: %s\nNomor HP: %s\nJenis Kelamin: %s\nWarga Negara Asing: %s",
                        nama, nomorHp, jenisKelamin, wargaAsing ? "Ya" : "Tidak");
                JOptionPane.showMessageDialog(null, message);
            }
        });

        // Set ukuran jendela
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Tampilkan form
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormBiodata().setVisible(true);
            }
        });
    }
}
