package cn.taike.mongo.yun;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huayandong on 17/7/26.
 */
@Document(collection = "course_content_label")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CourseContentLabel {

    @Id
    @JsonIgnore
    private String id;

    private String bookSectionId;

    private String bookSectionName;

    private List<SentenceLabel> sentenceLabels = new ArrayList<>();

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

    public String getBookSectionName() {
        return bookSectionName;
    }

    public void setBookSectionName(String bookSectionName) {
        this.bookSectionName = bookSectionName;
    }

    public List<SentenceLabel> getSentenceLabels() {
        return sentenceLabels;
    }

    public void setSentenceLabels(List<SentenceLabel> sentenceLabels) {
        this.sentenceLabels = sentenceLabels;
    }
}
