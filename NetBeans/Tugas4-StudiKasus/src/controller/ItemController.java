/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Item;
import model.ItemMapper;
import view.ItemView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ItemController {
    private ItemView view;
    private ItemMapper mapper;

    public ItemController(ItemView view, ItemMapper mapper) {
        this.view = view;
        this.mapper = mapper;

        view.getBtnAdd().addActionListener(e -> addItem());
        view.getBtnDelete().addActionListener(e -> deleteItem());
        view.getBtnRefresh().addActionListener(e -> loadItems());
        view.getBtnUpdate().addActionListener(e -> {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Pilih baris yang ingin diubah");
                return;
            }

            int id = (int) view.getTable().getValueAt(selectedRow, 0);
            String namaProduk = view.getTable().getValueAt(selectedRow, 1).toString();
            String kategori = view.getTable().getValueAt(selectedRow, 2).toString();
            double harga = Double.parseDouble(view.getTable().getValueAt(selectedRow, 3).toString());
            int stok = Integer.parseInt(view.getTable().getValueAt(selectedRow, 4).toString());

            JDialog dialog = new JDialog(view, "Ubah Item", true);
            dialog.setLayout(new GridLayout(5, 2, 10, 10));
            dialog.setSize(400, 300);

            JTextField tfNamaProduk = new JTextField(namaProduk);
            JTextField tfKategori = new JTextField(kategori);
            JTextField tfHarga = new JTextField(String.valueOf(harga));
            JTextField tfStok = new JTextField(String.valueOf(stok));
            JButton btnUpdateDialog = new JButton("Ubah");

            dialog.add(new JLabel("Nama Produk:"));
            dialog.add(tfNamaProduk);
            dialog.add(new JLabel("Kategori:"));
            dialog.add(tfKategori);
            dialog.add(new JLabel("Harga:"));
            dialog.add(tfHarga);
            dialog.add(new JLabel("Stok:"));
            dialog.add(tfStok);
            dialog.add(new JLabel());
            dialog.add(btnUpdateDialog);

            btnUpdateDialog.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Item item = new Item();
                    item.setId(id);
                    item.setNamaProduk(tfNamaProduk.getText());
                    item.setKategori(tfKategori.getText());
                    item.setHarga(Double.parseDouble(tfHarga.getText()));
                    item.setStok(Integer.parseInt(tfStok.getText()));

                    mapper.updateItem(item);
                    JOptionPane.showMessageDialog(dialog, "Data berhasil diubah");
                    dialog.dispose();
                    loadItems();
                }
            });

            dialog.setLocationRelativeTo(view);
            dialog.setVisible(true);
        });

        loadItems();
    }

    private void loadItems() {
        List<Item> items = mapper.getAllItems();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nama Produk", "Kategori", "Harga", "Stok"}, 0);
        for (Item item : items) {
            model.addRow(new Object[]{item.getId(), item.getNamaProduk(), item.getKategori(), item.getHarga(), item.getStok()});
        }
        view.getTable().setModel(model);
    }

    private void addItem() {
        Item item = new Item();
        item.setNamaProduk(view.getTfNamaProduk().getText());
        item.setKategori(view.getTfKategori().getText());
        item.setHarga(Double.parseDouble(view.getTfHarga().getText()));
        item.setStok(Integer.parseInt(view.getTfStok().getText()));
        mapper.insertItem(item);
        loadItems();
    }

    private void deleteItem() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Pilih baris yang ingin dihapus");
            return;
        }
        int id = (int) view.getTable().getValueAt(selectedRow, 0);
        mapper.deleteItem(id);
        loadItems();
    }
}