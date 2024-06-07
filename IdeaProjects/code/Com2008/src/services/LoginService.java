package services;

import users.Customer;
import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    public void login(Customer customer) throws Exception {
        DatabaseConnection jdbc_connection = new DatabaseConnection();
        Connection connection = jdbc_connection.getConnection();

        String queryCustomer = "SELECT * FROM customers  WHERE username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(queryCustomer);
        preparedStatement.setString(1, customer.getUsername());
        preparedStatement.setString(2, customer.getPassword());

        ResultSet customerDetails = preparedStatement.executeQuery();
        if (customerDetails.next()) {
            customer.setID(customerDetails.getInt(1));
            customer.setForename(customerDetails.getString(2));
            customer.setSurname(customerDetails.getString(3));

            // TODO: We need to figure out how to reference the 'Address' table to pass into setAddress
            // customer.setAddress(customerDetails);
            
            customer.setUsername(customerDetails.getString(6));
            customer.setPassword(customerDetails.getString(7));
            System.out.println("login successfully");
        } else {
            System.out.println("login failure");
        }

        preparedStatement.close();
        customerDetails.close();
        connection.close();
    }

}
