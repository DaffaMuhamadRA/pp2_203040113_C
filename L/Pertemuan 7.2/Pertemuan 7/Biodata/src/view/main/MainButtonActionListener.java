package view.main;

// MainButtonActionListener.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;

public class MainButtonActionListener implements ActionListener {
    private JFrame parentFrame;
    private String frameType;
    private Connection connection;

    public MainButtonActionListener(JFrame parentFrame, String frameType, Connection connection) {
        this.parentFrame = parentFrame;
        this.frameType = frameType;
        this.connection = connection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (frameType.equals("jurusan")) {
                JurusanFrame jurusanFrame = new JurusanFrame(connection);
                jurusanFrame.setVisible(true);
            } else if (frameType.equals("mahasiswa")) {
                MahasiswaFrame mahasiswaFrame = new MahasiswaFrame(connection);
                mahasiswaFrame.setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(parentFrame, "Error: " + ex.getMessage());
        }
    }
}

