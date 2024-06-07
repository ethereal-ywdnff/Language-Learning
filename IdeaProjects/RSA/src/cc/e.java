package cc;

import RSA.Generator;
import RSA.RSAUtil;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class e {
    public static void main(String[] args) throws Exception{
        final String URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
        final String DbName = "team010";
        final String User = "team010";
        final String Password = "1395a1a5";

        Connection con = DriverManager.getConnection(URL + DbName, User, Password);

        if (!Generator.areKeysPresent()) {
            // Method generates a pair of keys using the RSA algorithm and stores it
            // in their respective files
            Generator.generateKey();
        }

        final String forename = "kkk";
        final String surname = "lll";
        ObjectInputStream inputStream = null;

        inputStream = new ObjectInputStream(new FileInputStream(Generator.PUBLIC_KEY_FILE));
        final PublicKey publicKey = (PublicKey) inputStream.readObject();
        final byte[] encryptedForename = RSAUtil.encrypt(forename, publicKey);
        final byte[] encryptedSurname = RSAUtil.encrypt(surname, publicKey);
        String fn = new String(encryptedForename, Charset.forName("ISO_8859_1"));
        String sn = new String(encryptedSurname, Charset.forName("ISO_8859_1"));

        String sql = "INSERT IGNORE INTO addresses VALUES (?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, "4");
        statement.setString(2, "4");
        statement.setString(3, "4");
        statement.setString(4, "4");
        statement.executeUpdate();

        String sql2 = "INSERT INTO customers VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement1 = con.prepareStatement(sql2);
        statement1.setInt(1, 0); // This gets magically assigned
        statement1.setString(2, fn);
        statement1.setString(3, sn);
        statement1.setString(4, "4");
        statement1.setString(5, "4");
        statement1.executeUpdate();

//        inputStream = new ObjectInputStream(new FileInputStream(Generator.PRIVATE_KEY_FILE));
//        final PrivateKey privateKey = (PrivateKey) inputStream.readObject();
//        System.out.println(RSAUtil.decrypt(encryptedPassword, privateKey));
//        System.out.println(RSAUtil.decrypt(pwd1.getBytes(StandardCharsets.ISO_8859_1), privateKey));

        con.close();
        statement1.close();
    }
}
