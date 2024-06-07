import AES.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tt {
    public static void main(String[] args) throws Exception {
        final String URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
        final String DbName = "team010";
        final String User = "team010";
        final String Password = "1395a1a5";

        String fn = Util.encryptString("aa");
        String sn = Util.encryptString("bb");
        Connection connection = DriverManager.getConnection(URL + DbName, User, Password);
//        String sql2 = "INSERT INTO customers VALUES (?, ?, ?, ?, ?)";
//        PreparedStatement statement1 = connection.prepareStatement(sql2);
//        statement1.setInt(1, 0); // This gets magically assigned
//        statement1.setString(2, fn);
//        statement1.setString(3, sn);
//        statement1.setString(4, "56");
//        statement1.setString(5, "S101TB");
//        statement1.executeUpdate();

        String forename = "aa";
        String surname = "bb";
        String queryCustomer = "SELECT forename, surname FROM customers";
        PreparedStatement preparedStatement1 = connection.prepareStatement(queryCustomer);
        ResultSet customerDetails = preparedStatement1.executeQuery();

        List<String> forenames = new ArrayList<>();
        List<String> surnames = new ArrayList<>();

        while (customerDetails.next()) {
            String a = customerDetails.getString("forename");
            forenames.add(Util.decryptString(a));

            String b = customerDetails.getString("surname");
            surnames.add(Util.decryptString(b));
        }

        String queryAddress = "SELECT * FROM addresses WHERE HOUSENUMBER = ? AND STREETNAME = ? AND CITYNAME = ? AND POSTCODE = ?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(queryAddress);
        preparedStatement2.setString(1, "56");
        preparedStatement2.setString(2, "Mulehouse Road");
        preparedStatement2.setString(3, "Sheffield");
        preparedStatement2.setString(4, "S101TB");
        ResultSet addressDetails = preparedStatement2.executeQuery();

        //boolean customerExists = customerDetails.next();
        boolean addressExists = addressDetails.next();

        //System.out.println("Customer Exists: "+ customerExists);
        System.out.println("Address Exists: "+ addressExists);

        if (forenames.contains(forename) && surnames.contains(surname) && addressExists) {
            System.out.println("login successfully");
            int index = forenames.indexOf(forename);
            String query = "SELECT id FROM customers LIMIT ?, 1";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, index);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
        } else {
            System.out.println("login failure");
        }

        preparedStatement2.close();
        connection.close();
    }
}
