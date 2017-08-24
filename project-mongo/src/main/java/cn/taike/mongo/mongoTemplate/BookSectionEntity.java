package cn.taike.mongo.mongoTemplate;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Created by huayandong on 17/8/24.
 */
@Data
@Document(collection = "book_Section_collection")
public class BookSectionEntity {

    @Id
    private Long id;

    private String bookName;
    private String projectName;
    private String type;
    private String cover;

    @Override
    public String toString() {
        return "BookSectionEntity{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", type='" + type + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}
