package flightTicketBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Booking {
	Scanner scr = new Scanner(System.in);
	public boolean booking(Flight f, int bookerId)
	{
		List<Passengers> p = new ArrayList<>(); 
	    System.out.println("enter the number of tickets you want ");
	    int n = scr.nextInt(),e=0,b=0;

	    if(checkForTickets(n,f))  
	    	return false;
	    else
	    {
		    for(int i=0 ; i<n ;i++)
		    {
		    	scr.nextLine();
			    System.out.println("enter your name ");
			    String name = scr.nextLine();
			    
			    System.out.println("enter your age ");
			    int age = scr.nextInt();

			    System.out.println("do you want meals y/n");
			    char m = scr.next().charAt(0);
			    boolean meals = m == 'y' ? true : false;
			    
			    System.out.println("enter the business class or economic class ");
			    String seatClass = scr.next();
			    System.out.println("enter the seat number ");
			    int seat = scr.nextInt();
			    
			    Passengers passenger = new Passengers(name, age, seat, meals, seatClass); 
			    if(f.checkTicket(passenger))
					p.add(passenger);
			    else
			    {
			    	System.out.println("your entered invalid seat");
			    	return false;
			    }
			    System.out.println(p.get(i));
			    if(seatClass.equals("economic")) e++;
			    else b++;
			    System.out.println();
			    System.out.println();
		    }
		    f.finalStage(p, e, b, bookerId);
	    }
	    return true;
	}
	
	int cancel(Flight f, int id)
	{
		if(!f.isIDPresent(id))
		{
			System.out.println("Invalid id ");
			return -1;
		}
			return f.cancelTicket(id);
	}
	
	
	
	boolean checkForTickets(int n, Flight f)
	{
		if(((f.getEconomicSeat()+f.getBusinessSeat())-n) > 0)
			return false;
		return true;
	}
	
	Flight[] flightCreation(int n) {
		Flight[] f = new Flight[n];
		f[0] = new Flight(5, 5, 200, 100, "Madurai", "Trichi");
		f[1] = new Flight(3, 5, 400, 300, "Trichi", "Madras");
		return f;
	}
	
}
