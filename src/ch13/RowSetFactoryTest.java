package ch13;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by scn on 2017/7/11.
 * 使用RowSetFactory来创建JdbcRowSet实例
 */
public class RowSetFactoryTest {
    private String driver;
    private String url;
    private String user;
    private String pwd;
    public void initParam(String paramFile) throws IOException, ClassNotFoundException {
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pwd = props.getProperty("pwd");
        Class.forName(driver);
    }
    public void update(String sql) throws Exception {
        // 使用RowSetProvider创建RowSetFactory
        RowSetFactory factory = RowSetProvider.newFactory();
        try (
                // 使用RowSetProvider创建默认的JdbcRowSet实例
                JdbcRowSet jdbcRs = factory.createJdbcRowSet()
                ) {
            // 设置必要的连接信息
            jdbcRs.setUrl(url);
            jdbcRs.setUsername(user);
            jdbcRs.setPassword(pwd);
            // 设置SQL查询语句
            jdbcRs.setCommand(sql);
            // 执行查询
            jdbcRs.execute();
            jdbcRs.afterLast();
            // 向前滚动结果集
            while (jdbcRs.previous()) {
                System.out.println(jdbcRs.getString(1) + "\t"
                        + jdbcRs.getString(2) + " \t"
                        + jdbcRs.getString(3));
                if (jdbcRs.getInt("student_id") == 3) {
                    // 修改指定记录
                    jdbcRs.updateString("student_name", "孙悟空");
                    jdbcRs.updateRow();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        RowSetFactoryTest rsf = new RowSetFactoryTest();
        rsf.initParam("mysql.properties");
        rsf.update("select * from student_table");
    }
}
