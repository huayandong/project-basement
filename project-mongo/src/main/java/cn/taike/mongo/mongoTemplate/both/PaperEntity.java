package cn.taike.mongo.mongoTemplate.both;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * Created by huayandong on 17/8/25.
 */
@Data
@Document(collection = "paper_collection")
@TypeAlias("PaperRecognition")
@CompoundIndexes(
        @CompoundIndex(name = "index_id_paperName_paperId", def = "{'id':1,'paperName':1,'paperId':1}", unique = true)
)

@Entity
@Table(
        name = "table_paper",
        indexes = {
                @Index(name = "index_paperName_paperId", columnList = "paperName,paperId", unique = true)
        }
)
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
