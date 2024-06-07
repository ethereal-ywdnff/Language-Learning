import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatement_ {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("your id: ");
        String admin_id = scanner.nextLine();
        System.out.print("your name: ");
        String admin_name = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String uname = "root";
        String password = "LKH20021127klaus";
        Connection connection = DriverManager.getConnection(url, uname, password);

        //? 占位符
        String query = "select id, name from people where id = ? and name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        //给 ？赋值
        preparedStatement.setString(1, admin_id);
        preparedStatement.setString(2, admin_name);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()==false) {
            System.out.println("congratulations");
        } else {
            System.out.println("sorry, wrong info");
        }
    }
}
