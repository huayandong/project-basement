package cn.taike.mongo.nosql;

import cn.taike.mongo.syj.BookSectionLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by huayandong on 17/7/27.
 */
@Repository
public interface BookSectionLabelJpaRepository extends JpaRepository<BookSectionLabel, Long> {
}
