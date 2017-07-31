package cn.taike.mongo.nosql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huayandong on 17/7/27.
 */
@Service
public class CourseService {

    @Autowired
    CourseJpaRepository courseJpaRepository;

    @Autowired
    CourseDao courseDao;

    public void queryAllCourse() {
        List<Course> courseList = courseJpaRepository.findAll();

        int size = courseList.size();
        System.out.println("total:" + size);

        try {
            int count = size;
            for (Course course : courseList) {
                count--;

                String bookSectionId = course.getBookSectionId();

                String courseLevel = null;
                if (course.getCourseLevel() != null && course.getCourseLevel().size() != 0) {
                    courseLevel = course.getCourseLevel().get(0);
                }

                String courseType = null;
                if (course.getCourseType() != null && course.getCourseType().size() != 0) {
                    courseType = course.getCourseType().get(0);
                }

                String courseTypeV2 = null;
                if (course.getCourseTypeV2() != null && course.getCourseTypeV2().size() != 0) {
                    courseTypeV2 = course.getCourseTypeV2().get(0);
                }

                courseDao.saveLessonName(bookSectionId, courseLevel, courseType, courseTypeV2);

                System.out.println("计数：" + count);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
