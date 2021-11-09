package com.mapsa.onetoonewithsharedprimarykeysample.controller.singleTable;

import com.mapsa.onetoonewithsharedprimarykeysample.SingleTableParame;
import com.mapsa.onetoonewithsharedprimarykeysample.model.singleTable.Book;
import com.mapsa.onetoonewithsharedprimarykeysample.service.singleTable.BookService;
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
