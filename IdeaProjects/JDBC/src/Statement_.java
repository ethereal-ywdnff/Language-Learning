import java.sql.*;
import java.util.Scanner;

public class Statement_ {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.print("you id: ");
        String admin_id = scanner.nextLine();
        System.out.print("you name: ");
        String admin_name = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String uname = "root";
        String password = "LKH20021127klaus";
        Connection connection = DriverManager.getConnection(url, uname, password);

        Statement statement = connection.createStatement();
        //会导致sql注入
        //id: 1' or
        //name: or '1' = '1
        String query = "select id, name from people where id = '"+admin_id+"' and name = '"+admin_name+"'";

        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            System.out.println("congratulations");
        } else {
            System.out.println("sorry, wrong info");
        }

        rs.close();
        statement.close();
        connection.close();
    }
}
