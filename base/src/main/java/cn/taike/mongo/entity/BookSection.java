package cn.taike.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by huayandong on 17/6/26.
 */
@Data
@Document(collection = "book_section")
public class BookSection {

    @Id
    private Integer id;

    private String bookName;

    private String projectName;

    private String type;
}
