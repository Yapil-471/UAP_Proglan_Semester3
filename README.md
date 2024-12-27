##Data Warga RT

#Deskripsi
Aplikasi "Data Warga RT" adalah aplikasi berbasis GUI menggunakan Java Swing untuk mengelola data warga di suatu lingkungan RT. Aplikasi ini menyediakan fitur untuk menambahkan, mengedit, menghapus, mencari data warga, serta menampilkan gambar profil warga.

##Fitur Utama

#CRUD Data Warga: 
Tambah data warga baru.
Edit data warga yang sudah ada.
Hapus data warga.
Menampilkan daftar warga dalam tabel.
#Pencarian Data Warga:
Mencari warga berdasarkan nama, NIK, alamat, atau nomor telepon.
#Image Handling:
Menampilkan foto warga pada tabel.
Upload foto saat menambahkan atau mengedit data warga.
#Penyimpanan Data:
Data disimpan secara lokal menggunakan serialisasi file.
#Exception Handling:
Menangani berbagai kesalahan, seperti file tidak ditemukan, kesalahan input, atau file gambar yang tidak valid.
##Teknologi yang Digunakan
Bahasa Pemrograman: Java
Framework: Java Swing untuk GUI
Penyimpanan Data: Serialisasi file (Java Serializable)
##Struktur Kode
WargaAppGUI: Komponen utama aplikasi yang mengelola antarmuka pengguna.
Warga: Model data warga dengan atribut seperti ID, nama, NIK, alamat, telepon, dan foto.
WargaForm: Form untuk menambahkan atau mengedit data warga.
WargaManager: Kelas utilitas untuk menyimpan dan memuat data dari file.
ImageRenderer: Renderer khusus untuk menampilkan gambar di tabel

##Cara Menjalankan Aplikasi

#Prasyarat:
Pastikan Anda memiliki JDK 8 atau versi yang lebih baru.
IDE seperti IntelliJ IDEA, Eclipse, atau NetBeans untuk menjalankan proyek.
#Langkah-langkah:
Clone atau unduh repositori ini.
Buka proyek di IDE favorit Anda.
Jalankan kelas WargaAppGUI untuk memulai aplikasi.

##Pengujian
#Manual Testing:
Cek setiap fungsi CRUD untuk memastikan berjalan dengan baik.
Uji fitur pencarian dengan berbagai kata kunci.
Pastikan gambar dapat diunggah dan ditampilkan di tabel.
#Automated Testing:
Belum diterapkan pada versi ini, namun dapat ditambahkan dengan framework testing seperti JUnit.

##Review Kode
#Beberapa poin perbaikan dari code review:
Gunakan konvensi penamaan variabel dan metode yang konsisten.
Pisahkan logika bisnis dari tampilan (GUI) untuk memudahkan pengujian.
Tambahkan logging untuk mempermudah debugging.

##Lisensi
Proyek ini menggunakan lisensi MIT. Anda bebas untuk menggunakan, memodifikasi, dan mendistribusikan proyek ini dengan tetap mencantumkan atribusi kepada pengembang asli.

##Dikembangkan oleh M. Bisri Farizi(469) dan M. Yapil Islami(471)