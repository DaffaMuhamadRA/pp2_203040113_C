package view.mahasiswa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.MahasiswaDao;

public class MahasiswaButtonSimpanActionListener implements ActionListener {
    private MahasiswaFrame mahasiswaFrame;
    private MahasiswaDao mahasiswaDao;

    public MahasiswaButtonSimpanActionListener(MahasiswaFrame mahasiswaFrame, MahasiswaDao mahasiswaDao) {
        this.mahasiswaFrame = mahasiswaFrame;
        this.mahasiswaDao = mahasiswaDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nama = mahasiswaFrame.getNamaField().getText();
            String npm = mahasiswaFrame.getNpmField().getText();
            Jurusan jurusan = (Jurusan) mahasiswaFrame.getJurusanComboBox().getSelectedItem();
            String alamat = mahasiswaFrame.getAlamatField().getText();
            String noTelepon = mahasiswaFrame.getNoTeleponField().getText();

            Mahasiswa mahasiswa = new Mahasiswa(0, nama, npm, jurusan, alamat, noTelepon);
            mahasiswaDao.tambahMahasiswa(mahasiswa);
            JOptionPane.showMessageDialog(mahasiswaFrame, "Data Mahasiswa Berhasil Disimpan!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mahasiswaFrame, "Error: " + ex.getMessage());
        }
    }
}

