package com.example.app.restapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * BookEntity
 *
 * @author shimiz
 */
@Component
@Entity
@Table(name="book")
public class BookEntity {

  @Id
  @GeneratedValue
  @Column(name="id")
  private Long id;

//  @NotEmpty
//  @Size(min=4, max=20)
  @Column(name="title")
  private String title;

  @Column(name="author")
  private String author;

  @Column(name="description")
  private String description;

  @Column(name="price")
  private Long price;

  @DateTimeFormat
  @Column(name="createAt")
  private Date createAt;

  @DateTimeFormat
  @Column(name="updateAt")
  private Date updateAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public Date getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(Date updateAt) {
    this.updateAt = updateAt;
  }

}