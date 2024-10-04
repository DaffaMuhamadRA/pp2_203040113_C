import java.awt.event.*;
import javax.swing.*;

public class BiodataTeman extends JFrame{

    public BiodataTeman(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelNama = new JLabel("Input nama : ");
        labelNama.setBounds(130, 40, 100, 10);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(130, 60, 150, 30);

        JLabel labelNoTelp = new JLabel("Input No Telp : ");
        labelNoTelp.setBounds(130, 100, 100, 10);

        JTextField textFieldNoTelp = new JTextField();
        textFieldNoTelp.setBounds(130, 120, 150, 30);

        JButton button = new JButton("Klik");
        button.setBounds(130, 160, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130, 210, 200, 200);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nama = textFieldNama.getText();
                String notelp = textFieldNoTelp.getText();
                txtOutput.append(nama + " - " + notelp + "\n");

                textFieldNama.setText("");
                textFieldNoTelp.setText("");
            }
        });

        this.add(button);
        this.add(textFieldNama);
        this.add(labelNama);
        this.add(labelNoTelp);
        this.add(textFieldNoTelp);
        this.add(txtOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                BiodataTeman biodataTeman = new BiodataTeman();
                biodataTeman.setVisible(true);
            }
        });
    }
}
