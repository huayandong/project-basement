package cn.taike.mongo.recognition.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by huayandong on 17/8/14.
 */
public interface PaperRecognitionRepository extends JpaRepository<PaperRecognitionEntity, Long> {

    Optional<PaperRecognitionEntity> findByUserIdAndPaperIdAndPageId(Long userId, String paperId, String pageId);
}
