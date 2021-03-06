package com.javakc.cms.controller;

import com.javakc.cms.entity.Book;
import com.javakc.cms.entity.BookQuery;
import com.javakc.cms.service.BookService;
import com.javakc.commonutils.api.APICODE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "书籍管理")
@RestController
//解决跨域访问问题
@CrossOrigin
@RequestMapping("/cms/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "查询所有书籍")
    @GetMapping
    public APICODE findBook() {
        List<Book> bookList = bookService.findBook();
        return APICODE.OK().data("items", bookList);
    }

    @ApiOperation(value = "根据条件进行分页查询")
    @PostMapping("{pageNo}/{pageSize}")
    public APICODE findPageBook(BookQuery bookQuery, @PathVariable int pageNo, @PathVariable int pageSize) {
        System.out.println("============="+bookQuery);
        Page<Book> page = bookService.findPageBook(bookQuery, pageNo, pageSize);
        long totalElements = page.getTotalElements();
        List<Book> bookList = page.getContent();
        return APICODE.OK().data("total", totalElements).data("items", bookList);
    }

    @ApiOperation(value = "新增书籍")
    @PostMapping("saveBook")
    public APICODE saveBook(@RequestBody Book book) {
        bookService.saveOrUpdate(book);
        return APICODE.OK();
    }

    @ApiOperation(value = "根据ID获取书籍")
    @GetMapping("getBookById/{bookId}")
    public APICODE getBookById(@PathVariable String bookId) {
        Book book = bookService.getById(bookId);
        return APICODE.OK().data("book", book);
    }

    @ApiOperation(value = "修改书籍")
    @PostMapping("updateBook")
    public APICODE updateBook(@RequestBody Book book) {
        bookService.saveOrUpdate(book);
        return APICODE.OK();
    }

    @ApiOperation(value = "根据ID删除书籍")
    @DeleteMapping("deleteById/{bookId}")
    public APICODE deleteById(@PathVariable String bookId) {
        bookService.removeById(bookId);
        return APICODE.OK();
    }






























}
