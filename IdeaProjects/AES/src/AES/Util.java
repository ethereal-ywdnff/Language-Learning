package AES;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

public class Util {
    static Cipher cipher;

    public static String encryptString(String text) throws Exception {
        if (!G.keysExist()) {
            //if the key files don't exist, then generate them
            G.generateKey();
        }

        cipher = Cipher.getInstance("AES");
        // Path path = Paths.get("src/ASE/AES_KEY.txt");
        String KEY_FILE = "src/AES/AES_KEY.txt";
        File file = new File(KEY_FILE);
        
        Scanner myReader = new Scanner(file);
        String key = "";
        while (myReader.hasNextLine()) {
            key = myReader.nextLine();
        }
        myReader.close();

        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        return encrypt(text, originalKey);
    }

    public static String decryptString(String encrypted) throws Exception {
        if (!G.keysExist()) {
            //if the key files don't exist, then generate them
            G.generateKey();
        }

        cipher = Cipher.getInstance("AES");
        File file = new File("src/AES/AES_KEY.txt");

        Scanner myReader = new Scanner(file);
        String key = "";
        while (myReader.hasNextLine()) {
            key = myReader.nextLine();
        }
        myReader.close();

        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        return decrypt(encrypted, originalKey);
    }

    public static String encrypt(String plainText, SecretKey secretKey)
            throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    public static String decrypt(String encryptedText, SecretKey secretKey)
            throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
}
