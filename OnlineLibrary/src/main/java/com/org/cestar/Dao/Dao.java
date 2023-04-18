package com.org.cestar.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.org.cestar.Model.Book;

public class Dao {
	public Connection getConnection() {

		Connection con = null;

		String user = "root";

		String pwd = "";

		String url = "jdbc:mysql://localhost:3306/book";

		// Load the Driver

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Connection Ho gai Hai");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public List<Book> displayBooks() {

		List<Book> books = new ArrayList<>();

		Connection con = getConnection();

		String sql = "select * from book";

		try {

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Book book = new Book(rs.getInt("id"), rs.getString("name"), rs.getString("author"), rs.getInt("price"),
						rs.getString("genre"), rs.getString("pub_date"));

				books.add(book);

			}

			System.out.println(books);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public Book getRecById(int id_to_getRec) {

		Book book = null;

		Connection con = getConnection();

		String sql = "SELECT * from book where id=?";

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id_to_getRec);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				book = new Book(rs.getInt("id"), rs.getString("name"), rs.getString("author"), rs.getInt("price"),
						rs.getString("genre"), rs.getString("pub_date"));
			}
			System.out.println(book);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;

	}

	public int insertRec(Book book_tob_inserted) {

		int status = 0;

		Connection con = getConnection();

		String sql = "insert INTO book (id,name,author, price,genre, pub_date) VALUES (?,?,?,?,?,?)";

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, book_tob_inserted.getId());

			pstmt.setString(2, book_tob_inserted.getName());

			pstmt.setString(3, book_tob_inserted.getAuthor());

			pstmt.setInt(4, book_tob_inserted.getPrice());

			pstmt.setString(5, book_tob_inserted.getGenre());

			pstmt.setString(6, book_tob_inserted.getPub_date());

			status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Book Add Ho gia Hai!!!");
			} else {

				System.out.println("Try Again Bhai Jaan Some Error Occured!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	public int updateRec(Book updated_book) {

		int status = 0;

		Connection con = getConnection();

		String sql = "update book set id=?,name=?,author=?,price=?,genre=?,pub_date=? where id=?";

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, updated_book.getId());

			pstmt.setString(2, updated_book.getName());

			pstmt.setString(3, updated_book.getAuthor());

			pstmt.setInt(4, updated_book.getPrice());

			pstmt.setString(5, updated_book.getGenre());

			pstmt.setString(6, updated_book.getPub_date());

			pstmt.setInt(7, updated_book.getId());

			status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Update Ho Gia Hai Congratulatios!!!");

			}

			else {

				System.out.println("Try Try Again Somer Error Occured!!!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

	public int deleteRec(int id_to_deleteRec) {

		int status = 0;

		Connection con = getConnection();

		String sql = "DELETE FROM book WHERE id = ?";

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id_to_deleteRec);

			status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Delete Ho Gia Hai !");
			} else {
				System.out.println("Something Wrong Pha G Try Again!!!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
