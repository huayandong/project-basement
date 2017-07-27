package cn.taike.mongo.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayandong on 17/7/27.
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/add")
    public void insert() {
        Book book = new Book("1234", "一起来刷牙", "/幼儿园课程/一起来刷牙.xlsx", "TEACHER", 23.7);
        bookService.insertBook(book);
    }

    @RequestMapping(value = "/book/hello")
    public String hello() {
        return "hello mongo";
    }

}
