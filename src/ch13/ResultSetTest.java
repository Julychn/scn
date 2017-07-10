package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by scn on 2017/7/10.
 * 创建可滚动、可更新的结果集
 */
public class ResultSetTest {
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
    public void query(String sql) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        try (
                Connection conn = DriverManager.getConnection(url, user, pwd);
                // 使用Connection来创建一个PreparedStatement
                // 传入控制结果集可滚动、可更新的参数
                PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = pstmt.executeQuery()
                ) {
            rs.last();
            int rowCount = rs.getRow();
            for(int i = rowCount; i > 0; i--) {
                rs.absolute(i);
                System.out.println(rs.getString(1) + "\t"
                + rs.getString(2) + "\t" + rs.getString(3));
                // 修改记录指针所指记录、第2列的值
                rs.updateString(2, "学生名" + i);
                // 提交修改
                rs.updateRow();
            }
        }
    }
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ResultSetTest rt = new ResultSetTest();
        rt.initParam("mysql.properties");
        rt.query("select * from student_table");
    }
}
