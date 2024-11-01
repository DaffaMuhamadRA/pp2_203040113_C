package Tugas.Tugas3.tugas3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeminjamanBuku extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public PeminjamanBuku() {
    
        setTitle("Aplikasi Peminjaman Buku Unpas");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
      
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem loanFormItem = new JMenuItem("Form Peminjaman Buku");
        menu.add(loanFormItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
   
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nama Peminjam");
        tableModel.addColumn("Judul Buku");
        tableModel.addColumn("Deskripsi");
        tableModel.addColumn("Jenis Buku");
        tableModel.addColumn("Status Pengembalian");
        tableModel.addColumn("Metode Pembayaran");
        tableModel.addColumn("Kategori Buku");
        tableModel.addColumn("Tanggal Pinjam");
        tableModel.addColumn("Rating Buku");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

   
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Tambah Data");
        JButton removeButton = new JButton("Hapus Data");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

       
        loanFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLoanForm();
            }
        });
        
        addButton.addActionListener(e -> openLoanForm());

        removeButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

       
        JComboBox<String> genreComboBox = new JComboBox<>(new String[]{"Fiksi", "Non-Fiksi", "Komik", "Lainnya"});
        TableColumn genreColumn = table.getColumnModel().getColumn(3);
        genreColumn.setCellEditor(new DefaultCellEditor(genreComboBox));

       
        JComboBox<String> paymentComboBox = new JComboBox<>(new String[]{"Cash", "Kartu Kredit"});
        TableColumn paymentColumn = table.getColumnModel().getColumn(5);
        paymentColumn.setCellEditor(new DefaultCellEditor(paymentComboBox));
    }

    private void openLoanForm() {
       
        JFrame formFrame = new JFrame("Form Peminjaman Buku");
        formFrame.setSize(400, 700);
        formFrame.setLocationRelativeTo(null);

        // Panel Form
        JPanel formPanel = new JPanel(new GridLayout(11, 2, 10, 10));

        // Komponen Input
        formPanel.add(new JLabel("Nama Peminjam:"));
        JTextField nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Judul Buku:"));
        JTextField titleField = new JTextField();
        formPanel.add(titleField);

        formPanel.add(new JLabel("Deskripsi Buku:"));
        JTextArea descriptionArea = new JTextArea(3, 20);
        formPanel.add(new JScrollPane(descriptionArea));

        formPanel.add(new JLabel("Jenis Buku:"));
        JComboBox<String> genreBox = new JComboBox<>(new String[]{"Fiksi", "Non-Fiksi", "Komik", "Lainnya"});
        formPanel.add(genreBox);

        formPanel.add(new JLabel("Status Pengembalian:"));
        JCheckBox returnedCheckBox = new JCheckBox("Sudah Dikembalikan");
        formPanel.add(returnedCheckBox);

        formPanel.add(new JLabel("Metode Pembayaran:"));
        JRadioButton cashButton = new JRadioButton("Cash");
        JRadioButton cardButton = new JRadioButton("Kartu Kredit");
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashButton);
        paymentGroup.add(cardButton);
        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        paymentPanel.add(cashButton);
        paymentPanel.add(cardButton);
        formPanel.add(paymentPanel);

        formPanel.add(new JLabel("Kategori Buku:"));
        JList<String> categoryList = new JList<>(new String[]{"Novel", "Biografi", "Edukasi", "Sains", "Teknologi"});
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formPanel.add(new JScrollPane(categoryList));

        formPanel.add(new JLabel("Tanggal Pinjam:"));
        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        formPanel.add(dateSpinner);

        formPanel.add(new JLabel("Rating Buku:"));
        JSlider ratingSlider = new JSlider(0, 10);
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);
        formPanel.add(ratingSlider);

        
        JButton saveButton = new JButton("Simpan");
        formPanel.add(saveButton);

        formFrame.add(formPanel);
        formFrame.setVisible(true);

        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String title = titleField.getText();
                String description = descriptionArea.getText();
                String genre = (String) genreBox.getSelectedItem();
                String status = returnedCheckBox.isSelected() ? "Sudah" : "Belum";
                String paymentMethod = cashButton.isSelected() ? "Cash" : "Kartu Kredit";
                String category = categoryList.getSelectedValue();
                String date = dateSpinner.getValue().toString();
                int rating = ratingSlider.getValue();

                tableModel.addRow(new Object[]{name, title, description, genre, status, paymentMethod, category, date, rating});
           
                formFrame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PeminjamanBuku app = new PeminjamanBuku();
            app.setVisible(true);
        });
    }
}
