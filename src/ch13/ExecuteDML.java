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
 * jdbc使用executeUpdate方法
 */
public class ExecuteDML {
    private String driver;
    private String url;
    private String user;
    private String pwd;
    public void initParam(String paramFile) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pwd = props.getProperty("pwd");
    }
    public int insertData(String sql) throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName(driver);

        try (
                // 创建连接
                Connection conn = DriverManager.getConnection(url, user, pwd);
                // 创建statement对象
                Statement stmt = conn.createStatement()
                )
        {
            // 执行DML语句 返回受影响的记录条数
            return stmt.executeUpdate(sql);
        }
    }
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ExecuteDML executeDML = new ExecuteDML();
        executeDML.initParam("mysql.properties");
        int result = executeDML.insertData("insert into jdbc_test(jdbc_name, jdbc_desc)" +
                " select s.student_name, t.teacher_name" +
                " from student_table s, teacher_table t" +
                " where s.java_teacher = t.teacher_id;");
        System.out.println("共有" + result + "条记录受影响");
    }
}
