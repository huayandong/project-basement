package cn.taike.mongo.yun;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by huayandong on 17/7/26.
 */
@Service
public class CourseLabelService {

    @Autowired
    private CourseContentLabelJpaRepository courseContentLabelJpaRepository;

    private String savePath = "/Users/huayandong/Desktop/test";
    private ObjectMapper objectMapper = new ObjectMapper();

    //剔除集合中重复的元素
    public void check() {
        List<CourseContentLabel> list = courseContentLabelJpaRepository.findAll();

        List<String> sourceList = list.stream()
                .map(CourseContentLabel::getBookSectionId)
                .collect(toList());
        List<String> anotherList = sourceList;

        List<String> sourceListDistinct = sourceList.stream().distinct().collect(toList());

        ListIterator<String> iterator = sourceListDistinct.listIterator();
        while (iterator.hasNext()) {
            String id = iterator.next();
            anotherList.remove(id);
        }

        Set<String> collect = anotherList.stream().distinct().collect(toSet());

        try {
            Path path = Paths.get(savePath, "重复的id2333333.json");
            objectMapper.writeValue(path.toFile(), collect);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("done!!...");

    }


    public void labelService() {
        List<CourseContentLabel> allCourseLabel = courseContentLabelJpaRepository.findAll();
        Set<PrintEntity> allSet = new HashSet<>();

        Set<String> sentencePattern = new HashSet<>();
        String bookSectionId;
        String courseName;

        for (CourseContentLabel label : allCourseLabel) {
            int i = 0;

            PrintEntity entry = new PrintEntity();

            bookSectionId = label.getBookSectionId();
            courseName = label.getBookSectionName();
            sentencePattern = label.getSentenceLabels()
                    .stream()
                    .map(SentenceLabel::getTheSentencePattern)
                    .collect(toSet());

            entry.setBookSectionId(bookSectionId);
            entry.setCourseName(courseName);
            entry.setSentencePattern(sentencePattern);
            allSet.add(entry);

            i++;
            System.out.println("计数：" + i);
        }

        try {
            Path path = Paths.get(savePath, "theSentencePattern.json");
            objectMapper.writeValue(path.toFile(), allSet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("done!!...");
    }

}
