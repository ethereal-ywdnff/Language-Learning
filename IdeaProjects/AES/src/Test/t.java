package Test;

import AES.Util;

import java.sql.*;

public class t {
    public static void main(String[] args) throws Exception {
        final String URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
        final String DbName = "team010";
        final String User = "team010";
        final String Password = "1395a1a5";

        Connection connection = DriverManager.getConnection(URL + DbName, User, Password);

//        String password = "admin";
//        String pwd = Util.encryptString(password);
//        String sql = "insert into team010.staff values (?, ?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, "admin");
//        preparedStatement.setString(2, pwd);
//        preparedStatement.executeUpdate();

        String sql = "SELECT * FROM staff WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "admin");

        ResultSet staffDetails = preparedStatement.executeQuery();
        if(staffDetails.next()) {
            final String pwd = staffDetails.getString("password");

            String decryptedPassword = Util.decryptString(pwd);
            System.out.println(decryptedPassword);
        }

        connection.close();
        preparedStatement.close();
    }
}
