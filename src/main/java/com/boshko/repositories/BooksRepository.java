package com.boshko.repositories;


import com.boshko.entities.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BooksRepository extends PagingAndSortingRepository<Book, Long> {

}
