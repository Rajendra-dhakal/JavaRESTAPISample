package com.org.cestar.OnlineLibrary;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.org.cestar.Dao.Dao;
import com.org.cestar.Model.Book;

@Path("libresource")
public class LibResource {
	Dao  dao = new Dao();
	
	@Path("books")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Book>  getBooks(){
		
		List<Book> books = dao.displayBooks();
		
		return books ;
	}
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
	@Path("book/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Book getBookById(@PathParam("id")  int b_id) {
		
		Book book = dao.getRecById(b_id);
		
		return book;
		
	}
	@Path("insert/{id}/{name}/{author}/{price}/{genre}/{pub_date}")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String insertBook(@PathParam("id") int id, @PathParam("name") String name, @PathParam("author") String author, @PathParam("price") int price, @PathParam("genre") String genre, @PathParam("pub_date") String pub_date) {
		Book book = new Book(id, name, author, price, genre, pub_date);
		int status = dao.insertRec(book);
		if(status > 0) {
		return "Book Created Successfully!!!";
		}
		else {
			return "Book already exists";
		}
	}
	@Path("update/{id}/{name}/{author}/{price}/{genre}/{pub_date}")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBook(@PathParam("id") int id, @PathParam("name") String name, @PathParam("author") String author, @PathParam("price") int price, @PathParam("genre") String genre, @PathParam("pub_date") String pub_date) {
		Book book = new Book(id, name, author, price, genre, pub_date);
		int status = dao.updateRec(book);
		if(status > 0) {
		return "Book Updated Successfully!!!";
		}
		else {
			return "Book could not be update, please check if book exists";
		}
	}
	@Path("delete/{id}")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBook(@PathParam("id") int id) {
		int status = dao.deleteRec(id);
		if(status > 0) {
		return "Book Deleted Successfully!!!";
		}
		else {
			return "Book could not be deleted, please check if book exists";
		}
	}
}
