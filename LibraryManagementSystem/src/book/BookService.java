package book;

public class BookService {
	
	private BookDB bookDb ;
	private int fineAmount=10, maxDays=1;
	
	
	public BookService(BookDB bookDb) {
		this.bookDb = bookDb;
		add("science1","author1");
		add("science2","author2");
		add("science3","author3");
		add("science4","author4");
		add("science5","author5");
	}
	
	public void setFineAmountAndDate(int fineAmount, int maxDays) {
		this.fineAmount = fineAmount;
		this.maxDays = maxDays;
	}
	
	public int getFineAmout() {
		return fineAmount;
	}
	
	public int getMaxDays() {
		return maxDays;
	}
	
	public int setFineAmount(int days) {
		return days< maxDays ?  0 :  days * fineAmount;
	}
	
	public void bookAvailable() {
		bookDb.availableBooks();
	}
	
	
	
	public void add(String bookName, String author) {
		bookDb.addBook(new Book(bookName, author));
	}
	
	public void viewBooks() {
		bookDb.viewAllBooks();
	}
	
	public void BookAvailable(Book b)
	{
		if(b.isAvailable()) {
			b.setAvailable(false);
		}else {
			b.setAvailable(true);
		}
		bookDb.updateBook(b);
	}
	
	public Book findBook(int id) {
		return bookDb.findBookById(id);
	}
	
	public void updateBook(Book b) {
		bookDb.updateBook(b);
	}


	public void deleteBook(int id) {
		if(bookDb.TotalBooks() >= id) {
			bookDb.deleteBook(id);
			System.out.println(id+" book is deleted");
		} else {
			System.out.println("invalid id ");
		}
	}
}
