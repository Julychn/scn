package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by scn on 2017/7/10.
 * 使用CallableStatement调用存储过程
 */
public class CallableStatementTest {
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
    public void callProdure() throws SQLException, ClassNotFoundException {
        // 加载驱动
        Class.forName(driver);
        try (
                // 获取数据库连接
                Connection conn = DriverManager.getConnection(url, user, pwd);
                // 使用conn创建一个CallableStatement对象
                CallableStatement cstmt = conn.prepareCall("call add_pro(?, ?, ?)")
                ) {
            // 存储过程传入参数
            cstmt.setInt(1, 4);
            cstmt.setInt(2, 5);
            // 注册参数类型
            cstmt.registerOutParameter(3, Types.INTEGER);
            // 执行存储过程
            cstmt.execute();
            // 获取并输出存储过程传出参数的值
            System.out.println("执行结果是：" + cstmt.getInt(3));
        }
    }
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        CallableStatementTest cs = new CallableStatementTest();
        cs.initParam("mysql.properties");
        cs.callProdure();
    }
}
