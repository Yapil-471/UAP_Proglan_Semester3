public class Warga implements java.io.Serializable {
    private long id;
    private String nama;
    private String nik;
    private String alamat;
    private String telepon;
    private String fotoPath; // Tambahan untuk foto

    // Getter dan Setter
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getTelepon() { return telepon; }
    public void setTelepon(String telepon) { this.telepon = telepon; }

    public String getFotoPath() { return fotoPath; }
    public void setFotoPath(String fotoPath) { this.fotoPath = fotoPath; }
}
