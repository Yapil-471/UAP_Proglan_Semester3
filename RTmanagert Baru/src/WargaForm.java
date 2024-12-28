import javax.swing.*;
import java.awt.*;
import java.io.File;

public class WargaForm extends JDialog {
    private JTextField namaField, nikField, alamatField, teleponField;
    private JLabel fotoLabel;
    private JButton pilihFotoButton, simpanButton, batalButton;
    private Warga warga;
    private File fotoFile;

    public WargaForm(JFrame parent, Warga warga) {
        super(parent, "Form Data Warga", true);
        this.warga = warga;

        setLayout(new BorderLayout());
        setSize(400, 500);
        setLocationRelativeTo(parent);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Nama:"));
        namaField = new JTextField();
        formPanel.add(namaField);

        formPanel.add(new JLabel("NIK:"));
        nikField = new JTextField();
        formPanel.add(nikField);

        formPanel.add(new JLabel("Alamat:"));
        alamatField = new JTextField();
        formPanel.add(alamatField);

        formPanel.add(new JLabel("Telepon:"));
        teleponField = new JTextField();
        formPanel.add(teleponField);

        formPanel.add(new JLabel("Foto:"));
        fotoLabel = new JLabel("Belum ada foto", SwingConstants.CENTER);
        fotoLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        fotoLabel.setPreferredSize(new Dimension(200, 150));
        formPanel.add(fotoLabel);

        pilihFotoButton = new JButton("Pilih Foto");
        formPanel.add(pilihFotoButton);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        simpanButton = new JButton("Simpan");
        batalButton = new JButton("Batal");
        buttonPanel.add(simpanButton);
        buttonPanel.add(batalButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Jika data diedit, isi field dengan data yang ada
        if (warga != null) {
            namaField.setText(warga.getNama());
            nikField.setText(warga.getNik());
            alamatField.setText(warga.getAlamat());
            teleponField.setText(warga.getTelepon());
            if (warga.getFotoPath() != null) {
                fotoFile = new File(warga.getFotoPath());
                setFotoLabel(fotoFile);
            }
        }

        // Event listener
        pilihFotoButton.addActionListener(e -> pilihFoto());
        simpanButton.addActionListener(e -> simpanData());
        batalButton.addActionListener(e -> dispose());
    }

    private void pilihFoto() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Gambar (*.jpg, *.png)", "jpg", "png"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            fotoFile = fileChooser.getSelectedFile();
            setFotoLabel(fotoFile);
        }
    }

    private void setFotoLabel(File file) {
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
        Image img = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        fotoLabel.setIcon(new ImageIcon(img));
        fotoLabel.setText(null);
    }

    private void simpanData() {
        String nama = namaField.getText();
        String nik = nikField.getText();
        String alamat = alamatField.getText();
        String telepon = teleponField.getText();

        if (nama.isEmpty() || nik.isEmpty() || alamat.isEmpty() || telepon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (warga == null) {
            warga = new Warga();
            warga.setId(System.currentTimeMillis()); // ID unik
        }

        warga.setNama(nama);
        warga.setNik(nik);
        warga.setAlamat(alamat);
        warga.setTelepon(telepon);
        if (fotoFile != null) {
            warga.setFotoPath(fotoFile.getAbsolutePath());
        }

        ((WargaAppGUI) getParent()).addOrUpdateWarga(warga);
        dispose();
    }
}
