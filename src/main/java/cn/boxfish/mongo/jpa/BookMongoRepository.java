package cn.boxfish.mongo.jpa;

import cn.boxfish.mongo.entity.BookSection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/6/2.
 */
@Component
public interface BookMongoRepository extends MongoRepository<BookSection,Integer> {
}
