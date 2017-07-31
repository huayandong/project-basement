/*
package cn.taike.jpa;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

*/
/**
 * Created by huayadlly on 17/7/28.
 *//*

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
public class DataSourceConfig {

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "secondaryDataSource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

}
*/


/*
yml配置文件中

---
spring:
    profiles: development
    datasource:
        primary:
            url: jdbc:mysql://。。。。。。。:3306/bebase?useUnicode=true&characterEncoding=utf8
            username: ....
            password: ....
        secondary:
            url: jdbc:mysql://。。。。。。。:3306/statistic?useUnicode=true&characterEncoding=utf8
            username: ....
            password: ....
        thirdary:
            url: jdbc:mysql://。。。。。。。:3306/bebase?useUnicode=true&characterEncoding=utf8
            username: ...
            password: ckp4hNEup7wfLV2
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
