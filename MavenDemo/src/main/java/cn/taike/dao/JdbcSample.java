package cn.taike.dao;

import java.sql.*;

/**
 * Created by huayandong on 17/8/4.
 */
public class JdbcSample {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basement?useUnicode=true&characterEncoding=utf8";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "boxfish123";

    public void testJdbc() {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//            String sql = "SELECT COUNT(*) AS sizes FROM book"; //统计表中总记录数
            String sql = "INSERT INTO book(id,book_name,project_name,type,cover,video) VALUES(?,?,?,?,?,?)";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, 16);
            pst.setString(2, "吃饼干");
            pst.setString(3, "/share/svn/幼儿园课程/吃饼干.xlsx");
            pst.setString(4, "STUDENT");
            pst.setString(5, "/cover/吃饼干.jpg");
            pst.setString(6, "student.mp4");
            int i = pst.executeUpdate();
            System.out.println("插入成功？: " + i);
//            while (rs.next()) {
//                int sizes = rs.getInt("sizes");
//                System.out.println(sizes);
//            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }


    }


    public static void main(String[] args) {
        new JdbcSample().testJdbc();

    }

}
