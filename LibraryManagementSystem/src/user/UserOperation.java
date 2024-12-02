package user;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import book.Book;
import book.BookService;

public class UserOperation {
	Scanner scr = new Scanner(System.in);
	BookService bookService;
	public UserOperation(BookService bookService) {
		this.bookService = bookService;
	}

	public User userOperation(User user) {
		boolean b = true; 
		Map<Integer, Book> tempMap= user.getListBooks();
		while(b) {
			System.out.println("0. view all books 1. add book 2. remove book 3. fine Amount 4.view current borrow books 5. history of books ");
			int n = scr.nextInt();
			scr.nextLine();
			switch(n) {
			case 0:
				bookService.bookAvailable();
				break;
			case 1:
				addBookToUser(user, tempMap);
				break;
			case 2:
				removeBookFromUser(user, tempMap);
				break;
			case 3:
				System.out.println("fine amount "+user.getFineAmount());
				break;
			case 4:
				System.out.println(tempMap);
				break;
			case 5:
				System.out.println(user.getHistoryBook());
				break;
			default:
				System.out.println("you enter wrong input");
				System.out.println("thank you "+user.getName());
				b=false;
			}
		}
		
		return user;
	}

	private void removeBookFromUser(User user, Map<Integer, Book> tempMap) {
		if(tempMap.size()>0){
			System.out.println("enter the id of the book");
			int id = scr.nextInt(),tempId=-1;
			Book book = null;
			for(Entry<Integer, Book> e: tempMap.entrySet()) {
				if(e.getValue().getBookId() == id)
				{
					tempId = e.getKey();
					book = e.getValue();
					break;
				}
			}
			try {
				book.getBookId();
				System.out.println("enter the return date ");
				int date = scr.nextInt();
				book.setReturnDate(date);         // set return date
				
				int fine = bookService.setFineAmount(Math.abs(book.getBorrowDate()- date));
				book.setFine(fine);                // set book fine
				user.setFineAmount(fine+user.getFineAmount()); // total fine calculation
				
				tempMap.remove(tempId);     // remove from list
				bookService.BookAvailable(book);  // set available as false
				user.updateHistoryMap(tempId,new Book(book)); // update date and fine amount here 
				
				/* we update by new Book object use copy parameter 
				 * because we again change the parameter after storing.
				 * Due to reference is pass to updateHistoryList, if change any parameter it will reflect in list also.
				 * So we create new book object pass by copy constructor
				 * */
				

//				// reset fine date and update in database
				book.setFine(0);
				book.setReturnDate(-1);
				book.setBorrowDate(-1);
				bookService.updateBook(book);
			}
			catch(Exception e) {
				System.err.println(id+" book is not available in your list");
			}
		}
		else {
			System.err.println("no books borrow ");
		}
	}

	private void addBookToUser(User user, Map<Integer, Book> tempMap) {
		try {
			System.out.println("enter the id of the book");
			int id = scr.nextInt();
			Book book = bookService.findBook(id);
			if(book.isAvailable()) {
				System.out.println("book is available, enter the borrow date ");
				int date = scr.nextInt();
				book.setBorrowDate(date);
				user.addBook(book);
//						tempList.add(book);    // stored in temp and history list
				tempMap.put(user.getMaintainBooks(), book);                       // store in temp map
				bookService.BookAvailable(book);  // set available as false
			}
			else {
				System.out.println(id+" id book is not available");
			}
		}
		catch (Exception e) {
			System.err.println("book id is wrong");
		}
	}
	
}
