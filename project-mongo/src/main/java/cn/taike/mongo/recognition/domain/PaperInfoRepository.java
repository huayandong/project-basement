package cn.taike.mongo.recognition.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by huayandong on 17/8/10.
 */
public interface PaperInfoRepository extends JpaRepository<PaperInfoEntity, Long> {

    List<PaperInfoEntity> findByPaperId(String paperId);

    Optional<PaperInfoEntity> findByBookIdAndPageId(String bookId, String pageId);

    Optional<PaperInfoEntity> findByPageId(String pageId);
}
