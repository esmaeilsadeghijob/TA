package com.mapsa.relationsample.repository.singleTable;

import com.mapsa.relationsample.model.singleTable.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
