import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatement_ {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("you id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("you name: ");
        String name = scanner.nextLine();

//        int id = 1;
//        String name = "lkh";

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String uname = "root";
        String password = "20021127klaus";
        Connection connection = DriverManager.getConnection(url, uname, password);

        //? 占位符
        String query = "select id, name from `user` where id = ? and name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        //给 ？赋值
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);

        ResultSet rs = preparedStatement.executeQuery();
        boolean found = false;
        while (rs.next()) {
            int id1 = rs.getInt("id");
            String name1 = rs.getString("name");
            if (id1 == id && name1.equals(name)) {
                System.out.println("ID: " + id + ", Name: " + name);
                found = true;
            }
        }
        if (found) {
            System.out.println("congratulations");
        } else {
            System.out.println("sorry, wrong info");
        }



    }
}
