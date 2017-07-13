package cn.taike.page;

import cn.taike.entity.Book;
import cn.taike.page.dao.BookRepository;
import cn.taike.page.dao.PageDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Created by huayandong on 17/5/25.
 */
@RestController
public class PageController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PageDao pageDao;

    private ObjectMapper objectMapper = new ObjectMapper();
    private Integer startPage = 1;
    private Integer pageSize = 3;

    @RequestMapping(value = "/page/query", method = RequestMethod.GET)
    public Map<String, String> pageQuery() {

        Map<String, String> map = Maps.newHashMap();

        try {
            Pageable pageable = new PageRequest(startPage, pageSize, new Sort(Sort.Direction.DESC, "id"));
            Page<Book> page = bookRepository.findAll(pageable);

            PageUtils pageUtils = new PageUtils(page);
            String pageJson = objectMapper.writeValueAsString(pageUtils);

            Path path = Paths.get("/test/Hellen", "pageJson.json");
            objectMapper.writeValue(path.toFile(), pageUtils);

            Path path2 = Paths.get("/test/Hellen", "pageJson_bak.json");
            FileUtils.writeStringToFile(path2.toFile(), pageJson);

            map.put("SUCCESS", "YES");
        } catch (Exception e) {
            map.put("SUCCESS", "NO");
            map.put("MSG", e.toString());
            e.printStackTrace();
        }
        return map;
    }


    @RequestMapping(value = "/page/query/db", method = RequestMethod.GET)
    public Map<String, String> pageQueryByDBUtils() {

        Map<String, String> map = Maps.newHashMap();

        try {
            //查询表中总记录数
            Integer totalCount = pageDao.queryCount();
            Integer startIndex = (startPage - 1) * pageSize;
            //查数据
            List<Book> bookList = pageDao.pageQueryList(startIndex, pageSize);
            PageUtils pageUtils = new PageUtils(startPage, pageSize, startIndex, totalCount, bookList);
            String pageJson = objectMapper.writeValueAsString(pageUtils);

            Path path = Paths.get("/test/Hellen", "pageJson_dbUtils.json");
            objectMapper.writeValue(path.toFile(), pageUtils);

            Path path2 = Paths.get("/test/Hellen", "pageJson_bak_dbUtils.json");
            FileUtils.writeStringToFile(path2.toFile(), pageJson);

            map.put("SUCCESS", "YES");
        } catch (Exception e) {
            map.put("SUCCESS", "NO");
            map.put("MSG", e.toString());
            e.printStackTrace();
        }
        return map;
    }
}
