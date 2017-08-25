package cn.taike.mongo.mongoTemplate;

import cn.taike.mongo.mongoTemplate.both.PaperEntity;
import cn.taike.mongo.mongoTemplate.both.PaperMongoRepository;
import cn.taike.mongo.mongoTemplate.both.PaperMysqlRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    @Autowired
    private PaperMongoRepository paperMongoRepository;

    @Autowired
    private PaperMysqlRepository paperMysqlRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<String> testMongoTemplate() {
        Query query = new Query();
        query.addCriteria(Criteria.where("paperId").is("BOXFISH"));
        long count = mongoTemplate.count(query, PaperEntity.class);
        System.out.println(count);
        return null;

    }

    public void saveMySqlAndMongo() {
        System.out.println("start print ...");

        PaperEntity paperEntity = new PaperEntity();

        paperEntity.setId(11123L);
        paperEntity.setPaperName("英语学习");
        paperEntity.setPageId("1");
        paperEntity.setPaperId("BOXFISH");
        paperEntity.setQuestions("这是问题");
        paperEntity.setAnswer("这是答案");
        DateTime nowTime = DateTime.now();
        paperEntity.setCreateTime(nowTime);
        paperEntity.setUpdateTime(nowTime);

        paperMongoRepository.save(paperEntity);
        System.out.println("save mongo ...");

        paperMysqlRepository.save(paperEntity);
        System.out.println("save mysql ...");
    }

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


    public void findByPage() {
        Pageable pageable = new PageRequest(0, 2, Sort.Direction.DESC, "bookName");
        Page<BookSectionEntity> pages = bookSectionMongoRepository.findAll(pageable);

        List<BookSectionEntity> pageContent = pages.getContent();
        System.out.println("count: " + pageContent);
        long totalElements = pages.getTotalElements();   // 查询到的元素总个数
        int totalPages = pages.getTotalPages();          // 总页数
        int currentPageNumber = pages.getNumber();       // 当前页

    }

    public void findByName(String bookName) {
        Optional<BookSectionEntity> optEntity = bookSectionMongoRepository.findByBookName(bookName);
        if (optEntity.isPresent()) {
            BookSectionEntity entity = optEntity.get();
            System.out.println(entity);
        }
    }
}
