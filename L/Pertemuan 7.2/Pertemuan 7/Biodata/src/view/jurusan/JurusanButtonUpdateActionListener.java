package view.jurusan;

// JurusanButtonUpdateActionListener.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.JurusanDao;
import model.Jurusan;
import view.jurusan.*;

public class JurusanButtonUpdateActionListener implements ActionListener {
    private JurusanFrame jurusanFrame;
    private JurusanDao jurusanDao;

    public JurusanButtonUpdateActionListener(JurusanFrame jurusanFrame, JurusanDao jurusanDao) {
        this.jurusanFrame = jurusanFrame;
        this.jurusanDao = jurusanDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int selectedRow = jurusanFrame.getJurusanTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(jurusanFrame, "Pilih jurusan yang ingin diupdate.");
                return;
            }

            int id = (int) jurusanFrame.getJurusanTable().getValueAt(selectedRow, 0);
            String nama = jurusanFrame.getJurusan_nama().getText();

            if (nama.isEmpty()) {
                JOptionPane.showMessageDialog(jurusanFrame, "Nama Jurusan tidak boleh kosong.");
                return;
            }

            Jurusan jurusan = new Jurusan(id, nama);
            jurusanDao.updateJurusan(jurusan);
            JOptionPane.showMessageDialog(jurusanFrame, "Jurusan berhasil diupdate!");
            jurusanFrame.refreshTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jurusanFrame, "Error: " + ex.getMessage());
        }
    }
}

