package cn.taike.mongo.mongoTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huayandong on 17/8/22.
 */
@Service
public class StudentService {

    @Autowired
    private StudentEntityMongoRepository studentEntityMongoRepository;

    public void addStudent() {

        StudentEntity entity = new StudentEntity();
        entity.setId(123L);
        entity.setName("Jerry");
        entity.setPassword("boxfish");
        entity.setAddress("china");

        studentEntityMongoRepository.save(entity);
    }
}
