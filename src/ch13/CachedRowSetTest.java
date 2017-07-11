package ch13;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by scn on 2017/7/11.
 * CachedRowSet测试(离线RowSet)
 */
public class CachedRowSetTest {
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
    public CachedRowSet query(String sql) throws SQLException, ClassNotFoundException {
        // 加载驱动
        Class.forName(driver);
        // 获取数据库连接
        Connection conn = DriverManager .getConnection(url, user, pwd);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        // 使用RowSetProvider创建RowSetFactory
        RowSetFactory factory = RowSetProvider.newFactory();
        // 创建默认的CachedRowSet实例
        CachedRowSet cachedRs = factory.createCachedRowSet();
        // 使用ResultSet装填RowSet
        cachedRs.populate(rs);
        rs.close();
        stmt.close();
        conn.close();
        return cachedRs;
    }
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        CachedRowSetTest ct = new CachedRowSetTest();
        ct.initParam("mysql.properties");
        CachedRowSet rs = ct.query("select * from student_table");
        rs.beforeFirst();
        // 向后滚动
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t"
            + rs.getString(2) + "\t"
            + rs.getString(3));
            if (rs.getInt("student_id") == 4) {
                // 修改指定记录行
                rs.updateString("student_name", "唐僧");
                rs.updateRow();
            }
        }
        // 重新获取数据库连接
        Connection conn = DriverManager.getConnection(url, user, pwd);
        conn.setAutoCommit(false);
        // 把对RowSet所做的修改同步到底层数据库
        rs.acceptChanges(conn);
    }
}
