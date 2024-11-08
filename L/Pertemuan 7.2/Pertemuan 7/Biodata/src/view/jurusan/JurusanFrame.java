package view.jurusan;

// JurusanFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import dao.JurusanDao;
import model.Jurusan;
import model.JurusanTableModel;

public class JurusanFrame extends JFrame {
    private JTextField namaField;
    private JButton simpanButton, updateButton, hapusButton;
    private JTable jurusanTable;
    private JurusanTableModel jurusanTableModel; // Deklarasi variabel jurusanTableModel
    private JurusanDao jurusanDao;

    public JurusanFrame(Connection connection) throws SQLException {
        jurusanDao = new JurusanDao(connection);
        setTitle("Manajemen Jurusan");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        refreshTable();
    }

    private void initComponents() throws SQLException {
        JPanel panelInput = new JPanel(new GridLayout(2, 2));
        panelInput.add(new JLabel("Nama Jurusan:"));
        namaField = new JTextField();
        panelInput.add(namaField);

        simpanButton = new JButton("Simpan");
        updateButton = new JButton("Update");
        hapusButton = new JButton("Hapus");

        panelInput.add(simpanButton);
        panelInput.add(updateButton);
        panelInput.add(hapusButton);

        add(panelInput, BorderLayout.NORTH);

        // Inisialisasi JTable dengan model kosong
        jurusanTableModel = new JurusanTableModel(jurusanDao.getAllJurusan());
        jurusanTable = new JTable(jurusanTableModel);
        add(new JScrollPane(jurusanTable), BorderLayout.CENTER);

        // Tambahkan action listener untuk tombol simpan, update, dan hapus
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = namaField.getText();
                    Jurusan jurusan = new Jurusan(0, nama);
                    jurusanDao.tambahJurusan(jurusan);
                    JOptionPane.showMessageDialog(JurusanFrame.this, "Jurusan berhasil disimpan!");
                    refreshTable();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(JurusanFrame.this, "Error: " + ex.getMessage());
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = jurusanTable.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(JurusanFrame.this, "Pilih jurusan yang ingin diupdate.");
                        return;
                    }

                    int id = (int) jurusanTable.getValueAt(selectedRow, 0);
                    String nama = namaField.getText();
                    Jurusan jurusan = new Jurusan(id, nama);
                    jurusanDao.updateJurusan(jurusan);
                    JOptionPane.showMessageDialog(JurusanFrame.this, "Jurusan berhasil diupdate!");
                    refreshTable();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(JurusanFrame.this, "Error: " + ex.getMessage());
                }
            }
        });

        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = jurusanTable.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(JurusanFrame.this, "Pilih jurusan yang ingin dihapus.");
                        return;
                    }

                    int id = (int) jurusanTable.getValueAt(selectedRow, 0);
                    jurusanDao.hapusJurusan(id);
                    JOptionPane.showMessageDialog(JurusanFrame.this, "Jurusan berhasil dihapus!");
                    refreshTable();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(JurusanFrame.this, "Error: " + ex.getMessage());
                }
            }
        });
    }

    // Metode untuk merefresh tabel
    public void refreshTable() {
        try {
            List<Jurusan> jurusanList = jurusanDao.getAllJurusan();
            jurusanTableModel = new JurusanTableModel(jurusanList);
            jurusanTable.setModel(jurusanTableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // Menambahkan metode getJurusanTable
    public JTable getJurusanTable() {
        return jurusanTable;
    }
}
