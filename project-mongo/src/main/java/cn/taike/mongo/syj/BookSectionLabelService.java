package cn.taike.mongo.syj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huayandong on 17/7/27.
 */
@Service
public class BookSectionLabelService {

    @Autowired
    private BookSectionLabelJpaRepository bookSectionLabelJpaRepository;

    public void saveBookSectionLabel(String lesson, String level, String type) {

        BookSectionLabel bookSectionLabel = new BookSectionLabel();
        bookSectionLabel.setLesson(lesson);
        bookSectionLabel.setLevel(level);
        bookSectionLabel.setType(type);
        bookSectionLabelJpaRepository.save(bookSectionLabel);
    }
}
