package cn.taike.mongo.mongoTemplate.both;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huayandong on 17/8/25.
 */
public interface PaperMysqlRepository extends JpaRepository<PaperEntity, Long> {

}
