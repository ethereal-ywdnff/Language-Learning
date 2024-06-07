import org.junit.jupiter.api.Test;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction_ {
    @Test
    public void noTransaction() {//没有使用事务
        //连接
        Connection connection = null;
        //组织sql语句
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //创建PreparedStatement 对象
        try {
            connection = JdbcUtils.getConnection();//默认情况下，connection默认自动提交
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();//执行第一条sql
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();//执行第二条sql

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            //关闭资源
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }
    @Test
    public void useTransaction() {//使用事务
        //连接
        Connection connection = null;
        //组织sql语句
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //创建PreparedStatement 对象
        try {
            connection = JdbcUtils.getConnection();//默认情况下，connection默认自动提交
            //将connection设置成不自动提交
            connection.setAutoCommit(false);//开启了事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();//执行第一条sql

            //int a = 1/ 0;//抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();//执行第二条sql

            //提交事务
            connection.commit();
        } catch (SQLException e) {
            //在这里可以进行回滚
            System.out.println("exception happens, transaction automatically start");
            try {
                connection.rollback();
            } catch (Exception throwable) {
                throwable.printStackTrace();
            }
        } finally {
            //关闭资源
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }
}
