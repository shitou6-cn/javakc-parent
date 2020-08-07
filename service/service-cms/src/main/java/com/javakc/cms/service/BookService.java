package com.javakc.cms.service;

import com.javakc.cms.dao.BookDao;
import com.javakc.cms.entity.Book;
import com.javakc.cms.entity.BookQuery;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends BaseService<BookDao, Book> {
    @Autowired
    private BookDao bookDao;


    /**
     * 查询所有书籍
     * @return
     */
    public List<Book> findBook() {
        return dao.findAll();
    }

    /**
     * 根据条件进行分页查询
     * @param bookQuery
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Book> findPageBook(BookQuery bookQuery, int pageNo , int pageSize) {
        System.out.println("++++++++++++++"+bookQuery);
        Specification<Book> specification = new SimpleSpecificationBuilder().and("bookName", ":", bookQuery.getTitle()).getSpecification();
        return dao.findAll(specification, PageRequest.of(pageNo - 1, pageSize));
    }

}
