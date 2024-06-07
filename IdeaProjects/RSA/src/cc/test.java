package cc;

import RSA.Generator;
import RSA.RSAUtil;

import javax.crypto.Cipher;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String uname = "root";
            String password = "LKH20021127klaus";
            //建立连接
            Connection con = DriverManager.getConnection(url, uname, password);

            // Check if the pair of keys are present else generate those.
            if (!Generator.areKeysPresent()) {
                // Method generates a pair of keys using the RSA algorithm and stores it
                // in their respective files
                Generator.generateKey();
            }

            final String originalText = "admin";
            ObjectInputStream inputStream = null;

            // Encrypt the string using the public key
            inputStream = new ObjectInputStream(new FileInputStream(Generator.PUBLIC_KEY_FILE));
            final PublicKey publicKey = (PublicKey) inputStream.readObject();
            final byte[] cipherText = RSAUtil.encrypt(originalText, publicKey);
            String pwd = new String(cipherText, Charset.forName("ISO_8859_1"));
            //System.out.println(pwd);
//            System.out.println(pwd.getBytes(StandardCharsets.ISO_8859_1));

//            String sql = "insert into staff values (?, ?)";
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setString(1, "admin");
//            preparedStatement.setString(2, pwd);
//            preparedStatement.executeUpdate();

            String sql = "SELECT * FROM staff WHERE username = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "admin");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            final String pwd1 = resultSet.getString("password");
            System.out.println(pwd1);
            System.out.println(pwd1.getBytes(StandardCharsets.ISO_8859_1));

            inputStream = new ObjectInputStream(new FileInputStream(Generator.PRIVATE_KEY_FILE));
            final PrivateKey privateKey = (PrivateKey) inputStream.readObject();
            System.out.println(RSAUtil.decrypt(pwd1.getBytes(StandardCharsets.ISO_8859_1), privateKey));

            con.close();
            preparedStatement.close();

            // Decrypt the cipher text using the private key.
            //final byte[] password = [B@6f75e721;
//            inputStream = new ObjectInputStream(new FileInputStream(Generator.PRIVATE_KEY_FILE));
//            final PrivateKey privateKey = (PrivateKey) inputStream.readObject();
//            final String plainText = decrypt(cipherText, privateKey);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
