package book;

public class Book {
	private static int id;
	private int bookId, borrowDate, returnDate,fine;
	private String bookName,author;
	private boolean available;
	
	public Book(String bookName, String author) {
		bookId = ++id;
		this.bookName = bookName;
		this.author = author;
		this.borrowDate = -1;
		this.returnDate = -1;
		available = true;
		fine = 0;
	}
	
	public Book(Book book) {
		bookId = book.getBookId();
		bookName = book.getBookName();
		author = book.getAuthor();
		borrowDate = book.getBorrowDate();
		returnDate = book.getReturnDate();
		available = true;
		fine = book.getFine();
		
	}
	
	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public int getBorrowDate() {
		return borrowDate;
	}
	
	public void setBorrowDate(int borrowDate) {
		this.borrowDate = borrowDate;
	}
	
	public int getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(int returnDate) {
		this.returnDate = returnDate;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ",\t bookName=" + bookName + ",\t author=" + author 
				+ ",\n borrowDate=" + borrowDate + ",\t returnDate=" + returnDate + ",\t isPresent=" + available 
				+ ",\n fineAmount="+fine+"]\n\n";
	}
	
	
	
	
	
}
