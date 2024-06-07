import datasourse_.JDBCUtilsByDruid;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class createTable {
    @Test
    public void table() throws Exception{
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "CREATE TABLE `jdbc`.`tt` (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`));";
        String sql2 = "insert into `tt` (id, name) values (1, \"lll\");";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        connection.close();
        }



}
