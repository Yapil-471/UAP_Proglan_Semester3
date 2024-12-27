# RT Manager

## Deskripsi
RT Manager adalah aplikasi berbasis GUI yang dikembangkan menggunakan Java Swing untuk membantu pengelolaan data warga dalam suatu lingkungan RT. Aplikasi ini menyediakan fitur lengkap untuk menambah, mengedit, menghapus, mencari data warga, serta menampilkan gambar profil warga dalam antarmuka yang ramah pengguna.

---
## Fitur Utama
### CRUD Data Warga
- **Tambah Data:** Memungkinkan pengguna menambahkan data warga baru.
- **Edit Data:** Memperbarui informasi warga yang sudah ada.
- **Hapus Data:** Menghapus data warga yang tidak diperlukan.
- **Tabel Warga:** Menampilkan daftar warga secara terstruktur dalam tabel interaktif.

### Pencarian Data Warga
- Cari data warga berdasarkan:
  - Nama
  - NIK
  - Alamat
  - Nomor telepon

### Image Handling
- **Tampilan Foto:** Menampilkan foto warga langsung di tabel.
- **Upload Foto:** Menyediakan fitur untuk mengunggah foto saat menambahkan atau mengedit data warga.

### Penyimpanan Data
- Data disimpan secara lokal dengan memanfaatkan serialisasi file (Java Serializable), sehingga tetap aman dan dapat diakses kembali.

### Exception Handling
- Menangani berbagai kesalahan seperti:
  - File tidak ditemukan
  - Kesalahan input pengguna
  - File gambar tidak valid
---
## Teknologi yang Digunakan
- **Bahasa Pemrograman:** Java
- **Framework:** Java Swing untuk GUI
- **Penyimpanan Data:** Serialisasi file
---

## Struktur Kode

### Komponen Utama

1. **WargaAppGUI**
   - Komponen utama yang mengelola antarmuka pengguna.

2. **Warga**
   - Model data warga dengan atribut:
     - ID
     - Nama
     - NIK
     - Alamat
     - Nomor telepon
     - Foto

3. **WargaForm**
   - Formulir untuk menambahkan atau mengedit data warga.

4. **WargaManager**
   - Kelas utilitas untuk menyimpan dan memuat data warga dari file.

5. **ImageRenderer**
   - Renderer khusus untuk menampilkan gambar pada tabel.

---

## Cara Menjalankan Aplikasi

### Prasyarat
- **JDK:** Pastikan Anda memiliki JDK 8 atau versi yang lebih baru.
- **IDE:** Disarankan menggunakan IntelliJ IDEA, Eclipse, atau NetBeans.

### Langkah-langkah
1. Clone atau unduh repositori proyek ini.
2. Buka proyek di IDE favorit Anda.
3. Jalankan kelas `WargaAppGUI` untuk memulai aplikasi.
---
## Pengujian

### Pengujian Manual
1. Cek setiap fungsi CRUD untuk memastikan berjalan tanpa kendala.
2. Uji fitur pencarian dengan berbagai kombinasi kata kunci.
3. Verifikasi bahwa gambar dapat diunggah dan ditampilkan dengan benar di tabel.
### Pengujian Otomatis
- Pengujian otomatis belum diterapkan pada versi ini. Rencana mendatang akan menggunakan framework seperti JUnit untuk pengujian unit dan integrasi.
---

## Review Kode
### Rekomendasi Perbaikan
1. Gunakan konvensi penamaan variabel dan metode yang konsisten.
2. Pisahkan logika bisnis dari tampilan (GUI) untuk meningkatkan modularitas dan kemudahan pengujian.
3. Tambahkan logging untuk mempermudah proses debugging.
---

## Lisensi
Proyek ini menggunakan lisensi MIT. Anda bebas untuk menggunakan, memodifikasi, dan mendistribusikan proyek ini, dengan tetap mencantumkan atribusi kepada pengembang asli.

---

## Pengembang
Aplikasi ini dikembangkan oleh:
- **M. Bisri Farizi (469)**
- **M. Yapil Islami(471)**

