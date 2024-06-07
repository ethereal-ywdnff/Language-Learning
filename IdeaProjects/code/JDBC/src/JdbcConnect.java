import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConnect {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String uname = "root";
        String password = "LKH20021127klaus";
        Class.forName("com.mysql.cj.jdbc.Driver");//可写可不写

        //建立连接
        Connection con = DriverManager.getConnection(url, uname, password);
        Statement st = con.createStatement();
        String query = "select * from people";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }

    @Test
    public void Con() throws Exception {
        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));
        //获取相关的值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("success");
    }
}
