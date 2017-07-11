package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by scn on 2017/7/11.
 * 使用DatabaseMetaData分析数据库信息
 */
public class DatabaseMetaDataTest {
    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;
    public void initParam(String paramFile) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pwd = props.getProperty("pwd");
    }
    public void info() throws Exception {
        // 加载驱动
        Class.forName(driver);
        try (
                Connection conn = DriverManager.getConnection(url, user, pwd)
                ) {
            // 获取DatabaseMetaData对象
            DatabaseMetaData dbmd = conn.getMetaData();
            // 获取MySQL支持的所有表类型
            ResultSet rs = dbmd.getTableTypes();
            System.out.println("--MySQL支持的表类型信息--");
            printResultSet(rs);
            // 获取当前数据库的全部数据表
            rs = dbmd.getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("--当前数据库里的数据表信息--");
            printResultSet(rs);
            // 获取student_table表的主键
            rs = dbmd.getPrimaryKeys(null, null, "student_table");
            System.out.println("--student_table表的主键信息--");
            printResultSet(rs);
            // 获取当前数据库的全部存储过程
            rs = dbmd.getProcedures(null, null, "%");
            printResultSet(rs);
            // 获取teacher_table和student_table表之间的外键约束
            rs = dbmd.getCrossReference(null, null, "teacher_table",
                    null, null, "student_table");
            System.out.println("--teacher_table和student_table表之间的外键约束--");
            printResultSet(rs);
            // 获取student_table表的全部数据列
            rs = dbmd.getColumns(null, null, "student_table", "%");
            System.out.println("--student_table表的全部列--");
            printResultSet(rs);
        }
    }
    public void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        // 打印ResultSet的所有列标题
        for (int i = 0; i < rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i + 1) + "\t");
        }
        System.out.println();
        // 打印所有数据
        while (rs.next()) {
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i + 1) + "\t");
            }
            System.out.println();
        }
        rs.close();
    }
    public static void main(String[] args) throws Exception {
        DatabaseMetaDataTest dt = new DatabaseMetaDataTest();
        dt.initParam("mysql.properties");
        dt.info();
    }
}
