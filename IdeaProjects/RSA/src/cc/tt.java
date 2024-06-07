package cc;

import RSA.Generator;
import RSA.RSAUtil;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.*;

public class tt {
    public static void main(String[] args) throws Exception {
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

        final String originalText = "admin";
        ObjectInputStream inputStream = null;

        inputStream = new ObjectInputStream(new FileInputStream(Generator.PUBLIC_KEY_FILE));
        final PublicKey publicKey = (PublicKey) inputStream.readObject();
        final byte[] encryptedPassword = RSAUtil.encrypt(originalText, publicKey);
        String pwd = new String(encryptedPassword, Charset.forName("ISO_8859_1"));
        //System.out.println(pwd);
        //System.out.println(encryptedPassword.toString());

//        String sql = "SELECT * FROM staff WHERE username = ?";
//        PreparedStatement preparedStatement = con.prepareStatement(sql);
//        preparedStatement.setString(1, "admin");
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        resultSet.next();
//        final String pwd1 = resultSet.getString("password");
//        System.out.println(pwd1);
//        System.out.println(pwd1.getBytes(StandardCharsets.ISO_8859_1));

        String sql = "insert into team010.staff values (?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, "admin");
        preparedStatement.setString(2, pwd);
        preparedStatement.executeUpdate();

        inputStream = new ObjectInputStream(new FileInputStream(Generator.PRIVATE_KEY_FILE));
        final PrivateKey privateKey = (PrivateKey) inputStream.readObject();
//        System.out.println(RSAUtil.decrypt(encryptedPassword, privateKey));
        //System.out.println(RSAUtil.decrypt(pwd1.getBytes(StandardCharsets.ISO_8859_1), privateKey));


    }

}
