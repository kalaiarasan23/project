package user;

import java.util.ArrayList;
import java.util.List;

import book.Book;

public class UserService {
	
	UserDB userDB;
	
	public UserService(UserDB userDB) {
		this.userDB = userDB;
		addUser("raj");
		addUser("mohan");
		addUser("hari");
	}
	
	public void addUser(String name) {
		userDB.addUser(new User(name));
	}
	
	public User getUser(int id) {
			return userDB.getUserById(id);
	}
	
	public void update(User u) {
		userDB.updateUser(u);
	}
	
	
	public void printAllUser() {
		userDB.printAllUser();
	}
	
	public void userTable() {
		List<User> temp = userDB.userTable();
		for(User u : temp) {
			System.out.println("User id "+u.getUserId()+" userName "+u.getName()+" total fine "+u.getFineAmount());
			List<Book> historyList = new ArrayList<>(u.getHistoryBook().values());
			for(Book histroy: historyList ) {
				System.out.println("id: "+histroy.getBookId()+" name: "+histroy.getAuthor()+" borrowDate: "+histroy.getBorrowDate()+" return Date: "+histroy.getReturnDate()+" fine amount: "+histroy.getFine());
				System.out.println("\n\n");
			}
		}
	}
	public void fineOrderTable() 	{
		List<User> temp = userDB.userTable();
		temp.sort((a,b) -> Integer.compare(b.getFineAmount(),a.getFineAmount()));
		for(User u : temp) {
			System.out.println("name "+u.getName()+" Total Books "+u.getHistoryBook().size()+" fine amount= "+u.getFineAmount());
		}
	}
	
	
	
}
