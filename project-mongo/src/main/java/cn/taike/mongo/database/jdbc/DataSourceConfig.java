package cn.taike.mongo.database.jdbc;

/**
 * Created by huayandong on 17/3/13.
 */

/**
 * 多数据源配置，打开注解即可
 */

//@Configuration
//@EnableConfigurationProperties
//@EnableAutoConfiguration
//public class DataSourceConfig {
//
//    @Bean(name = "primaryDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.primary")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "secondaryDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.secondary")
//    public DataSource secondaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//
//    @Bean(name = "thirdaryDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.thirdary")
//    public DataSource thirdaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}



/*
yml配置文件中

---
spring:
    profiles: development
    datasource:
        primary:
            url: jdbc:mysql://192.168.0.100:3306/bebase?useUnicode=true&characterEncoding=utf8
            username: bebase
            password: boxfish
        secondary:
            url: jdbc:mysql://192.168.0.100:3306/statistic?useUnicode=true&characterEncoding=utf8
            username: 888
            password: 888
        thirdary:
            url: jdbc:mysql://127.0.0.1/bebase?useUnicode=true&characterEncoding=utf8
            username: 888
            password: 888
*/



/*
在dao类中，注入指定的数据源

import javax.annotation.Resource;
import javax.inject.Inject;
public class CountDao{

    @Inject
    @Resource(name = "secondaryDataSource")
    DataSource dataSource;
}
*/