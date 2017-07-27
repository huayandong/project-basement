package cn.taike.mongo;

import cn.taike.entity.SentenceLabel;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static java.util.stream.Collectors.toSet;

/**
 * Created by huayandong on 17/7/26.
 */
public class CourseLabels {

    private static final Logger logger = LoggerFactory.getLogger(CourseLabels.class);

    public static void connMongo() {
        try {
            //连接到mongo服务
            ServerAddress serverAddress = new ServerAddress("127.0.0.1", 27017);
            List<ServerAddress> addr = new ArrayList<>();
            addr.add(serverAddress);

            MongoCredential scramSha1Credential = MongoCredential.createScramSha1Credential(
                    "***",
                    "****",
                    "****".toCharArray()
            );

            List<MongoCredential> credentials = new ArrayList<>();
            credentials.add(scramSha1Credential);

            //通过连接认证获得Mongo连接
            MongoClient mongoClient = new MongoClient(addr, credentials);

            //连接到数据库
            MongoDatabase mydb = mongoClient.getDatabase("beqp");
            System.out.println("Connection to database successfully");
            logger.info("Connection to database successfully");

            //得到集合 course_content_label
            MongoCollection<Document> courseContentLabel = mydb.getCollection("course_content_label");

            Set<String> sentencePattern = new HashSet<>();

            //遍历集合course_content_label 中的元素
            MongoCursor<Document> iterator = courseContentLabel.find().iterator();
            while (iterator.hasNext()) {
                Document document = iterator.next();
                Object sentenceLabelsObj = document.get("sentenceLabels");

                if (sentenceLabelsObj instanceof List) {
                    System.out.println("flag: sentenceLabelsObj is belong List");

                    List<SentenceLabel> labelList = (List<SentenceLabel>) sentenceLabelsObj;
                    sentencePattern = labelList.stream()
                            .map(SentenceLabel::getTheSentencePattern)
                            .filter(StringUtils::isNotBlank)
                            .collect(toSet());

                }
                //判断set集合是否为空
                if (sentencePattern != null && sentencePattern.size() != 0) {
                    String bookSectionId = String.valueOf(document.get("bookSectionId"));
                    String courseName = String.valueOf(document.get("courseName"));
                }

            }

        } catch (Exception e) {
            logger.error("Fail to connection to database");
        }
    }


    public static void main(String[] args) {
        connMongo();
    }

}
