package user;

import java.util.HashMap;
import java.util.Map;

import book.Book;

public class User {
	private static int id;
	private String name ;
	private int userId, fineAmount, maintainBooks;
	
	
	private Map<Integer,Book> currentBook;
	private Map<Integer,Book> historyBook;
	
	public User(String name) {
		userId = ++id;
		this.name = name;
		currentBook = new HashMap<>();
		historyBook = new HashMap<>();
		fineAmount = 0;
		maintainBooks = 0;
	}
	
	public int getMaintainBooks() {
		return maintainBooks;
	}


	public int getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}

	public String getName() {
		return name;
	}

	public int getUserId() {
		return userId;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addBook(Book b) {
		historyBook.put(++maintainBooks,b);
	}
	
	public void updateHistoryMap(int id, Book book) {
		historyBook.put(id,book);
	}

	public Map<Integer,Book> getListBooks() {
		return currentBook;
	}

	public void setListBooks(Map<Integer, Book> currentBook) {
		this.currentBook = currentBook;
	}

	public Map<Integer, Book> getHistoryBook() {
		return historyBook;
	}

}
