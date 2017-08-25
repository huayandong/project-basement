package cn.taike.mongo.mongoTemplate.both;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by huayandong on 17/8/25.
 */
@Data
@Document(collection = "paper_collection")
@TypeAlias("PaperRecognition")

@Entity
@Table(name = "table_paper")
public class PaperEntity {

    @Id
    private Long id;

    private String paperName;
    private String paperId;
    private String pageId;

    private String questions;
    private String answer;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updateTime;
}
