package utils;

import org.junit.Test;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtilsUse {
    @Test
    public void testSelect() {
        //连接
        Connection connection = null;
        //组织sql语句
        String sql = "select * from people where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //创建PreparedStatement 对象
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setInt(1, 1);
            //执行得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            //关闭资源
            JdbcUtils.close(set, preparedStatement, connection);
        }
    }
    @Test
    public void testDML() {
        //连接
        Connection connection = null;

        //组织sql语句
        String sql = "update people set name = ? where id = ?";
        PreparedStatement preparedStatement = null;
        //创建PreparedStatement 对象
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1, "lll");
            preparedStatement.setInt(2, 2);
            //执行
            preparedStatement.executeUpdate();
            System.out.println("success");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            //关闭资源
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }
}
