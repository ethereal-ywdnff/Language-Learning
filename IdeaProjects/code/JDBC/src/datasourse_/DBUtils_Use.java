package datasourse_;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

public class DBUtils_Use {
    //用druid完成增删改查
    @Test
    public void testQueryMany() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        //可以执行相关的方法，返回ArrayList结果集
        //String sql = "select * from people where id > ?";
        String sql = "select name from people where id > ?";
        //执行sql语句，得到一个ResultSet，封装到一个ArrayList集合中
        //返回集合
        //new BeanListHandler<>(People.class) 将ResultSet 放到 People对象中，封装到ArrayList中
        //  底层使用反射机制来获得People属性，然后进行封装
        // 1 就是给sql语句中的 ? 赋值，可以有多个值，是可变参数
        //底层得到的 ResultSet 和 PreparedStatement 会在query关闭
        List<People> list =
                queryRunner.query(connection, sql, new BeanListHandler<>(People.class), 0);

        for (People people : list) {
            System.out.println(people);
        }

        JDBCUtilsByDruid.close(null, null, connection);
    }
}
