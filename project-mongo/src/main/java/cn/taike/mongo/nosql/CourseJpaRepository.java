package cn.taike.mongo.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by huayandong on 17/7/27.
 */
public interface CourseJpaRepository extends MongoRepository<Course,String> {

}
