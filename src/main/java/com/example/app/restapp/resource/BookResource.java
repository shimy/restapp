package com.example.app.restapp.resource;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.restapp.entity.BookEntity;
import com.example.app.restapp.filter.UserAuth;
import com.example.app.restapp.service.BookService;

/**
 * BookResource
 *
 * @author shimiz
 */
//@UserAuth
@Component
@Path("books")
public class BookResource {

  @Autowired
  private BookService bookService;

  /**
   * All books
   * GET /books
   *
   * @return response
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response listBook() throws IOException {

    List<BookEntity> bookList = bookService.listBook();
    GenericEntity<List<BookEntity>> entity = new GenericEntity<List<BookEntity>>(bookList){};

    return Response
        .status(Response.Status.OK)
        .entity(entity)
        .build();
  }

  /**
   * One book
   * GET /books/{id}
   *
   * @param id
   * @return response
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBook(@PathParam("id") Long id) throws IOException {
    BookEntity bookEntity = bookService.getBook(id);
    return Response
        .status(Response.Status.OK)
        .entity(bookEntity)
        .build();
  }

  /**
   * Create book
   * POST /books
   *
   * @param title
   * @param author
   * @param description
   * @param price
   * @return response
   */
  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional("transactionManager")
  public Response createBook(
          @FormParam("title") String title,
//          @NotEmpty @FormParam("author") String author,
          @FormParam("author") String author,
          @FormParam("description") String description,
          @FormParam("price") Long price
          ) {

    BookEntity bookEntity = new BookEntity();
    bookEntity.setTitle(title);
    bookEntity.setAuthor(author);
    bookEntity.setDescription(description);
    bookEntity.setPrice(price);

    bookService.createBook(bookEntity);

      return Response
              .status(Response.Status.CREATED)
              .entity(bookEntity)
              .build();
  }

  /**
   * Update(Full) book
   * PUT /books/{id}
   *
   * @param title
   * @param author
   * @param description
   * @param price
   * @return response
   */
  @PUT
  @Path("{id}")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional("transactionManager")
  public Response updateBook(
      @PathParam("id") Long id,
          @FormParam("title") String title,
          @FormParam("author") String author,
          @FormParam("description") String description,
          @FormParam("price") Long price
          ) {

    BookEntity bookEntity = new BookEntity();
    bookEntity.setId(id);
    bookEntity.setTitle(title);
    bookEntity.setAuthor(author);
    bookEntity.setDescription(description);
    bookEntity.setPrice(price);

    bookService.updateBook(bookEntity);

      return Response
              .status(Response.Status.OK)
              .entity(bookEntity)
              .build();
  }

  /**
   * Update(Partial) book
   * POST /books/{id}
   *
   * @param title
   * @param author
   * @param description
   * @param price
   * @return response
   */
  /**
  @POST
  @Path("{id}")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateBookPartial(){
    // TODO
  }
  **/

  /**
   * Delete book
   * DELETE /books/{id}
   *
   * @param id
   * @return response
   */
  @DELETE
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional("transactionManager")
  public Response deleteBook(@PathParam("id") Long id) {

    bookService.deleteBook(id);

      return Response
              .status(Response.Status.NO_CONTENT)
              .build();
  }

}