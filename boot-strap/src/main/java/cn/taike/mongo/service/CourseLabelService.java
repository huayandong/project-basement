package cn.taike.mongo.service;

import cn.taike.mongo.entity.CourseContentLabel;
import cn.taike.mongo.entity.PrintEntity;
import cn.taike.mongo.entity.SentenceLabel;
import cn.taike.mongo.repository.CourseContentLabelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * Created by huayandong on 17/7/26.
 */
@Service
public class CourseLabelService {

    @Resource(name = "courseContentLabelRepository")
    private CourseContentLabelRepository courseContentLabelRepository;

    private String savePath = "/Users/huayandong/Desktop/test";
    private ObjectMapper objectMapper = new ObjectMapper();

    public void labelService() {
        List<CourseContentLabel> allCourseLabel = courseContentLabelRepository.findAll();
        Set<PrintEntity> allSet = Sets.newHashSet();

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
