package view.main;

// MainFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import dao.*;

public class MainFrame extends JFrame {
    private JButton jurusanButton;
    private JButton mahasiswaButton;
    private Connection connection;

    public MainFrame(Connection connection) {
        this.connection = connection;
        setTitle("Sistem Informasi Mahasiswa");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        jurusanButton = new JButton("Manajemen Jurusan");
        mahasiswaButton = new JButton("Manajemen Mahasiswa");

        jurusanButton.addActionListener(new MainButtonActionListener(this, "jurusan", connection));
        mahasiswaButton.addActionListener(new MainButtonActionListener(this, "mahasiswa", connection));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(jurusanButton);
        panel.add(mahasiswaButton);

        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }
        });
    }
}

