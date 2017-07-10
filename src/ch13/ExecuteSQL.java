package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by scn on 2017/7/10.
 * 使用Statement的execute()方法执行任意的SQL语句
 */
public class ExecuteSQL {
    private String driver;
    private String url;
    private String user;
    private String pwd;
    public void initParam(String paramFile) throws IOException {
        // 使用Properties类加载属性文件
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pwd = props.getProperty("pwd");
    }
    public void executeSql(String sql) throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName(driver);
        try (
                // 创建Connection连接
                Connection conn = DriverManager.getConnection(url, user, pwd);
                // 创建Statement对象
                Statement stmt = conn.createStatement()
                )
        {
            // 执行SQL语句,返回boolean表示是否包含ResultSet
            boolean hasResultSet = stmt.execute(sql);
            // 如果执行后有ResultSet结果集
            if (hasResultSet) {
                try (
                        // 获取结果集
                        ResultSet rs = stmt.getResultSet()
                        )
                {
                    // ResultSetMetaData是用于分析结果集的元数据接口
                    ResultSetMetaData rsmd = rs.getMetaData();
                    // 获取结果集的列数
                    int columnCount = rsmd.getColumnCount();
                    // 迭代输出ResultSet对象
                    while(rs.next()) {
                        // 依次输出每列的值
                        for (int i = 0; i < columnCount; i++) {
                            System.out.print(rs.getString(i + 1) + "\t");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("该SQL语句影响的记录有" + stmt.getUpdateCount() + "条");
            }
        }
    }
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ExecuteSQL e = new ExecuteSQL();
        e.initParam("mysql.properties");
        System.out.println("—————————执行删除表的DDL语句—————————");
        e.executeSql("drop table if exists my_test;");
        System.out.println("——————————执行建表的语句——————————");
        e.executeSql("create table my_test" +
                " (test_id int auto_increment primary key," +
                " test_name varchar(255));");
        System.out.println("——————————执行插入数据的DML语句——————————");
        e.executeSql("insert into my_test(test_name)" +
                " select student_name from student_table;");
        System.out.println("——————————执行查询语句——————————");
        e.executeSql("select * from my_test;");
    }
}
