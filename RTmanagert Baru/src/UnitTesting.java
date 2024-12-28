import junit.Warga;
import junit.WargaManagerTestHelperr;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Gunakan Assertions yang sesuai untuk JUnit 5

class WargaManagerTest {

    @Test
    void testValidateInput() {
        WargaManagerTestHelperr helper = new WargaManagerTestHelperr();

        // Data valid
        Warga validWarga = new Warga();
        validWarga.setNama("Valid Name");
        validWarga.setNik("1234567890123456");
        validWarga.setTelepon("08123456789");
        assertNull(helper.validateInput(validWarga), "Valid data should pass validation");

        // Data invalid - NIK kurang dari 16 digit
        Warga invalidNIK = new Warga();
        invalidNIK.setNama("Invalid NIK");
        invalidNIK.setNik("12345678");
        invalidNIK.setTelepon("0812345678");
        assertEquals("NIK harus 16 digit angka.", helper.validateInput(invalidNIK), "Invalid NIK should return error message");

        // Data invalid - Telepon berisi karakter non-angka
        Warga invalidTelepon = new Warga();
        invalidTelepon.setNama("Invalid Phone");
        invalidTelepon.setNik("1234567890123456");
        invalidTelepon.setTelepon("08123ABCD");
        assertEquals("Nomor telepon hanya boleh mengandung angka.", helper.validateInput(invalidTelepon), "Invalid phone number should return error message");

        // Data invalid - Nama kosong
        Warga invalidNama = new Warga();
        invalidNama.setNama("");
        invalidNama.setNik("1234567890123456");
        invalidNama.setTelepon("08123456789");
        assertEquals("Nama tidak boleh kosong.", helper.validateInput(invalidNama), "Empty name should return error message");
    }
}