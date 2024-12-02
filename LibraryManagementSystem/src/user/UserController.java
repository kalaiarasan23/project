package user;

import java.util.Scanner;

import book.BookService;

public class UserController {
	
	UserService userService;
	UserOperation userOperation; 
	Scanner scr = new Scanner(System.in);
	
	public UserController(UserService userService,BookService bookService) {
		this.userService = userService;
		userOperation = new UserOperation(bookService);
 	}
	
	
	public void initialDash() {
		
		boolean b = true;
		while(b) {
			System.out.println("enter 1. add new User 2. existUser");
			int n = scr.nextInt();
			scr.nextLine();
			switch(n) {
			case 1:
				addUser();
				break;
			case 2:
				existUser();
				break;
			default:
				b= false;
				System.out.println("wrong button, so exit from initial dashBoard");
			}
		}
	}
	
	public void addUser() {
		System.out.println("enter your name ");
		String name = scr.nextLine();
		userService.addUser(name);
	}
	
	public void existUser() {
		try {
			System.out.println("enter your id");
			int n = scr.nextInt();
			scr.nextLine();
			User u =userOperation.userOperation(userService.getUser(n));
			userService.update(u);
		}
		catch (NullPointerException e) {
			System.err.println("wrong id entered");
		}
	}
	

	
}
