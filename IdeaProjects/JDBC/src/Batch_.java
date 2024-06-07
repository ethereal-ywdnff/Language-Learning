import org.junit.Test;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Batch_ {
    @Test
    public void noBatch() throws Exception {
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into admin values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i ++) {
            preparedStatement.setString(1, "tom" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("traditional method takes " + (end - start));

        JdbcUtils.close(null, preparedStatement, connection);
    }
    @Test
    public void batch_() throws Exception {
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into admin values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i ++) {
            preparedStatement.setString(1, "tom" + i);
            preparedStatement.setString(2, "666");
            //将sql语句添加到批处理包中
            preparedStatement.addBatch();
            //当有1000条记录时再批量执行
            if ((i + 1) % 2000 == 0) {
                preparedStatement.executeBatch();
                //清空batch
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("batch method takes " + (end - start));

        JdbcUtils.close(null, preparedStatement, connection);
    }
}
