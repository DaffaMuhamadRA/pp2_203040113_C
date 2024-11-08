package view.mahasiswa;

// MahasiswaTableModel.java
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MahasiswaTableModel extends AbstractTableModel {
    private final List<Mahasiswa> mahasiswaList;
    private final String[] columnNames = {"ID", "Nama", "NIM", "Jurusan"};

    public MahasiswaTableModel(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    @Override
    public int getRowCount() {
        return mahasiswaList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mahasiswa mahasiswa = mahasiswaList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mahasiswa.getId();
            case 1:
                return mahasiswa.getNama();
            case 2:
                return mahasiswa.getNim();
            case 3:
                return mahasiswa.getJurusan().getNama(); // Mendapatkan nama jurusan dari objek Jurusan
            default:
                return null;
        }
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaList.add(mahasiswa);
        fireTableRowsInserted(mahasiswaList.size() - 1, mahasiswaList.size() - 1);
    }

    public void removeMahasiswa(int rowIndex) {
        mahasiswaList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public Mahasiswa getMahasiswaAt(int rowIndex) {
        return mahasiswaList.get(rowIndex);
    }

    public void updateMahasiswa(int rowIndex, Mahasiswa mahasiswa) {
        mahasiswaList.set(rowIndex, mahasiswa);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
}

