package admin;

import java.util.Scanner;

import book.BookController;
import user.UserService;

public class AdminController {
	Scanner scr = new Scanner(System.in);
	UserService userService; 
	BookController bookController;
	AdminDB adminDb;
	public AdminController(UserService userService ,BookController bookController, AdminDB adminDb) {
		this.userService = userService;
		this.bookController = bookController;
		this.adminDb = adminDb;
	}
	
	public void adminfinder() {
		System.out.println("enter the admin id ");
		int n = scr.nextInt();
		scr.nextLine();
		if(adminDb.checkAdmin(n))
			adminOperation();
		else
			System.out.println("invalid admin id ");
	}
	
	private void adminOperation() {
		boolean b = true;
		while(b) {
			System.out.println(" admin login 1. user operation 2. book operation 3. change amount and days");
			int n = scr.nextInt();
					scr.nextLine();
			
			switch(n) {
			case 1:
				userTakes();
				break;
			case 2:
				bookController.crud();
				break;
			case 3:
				bookController.fineAmountAndDate();
				break;
			default:
				System.out.println("wrong input so exit from adminOperaion");
				b= false;
			}
		}
	}

	private void userTakes() {
		boolean b = true;
		while(b) {
			System.out.println(" user table 1. user history books 2. user by fine");
			int n = scr.nextInt();
					scr.nextLine();
			
			switch(n) {
			case 1:
				userService.userTable();
				break;
			case 2:
				userService.fineOrderTable();
				break;
			default :
				System.out.println("exit from user tables");
				b= false;
				}
			}
	}
}
