package cn.taike.myBatis;

import cn.taike.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by huayandong on 17/8/10.
 */
public class SampleTest {

    private static final String RESOURCE = "SqlMapConfig.xml";
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream stream = Resources.getResourceAsStream(RESOURCE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //统计表中记录数
    public void selectCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Integer count = sqlSession.selectOne("selectBookCount");
        System.out.println("数量: " + count);

        sqlSession.close();
    }

    //根据id查询对象
    public void queryBookById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Book book = sqlSession.selectOne("queryBookById", 3);
        System.out.println("BOOK: " + book);

        sqlSession.close();
    }


    public static void main(String[] args) {

        SampleTest sample = new SampleTest();

        sample.selectCount();
        sample.queryBookById();

    }


}
