package cn.taike.mongo.recognition.domain;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by huayandong on 17/8/10.
 */
@Data
@Entity
@Table(
        name = "paper",
        indexes = {
                @Index(name = "index_pageId", columnList = "pageId", unique = true)}
)
public class PaperInfoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String paperId;
    @Column
    private String paperName;

    @Column
    private String bookId;
    @Column
    private String bookName;

    @Column
    private String pageId;

    @Column(columnDefinition = "TEXT")
    private String questionText;

    @Column(columnDefinition = "TEXT")
    private String answerAndAreas;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updateTime;
}
