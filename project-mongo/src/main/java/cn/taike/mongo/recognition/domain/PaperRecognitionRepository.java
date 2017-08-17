package cn.taike.mongo.recognition.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by huayandong on 17/8/14.
 */
public interface PaperRecognitionRepository extends JpaRepository<PaperRecognitionEntity, Long> {

    Optional<PaperRecognitionEntity> findByUserIdAndPaperIdAndPageId(Long userId, String paperId, String pageId);

    @Query(value = "SELECT DISTINCT(paper_id) FROM paper_table_test WHERE user_id = ?1", nativeQuery = true)
    List<String> selectDistinctPaperId(Long userId);

    @Query(value = "SELECT paper_name FROM paper_table_test WHERE user_id = ?1 AND paper_id = ?2", nativeQuery = true)
    Optional<String> selectDistinctPaperName(Long userId, String paperId);

    List<PaperRecognitionEntity> findByUserIdAndPaperId(Long userId, String paperId);
}
