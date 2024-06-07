import java.sql.*;

public class con {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/team10";
        String uname = "team10";
        String password = "Ikun123456";

        Connection connection = DriverManager.getConnection(url, uname, password);
        String query = "select * from questions_info where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, 1);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            System.out.println(rs.getString("content"));
        } else {
            System.out.println("sorry, wrong info");
        }
    }
}
