package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by scn on 2017/7/10.
 * jdbc 使用executeUpdate方法执行DDL语句
 */
public class ExecuteDDL {
    private String driver;
    private String url;
    private String user;
    private String pwd;
    public void initParam(String paramFile) throws IOException {
        // 使用Properties类来加载属性文件
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pwd = props.getProperty("pwd");
    }
    public void createTable(String sql) throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName(driver);
        try (
                // 获取数据库连接
                Connection conn = DriverManager.getConnection(url, user, pwd);
                // 使用Connection来创建一个statement对象
                Statement stmt = conn.createStatement()
                )
        {
            // 执行DDL语句，创建数据表
            stmt.executeUpdate(sql);
        }
    }
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ExecuteDDL ed = new ExecuteDDL();
        ed.initParam("mysql.properties");
        ed.createTable("create table jdbc_test " +
                "( jdbc_id int auto_increment primary key," +
                "jdbc_name varchar(255)," +
                "jdbc_desc text);");
        System.out.println("建表成功");
    }
}
