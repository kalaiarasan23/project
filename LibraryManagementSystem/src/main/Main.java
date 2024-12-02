package main;

import java.util.Scanner;

import admin.AdminController;
import admin.AdminDB;
import book.BookController;
import book.BookDB;
import book.BookService;
import user.UserController;
import user.UserDB;
import user.UserService;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		boolean b = true;
		
		
		BookService bookService = new BookService(new BookDB());
		UserService userService = new UserService(new UserDB());
		UserController userController = new UserController(userService,bookService);
		AdminController adminController = new AdminController(userService, new BookController(bookService), new AdminDB());
	
		
		while(b) {
			System.out.println("enter 1. user Login 2. admin Login");
			switch(scr.nextInt()) {
			case 1:
				userController.initialDash();
				break;
			case 2:
				adminController.adminfinder();
				break;
			default:
				System.out.println("wrong login ");
				b= false;
			}
		}
			
		scr.close();
	}
}
