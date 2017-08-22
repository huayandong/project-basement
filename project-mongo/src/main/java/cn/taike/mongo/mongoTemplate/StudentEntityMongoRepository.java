package cn.taike.mongo.mongoTemplate;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by huayandong on 17/8/22.
 */
public interface StudentEntityMongoRepository extends MongoRepository<StudentEntity, Long> {


}
