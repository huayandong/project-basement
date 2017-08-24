package cn.taike.mongo.mongoTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by huayandong on 17/8/22.
 */
@Service
public class StudentService {

    @Autowired
    private StudentEntityMongoRepository studentEntityMongoRepository;

    @Autowired
    private BookSectionMongoRepository bookSectionMongoRepository;

    public void addStudent() {

        StudentEntity entity = new StudentEntity();
        entity.setId(123L);
        entity.setName("Jerry");
        entity.setPassword("boxfish");
        entity.setAddress("china");

        studentEntityMongoRepository.save(entity);
    }


    public void addBookSection() {

        BookSectionEntity entity = new BookSectionEntity();
        entity.setId(12349L);
        entity.setBookName("002.funny.xlsx");
        entity.setProjectName("/share/svn/幼儿园课程/002.funny.xlsx");
        entity.setType("STUDENT");
        entity.setCover("/cover/funny.jpg");

        bookSectionMongoRepository.save(entity);
    }

    public void findAll() {
        List<BookSectionEntity> allList = bookSectionMongoRepository.findAll();
        System.out.println("个数：" + allList.size());
        allList.forEach(bookSectionEntity -> {
            System.out.println("bookSectionName: " + bookSectionEntity.getBookName());
        });
    }

    public void findByName(String bookName) {
        Optional<BookSectionEntity> optEntity = bookSectionMongoRepository.findByBookName(bookName);
        if (optEntity.isPresent()) {
            BookSectionEntity entity = optEntity.get();
            System.out.println(entity);
        }
    }
}
