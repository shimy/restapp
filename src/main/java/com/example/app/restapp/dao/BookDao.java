package com.example.app.restapp.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.example.app.restapp.entity.BookEntity;

/**
 * BookDao
 *
 * @author shimiz
 */
@Component
public class BookDao {

  @PersistenceContext(unitName="myPersistence")
  private EntityManager entityManager;

  /**
   * getBookById
   *
   * @param id
   * @return BookEntity
   */
  public BookEntity getBookById(Long id) {
    return entityManager.find(BookEntity.class, id);
  }

  /**
   * getAllBooks
   *
   * @return Lst<BookEntity>
   */
  public List<BookEntity> getAllBooks() {
    try {
      String sql = "SELECT p FROM BookEntity p";
      TypedQuery<BookEntity> query = entityManager.createQuery(sql, BookEntity.class);
      return query.getResultList();
    } catch (NoResultException e) {
      return null;
    }
  }

  /**
   * insertBook
   *
   * @param bookEntity
   * @return BookEntity
   */
  public BookEntity insertBook(BookEntity bookEntity){
    bookEntity.setCreateAt(new Date());
    bookEntity.setUpdateAt(new Date());
    entityManager.merge(bookEntity);
    entityManager.flush();
    return bookEntity;
  }

  /**
   * updateBook
   *
   * @param bookEntity
   * @return BookEntity
   */
  public BookEntity updateBook(BookEntity bookEntity){
    bookEntity.setUpdateAt(new Date());
    entityManager.merge(bookEntity);
    entityManager.flush();
    return bookEntity;
  }

  /**
   * deleteBookById
   *
   * @param id
   */
  public void deleteBookById(Long id){
    entityManager.remove(entityManager.find(BookEntity.class, id));
  }

}