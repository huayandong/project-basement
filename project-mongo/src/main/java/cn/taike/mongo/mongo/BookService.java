package cn.taike.mongo.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huayandong on 17/7/27.
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void insertBook(Book book){
        bookRepository.insert(book);
    }


}
