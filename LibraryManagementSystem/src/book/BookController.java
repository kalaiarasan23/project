package book;

import java.util.Scanner;

public class BookController {
	
	BookService bookService;
	Scanner scr = new Scanner(System.in);
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	public void crud() {
		boolean b = true;
		while(b) {
			System.out.println(" book opeartion 1. add book 2. get book 3. update book  4. delete book 5. viewAll books");
			int n = scr.nextInt();
					scr.nextLine();
			
			switch(n) {
			case 1:
				addBook();
				break;
			case  2:
				try {
					System.out.println(getBook());					
				}catch (NullPointerException e) {
					System.err.println("no such book id found");
				}
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				bookService.viewBooks();
				break;
			default:
				System.out.println("exit from book operation");
				b= false;
			}
		}
	}


	private void addBook() {
		System.out.println("enter the book name ");
		String name = scr.nextLine();
		System.out.println("enter the author name ");
		String author = scr.nextLine();
		bookService.add(name, author);
	}
	
	private Book getBook(){
		System.out.println("enter the book id");
		int id = scr.nextInt();
		return bookService.findBook(id); 
	}
	
	private void update() {
		try {
			Book book = getBook();
			System.out.println("enter");
			int n = scr.nextInt();
			scr.nextLine();
			switch(n)
			{
			case 1:
				System.out.println("enter the new book name");
				book.setBookName(scr.nextLine());
				break;
			case 2:
				System.out.println("enter the new author name");
				book.setAuthor(scr.nextLine());
				break;
			default:
				System.out.println("wrong input");
			}
			bookService.updateBook(book);
		}catch (Exception e) {
			System.err.println("invalid id");
		}
	}
	
	private void delete() {
		System.out.println("enter the id for remove book");
		int id = scr.nextInt();
		bookService.deleteBook(id);
		System.out.println("successfully deleted ");
	}
	
	public void fineAmountAndDate() {
		System.out.println("enter the fine Amount ");
		int Amount = scr.nextInt();
		System.out.println("enter the maxDays for keep book ");
		int days = scr.nextInt();
		bookService.setFineAmountAndDate(Amount, days);
	}
	
}
