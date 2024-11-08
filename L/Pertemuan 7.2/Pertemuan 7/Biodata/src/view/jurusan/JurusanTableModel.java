package view.jurusan;

// JurusanTableModel.java
import javax.swing.table.AbstractTableModel;
import java.util.List;
import view.jurusan.*;

public class JurusanTableModel extends AbstractTableModel {
    private final List<Jurusan> jurusanList;
    private final String[] columnNames = {"ID", "Nama Jurusan"};

    public JurusanTableModel(List<Jurusan> jurusanList) {
        this.jurusanList = jurusanList;
    }

    @Override
    public int getRowCount() {
        return jurusanList.size();
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
        Jurusan jurusan = jurusanList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return jurusan.getId();
            case 1:
                return jurusan.getNama();
            default:
                return null;
        }
    }

    public void addJurusan(Jurusan jurusan) {
        jurusanList.add(jurusan);
        fireTableRowsInserted(jurusanList.size() - 1, jurusanList.size() - 1);
    }

    public void removeJurusan(int rowIndex) {
        jurusanList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public Jurusan getJurusanAt(int rowIndex) {
        return jurusanList.get(rowIndex);
    }

    public void updateJurusan(int rowIndex, Jurusan jurusan) {
        jurusanList.set(rowIndex, jurusan);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
}

