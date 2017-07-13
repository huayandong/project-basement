package cn.taike.page.dao;

import cn.taike.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by huayandong on 17/5/25.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
