import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class eee {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/mysql.properties"));

            String url = properties.getProperty("url");
            String username = properties.getProperty("user");
            String password = properties.getProperty("password");
            Connection connection = DriverManager.getConnection(url, username, password);

//            String query = "select `name`, `age` from `staff` where `name` = \"tom\" and age = \"18\"";
            String query = "select `name`, `age` from `staff` where `name` = ? and age = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "tom");
            preparedStatement.setInt(2, 18);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("name: " + name + ", age: " + age);
            } else {
                System.out.println("doesn't found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
