package dao;

import java.sql.Statement;
import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Jurusan;

public class JurusanDao {
    private Connection connection;

    public JurusanDao(Connection connection) {
        this.connection = connection;
    }

    public List<Jurusan> getAllJurusan() throws SQLException {
        List<Jurusan> jurusanList = new ArrayList<>();
        String sql = "SELECT * FROM jurusan";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Jurusan jurusan = new Jurusan(
                    resultSet.getInt("id"),
                    resultSet.getString("nama")
                );
                jurusanList.add(jurusan);
            }
        }
        return jurusanList;
    }

    public void tambahJurusan(Jurusan jurusan) throws SQLException {
        String sql = "INSERT INTO jurusan (nama) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, jurusan.getNama());
            statement.executeUpdate();
        }
    }

    public void updateJurusan(Jurusan jurusan) throws SQLException {
        String sql = "UPDATE jurusan SET nama = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, jurusan.getNama());
            statement.setInt(2, jurusan.getId());
            statement.executeUpdate();
        }
    }

    public void hapusJurusan(int id) throws SQLException {
        String sql = "DELETE FROM jurusan WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

