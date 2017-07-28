package cn.taike.mongo.syj;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by huayandong on 17/7/27.
 */
@Repository
public interface BookSectionLabelJpaRepository extends JpaRepository<BookSectionLabel, Integer> {

    //根据BookSectionId查询
    @Query(value = "SELECT b.id,b.lesson,b.level,b.type FROM book_section_label b WHERE b.lesson = ?1", nativeQuery = true)
    BookSectionLabel findByBookSectionId(String lesson);

    //update
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE book_section_label b SET b.level = ?1,b.type = ?2 WHERE b.lesson = ?3", nativeQuery = true)
    void updateBookSectionLabel(String courseLevel, String typeV2, String bookSectionId);

    //INSERT
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO book_section_label(lesson,level,type) VALUES (?1,?2,?3)", nativeQuery = true)
    void insertBookSectionLabel(String lesson, String level, String type);


}
