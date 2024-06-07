import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatementDML_ {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("id: ");
        String admin_id = scanner.nextLine();
        System.out.print("name: ");
        String admin_name = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String uname = "root";
        String password = "LKH20021127klaus";
        Connection connection = DriverManager.getConnection(url, uname, password);

        //? 占位符
        //String query = "insert into people values(?, ?)";
        //String query = "update people set name = ? where id = ?";
        String query = "delete from people where name = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        //给 ？赋值
        //insert
//        preparedStatement.setString(1, admin_id);
//        preparedStatement.setString(2, admin_name);
        //update
//        preparedStatement.setString(1, admin_name);
//        preparedStatement.setString(2, admin_id);
        //delete
        preparedStatement.setString(1, admin_name);

        //rows 修改的行数
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "success" : "failed");

    }
}
