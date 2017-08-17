package cn.taike.mongo.database.jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by huayandong on 17/7/27.
 */
@Component
public class CourseDao {

    private QueryRunner queryRunner = new QueryRunner();

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    public void saveLessonName(String bookSectionId, String courseLevel, String courseType, String courseTypeV2) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO book_section_label (bookSectionId,level,type,courseTypeV2) VALUE (?,?,?,?)";
            queryRunner.insert(conn, sql, new ArrayHandler(), bookSectionId, courseLevel, courseType, courseTypeV2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
