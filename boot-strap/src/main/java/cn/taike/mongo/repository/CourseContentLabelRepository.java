package cn.taike.mongo.repository;

import cn.taike.mongo.entity.CourseContentLabel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by huayandong on 17/7/26.
 */
public interface CourseContentLabelRepository extends MongoRepository<CourseContentLabel, String> {
}
