package services;

import database.DatabaseConnection;
import users.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CustomerService {
    public void createCustomer(Customer customer) throws Exception{

        //connect to the database
        DatabaseConnection jdbc_connection = new DatabaseConnection();
        Connection connection = jdbc_connection.getConnection();

        String sql =
                "select id, forename, surname from `customers` where id = ? and forename = ? and surname= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //assign values to ?
        preparedStatement.setInt(1, customer.getID());
        preparedStatement.setString(2, customer.getForename());
        preparedStatement.setString(3, customer.getSurname());
        //check if the given details exist
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next() == false) {
            String sql2 =
                    "insert into `customers` values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setInt(1, customer.getID());
            preparedStatement2.setString(2, customer.getForename());
            preparedStatement2.setString(3, customer.getSurname());
            preparedStatement2.setObject(4, customer.getAddress());
            preparedStatement2.setString(5, customer.getUsername());
            preparedStatement2.setString(6, customer.getPassword());
            preparedStatement2.executeUpdate();
            System.out.println("You have successfully created an account");
            preparedStatement2.close();
        } else {
            System.out.println("Account already exists.");
        }
        connection.close();
        preparedStatement.close();
        resultSet.close();
    }

    public void editCustomer(Customer customer) throws Exception{
        //connect to the database
        DatabaseConnection jdbc_connection = new DatabaseConnection();
        Connection connection = jdbc_connection.getConnection();

        //get the information that customer want to modify
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your customer ID: ");
        int customer_id = scanner.nextInt();
        System.out.print("which one do you want to modify?");
        String detail1 = scanner.nextLine();
        System.out.print("Please enter what you want to modify");
        String detail2 = scanner.nextLine();

        String sql = "update customers set ? = ? where ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, detail1);
        preparedStatement.setString(2, detail2);
        preparedStatement.setInt(3, customer_id);
        preparedStatement.executeUpdate();

        connection.close();
        preparedStatement.close();
    }
}
