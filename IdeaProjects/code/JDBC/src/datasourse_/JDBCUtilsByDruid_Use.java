package datasourse_;


import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCUtilsByDruid_Use {
    @Test
    public void testSelect() {
        System.out.println("using druid");
        //连接
        Connection connection = null;
        //组织sql语句
        String sql = "select * from people where id > ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setInt(1, 0);
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
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }
    //土方法，把ResultSet封装到Arraylist里
    @Test
    public void testSelectToArraylist() {
        System.out.println("using druid");
        //连接
        Connection connection = null;
        //组织sql语句
        String sql = "select * from people where id > ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<People> list = new ArrayList<>();
        //创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setInt(1, 0);
            //执行得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                //把得到的ResultSet记录封装到 People 对象里，放入到list里
                list.add(new People(id, name));
            }
            System.out.println("list: " + list);
            for (People people : list) {
                System.out.println("id: " + people.getId() + "\tname: " + people.getName());
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }
}
