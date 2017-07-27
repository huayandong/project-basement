package cn.taike.mongo.mysql;

import cn.taike.mongo.syj.BookSectionLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by huayandong on 17/7/27.
 */
@RestController
public class BookSectionController {

    @Autowired
    private BookSectionJpaRepository bookSectionJpaRepository;

    @RequestMapping(value = "/add/book/section")
    public void addBookSection() {
        try {
            BookSection bookSection = new BookSection();
            bookSection.setBookName("一起来刷牙");
            bookSection.setProjectName("/幼儿园课程/一起来刷牙");
            bookSection.setCover("/cover/一起来刷牙.jpg");
            bookSection.setType("STUDENT");
            bookSectionJpaRepository.save(bookSection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询前五条
    @RequestMapping(value = "/query/first/5")
    public Object findFirst5() {
        try {
//            List<BookSection> book_name = bookSectionJpaRepository.findAll(new Sort(Sort.Direction.DESC, "type"));

            //根据ID来查询
//            BookSection allById = bookSectionJpaRepository.findAllById(9);
//
//            //查询课程类型
//            List<String> allType = bookSectionJpaRepository.findAllType();
//
            //更新表中记录
            bookSectionJpaRepository.insertVideoByType("teacher.mp4", "TEACHER");

            return "123";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "nooo";
    }
}
