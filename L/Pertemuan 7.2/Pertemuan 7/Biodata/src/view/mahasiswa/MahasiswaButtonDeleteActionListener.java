package view.mahasiswa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import dao.MahasiswaDao;

public class MahasiswaButtonDeleteActionListener implements ActionListener {
    private MahasiswaFrame mahasiswaFrame;
    private MahasiswaDao mahasiswaDao;

    public MahasiswaButtonDeleteActionListener(MahasiswaFrame mahasiswaFrame, MahasiswaDao mahasiswaDao) {
        this.mahasiswaFrame = mahasiswaFrame;
        this.mahasiswaDao = mahasiswaDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int selectedRow = mahasiswaFrame.getMahasiswaTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(mahasiswaFrame, "Pilih mahasiswa yang ingin dihapus.");
                return;
            }

            int id = (int) mahasiswaFrame.getMahasiswaTable().getValueAt(selectedRow, 0);
            mahasiswaDao.hapusMahasiswa(id);
            JOptionPane.showMessageDialog(mahasiswaFrame, "Data Mahasiswa Berhasil Dihapus!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(mahasiswaFrame, "Error: " + ex.getMessage());
        }
    }
}

