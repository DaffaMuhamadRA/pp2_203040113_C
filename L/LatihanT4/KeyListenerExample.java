package Latihan.L.LatihanT4;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class KeyListenerExample {

    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("KeyListener Example");
        frame.setSize(400, 400);
        frame.setLayout(null);

        // Membuat label
        JLabel label = new JLabel("Tekan tombol pada keyboard");
        label.setBounds(50, 50, 300, 30);

        // Membuat text field
        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 200, 30);

        // Menambahkan key listener ke text field
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyTyped(KeyEvent e) {
                label.setText("Key Typed: " + e.getKeyChar());
            }
        });

        // Menambahkan komponen ke frame
        frame.add(label);
        frame.add(textField);

        // Menampilkan frame
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
