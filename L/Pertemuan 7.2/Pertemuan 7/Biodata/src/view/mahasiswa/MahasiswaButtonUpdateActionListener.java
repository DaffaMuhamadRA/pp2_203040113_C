package view.mahasiswa;

// MahasiswaButtonUpdateActionListener.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.MahasiswaDao;

public class MahasiswaButtonUpdateActionListener implements ActionListener {
    private MahasiswaFrame mahasiswaFrame;
    private MahasiswaDao mahasiswaDao;

    public MahasiswaButtonUpdateActionListener(MahasiswaFrame mahasiswaFrame, MahasiswaDao mahasiswaDao) {
        this.mahasiswaFrame = mahasiswaFrame;
        this.mahasiswaDao = mahasiswaDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int selectedRow = mahasiswaFrame.getMahasiswaTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(mahasiswaFrame, "Pilih mahasiswa yang ingin diupdate.");
                return;
            }

            int id = (int) mahasiswaFrame.getMahasiswaTable().getValueAt(selectedRow, 0);
            String nama = mahasiswaFrame.getNamaField().getText();
            String npm = mahasiswaFrame.getNpmField().getText();
            Jurusan jurusan = (Jurusan) mahasiswaFrame.getJurusanComboBox().getSelectedItem();
            String alamat = mahasiswaFrame.getAlamatField().getText();
            String noTelepon = mahasiswaFrame.getNoTeleponField().getText();

            Mahasiswa mahasiswa = new Mahasiswa(id, nama, npm, jurusan, alamat, noTelepon);
            mahasiswaDao.updateMahasiswa(mahasiswa);
            JOptionPane.showMessageDialog(mahasiswaFrame, "Data Mahasiswa Berhasil Diupdate!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mahasiswaFrame, "Error: " + ex.getMessage());
        }
    }
}

