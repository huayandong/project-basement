package cn.taike.mongo.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huayandong on 17/7/26.
 */
public class PrintEntity {

    private Set<String> sentencePattern = new HashSet<>();
    private String bookSectionId;
    private String courseName;

    public Set<String> getSentencePattern() {
        return sentencePattern;
    }

    public void setSentencePattern(Set<String> sentencePattern) {
        this.sentencePattern = sentencePattern;
    }

    public String getBookSectionId() {
        return bookSectionId;
    }

    public void setBookSectionId(String bookSectionId) {
        this.bookSectionId = bookSectionId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
