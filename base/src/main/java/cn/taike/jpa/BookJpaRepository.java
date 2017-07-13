package cn.taike.jpa;

import cn.taike.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huayandong on 17/5/18.
 */
@Repository
public interface BookJpaRepository extends JpaRepository<Book, Integer> {

    //保存
//    Book save(Book book);

    Long countDistinctById(Integer id);

    Long countDistinctByType(String type);

//    @Query(value = "SELECT COUNT(1) FROM book", nativeQuery = true)
//    Integer totalCount();

    //CrudRepository接口中自带的方法，继承的JpaRepository中继承CrudRepository,可以直接调用
//    long count();

    //分页查询









    SliceImpl<Book> findTop2ByType(String type,Pageable pageable);



}
