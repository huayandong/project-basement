package cn.taike.page;


import cn.taike.entity.Book;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by huayandong on 17/5/25.
 */
@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageUtils {

    @JsonProperty(value = "total_count")
    private Integer totalCount;//总记录数

    @JsonProperty(value = "total_page")
    private Integer totalPage;//总页数

    @JsonProperty(value = "page_size")
    private Integer pageSize;//每页显示记录数

    @JsonProperty(value = "start_page")
    private Integer startPage;//起始页

    @JsonProperty(value = "start_index")
    private Integer startIndex;//起始查询位置

    @JsonProperty(value = "content_list")
    private List<Book> contentList = Lists.newArrayList();

    public PageUtils() {
    }

    public PageUtils(Page<Book> page) {
        this.startPage = page.getNumber();
        this.pageSize = page.getSize();
        this.startIndex = (startPage - 1) * pageSize;
        this.totalCount = new Long(page.getTotalElements()).intValue();
        this.contentList = page.getContent();

        //写法1:判断比较方式
        if (totalCount % pageSize == 0) {
            this.totalPage = totalCount / pageSize;
        } else {
            this.totalPage = (totalCount / pageSize) + 1;
        }

        //写法2:三元表达式方式
        this.totalPage = (totalCount % pageSize == 0) ? totalCount / pageSize : (totalCount / pageSize) + 1;

        //写法3:maths工具类方式---注意:将double转换成Integer类型的方式
        this.totalPage = new Double(Math.ceil(Double.valueOf(totalCount) / pageSize)).intValue();

        //写法4:jpa方式分页查询统计总页数
        this.totalPage = page.getTotalPages();

    }

    public PageUtils(Integer startPage, Integer pageSize, Integer startIndex, Integer totalCount, List<Book> bookList) {
        this.startPage = startPage;
        this.pageSize = pageSize;
        this.startIndex = startIndex;
        this.totalCount = totalCount;
        this.contentList = bookList;
        this.totalPage = (totalCount % pageSize == 0) ? totalCount / pageSize : (totalCount / pageSize) + 1;
    }

}
