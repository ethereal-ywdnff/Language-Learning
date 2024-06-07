package AES;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class G {
    public static final String KEY_FILE = "src/AES/AES_KEY.txt";

    public static void generateKey() throws Exception{
        final KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        File keyFile = new File(KEY_FILE);

        // Create files to store key

        // Path path = Paths.get("src/AES/AES_KEY.txt");
        keyFile.createNewFile();

        // Saving the Public key in a file
        FileWriter fw = new FileWriter(keyFile);

        fw.write(encodedKey);
        fw.close();
    }

    public static boolean keysExist() {
        File key = new File(KEY_FILE);

        if (key.exists()) {
            return true;
        }
        return false;
    }
}
