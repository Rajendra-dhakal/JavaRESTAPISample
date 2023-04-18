package com.org.cestar.Model;

public class Book {
	public int id;
	public String name;
	public String author;
	public int price;
	public String genre;
	public String pub_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public Book() {
		super();
	}
	public Book(int id, String name, String author, int price, String genre, String pub_date) {
		super();
		this.id = id;
		this.author = author;
		this.genre = genre;
		this.name = name;
		this.price = price;
		this.pub_date = pub_date;
	}
}
