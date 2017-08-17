package cn.taike.mongo.recognition.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by huayandong on 17/8/16.
 */
@Repository
public class PaperDistinctRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PaperRecognitionEntity> findEntity(Long userId, String pageId, String paperId) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PaperRecognitionEntity> query = builder.createQuery(PaperRecognitionEntity.class);
        Root<PaperRecognitionEntity> root = query.from(PaperRecognitionEntity.class);

        query
                .select(root)
                .distinct(true)
                .where(
                        builder.and(
                                builder.equal(root.get("userId"), userId),
                                builder.equal(root.get("paperId"), paperId),
                                builder.equal(root.get("pageId"), pageId)
                        )
                )
                .orderBy(
                        builder.desc(root.get("updateTime"))
                )
        ;
        return entityManager.createQuery(query).getResultList();
    }

    public List<String> findDistinctPageIdByUserIdAndPaperId(Long userId, String paperId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);
        Root<PaperRecognitionEntity> root = query.from(PaperRecognitionEntity.class);

        query
                .select(root.get("pageId"))
                .distinct(true)
                .where(
                        builder.and(
                                builder.equal(root.get("userId"), userId),
                                builder.equal(root.get("paperId"), paperId)
                        )
                )
                .orderBy(
                        builder.desc(root.get("updateTime"))
                )
        ;
        return entityManager.createQuery(query).getResultList();
    }
}
