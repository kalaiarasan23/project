package railwayTicketBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int regId ;
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		boolean run = true;
		while(run) 
		{
			System.out.println("enter the choice \n 1. Book ticket\n 2. cancel ticket\n 3.display details");
			int n = scr.nextInt();
			switch(n)
			{
				case 1:
					System.out.println("Total tickets"+TicketBooking.TOTAL_TICKETS+" regId "+regId);
					if( TicketBooking.TOTAL_TICKETS > ++regId )
					{
						System.out.println("enter the number of pessengers ");
						int id = scr.nextInt();
						List<Passenger> list = new ArrayList<>();
						System.out.println("Total tickets"+TicketBooking.TOTAL_TICKETS+" regId+Id "+(regId+id));
						if(TicketBooking.TOTAL_TICKETS > (regId+id))
						{
							while(id>0)
							{
								Passenger p = DisplayClass.addPassenger();
								TicketBooking.addPassangers(p);
								list.add(p);
								System.out.println(p);
								id--;
							}
							System.out.println("Your group id is "+ ++regId);
							DisplayClass.addMap(regId, list);
						}
						else
						{
							System.out.println("Sorry please press number 4 for check the tickets left");
						}
					}
					else
						System.out.println("sorry, No Tickets ");
					break;
					

// cancel process 				
				case 2:
					System.out.println("enter the group id ");
					int id=scr.nextInt();
					if(id<= regId)
					{
						System.out.println("1. remove full id\n2. particular id");
						int removeId =scr.nextInt();
						switch(removeId)
						{
							case 1:
								DisplayClass.removeMap(id);
								break;
							case 2:
								System.out.println("enter the passanger id for remove");
								break;
							default:
								System.out.println("sorry, no such option in this section");
						}
					}
					else
					{
						System.out.println("Their is not such id");
					}
					break;
					
				case 3:
					System.out.println(DisplayClass.mp);
					break;
					
				case 4:
					TicketBooking.available();
					break;
					
				default:
					run =false;
			}
		}
	}
		
}
