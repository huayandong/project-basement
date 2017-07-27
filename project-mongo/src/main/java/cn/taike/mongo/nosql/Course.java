package cn.taike.mongo.nosql;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by huayandong on 17/7/27.
 */

@Document(collection = "course_new")
public class Course {

    @Id
    private String id;
    private String bookSectionId;
    private List<String> courseLevel;
    private List<String> courseType;
    private List<String> courseTypeV2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookSectionId() {
        return bookSectionId;
    }

    public void setBookSectionId(String bookSectionId) {
        this.bookSectionId = bookSectionId;
    }

    public List<String> getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(List<String> courseLevel) {
        this.courseLevel = courseLevel;
    }

    public List<String> getCourseType() {
        return courseType;
    }

    public void setCourseType(List<String> courseType) {
        this.courseType = courseType;
    }

    public List<String> getCourseTypeV2() {
        return courseTypeV2;
    }

    public void setCourseTypeV2(List<String> courseTypeV2) {
        this.courseTypeV2 = courseTypeV2;
    }
}
