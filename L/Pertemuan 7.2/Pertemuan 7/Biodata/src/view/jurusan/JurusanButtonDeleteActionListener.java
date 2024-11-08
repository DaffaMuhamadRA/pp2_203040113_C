package view.jurusan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.JurusanDao;
import view.jurusan.*;

public class JurusanButtonDeleteActionListener implements ActionListener {
    private JurusanFrame jurusanFrame;
    private JurusanDao jurusanDao;

    public JurusanButtonDeleteActionListener(JurusanFrame jurusanFrame, JurusanDao jurusanDao) {
        this.jurusanFrame = jurusanFrame;
        this.jurusanDao = jurusanDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int selectedRow = jurusanFrame.getJurusanTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(jurusanFrame, "Pilih jurusan yang ingin dihapus.");
                return;
            }

            int id = (int) jurusanFrame.getJurusanTable().getValueAt(selectedRow, 0);

            int confirm = JOptionPane.showConfirmDialog(jurusanFrame, 
                    "Apakah Anda yakin ingin menghapus jurusan ini?", 
                    "Konfirmasi Hapus", 
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                jurusanDao.hapusJurusan(id);
                JOptionPane.showMessageDialog(jurusanFrame, "Jurusan berhasil dihapus!");
                jurusanFrame.refreshTable();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jurusanFrame, "Error: " + ex.getMessage());
        }
    }
}

