package cn.taike.dao;


import cn.taike.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by huayandong on 17/8/4.
 */
public class JdbcTemplateSample {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basement?useUnicode=true&characterEncoding=utf8";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "boxfish123";
    private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    public void queryCount() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT COUNT(1) FROM book";

//        int count = (int) jdbcTemplate.queryForObject(sql, Integer.class); //统计：14
        int count = jdbcTemplate.queryForInt(sql); //统计：14

        System.out.println("统计：" + count);
    }

    public void queryBookList() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT b.* FROM book b ";

        List<Book> bookList = jdbcTemplate.query(sql, new myRowMapper());

        bookList.forEach(System.out::println);

    }


    class myRowMapper implements RowMapper {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            return new Book(rs.getInt("id"),
                    rs.getString("book_name"),
                    rs.getString("project_name"),
                    rs.getString("type"),
                    rs.getString("cover"),
                    rs.getString("video")
            );
        }
    }

    public static void main(String[] args) {

        JdbcTemplateSample jdbcTemplateSample = new JdbcTemplateSample();
//        jdbcTemplateSample.queryCount();
        jdbcTemplateSample.queryBookList();
    }

}
