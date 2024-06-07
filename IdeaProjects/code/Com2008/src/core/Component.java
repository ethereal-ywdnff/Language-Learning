package core;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.Scanner;

public abstract class Component {

    private String componentName;
    private double unitCost;
    private String brandName;
    private String serialNumber;

//    public void addWheel() throws Exception {
//        DatabaseConnection jdbc_connection = new DatabaseConnection();
//        Connection connection = jdbc_connection.getConnection();
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Please add the diameter of the wheel: ");
//        double a1 = scanner.nextDouble();
//        System.out.println("Please add the style of the wheel: ");
//        int a2 = scanner.nextInt();
//        System.out.println("Please add the brake type of the wheel: ");
//        int a3 = scanner.nextInt();
//        System.out.println("Please add the name of the wheel: ");
//        componentName = scanner.nextLine();
//        System.out.println("Please add the price of the wheel: ");
//        unitCost = scanner.nextDouble();
//        System.out.println("Please add the brand name of the wheel: ");
//        brandName = scanner.nextLine();
//        System.out.println("Please add the serial number of the wheel: ");
//        serialNumber = scanner.nextLine();
//
//        Wheel wheel = new Wheel(a1, a2, a3);
//
//        String insertDataWheel = "INSERT INTO Wheel VALUES (?, ?, ?)";
//        PreparedStatement preparedStatement1 = connection.prepareStatement(insertDataWheel);
//        preparedStatement1.setDouble(1, wheel.getDiameter());
//        preparedStatement1.setInt(2, wheel.getWheelStyle());
//        preparedStatement1.setInt(3, wheel.getBrakeType());
//
//        String insertDataComponents = "INSERT INTO Wheel VALUES (?, ?, ?, ?)";
//        PreparedStatement preparedStatement2 = connection.prepareStatement(insertDataComponents);
//        preparedStatement2.setString(1, componentName);
//        preparedStatement2.setDouble(2, unitCost);
//        preparedStatement2.setString(3, brandName);
//        preparedStatement2.setString(4, serialNumber);
//
//        preparedStatement1.executeUpdate();
//        preparedStatement2.executeUpdate();
//
//        preparedStatement1.close();
//        preparedStatement2.close();
//        jdbc_connection.closeConnection(connection);
//    }

}
