package cn.taike.mongo.database.mysql;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by huayandong on 17/7/27.
 */
@Data
@Entity
@Table(
        name = "book",
        indexes = {
                @Index(name = "index_bookName_projectName", columnList = "bookName,projectName", unique = true)
        }
)
public class BookSection {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String bookName;
    @Column
    private String projectName;
    @Column
    private String type;
    @Column
    private String cover;
    @Column
    private String video;

}
