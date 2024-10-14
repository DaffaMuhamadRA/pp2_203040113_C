package  Latihan.L.LatihanT4;

import javax.swing.*;
import java.awt.event.*;

public class MouseListenerExample {
    public static void main(String[] args) {
        //frame
        JFrame frame = new JFrame("MouseListener Example");

        //menampilkan pesan
        JLabel label = new JLabel("Arahkan dan klik mouse pada area ini");
        label.setBounds(50,50,300,30);

        //mouse listener ke label
        label.addMouseListener(new MouseListener() {
            //dijalankan ketika mosue di klik
            public void mouseClicke(MouseEvent e){
                label.setText("Mouse Clicked at : ("+e.getX()+","+e.getY()+")");
            }

            //dijalankan ketika mosue ditekan tanpa di lepaskan
            public void mousePressed(MouseEvent e){
                label.setText("Mouse Pressed at : ("+e.getX()+","+e.getY()+")");
            }

            public void mouseRelease(MouseEvent e){
                label.setText("Mouse Release at : ("+e.getX()+","+e.getY()+")");
            }

            public void mouseEntered(MouseEvent e){
                label.setText("Mouse Entered the area");
            }

            public void mouseExited(MouseEvent e){
                label.setText("Mouse Exited the area");
            }
        });

        frame.add(label);

        frame.setSize(400,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
