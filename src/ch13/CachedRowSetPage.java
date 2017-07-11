package ch13;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by scn on 2017/7/11.
 * 离线RowSet的查询分页
 */
public class CachedRowSetPage {
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
    public CachedRowSet query(String sql, int pageSize, int page) throws Exception {
        Class.forName(driver);
        try (
                // 获取数据库连接
                Connection conn = DriverManager.getConnection(url, user, pwd);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
                ) {
            // 使用RowSetProvider创建RowSetFactory
            RowSetFactory factory = RowSetProvider.newFactory();
            // 创建默认的CachedRowSet实例
            CachedRowSet cachedRs = factory.createCachedRowSet();
            // 设置每页显示pageSize条记录
            cachedRs.setPageSize(pageSize);
            // 使用result装填RowSet，设置从第几条记录开始
            cachedRs.populate(resultSet, (page - 1) * pageSize + 1);
            return cachedRs;
        }
    }

    public static void main(String[] args) throws Exception {
        CachedRowSetPage cachedRowSetPage = new CachedRowSetPage();
        cachedRowSetPage.initParam("mysql.properties");
        CachedRowSet cachedRs = cachedRowSetPage.query("select * from student_table", 3, 2);
        // 向后滚动结果集
        while (cachedRs.next()) {
            System.out.println(cachedRs.getString(1) + "\t"
            + cachedRs.getString(2) + "\t"
            + cachedRs.getString(3));
        }
    }
}
