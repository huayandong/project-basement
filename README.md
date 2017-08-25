# project-basement
Personal project, just fun for author.

## Version
1. 2017/07/10:发布1.0版本
2. 2017/07/14:发布2.0版本
3. 2017/07/17:发布3.0/3.1版本
4. 2017/07/19:发布3.2版本
5. 2017/07/31:发布4.1版本

## 1.StringUtils.isEmpty() 与 StringUtils.isBlank()区别
1.1 isEmpty() : 判断字符串是否为空，当字符串为null、""时返回为true,当字符串为" "、"abc"时返回为false;<br/>
1.2 isBlank() : 判断字符串是否为空白，当字符串为null、""、" "时，返回为true,当字符串为"abc"时，返回为false;<br/>
1.3 isAnyBlank() : 判断参数可以是多个字符串，当多个字符串都满足isBlank()是返回true;<br/>
1.4 isNoneBlank() : 判断参数可以是多个字符串，底层逻辑是对isAnyBlank()取反;<br/>
1.5 isAnyEmpty() : 多个字符串参数，都满足isEmpty()是返回true;<br/>
1.6 isNoneEmpty() : 多个字符串参数，底层是对isAnyEmpty()取反;<br/>

## 2.集合是否为空的判断
2.1 单列集合(Set/List)判断使用CollectionUtils.isEmpty(Set/List set/list);<br/>
2.2 双列集合(Map)判断使用MapUtils.isEmpty(Map map);<br/>

## 3.数组为空的判断
3.1 判断数组是否为空，使用ArrayUtils.isEmpty(Object[] array);<br/>

## 4.spring-ioc操作
4.1 使用配置文件的方式，完成spring对bean的创建和管理;<br/>
4.2 通过配置文件，向bean对象中注入数组、集合、map等，以及注入其他对象;<br/>

## 5.spring-aop操作
5.1 使用配置文件小试面向切面操作;<br/>
5.2 注解方式使用向实现aop操作;<br/>
5.3 增强类中的方法实现aop;<br/>

## 6.重新管理项目
6.1 重新构建项目，新建maven子项目;<br/>

## 7.spring boot中使用定时任务
7.1 修改入口程序中使用<code>@EnableScheduling</code>注解实现定时任务:
<pre><code>import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }
}
</code></pre>

7.2 创建定时任务类，并使用<code>@Scheduled</code>实现定时任务;
<pre><code>@Component  //将定时任务类加入到spring容器中
public class MyTimer {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000)  //每隔3秒中指定一次
    public void timerRate() {
        System.out.println(sdf.format(new Date()));
    }
}
</code></pre>

## 8.Java8
8.1 Java8中stream的使用;<br/>
8.2 Java8中函数式接口的使用;<br/>

## 9.Spring Data的使用
9.1 Spring Data Mongodb<br />
(1).暂不使用权限的配置方式，在<code>.yml</code>配置文件中添加配置:<code>spring.data.mongodb.uri: mongodb://127.0.0.1:27017/basement</code>;<br/>
(2).创建实体类，使用spring提供的注解实现实体类与collection的映射:<br/>
<pre><code>import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "paper_collection")                                       // 对应mongodb数据库中的集合名称
@TypeAlias("PaperRecognition")
@CompoundIndexes(                                                                // 向集合中添加索引
        @CompoundIndex(name = "index_id_paperName_paperId", def = "{'id':1,'paperName':1,'paperId':1}", unique = true)
)
public class PaperEntity {

    @Id
    private Long id;

    private String paperName;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")      // 在实体类中使用joda.time需要使用注解指定对应的类型
    private DateTime createTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updateTime;
}
</code></pre>
(3).定义接口，继承<code>MongoRepository<PaperEntity, Long></code>即可;<br />

9.2 Spring Data Jpa<br />
(1).在<code>.yml</code>配置文件中添加基本的数据库连接信息之外，还要添加<code>hibernate</code>的配置信息和连接池的配置信息;<br />
<pre><code>spring:
  datasource:
      url: jdbc:mysql://127.0.0.1:3306/basement?useUnicode=true&characterEncoding=utf8
      username: root
      password: boxfish123
      driver-class-name: com.mysql.jdbc.Driver
      
      initial-size: 1                       // ⏬ 数据库连接池配置信息
      max-active: 20
      max-idle: 20
      test-on-connect: true
      test-while-idle: true
      validation-query: SELECT 1
      timeBetweenEvictionRunsMillis: 3600000
      min-evictable-idle-time-millis: 3600000


spring.jpa:                                 // ⏬ hibernate配置信息
    show-sql: true
    generate-ddl: true
    hibernate.ddl-auto: update
    hibernate.naming_strategy: org.hibernate.cfg.ImprovedNamingStrategy
    database-platform: org.hibernate.dialect.MySQL5Dialect
</code></pre>
(2).创建与变关系映射的实体类:<br />
<pre><code>import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "paper_table_test",
        indexes = {
                @Index(name = "index_userId_paperId_pageId", columnList = "userId,paperId,pageId", unique = true)
        }
)
public class PaperRecognitionEntity {
    @Id                                 // 标识主键
    @GeneratedValue                     // 标识主键自增
    private Long id;

    @Column                             // 标识数据表中的列:默认将Java中的驼峰命名转换成下划线间隔
    private Long userId;

    @Column(columnDefinition = "TEXT")  // 标识数据表中文本的存储格式
    private String devRecognition;
    @Column(columnDefinition = "TEXT")

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")         // joda.time时间格式
    private DateTime createTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updateTime;
}
</code></pre>
(3).定义接口，继承<code>JpaRepository<PaperRecognitionEntity, Long></code>即可;<br />

9.3 使用Spring Data实现分页查询:<br />
<pre><code>
    public void findByPage() {
        Pageable pageable = new PageRequest(0, 2, Sort.Direction.DESC, "bookName");     // jpa提供的分页接口，参数为:(起始页，每页显示记录数，排序(升/降)，排序依靠的字段）
        Page<BookSectionEntity> pages = bookSectionMongoRepository.findAll(pageable);

        List<BookSectionEntity> pageContent = pages.getContent();
        System.out.println("count: " + pageContent);
        long totalElements = pages.getTotalElements();                                  // 查询到的元素总个数
        int totalPages = pages.getTotalPages();                                         // 总页数
        int currentPageNumber = pages.getNumber();                                      // 当前页

    }
</code></pre>

9.4 当mongoDB与mysql使用同一个实体类的时候:<br />
(1).在启动类中添加注解配置:
<pre><code>import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = org.springframework.data.jpa.repository.JpaRepository.class)})
@EnableMongoRepositories(includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = org.springframework.data.mongodb.repository.MongoRepository.class)})
public class MongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }
}
</code></pre>
(2).在实体类中只需要同时添加mongo和mysql的注解即可
<pre><code>import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data

@Document(collection = "UserCollection")
@TypeAlias("User")

@Entity
@Table(name = "test_table")
public class UserEntity {

    @Id
    private Long id;
    private String name;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dateTime;

}
</code></pre>

## 10.Microsoft Service

## 11.mq