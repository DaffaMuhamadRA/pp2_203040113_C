import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class Tugas2 extends JFrame {

    //variabel
    private boolean checkBoxSelected;
    private JPasswordField passwordField, confirmPasswordField;
    private JTextField textFieldNama, textFieldNoTelp;
    private JRadioButton radioButton1;
    private JList<String> listTabungan;
    private JSpinner spinnerFrekuensi, spinnerTanggalLahir;
    private JCheckBox checkBox;
    private JTextArea txtOutput;

    public Tugas2() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // actions
        resetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(resetMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        // Label , input nama
        JLabel labelNama = new JLabel("Input nama : ");
        labelNama.setBounds(130, 40, 100, 10);
        textFieldNama = new JTextField();
        textFieldNama.setBounds(130, 60, 150, 30);

        // Label , input nomor telepon
        JLabel labelNoTelp = new JLabel("Input No Telp : ");
        labelNoTelp.setBounds(130, 100, 100, 10);
        textFieldNoTelp = new JTextField();
        textFieldNoTelp.setBounds(130, 120, 150, 30);

        // RadioButton jenis kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin : ");
        labelRadio.setBounds(15, 160, 350, 10);
        radioButton1 = new JRadioButton("Laki-laki", true);
        radioButton1.setBounds(15, 180, 350, 30);
        JRadioButton radioButton2 = new JRadioButton("Perempuan", false);
        radioButton2.setBounds(15, 210, 350, 30);

        // ButtonGroup RadioButton
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // Checkbox status kewarganegaraan
        checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 250, 350, 30);

        // Input jenis tabungan
        JLabel labelTabungan = new JLabel("Jenis Tabungan: ");
        labelTabungan.setBounds(130, 290, 100, 10);
        String[] jenisTabungan = { "Tabungan Regular", "Tabungan Pendidikan", "Tabungan Reksadana", "Tabungan Bisnis" };
        listTabungan = new JList<>(jenisTabungan);
        listTabungan.setBounds(130, 310, 150, 70);

        // Spinner jumalah frekuensi transaksi
        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi per Bulan:");
        labelFrekuensi.setBounds(130, 390, 200, 10);
        spinnerFrekuensi = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spinnerFrekuensi.setBounds(130, 410, 100, 30);

        // Spinner tanggal lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(130, 450, 100, 10);
        spinnerTanggalLahir = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(dateEditor);
        spinnerTanggalLahir.setBounds(130, 470, 150, 30);

        // Password , confirm password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(130, 510, 100, 10);
        passwordField = new JPasswordField();
        passwordField.setBounds(130, 530, 150, 30);

        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(130, 570, 150, 10);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(130, 590, 150, 30);

        // Tombol Klik
        JButton button = new JButton("Daftar");
        button.setBounds(130, 640, 100, 40);

        // TextArea Output
        txtOutput = new JTextArea("");
        txtOutput.setLineWrap(true);
        txtOutput.setWrapStyleWord(true);

        //TextArea
            // txtOutput = new JTextArea("");
            // txtOutput.setBounds(130, 690, 300, 200);  // Atur ukuran dan posisi sesuai kebutuhan
            // txtOutput.setLineWrap(true);
            // txtOutput.setWrapStyleWord(true);

         // JScrollPane untuk txtOutput
         JScrollPane scrollPane = new JScrollPane(txtOutput);
         scrollPane.setBounds(130, 690, 300, 200);
        //  scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            


        // ActionListener tombol klik
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String notelp = textFieldNoTelp.getText();

                // get jenis kelamin
                String jenisKelamin = radioButton1.isSelected() ? "Laki-laki" : "Perempuan";

                // get jenis tabungan
                String jenisTabunganSelected = listTabungan.getSelectedValue();

                // get frekuensi transaksi
                int frekuensiTransaksi = (int) spinnerFrekuensi.getValue();

                // get tanggal lahir
                Date tanggalLahir = (Date) spinnerTanggalLahir.getValue();

                //cek kecocokan password
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String passwordStatus = password.equals(confirmPassword) ? "Password cocok" : "Password tidak cocok";

                
                // txtOutput
                txtOutput.append("Nama: " + nama + "\n");
                txtOutput.append("No Telp: " + notelp + "\n");
                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                txtOutput.append("WNA: " + (checkBoxSelected ? "Ya" : "Tidak") + "\n");
                txtOutput.append("Jenis Tabungan: " + jenisTabunganSelected + "\n");
                txtOutput.append("Frekuensi Transaksi: " + frekuensiTransaksi + "\n");
                txtOutput.append("Tanggal Lahir: " + dateEditor.getFormat().format(tanggalLahir) + "\n");
                txtOutput.append(passwordStatus + "\n");
                txtOutput.append("=====================\n");

                // Kosong inputan
                resetForm();
            }
        });

        // ActionListener checkbox
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == ItemEvent.SELECTED;
            }
        });

        // komponen JFrame
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelNoTelp);
        this.add(textFieldNoTelp);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelTabungan);
        this.add(listTabungan);
        this.add(labelFrekuensi);
        this.add(spinnerFrekuensi);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(button);
        this.add(scrollPane);

        // Pengaturan JFrame
        this.setSize(600, 1000);
        this.setLayout(null);
    }

    private void resetForm() {
        textFieldNama.setText("");
        textFieldNoTelp.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        radioButton1.setSelected(true);
        listTabungan.clearSelection();
        spinnerFrekuensi.setValue(1);
        spinnerTanggalLahir.setValue(new Date());
        checkBox.setSelected(false);
    }

    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tugas2 form = new Tugas2();
                form.setVisible(true);
            }
        });
    }
}
