package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by scn on 2017/7/10.
 * 使用PreparedStatement执行SQL语句
 * 该程序示范了使用Statement和PreparedStatement分别插入100条记录的对比
 */
public class PreparedStatementTest {
    private String driver;
    private String url;
    private String user;
    private String pwd;
    public void initParam(String paramFile) throws IOException, ClassNotFoundException {
        // 使用Properties来加载属性文件
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pwd = props.getProperty("pwd");
        // 加载驱动
        Class.forName(driver);
    }
    public void insertUseStatement() throws SQLException {
        // 记录时间
        long start = System.currentTimeMillis();
        try (
                // 获取数据库连接
                Connection conn = DriverManager.getConnection(url, user, pwd);
                // 创建Statement对象
                Statement stmt = conn.createStatement()
        )
        {
            // 需要使用100条SQL语句来插入100条记录
            for (int i = 0; i < 100; i++) {
                stmt.executeUpdate("insert into student_table " +
                        "VALUES(NULL , '姓名" + i + "', 1)");
            }
            System.out.println("使用Statement耗时：" + (System.currentTimeMillis() - start));
        }
    }
    public void insertUsePrepare() throws SQLException {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (
                // 获取数据库连接
                Connection conn = DriverManager.getConnection(url, user, pwd);
                // 获取PrepareStatement
                PreparedStatement pstmt = conn.prepareStatement("insert INTO student_table " +
                        "VALUES (NULL , ?, 1)")
                )
        {
            // 100次为PreparedStatement的参数设值，就可以插入100条记录
            for (int i = 0; i < 100; i++) {
                pstmt.setString(1, "姓名" + i);
                pstmt.executeUpdate();
            }
            System.out.println("使用PreparedStatement费时：" + (System.currentTimeMillis()-start));
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        PreparedStatementTest pt = new PreparedStatementTest();
        pt.initParam("mysql.properties");
        pt.insertUseStatement();
        pt.insertUsePrepare();
    }
}
