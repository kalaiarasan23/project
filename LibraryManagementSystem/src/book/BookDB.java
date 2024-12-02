package book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BookDB {
	
	Map<Integer,Book> bookMap ;
	
	
	public BookDB() {
		bookMap = new HashMap<>();
	}
	
	public void addBook(Book b) {
		bookMap.put(b.getBookId(), b);
		System.out.println("book "+b.getBookName()+" added");
	}
	
	public Book findBookById(int id) {
		return bookMap.get(id);
	}
	
	public void viewAllBooks() {
		System.out.println(bookMap);
	}
	
	public void updateBook(Book b) {
		bookMap.put(b.getBookId(), b);
	}
	
	public void deleteBook(int id) {
		bookMap.remove(id);
	}
	
	public int TotalBooks() {
		return bookMap.size();
	}
	
	public void availableBooks() {
//		for(Book  b : bookList) {
//			if(b.isAvailable())
//				System.out.println("book Id :"+b.getBookId()+"\t book Name: "+b.getBookName()+"\t authorName: "+b.getAuthor());
//		}
		
		for(Entry<Integer, Book> e : bookMap.entrySet()) {
			if(e.getValue().isAvailable()){
				Book b= e.getValue();
				System.out.println("book Id :"+b.getBookId()+"\t book Name: "+b.getBookName()+"\t authorName: "+b.getAuthor());
			}
		}
		
	}
	
}
