package cn.taike.page.dao;

import cn.taike.entity.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by huayandong on 17/5/26.
 */
@Named
public class PageDao {

    @Named("dataSource")
    @Inject
    private DataSource dataSource;

    private QueryRunner queryRunner = new QueryRunner();

    //查询总记录数
    public Integer queryCount() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT COUNT(1) FROM book";
            Object query = queryRunner.query(conn, sql, new ScalarHandler<>(1));
            return Integer.valueOf(String.valueOf(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查询数据
    public List<Book> pageQueryList(Integer startIndex, Integer pageSize) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT b.id,b.book_name AS bookName,b.project_name AS projectName," +
                    "b.type FROM book b ORDER BY b.id limit ?,? ";
            List<Book> bookList = queryRunner.query(conn,
                    sql,
                    new BeanListHandler<>(Book.class),
                    startIndex, pageSize);
            return bookList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
