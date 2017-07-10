package ch13;

import java.sql.*;

/**
 * Created by scn on 2017/7/10.
 * JDBC编程示例
 */
public class ConnMySQL {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.加载驱动，使用反射知识
        Class.forName("com.mysql.jdbc.Driver");
        try (
            // 2. 使用DriverManager获取数据库连接
            // 其中返回的Connection就代表了Java程序和数据库的连接
            // 不同数据库的URL写法需要查驱动文档，用户名、密码由DBA分配
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://120.27.111.133:3306/select_test",
                    "root", "");
            // 3.使用Connection来创建一个Statement对象
            Statement stmt = conn.createStatement();
            // 4.执行SQL语句
            ResultSet rs = stmt.executeQuery("select s.*, teacher_name " +
                                    "from student_table s, teacher_table t " +
                                    "where t.teacher_id = s.java_teacher")
        )
        {
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "\t"
                + rs.getString(2) + "\t"
                + rs.getString(3) + "\t"
                + rs.getString(4));
            }
        }
    }
}
