package java飞机大战.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clear {
    public Clear() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/team10";
            String uname = "team10";
            String password = "Ikun123456";
            Connection connection = DriverManager.getConnection(url, uname, password);

            String all_set_to0 = "update players_info set easy_right = 0, easy_wrong = 0, medium_right = 0, " +
                    "medium_wrong = 0, hard_right = 0, hard_wrong = 0 where player_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(all_set_to0);
            preparedStatement.setString(1, "test");
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
