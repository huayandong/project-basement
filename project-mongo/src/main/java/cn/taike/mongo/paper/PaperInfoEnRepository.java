package cn.taike.mongo.paper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaperInfoEnRepository extends JpaRepository<PaperInfoEntity, Long> {

    List<PaperInfoEntity> findByPaperId(String paperId);
}
