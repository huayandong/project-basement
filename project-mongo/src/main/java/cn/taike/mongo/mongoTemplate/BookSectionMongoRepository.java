package cn.taike.mongo.mongoTemplate;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by huayandong on 17/8/24.
 */
public interface BookSectionMongoRepository extends MongoRepository<BookSectionEntity, Long> {

    Optional<BookSectionEntity> findByBookName(String bookName);

}
