package com.mapsa.onetoonewithsharedprimarykeysample.repository.singleTable;

import com.mapsa.onetoonewithsharedprimarykeysample.model.singleTable.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
