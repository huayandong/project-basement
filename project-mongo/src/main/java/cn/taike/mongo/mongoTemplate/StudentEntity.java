package cn.taike.mongo.mongoTemplate;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Created by huayandong on 17/8/22.
 */
@Data
@Document(collection = "student_collection")
public class StudentEntity {

    @Id
    private Long id;

    private String name;
    private String password;
    private String address;

}
