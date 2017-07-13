package cn.taike.mongo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mongodb.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * Created by huayandong on 17/5/27.
 */
@Slf4j
public class TestMongoDB {

    public static void mongoDB() {
        try {
            Mongo mongo = new Mongo();
            DB mydb = mongo.getDB("mydb");
            DBCollection col = mydb.getCollection("col");

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("title", "MongoDB");
            DBCursor dbObjects = col.find(searchQuery);
            System.out.println("======A=====");
            while (dbObjects.hasNext()) {
                DBObject obj = dbObjects.next();
                Object title = obj.get("title");
                Object description = obj.get("description");
                Object tags = obj.get("tags");

                System.out.println(title);
                System.out.println(description);
                System.out.println(tags);
            }
            System.out.println("done");
            log.info("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveDocument() {
        try {
            Mongo mongo = new Mongo();
            DB mydb = mongo.getDB("mydb");
            DBCollection col = mydb.getCollection("col_test");

            BasicDBObject document = new BasicDBObject();
            document.put("title", "Action In MongoDB Edit 2");
            document.put("msg", "mongo开发手册");
            Map<String, String> map = Maps.newHashMap();
            map.put("book_name", "MongoDB");
            map.put("book_author", "Bob");
            map.put("book_cover", "/picture/cover/mongo.jpg");
            document.put("book_info", map);
            List<String> list = Lists.newArrayList("Spring Data MongoDB", "JPA", "JavaScript");
            document.put("books", list);
            col.insert(document);
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        saveDocument();
    }
}
