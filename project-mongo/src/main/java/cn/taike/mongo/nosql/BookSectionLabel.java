package cn.taike.mongo.nosql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by huayandong on 17/7/27.
 */
@Entity
@Table(name = "book_section_label")
public class BookSectionLabel {

    @Id
    private String id;
//    private String lesson;
    private String level;
    private String type;

    private String courseTypeV2;


    public String getCourseTypeV2() {
        return courseTypeV2;
    }

    public void setCourseTypeV2(String courseTypeV2) {
        this.courseTypeV2 = courseTypeV2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getLesson() {
//        return lesson;
//    }
//
//    public void setLesson(String lesson) {
//        this.lesson = lesson;
//    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
