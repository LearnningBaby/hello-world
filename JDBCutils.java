package utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCutils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {

        try {
            Properties pro = new Properties();

            //不知为何我找不到资源通过调用下面的方法淦!
            //现在知道了,类加载器只能找到src下的文件.
            ClassLoader classLoader = JDBCutils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            //System.out.println(path);
            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * @param rs   查询结果集合,调用next() 让游标下移,并判断当前行是否是最后一行,获取数据,将每行按属性分列,通过getXXx();获取
     * @param stmt 执行,静态sql
     *             容易造成sql的内渗 不安全
     *             以后都用PreparedStatement 是 Statement 的子类,可以执行动态sql ,不会出现内渗,安全.
     * @param conn
     */
    public static void close1(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
