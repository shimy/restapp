package com.example.app.restapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.app.restapp.dao.BookDao;
import com.example.app.restapp.entity.BookEntity;

/**
 * BookService
 *
 * @author shimiz
 */
@Component
public class BookService {

  @Autowired
  BookDao bookDao;

  /**
   * getBook
   *
   * @param id
   * @return BookEntity
   */
  public BookEntity getBook(Long id) {
    return bookDao.getBookById(id);
  }

  /**
   * listBook
   *
   * @return List<BookEntity>
   */
  public List<BookEntity> listBook() {
    return bookDao.getAllBooks();
  }

  /**
   * createBook
   *
   * @param bookEntity
   * @return BookEntity
   */
  public BookEntity createBook(BookEntity bookEntity){
    return bookDao.insertBook(bookEntity);
  }

  /**
   * updateBook
   *
   * @param bookEntity
   * @return BookEntity
   */
  public BookEntity updateBook(BookEntity bookEntity){
    return bookDao.updateBook(bookEntity);
  }

  /**
   * deleteBook
   *
   * @param id
   */
  public void deleteBook(Long id){
	  bookDao.deleteBookById(id);
  }

}