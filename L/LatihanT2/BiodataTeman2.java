import java.awt.event.*;
import javax.swing.*;

public class BiodataTeman2 extends JFrame {

    private boolean checkBoxSelected;

    public BiodataTeman2() {
        this.checkBoxSelected = false;  // Initialize checkbox selection status
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label untuk Nama
        JLabel labelNama = new JLabel("Input nama : ");
        labelNama.setBounds(130, 40, 100, 10);

        // Label untuk No Telp
        JLabel labelNoTelp = new JLabel("Input No Telp : ");
        labelNoTelp.setBounds(130, 100, 100, 10);

        // Input field untuk Nama
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(130, 60, 150, 30);

        // Input field untuk No Telp
        JTextField textFieldNoTelp = new JTextField();
        textFieldNoTelp.setBounds(130, 120, 150, 30);

        // RadioButton untuk jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin : ");
        labelRadio.setBounds(15, 160, 350, 10);

        JRadioButton radioButton1 = new JRadioButton("Laki Laki", true);
        radioButton1.setBounds(15, 180, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan", false);
        radioButton2.setBounds(15, 210, 350, 30);

        // ButtonGroup untuk RadioButton
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // Checkbox untuk status kewarganegaraan
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 250, 350, 30);

        // Tombol Klik
        JButton button = new JButton("Klik");
        button.setBounds(130, 290, 100, 40);

        // TextArea untuk menampilkan hasil
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130, 340, 200, 200);

        // ActionListener untuk tombol klik
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String notelp = textFieldNoTelp.getText();
                
                // Mengambil jenis Kelamin
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = "Laki Laki";
                } else if (radioButton2.isSelected()) {
                    jenisKelamin = "Perempuan";
                }

                // Menampilkan hasil di txtOutput
                txtOutput.append("Nama: " + nama + "\n");
                txtOutput.append("No Telp: " + notelp + "\n");
                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");

                // Status warga negara asing
                if (checkBoxSelected) {
                    txtOutput.append("Status: Warga Negara Asing\n");
                } else {
                    txtOutput.append("Status: Bukan Warga Negara Asing\n");
                }

                txtOutput.append("=====================\n");

                // Kosongkan textfield setelah submit
                textFieldNama.setText("");
                textFieldNoTelp.setText("");
            }
        });

        // ActionListener untuk checkbox
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == ItemEvent.SELECTED;
            }
        });

        // Menambahkan komponen ke JFrame
        this.add(labelNama);
        this.add(labelNoTelp);
        this.add(textFieldNama);
        this.add(textFieldNoTelp);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(button);
        this.add(txtOutput);

        // Pengaturan JFrame
        this.setSize(400, 600);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataTeman2 bt = new BiodataTeman2();
                bt.setVisible(true);
            }
        });
    }
}
