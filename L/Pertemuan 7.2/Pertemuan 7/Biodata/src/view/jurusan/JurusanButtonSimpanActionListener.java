package view.jurusan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.JurusanDao;
import model.Jurusan;
import view.jurusan.*;

public class JurusanButtonSimpanActionListener implements ActionListener {
    private JurusanFrame jurusanFrame;
    private JurusanDao jurusanDao;

    public JurusanButtonSimpanActionListener(JurusanFrame jurusanFrame, JurusanDao jurusanDao) {
        this.jurusanFrame = jurusanFrame;
        this.jurusanDao = jurusanDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nama = jurusanFrame.getJurusan_namaField().getText();
            if (nama.isEmpty()) {
                JOptionPane.showMessageDialog(jurusanFrame, "Nama Jurusan tidak boleh kosong.");
                return;
            }

            Jurusan jurusan = new Jurusan(0, nama);
            jurusanDao.tambahJurusan(jurusan);
            JOptionPane.showMessageDialog(jurusanFrame, "Jurusan berhasil disimpan!");
            jurusanFrame.refreshTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jurusanFrame, "Error: " + ex.getMessage());
        }
    }
}

