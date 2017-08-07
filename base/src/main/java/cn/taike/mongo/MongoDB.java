package cn.taike.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;

/**
 * Created by huayandong on 17/6/1.
 */
@Deprecated
public class MongoDB {

    @Resource
    private MongoTemplate mongoTemplate;



}
