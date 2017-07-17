//package cn.taike.mongo;
//
//import cn.taike.entity.Book;
//import cn.taike.jpa.BookJpaRepository;
//import cn.taike.mongo.jpa.BookMongoRepository;
//import com.google.common.collect.Maps;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.act.Page;
//import org.springframework.data.act.PageRequest;
//import org.springframework.data.act.Pageable;
//import org.springframework.data.act.Sort;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Map;
//
//
///**
// * Created by huayandong on 17/6/2.
// */
//@RestController
//public class MongoController {
//
//    @Autowired
//    private BookMongoRepository bookMongoRepository;
//
//    @Autowired
//    private BookJpaRepository bookJpaRepository;
//
//    @RequestMapping(value = "/save/mongo", method = RequestMethod.POST)
//    public Map<String, String> saveMongo() {
//        Map<String, String> msg = Maps.newHashMap();
//        try {
//            Integer startPage = 2;
//            Integer pageSize = 3;
//            Pageable pageable = new PageRequest(startPage, pageSize, new Sort(Sort.Direction.DESC, "id"));
//            Page<Book> pageBook = bookJpaRepository.findAll(pageable);
//            List<Book> bookContent = pageBook.getContent();
//            bookMongoRepository.save(bookContent);
//            System.out.println("保存成功！");
//
//            msg.put("SUCCESS", "YES");
//        } catch (Exception e) {
//            msg.put("SUCCESS", "NO");
//            e.printStackTrace();
//        }
//        return msg;
//    }
//
//    //查找mongo
//    @RequestMapping(value = "/save/single/mongo")
//    public Map<String, String> singleSaveMongo() {
//        Map<String, String> msg = Maps.newHashMap();
//        try {
//            Book book = new Book();
//            book.setBookName("北京初二上口语练习题6");
//            book.setProjectName("/share/svn/广州口语考试/北京初二上口语练习题6.xlsx");
//            book.setType("STUDENT");
//            book.setId(12);
//            bookMongoRepository.save(book);
//
//            System.out.println("文档保存成功");
//            msg.put("SUCCESS", "YES");
//        } catch (Exception e) {
//            msg.put("SUCCESS", "NO");
//            e.printStackTrace();
//        }
//        return msg;
//    }
//
//    //更新mongo中文档数据
//    @RequestMapping(value = "/update/mongo/data")
//    public Map<String, String> updateMongoData() {
//        Map<String, String> msg = Maps.newHashMap();
//        try {
//            //根据id获得文档
//            Book one = bookMongoRepository.findOne(12);
//            one.setId(66);
//
//            //将修改后的文档添加的数据库中
//            bookMongoRepository.save(one);
//            bookMongoRepository.delete(12);
//            System.out.println("文档更新成功");
//
//            msg.put("SUCCESS", "YES");
//        } catch (Exception e) {
//            msg.put("SUCCESS", "NO");
//            e.printStackTrace();
//        }
//        return msg;
//    }
//}
