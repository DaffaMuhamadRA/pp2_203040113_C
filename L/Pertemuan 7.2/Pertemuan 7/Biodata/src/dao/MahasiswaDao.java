package dao;

// MahasiswaDao.java
import java.sql.Statement;
import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Mahasiswa;
import model.Jurusan;

public class MahasiswaDao {
    private Connection connection;

    public MahasiswaDao(Connection connection) {
        this.connection = connection;
    }

    public void tambahMahasiswa(Mahasiswa mahasiswa) throws SQLException {
        String sql = "INSERT INTO mahasiswa (nama, npm, jurusan_id, alamat, noTelepon) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getNpm());
            statement.setInt(3, mahasiswa.getJurusan().getId()); // Mengambil ID dari objek jurusan
            statement.setString(4, mahasiswa.getAlamat());
            statement.setString(5, mahasiswa.getNoTelepon());
            statement.executeUpdate();
        }
    }
    
    

    public List<Mahasiswa> getAllMahasiswa() throws SQLException {
        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        String sql = """
                SELECT mahasiswa.*, jurusan.nama AS jurusan_nama 
                FROM mahasiswa 
                JOIN jurusan ON mahasiswa.jurusan_id = jurusan.id
                """;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Jurusan jurusan = new Jurusan(
                    resultSet.getInt("jurusan_id"),
                    resultSet.getString("jurusan_nama")
                );
                Mahasiswa mahasiswa = new Mahasiswa(
                    resultSet.getInt("id"),
                    resultSet.getString("nama"),
                    resultSet.getString("npm"),
                    jurusan,
                    resultSet.getString("alamat"),
                    resultSet.getString("noTelepon")
                );
                mahasiswaList.add(mahasiswa);
            }
        }
        return mahasiswaList;
    }

    public void updateMahasiswa(Mahasiswa mahasiswa) throws SQLException {
        String sql = "UPDATE mahasiswa SET nama=?, npm=?, jurusan_id=?, alamat=?, noTelepon=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getNpm());
            statement.setInt(3, mahasiswa.getJurusan().getId());
            statement.setString(4, mahasiswa.getAlamat());
            statement.setString(5, mahasiswa.getNoTelepon());
            statement.setInt(6, mahasiswa.getId());
            statement.executeUpdate();
        }
    }

    public void hapusMahasiswa(int id) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
