package com.dc18669.autoconfig.repository;

import java.util.List;

import com.dc18669.autoconfig.entity.Book;
import com.dc18669.autoconfig.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByReader(Reader reader);

}
