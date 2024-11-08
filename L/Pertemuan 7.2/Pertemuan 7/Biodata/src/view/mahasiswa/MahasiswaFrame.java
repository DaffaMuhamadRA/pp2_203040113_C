package view.mahasiswa;


import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.JurusanDao;
import dao.MahasiswaDao;
import model.Jurusan;
import model.Mahasiswa;

public class MahasiswaFrame extends JFrame {
    private JTextField namaField;
    private JTextField npmField;
    private JComboBox<Jurusan> jurusanComboBox; 
    private JTextField alamatField;
    private JTextField noTeleponField;
    private JButton simpanButton;
    private JButton hapusButton;
    private JButton updateButton;
    private JTable mahasiswaTable;
    private MahasiswaDao mahasiswaDao;
    private JurusanDao jurusanDao;



    public MahasiswaFrame(Connection connection) throws SQLException {
        mahasiswaDao = new MahasiswaDao(connection);
        jurusanDao = new JurusanDao(connection); 
        setTitle("Biodata Mahasiswa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() throws SQLException {
        // Panel input data
        JPanel panelInput = new JPanel(new GridLayout(6, 2));
        panelInput.add(new JLabel("Nama:"));
        namaField = new JTextField();
        panelInput.add(namaField);

        panelInput.add(new JLabel("NPM:"));
        npmField = new JTextField();
        panelInput.add(npmField);

        panelInput.add(new JLabel("Jurusan:"));
        jurusanComboBox = new JComboBox<>(); 
        List<Jurusan> jurusanList = jurusanDao.getAllJurusan();
        for (Jurusan jurusan : jurusanList) {
            jurusanComboBox.addItem(jurusan);
        }
        panelInput.add(jurusanComboBox);

        panelInput.add(new JLabel("Alamat:"));
        alamatField = new JTextField();
        panelInput.add(alamatField);

        panelInput.add(new JLabel("No Telepon:"));
        noTeleponField = new JTextField();
        panelInput.add(noTeleponField);

        simpanButton = new JButton("Simpan");
        
        panelInput.add(simpanButton);

        hapusButton = new JButton("Hapus");
      
        panelInput.add(hapusButton);

        updateButton = new JButton("Update");
        
        panelInput.add(updateButton);

        add(panelInput, BorderLayout.NORTH);

        
        mahasiswaTable = new JTable();
        add(new JScrollPane(mahasiswaTable), BorderLayout.CENTER);

        // Refresh data table saat pertama kali dibuka
        refreshTable();
    }

    public MahasiswaFrame(Connection connection) throws SQLException {
        mahasiswaDao = new MahasiswaDao(connection);
        mahasiswaTableModel = new MahasiswaTableModel(mahasiswaDao.getAllMahasiswa());
        mahasiswaTable = new JTable(mahasiswaTableModel);
        
        setTitle("Manajemen Mahasiswa");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        add(new JScrollPane(mahasiswaTable), BorderLayout.CENTER);
        refreshTable();
    }

    public void refreshTable() {
        try {
            List<Mahasiswa> mahasiswaList = mahasiswaDao.getAllMahasiswa();
            mahasiswaTableModel = new MahasiswaTableModel(mahasiswaList);
            mahasiswaTable.setModel(mahasiswaTableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public JComboBox<Jurusan> getJurusanComboBox() {
        return jurusanComboBox;
    }

    public JTextField getNamaField() { return namaField; }
    public JTextField getNpmField() { return npmField; }
    public JTextField getAlamatField() { return alamatField; }
    public JTextField getNoTeleponField() { return noTeleponField; }
}
