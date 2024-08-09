package flightTicketBooking;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		Flight[] f = new Booking().flightCreation(2);
		System.out.println(f[0]);
		System.out.println(f[1]);
		int bookerId=0,id=0;
		Scanner scr = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter the your choice \n1. booking \n2. cancel \n3. viewSeats \n4. total seats ");
			
			switch(scr.nextInt())
			{
			case 1:
				System.out.println("enter the flight id ");
			    id = scr.nextInt();
			    if(new Booking().booking(f[id-1],bookerId+1)) {
			    	System.out.println("your booker id is "+(++bookerId));
			    	System.out.println("booked successfully");
			    }
			    else
			    	System.out.println("booking error");
			    break;
			    
			case 2:
				System.out.println("enter your flight id ");
				id = scr.nextInt();
				System.out.println("enter your booker id");
				int bookId = scr.nextInt();
				System.out.println(new Booking().cancel(f[id-1], bookId));
				break;
				
			case 3: 
				for(int i =0 ;i<f.length;i++)
					f[i].displaySeats();
				break;
				
			case 4:	
				for(int i =0 ;i<f.length;i++)
					f[i].displayAll();
				break;
				
			case 5:
				return ;
				
			default :
				System.out.println("invalid option");
			}
			System.out.println();
			System.out.println();
		}
	}

}
