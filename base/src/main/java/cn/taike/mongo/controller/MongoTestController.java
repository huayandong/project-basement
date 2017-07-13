package cn.taike.mongo.controller;

import cn.taike.mongo.entity.BookSection;
import cn.taike.mongo.jpa.BookMongoRepository;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by huayandong on 17/6/23.
 */
@Controller
public class MongoTestController {

    @Value("${mongodb.server.host}")
    private String host;

    @Value("${mongodb.server.port}")
    private Integer port;

    @Autowired
    private BookMongoRepository bookMongoRepository;


    //mongodb方式操作数据
    @RequestMapping(value = "/test/mongo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> testMongoJpa() {
        Map<String, String> msg = Maps.newHashMap();
        try {

            ServerAddress address = new ServerAddress(host, port);
            MongoCredential credential = MongoCredential.createScramSha1Credential("bookRoot", "book", "123456".toCharArray());
            List<MongoCredential> list = Lists.newArrayList(credential);

            //获得连接
            MongoClient client = new MongoClient(address, list);
            MongoDatabase bookDb = client.getDatabase("book");
            MongoCollection<Document> book_section = bookDb.getCollection("book_section");

            //定义文档
            Document document = new Document();
            document.append("book_name", "北京初二上口语练习题6");
            document.append("project_name", "/share/svn/广州口语考试/北京初二上口语练习题6.xlsx");
            document.append("type", "STUDENT");
            document.append("_id", 1233);
            book_section.insertOne(document);


            System.out.println("主机：" + host + ", 端口号：" + port);
            System.out.println("DONE");
            msg.put("SUCCESS", "YES");
        } catch (Exception e) {
            msg.put("SUCCESS", "NO");
            e.printStackTrace();
        }
        return msg;
    }

    //spring data mongodb方式插入数据
    @RequestMapping(value = "/test/mongo/insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> insertData() {
        Map<String, String> msg = Maps.newHashMap();
        try {

            BookSection book = new BookSection();
            book.setBookName("北京初二上口语练习题6");
            book.setProjectName("/share/svn/广州口语考试/北京初二上口语练习题6.xlsx");
            book.setType("STUDENT");
            book.setId(124);
            bookMongoRepository.save(book);

            msg.put("success", "YES");
        } catch (Exception e) {
            msg.put("success", "NO");
            e.printStackTrace();
        }
        return msg;
    }


}
