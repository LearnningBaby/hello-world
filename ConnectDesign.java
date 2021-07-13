package Design;

import Elements.Administrator;
import Elements.Employee;
import Elements.Salary;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.scene.Parent;
import utils.JDBCutils;

import javax.swing.text.StyledEditorKit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员拥有 对数据库的增,删,查,改 权限.
 * 普通员工只有查询权限;
 */


public class ConnectDesign {

    public static List<Object> execute(String sql) {
        int index = 0;
        List<Object> list = new ArrayList<>();
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = JDBCutils.getConnection();
            stmt = conn.createStatement();
            boolean exe = stmt.execute(sql);
            if (exe) {
                rs = stmt.getResultSet();
                String[] s = sql.split(" ");
                for (int i = 0; i < s.length; ++i) {
                    if (s[i].equals("from")) {
                        index = i;
                        break;
                    }
                }
                String table = s[index + 1];

                if (table.equals("employees")) {
                    while (rs.next()) {
                        list.add(new Employee(rs.getString("ID"), rs.getString("password"),
                                rs.getString("name"), rs.getString("sex"), rs.getInt("age"), rs.getDate("entry_date")));
                    }

                } else if (table.equals("salary")) {
                    while (rs.next()) {
                        list.add(new Salary(rs.getString("ID"), rs.getString("name"), rs.getDate("paydate"),
                                        rs.getFloat("should_send"), rs.getFloat("taken"), rs.getFloat("overtime_pay"),
                                        rs.getFloat("leave_deduct"), rs.getFloat("sick_deduct"),
                                        rs.getFloat("income_tax"), rs.getFloat("state_tax"), rs.getFloat("medical_insurance"),
                                        rs.getFloat("retirement_insurance"), rs.getFloat("advance_payment"), rs.getFloat("real_wages"), rs.getString("bank_account"),
                                        rs.getString("bank_type")
                                )
                        );

                    }
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCutils.close1(rs, stmt, conn);
        }
        return list;

    }

    /**
     * 不需要开启事务 select
     *
     * @param ID    通过ID查找 如果查找全部 让`ID的 值为 %
     * @param table 表的名称
     * @return 查询结果list集合
     */
    public static List<Object> select(String ID, String table) {
        List<Object> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = JDBCutils.getConnection();
            String sql = null;
            if (ID.equals("%")) {
                sql = "select * from" + " " + table + " where ID like ? ";
            } else {
                sql = "select * from" + " " + table + " where ID = ? ";
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ID);
            rs = pstmt.executeQuery();

            if (table.equals("employees")) {
                while (rs.next()) {
                    list.add(new Employee(rs.getString("ID"), rs.getString("password"),
                            rs.getString("name"), rs.getString("sex"), rs.getInt("age"), rs.getDate("entry_date")));
                }

            } else if (table.equals("salary")) {
                while (rs.next()) {
                    list.add(new Salary(rs.getString("ID"), rs.getString("name"), rs.getDate("paydate"),
                                    rs.getFloat("should_send"), rs.getFloat("taken"), rs.getFloat("overtime_pay"),
                                    rs.getFloat("leave_deduct"), rs.getFloat("sick_deduct"),
                                    rs.getFloat("income_tax"), rs.getFloat("state_tax"), rs.getFloat("medical_insurance"),
                                    rs.getFloat("retirement_insurance"), rs.getFloat("advance_payment"), rs.getFloat("real_wages"), rs.getString("bank_account"),
                                    rs.getString("bank_type")
                            )
                    );

                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCutils.close1(rs, pstmt, conn);
        }
        return list;
    }


    /**
     * @param table_name 登录需要的查询的表名;
     * @param ID         用户名;
     * @param password   密码;
     * @return 查询成功登录成功;
     */
    public static boolean login(String table_name, String ID, String password) {
        if (ID == null || password == null) return false;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = JDBCutils.getConnection();
            String sql = "select * from" + " " + table_name + " where ID = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ID);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCutils.close1(rs, pstmt, conn);
        }
        return false;
    }


}
