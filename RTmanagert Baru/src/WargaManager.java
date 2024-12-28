import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WargaManager {
    private static final String FILE_PATH = "warga_data.ser";

    public static String getFilePath() {
        return FILE_PATH;
    }

    public static void saveWarga(List<Warga> wargaList) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(wargaList);
        }
    }

    public static List<Warga> loadWarga() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Warga>) ois.readObject();
        }
    }
}
