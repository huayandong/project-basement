package cn.taike.mongo.mongoTemplate.both;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by huayandong on 17/8/25.
 */
public interface PaperMongoRepository extends MongoRepository<PaperEntity, Long> {

}
