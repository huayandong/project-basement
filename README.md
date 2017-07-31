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