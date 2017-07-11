package ch13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by scn on 2017/7/11.
 * 使用ResultSetMetaData分析结果集
 */
public class QueryExecuter {
    JFrame jf = new JFrame("查询执行器");
    private JScrollPane scrollPane;
    private JButton execBn = new JButton("查询");
    private JTextField sqlField = new JTextField(45);
    private static Connection conn;
    private static Statement stmt;
    // 静态初始化块
    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("mysql.properties"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String pwd = props.getProperty("pwd");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
            stmt = conn.createStatement();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    // 初始化界面的方法
    public void init() {
        JPanel top = new JPanel();
        top.add(new JLabel("输入查询语句："));
        top.add(sqlField);
        top.add(execBn);
        // 为执行按钮、单行文本框添加事件监听器
        execBn.addActionListener(new ExecListener());
        sqlField.addActionListener(new ExecListener());
        jf.add(top, BorderLayout.NORTH);
        jf.setSize(740,480);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    //定义监听器
    class ExecListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // 删除原来的JTable
            if (scrollPane != null) {
                jf.remove(scrollPane);
            }
            try (
                    // 根据用户输入的SQL语句执行查询
                    ResultSet rs = stmt.executeQuery(sqlField.getText())
                    ) {
                // 取出ResultSet的Metadata
                ResultSetMetaData rsmd = rs.getMetaData();
                Vector<String> columnNames = new Vector<>();
                Vector<Vector<String>> data = new Vector<>();
                // 把ResultSet的所有列名添加到Vector里
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    columnNames.add(rsmd.getColumnName(i + 1));
                }
                // 把ResultSet的所有记录添加到Vector里
                while (rs.next()) {
                    Vector<String> v = new Vector<>();
                    for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        v.add(rs.getString(i + 1));
                    }
                    data.add(v);
                }
                // 创建新的JTable
                JTable table = new JTable(data, columnNames);
                scrollPane = new JScrollPane(table);
                // 添加新的Table
                jf.add(scrollPane);
                jf.validate();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new QueryExecuter().init();
    }
}

