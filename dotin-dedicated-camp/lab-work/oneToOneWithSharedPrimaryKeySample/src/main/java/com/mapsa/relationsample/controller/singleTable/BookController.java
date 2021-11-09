package com.mapsa.relationsample.controller.singleTable;

import com.mapsa.relationsample.param.SingleTableParame;
import com.mapsa.relationsample.model.singleTable.Book;
import com.mapsa.relationsample.service.singleTable.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService service;


    @PostMapping("save")
    public void save(@RequestBody SingleTableParame parame) {
        service.save(parame.getParam(), parame.getName());
    }

    @GetMapping("all")
    public List<Book> getAll() {
        return service.getAll();
    }
}
