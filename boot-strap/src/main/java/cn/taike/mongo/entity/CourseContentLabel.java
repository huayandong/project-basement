package cn.taike.mongo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by huayandong on 17/7/26.
 */
@Data
@Document(collection = "course_content_label")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CourseContentLabel {

    @Id
    @JsonIgnore
    private String id;

    private String bookSectionId;

    private String bookSectionName;

    private List<SentenceLabel> sentenceLabels = Lists.newArrayList();

}
