package cn.taike.mongo.database.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by huayandong on 17/7/27.
 */
public interface BookSectionJpaRepository extends JpaRepository<BookSection, Integer> {

    BookSection findAllById(Integer id);

    @Query(value = "SELECT DISTINCT book.type FROM book", nativeQuery = true)
    List<String> findAllType();

    @Transactional  //提交事务
    @Modifying(clearAutomatically = true)   //自动清除实体类中保存的数据
    @Query(value = "UPDATE book b SET b.video = ?1 WHERE b.type = ?2", nativeQuery = true)
    int insertVideoByType(String video, String type);

}
