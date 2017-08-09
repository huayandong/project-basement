package cn.taike.jdbc.template;

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

    private static DriverManagerDataSource dataSource = new DriverManagerDataSource();

    static {
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);
    }

    //统计记录数
    public void queryCount() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT COUNT(1) FROM book";

        //int count = (int) jdbcTemplate.queryForObject(sql, Integer.class); //统计：14
        int count = jdbcTemplate.queryForObject(sql, Integer.class); //统计：14

        System.out.println("统计：" + count);
    }

    //查询对象集合
    public void queryBookList() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT b.* FROM book b ";

        List<Book> bookList = jdbcTemplate.query(sql, new myRowMapper());

        bookList.forEach(System.out::println);

    }

    //查询对象
    public void queryEntity() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT b.* FROM book b WHERE id = ?";

        Book book = (Book) jdbcTemplate.queryForObject(sql, new Object[]{9}, new myRowMapper());
        System.out.println(book);

    }

    //自定义封装对象
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

    public void insertBook() {

    }

    public static void main(String[] args) {

        JdbcTemplateSample jdbcTemplateSample = new JdbcTemplateSample();

        jdbcTemplateSample.queryCount();
        System.out.println("-------");
        jdbcTemplateSample.queryBookList();
        System.out.println("-------");
        jdbcTemplateSample.queryEntity();
    }

}
