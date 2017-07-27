package cn.taike.mongo.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by huayandong on 17/7/27.
 */
@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
