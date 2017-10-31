package cn.taike.mongo.paper;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "paper_info",
        indexes = {
                @Index(name = "index_paperId", columnList = "paperId", unique = true)
        }
)
public class PaperInfoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String paperId;
    @Column
    private String paperName;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updateTime;

}
