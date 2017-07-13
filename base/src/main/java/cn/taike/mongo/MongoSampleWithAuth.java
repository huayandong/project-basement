package cn.taike.mongo;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

/**
 * Created by huayandong on 17/6/23.
 */
public class MongoSampleWithAuth {

    private static final String HOST = "localhost";
    private static final Integer PORT = 27017;
    private static final String USER_NAME = "bookRoot";
    private static final String PASSWORD = "123456";
    private static final String DATABASE_NAME = "book";

    //权限认证方式连接mongodb服务--连接读写权限账号
    public static void testMongodb() {
        try {
            ServerAddress serverAddress = new ServerAddress(HOST, PORT);
            List<ServerAddress> serverList = Lists.newArrayList(serverAddress);

            MongoCredential credential = MongoCredential.createCredential(USER_NAME,
                    DATABASE_NAME, PASSWORD.toCharArray());
            List<MongoCredential> credentials = Lists.newArrayList(credential);

            //通过连接认证获取MongoDB连接
//            MongoClient client = new MongoClient(serverAddress, credentials);
            MongoClient client = new MongoClient(serverList, credentials);
            System.out.println("获取连接成功");

            MongoDatabase database = client.getDatabase(DATABASE_NAME);
            MongoCollection<Document> bookSection = database.getCollection("book_section");
            System.out.println("选择文档成功");

            //创建文档
            Document document = new Document();
            document.append("_id", "hello_mongodb");
            document.append("name", "人教八下后语考试之单词口语练习.xlsx");
            document.append("project_name", "/share/svn/人教八下口语练习/人教八下后语考试之单词口语练习.xlsx");
            document.append("book_id", "6032");
            document.append("tags", Lists.newArrayList("口语", "口语练习", "人教八下"));

            List<Document> list = Lists.newArrayList(document);
            bookSection.insertMany(list);
            System.out.println("文档插入成功！");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //权限认证 -- 连接只读账号
    public static void teatMongoRead() {
        try {
            ServerAddress address = new ServerAddress(HOST, PORT);
            List<ServerAddress> list = Lists.newArrayList(address);

            MongoCredential credential = MongoCredential.createCredential("bookSectionAdmin", "bookSection", "123456".toCharArray());
            List<MongoCredential> credentialList = Lists.newArrayList(credential);

            MongoClient client = new MongoClient(list, credentialList);
            System.out.println("数据库连接成功");

            MongoDatabase bookSection = client.getDatabase("bookSection");
            System.out.println("获得数据库成功");

            MongoCollection<Document> book_section = bookSection.getCollection("book_section");
            System.out.println("获得文档成功");

            Document document = new Document();
            document.append("_id", "1233");
            document.append("name", "insert test");
            List<Document> documentsList = Lists.newArrayList(document);
            book_section.insertMany(documentsList);
//            book_section.insertOne(document);
            System.out.println("测试插入成功");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        teatMongoRead();
//        testMongodb();
    }
}
