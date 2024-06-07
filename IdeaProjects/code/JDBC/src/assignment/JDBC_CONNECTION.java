package assignment;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBC_CONNECTION {

    public Connection getConnection() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/assignment/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public void closeConnection(Connection connection) throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

}
