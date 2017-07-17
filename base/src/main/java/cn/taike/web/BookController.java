package cn.taike.web;

import cn.taike.entity.Book;
import cn.taike.jpa.BookJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by huayandong on 17/5/18.
 */
@RestController
public class BookController {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    //jpa的增加方法
    @RequestMapping(value = "/save/entity", method = RequestMethod.POST)
    public Map<String, String> addEntity() {
        Map<String, String> map = new HashMap<>();

        Book book = new Book();
        book.setBookName("单词对对碰之pretty");
        book.setProjectName("share/svn/人教八下/单词对对碰之pretty");
        book.setType("STUDENT");
        bookJpaRepository.save(book);

        map.put("SUCCESS", "Y");
        return map;
    }

    //统计数据表中数据
    @RequestMapping(value = "/count/value", method = RequestMethod.GET)
    public Map<String, String> getCount() {
        Map<String, String> map = new HashMap<>();

        //统计表中记录数：条件统计
//        Long countById = bookJpaRepository.countDistinctById(1);
//        Long countByStudent = bookJpaRepository.countDistinctByType("STUDENT");

        //自定义SQL，统计全部数据
        //Integer total = bookJpaRepository.totalCount();

        //jpa自带方法，统计全部记录
        long total2 = bookJpaRepository.count();


        map.put("TOTAL", String.valueOf(total2));
//        map.put("COUNT BY CONDITION", String.valueOf(countByStudent));
        return map;
    }

    //jpa的分页查询
    @RequestMapping(value = "/query/page", method = RequestMethod.GET)
    public Map<String, String> queryByPage() {
        Map<String, String> map = new HashMap<>();

        Integer startPage = 1;
        Integer pageSize = 3;
        Set<Book> set = new HashSet<>();

        Sort sort = new Sort(Sort.Direction.DESC, "id", "bookName");

        //Sort.Direction 将要查询的排序，值得是先排序，然后再查询,properties必须要写，就必须存在，否则报错
        Pageable pageable = new PageRequest(startPage, pageSize, sort);

        Page<Book> queryByPage = bookJpaRepository.findAll(pageable);

        long totalElements = queryByPage.getTotalElements();//总个数
        int totalPages = queryByPage.getTotalPages();//总页数

        queryByPage.forEach(book -> {
            set.add(book);
            String bookName = book.getBookName();
            String projectName = book.getProjectName();
            System.out.println("ID:" + book.getId() + "书名：" + bookName + ",项目名:" + projectName);
        });

        System.out.println("打印:" + set.toString());
        map.put("总个数", String.valueOf(totalElements));
        map.put("页面数", String.valueOf(totalPages));
        return map;
    }

    //jpa的分页查询
    @RequestMapping(value = "/delete/book", method = RequestMethod.POST)
    public Map<String, String> deleteBook() {
        Map<String, String> map = new HashMap<>();
        try {
            //根据参数删除表中的数据，如果存在就删除，如果不存在就报错！！"EmptyResultDataAccessException"
            bookJpaRepository.delete(2);
            map.put("SUCCESS", "Y");
        } catch (Exception e) {
            map.put("SUCCESS", "N");
            map.put("MESSAGE", e.getMessage());
        }
        return map;
    }

    //查找前10个
    @RequestMapping(value = "/query/book", method = RequestMethod.GET)
    public Map<String, String> sliceQuery() {
        Map<String, String> map = new HashMap<>();
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(0, 2, sort);

//            SliceImpl<Book> first = bookJpaRepository.findTop2ByType("STUDENT", pageable);
//            List<Book> content = first.getContent();
//            content.forEach(book -> {
//                System.out.println("bookName:" + book.getBookName());
//                System.out.println("bookType" + book.getType());
//            });
//            int numberOfElements = first.getNumberOfElements();
//            int number = first.getNumber();
//            int size = first.getSize();
//


//            map.put("RESULT", first.toString());
            map.put("SUCCESS", "Y");
            return map;
        } catch (Exception e) {
            map.put("SUCCESS", "N");
            map.put("MESSAGE", e.getMessage());
        }
        return map;
    }
}
