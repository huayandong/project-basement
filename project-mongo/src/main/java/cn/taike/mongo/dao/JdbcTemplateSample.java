package cn.taike.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/7/31.
 */
@Component
public class JdbcTemplateSample {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertBook() {

        String sql = "INSERT INTO book (book_name,project_name,type,cover,video) VALUE (?,?,?,?,?)";
        jdbcTemplate.update(sql, "fat mat cat", "/幼儿园/cat", "STUDENT", "/cover/fat.jpg", "CAT.m4v");
    }

    public void updateCover() {
        String sql = "UPDATE book SET video = ? WHERE type = ?";

//        String sql = "UPDATE book SET cover = ? WHERE cover IS null";
        jdbcTemplate.update(sql, "student.mp4", "STUDENT");
    }

    public void deleteBookSection() {
        String sql = "DELETE FROM book WHERE type IS null";
        jdbcTemplate.update(sql);
    }
}
