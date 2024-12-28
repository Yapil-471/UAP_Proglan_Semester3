package junit;

import javax.swing.JOptionPane;


public class WargaManagerTestHelperr {

    public String validateInput(Warga warga) {
        if (warga.getNama() == null || warga.getNama().isEmpty()) {
            return "Nama tidak boleh kosong.";
        }
        if (warga.getNik() == null || warga.getNik().length() != 16 || !warga.getNik().matches("\\d+")) {
            return "NIK harus 16 digit angka.";
        }
        if (warga.getTelepon() == null || !warga.getTelepon().matches("\\d+")) {
            return "Nomor telepon hanya boleh mengandung angka.";
        }
        return null; // Validasi berhasil
    }
}


