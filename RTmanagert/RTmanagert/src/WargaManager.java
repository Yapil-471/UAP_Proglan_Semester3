import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WargaManager {
    private static final String FILE_PATH = "warga_data.ser";

    // Menyimpan daftar warga ke file
    public static void saveWarga(List<Warga> wargaList) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(wargaList);
        }
    }

    // Membaca daftar warga dari file
    @SuppressWarnings("unchecked")
    public static List<Warga> loadWarga() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>(); // Jika file belum ada, kembalikan daftar kosong
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Warga>) ois.readObject();
        }
    }
}
