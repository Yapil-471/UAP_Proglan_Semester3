import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class WargaAppGUI extends JFrame {
    private DefaultTableModel tableModel;
    private JTable wargaTable;
    private List<Warga> wargaList;
    private JTextField searchField;

    public WargaAppGUI() {
        setTitle("Data Warga RT");
        setSize(800, 500); // Lebih besar agar UI lebih nyaman
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set kolom tabel
        String[] columnNames = {"ID", "Nama", "NIK", "Alamat", "Telepon", "Foto Path"};
        tableModel = new DefaultTableModel(columnNames, 0);
        wargaTable = new JTable(tableModel);

        // Tinggi baris untuk menyesuaikan ukuran gambar
        wargaTable.setRowHeight(120);

        // Set renderer khusus untuk kolom Foto Path
        wargaTable.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());

        // Buat panel untuk tabel
        JScrollPane scrollPane = new JScrollPane(wargaTable);
        add(scrollPane, BorderLayout.CENTER);

        // Panel untuk tombol
        JButton addButton = new JButton("Tambah");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Hapus");
        JButton searchButton = new JButton("Cari");

        // Field pencarian
        searchField = new JTextField(20);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JLabel("Cari: "));
        buttonPanel.add(searchField);
        buttonPanel.add(searchButton);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Load data saat aplikasi dimulai
        try {
            wargaList = WargaManager.loadWarga();
            refreshTable();
        } catch (Exception e) {
            wargaList = new ArrayList<>();
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
        }

        // Tombol Tambah
        addButton.addActionListener(e -> addWarga());

        // Tombol Edit
        editButton.addActionListener(e -> editWarga(wargaTable.getSelectedRow()));

        // Tombol Hapus
        deleteButton.addActionListener(e -> deleteWarga(wargaTable.getSelectedRow()));

        // Tombol Cari
        searchButton.addActionListener(e -> searchWarga(searchField.getText()));
    }




    private void refreshTable() {
        tableModel.setRowCount(0); // Hapus semua data lama di tabel
        for (Warga warga : wargaList) {
            tableModel.addRow(new Object[]{
                    warga.getId(),
                    warga.getNama(),
                    warga.getNik(),
                    warga.getAlamat(),
                    warga.getTelepon(),
                    warga.getFotoPath()
            });
        }
    }

    private void addWarga() {
        WargaForm form = new WargaForm(this, null);
        form.setVisible(true);
    }

    private void editWarga(int rowIndex) {
        if (rowIndex >= 0) {
            Warga warga = wargaList.get(rowIndex);
            WargaForm form = new WargaForm(this, warga);
            form.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diedit!");
        }
    }

    private void deleteWarga(int rowIndex) {
        if (rowIndex >= 0) {
            wargaList.remove(rowIndex);
            refreshTable();
            saveData();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
        }
    }

    private void searchWarga(String query) {
        if (query.isEmpty()) {
            refreshTable();
            return;
        }

        tableModel.setRowCount(0); // Hapus data lama di tabel
        for (Warga warga : wargaList) {
            if (warga.getNama().toLowerCase().contains(query.toLowerCase()) ||
                    warga.getNik().toLowerCase().contains(query.toLowerCase()) ||
                    warga.getAlamat().toLowerCase().contains(query.toLowerCase()) ||
                    warga.getTelepon().toLowerCase().contains(query.toLowerCase())) {
                tableModel.addRow(new Object[]{
                        warga.getId(),
                        warga.getNama(),
                        warga.getNik(),
                        warga.getAlamat(),
                        warga.getTelepon(),
                        warga.getFotoPath()
                });
            }
        }
    }

    public void saveData() {
        try {
            WargaManager.saveWarga(wargaList);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
        }
    }

    public void addOrUpdateWarga(Warga warga) {
        boolean isUpdate = false;
        for (int i = 0; i < wargaList.size(); i++) {
            if (wargaList.get(i).getId() == warga.getId()) {
                wargaList.set(i, warga);
                isUpdate = true;
                break;
            }
        }
        if (!isUpdate) {
            wargaList.add(warga);
        }
        refreshTable();
        saveData();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WargaAppGUI().setVisible(true);
        });
    }
}

// Renderer untuk kolom Foto Path
class ImageRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        if (value != null) {
            try {
                String filePath = value.toString();
                File file = new File(filePath);

                if (file.exists() && file.isFile()) {
                    // Load gambar dari path file
                    ImageIcon icon = new ImageIcon(filePath);
                    // Ubah ukuran gambar menjadi 100x100 piksel
                    Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(img));
                } else {
                    // Tampilkan teks jika file tidak ditemukan
                    label.setText("File tidak ditemukan");
                    label.setForeground(Color.RED);
                }
            } catch (Exception e) {
                // Penanganan jika terjadi error
                label.setText("Error memuat gambar");
                label.setForeground(Color.RED);
            }
        } else {
            // Jika kolom tidak memiliki nilai
            label.setText("Tidak ada gambar");
            label.setForeground(Color.GRAY);
        }

        return label;
    }
}
