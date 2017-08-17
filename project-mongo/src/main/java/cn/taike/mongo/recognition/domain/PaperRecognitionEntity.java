package cn.taike.mongo.recognition.domain;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by huayandong on 17/8/14.
 */
@Data
@Entity
@Table(
        name = "paper_table_test",
        indexes = {
                @Index(name = "index_userId_paperId_pageId", columnList = "userId,paperId,pageId", unique = true)
        }
)
public class PaperRecognitionEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long userId;
    @Column
    private String paperId;
    @Column
    private String pageId;
    @Column
    private String paperName;
    @Column
    private String taskId;

    @Column(columnDefinition = "TEXT")
    private String devRecognition;
    @Column(columnDefinition = "TEXT")
    private String devWords;
    @Column(columnDefinition = "TEXT")
    private String recImages;
    @Column(columnDefinition = "TEXT")
    private String recQas;

    @Column(columnDefinition = "TEXT")
    private String evaluation;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updateTime;


}
