package cn.taike.mongo;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huayandong on 17/5/31.
 */
@Slf4j
public class MongoJava {

    private static final String HOST = "localhost";
    private static final Integer PORT = 27017;

    //连接数据库
    public static void mongoJdbc() {
        try {
            //连接到mongodb服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            //连接到数据库
            MongoDatabase mydb = mongoClient.getDatabase("mydb");
            log.info("Connection to database successfully");

        } catch (Exception e) {
            log.error("Fail to connection to database");
            e.printStackTrace();
        }
    }

    //通过用户名和密码访问mongo服务
    public static void mongoAuthentic() {
        try {
            //连接到mongo服务
            ServerAddress serverAddress = new ServerAddress("localhost", 27017);
            List<ServerAddress> addr = new ArrayList<>();
            addr.add(serverAddress);

            MongoCredential scramSha1Credential = MongoCredential.createScramSha1Credential(
                    "username",
                    "databaseName",
                    "password".toCharArray()
            );

            List<MongoCredential> credentials = new ArrayList<>();
            credentials.add(scramSha1Credential);

            //通过连接认证获得Mongo连接
            MongoClient mongoClient = new MongoClient(addr, credentials);

            //连接到数据库
            MongoDatabase mydb = mongoClient.getDatabase("mydb");
            log.info("Connection to database successfully");

        } catch (Exception e) {
            log.error("Fail to connection to database");
            e.printStackTrace();
        }
    }

    //操作集合
    public static void mongoModitify() {
        try {
            //连接到mongodb服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            //连接到数据库
            MongoDatabase mydb = mongoClient.getDatabase("mydb");
            log.info("Connection to database successfully");

            //创建集合
            //mydb.createCollection("test_col");
            //log.info("集合创建成功！");

            //获取集合
            MongoCollection<Document> collection = mydb.getCollection("test_col");
            log.info("选择集合collection");

            //创建文档，将文档添加到集合中，插入到mongo
            Document document = new Document();
            document.append("title", "mongo_java2");
            document.append("description", "mongo_database");
            document.append("likes", 200);
            document.append("by", "Fly");
//            document.append("tags", "java,PHP,BOXFiSH");
            document.append("tags", Lists.newArrayList("Java", "PHP", "BOXFiSH"));
            List<Document> documentsList = Lists.newArrayList(document);

            collection.insertMany(documentsList);
            log.info("文档插入成功！");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //检索所有文档
    public static void mongoIndex() {
        //连接到mingo服务
        MongoClient client = new MongoClient("localhost", 27017);
        //连接到数据库
        MongoDatabase mydb = client.getDatabase("mydb");
        log.info("Connection to database successfully");

        MongoCollection<Document> collection = mydb.getCollection("test_col");

        //更新文档：将文档中likes = 100的文档修改成likes = 200
        collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));


        //检索文档
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            Document next = iterator.next();
            System.out.println(next);
        }
    }


    //删除一个文档
    public static void mongoDelete() {
        //连接到mongo服务
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase mydb = client.getDatabase("mydb");
        MongoCollection<Document> collection = mydb.getCollection("test_col");
        log.info("Connection to database successfully");

        //删除符合条件的第一个文档
//        collection.deleteOne(Filters.eq("likes", 200));
        //删除符合条件的所有文档
        collection.deleteMany(Filters.eq("likes", 98));

        //检索查看删除结果
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            Document next = iterator.next();
            System.out.println(next);
        }

    }

    public static void mongo_demo() {
        //连接mongo服务
        MongoClient client = new MongoClient(HOST, PORT);
        MongoDatabase mydb = client.getDatabase("mydb");//获得mongo中的数据库

        //创建集合
//        mydb.createCollection("book_col");
//        log.info("创建集合成功");

        //从库中获得集合
        MongoCollection<Document> book_col = mydb.getCollection("book_col");

        //向集合中添加文档
        Document document = new Document();
        document.append("title", "How to Learn Mongo");
        document.append("description", "a book to learn mongo");
        document.append("likes", 89);
        document.append("tags", Lists.newArrayList("Java", "PHP", "C#"));
        List<Document> docList = Lists.newArrayList(document);

        book_col.insertMany(docList);
        log.info("向集合中添加文档 成功！");

    }



    public static void main(String[] args) {
        mongo_demo();
    }

}
