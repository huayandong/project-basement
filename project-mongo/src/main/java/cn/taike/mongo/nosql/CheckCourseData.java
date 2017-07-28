package cn.taike.mongo.nosql;

import cn.taike.mongo.syj.BookSectionLabel;
import cn.taike.mongo.syj.BookSectionLabelJpaRepository;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by huayandong on 17/7/27.
 */
@Component
public class CheckCourseData {

    private static final Logger log = LoggerFactory.getLogger(CheckCourseData.class);

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Autowired
    private BookSectionLabelJpaRepository bookSectionLabelJpaRepository;

    public void doCheckData() {

        //mongo
        List<Course> allFromMongo = courseJpaRepository.findAll();
        //mysql
        List<BookSectionLabel> allFromMysql = bookSectionLabelJpaRepository.findAll();

        if (allFromMongo.size() == allFromMysql.size()) {
            log.info("mongo中的数据与mysql中的数据相同，不需要同步");
            return;
        } else {

            for (Course course : allFromMongo) {
                String bookSectionId = course.getBookSectionId();
                String courseLevel = course.getCourseLevel().get(0);
                String typeV2 = course.getCourseTypeV2().get(0);

                BookSectionLabel bookSectionLabel = null;
                try {
                    //根据 bookSectionId 从mysql中得到
                    bookSectionLabel = allFromMysql.stream()
                            .filter(item -> bookSectionId.equals(item.getLesson()))
                            .findFirst()
                            .get();
                } catch (NoSuchElementException e) {
                    //当从 allFromMysql 集合中得不到数据的时候会抛出 NoSuchElementException
                    //此时需要同步数据  TODO
                    synchronizeMongoToMysql(bookSectionId, courseLevel, typeV2);
                    return;
                }

//                String lessonId = bookSectionLabel.getLesson();
                String level = bookSectionLabel.getLevel();
                String type = bookSectionLabel.getType();

                if (StringUtils.equals(courseLevel, level) && StringUtils.equals(typeV2, type)) {
                    //mongo中的level type都和mysql中的相等，不用同步
                    return;
                } else {
                    //不都相等，需要同步 TODO
                    synchronizeMongoToMysql(bookSectionId, courseLevel, typeV2);
                }
            }
            log.info("同步完成！");
        }
    }


    public void synchronizeMongoToMysql(String bookSectionId, String courseLevel, String typeV2) {
        BookSectionLabel bookSectionLabel =
                bookSectionLabelJpaRepository.findByBookSectionId(bookSectionId);
        String type;
        if (bookSectionLabel != null) {
            //"不为空" update
            bookSectionLabelJpaRepository.updateBookSectionLabel(courseLevel, typeV2, bookSectionId);
            type = "UPDATE";
        } else {
            //"为空" INSERT
            bookSectionLabelJpaRepository.insertBookSectionLabel(bookSectionId, courseLevel, typeV2);
            type = "INSERT";
        }
        log.info("同步一次,id为:[{}],同步方式为:[{}]", bookSectionId, type);
    }
}
