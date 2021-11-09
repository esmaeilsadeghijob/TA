package com.mapsa.relationsample.service.singleTable;

import com.mapsa.relationsample.model.singleTable.Book;
import com.mapsa.relationsample.repository.singleTable.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public void save(String author, String name) {
        repository.save(new Book(name, author));
    }

    public List<Book> getAll() {
        return repository.findAll();
    }
}
