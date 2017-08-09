package cn.taike.jdbc.template;

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

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseUtils.close(rs, pst, conn);
        }

    }

    public void jdbcDelete() {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            String sql = "DELETE FROM book WHERE book_name = ? AND type = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, "fat mat cat");
            pst.setString(2, "TEACHER");
            int i = pst.executeUpdate();
            System.out.println("删除成功？: " + i);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseUtils.close(rs, pst, conn);
        }

    }


    public static void main(String[] args) {

        JdbcSample jdbcSample = new JdbcSample();
        jdbcSample.jdbcDelete();

    }

}
