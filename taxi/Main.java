package taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean b = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the number of taxis");
//		int n = sc.nextInt();
		ArrayList<Taxi> taxis = createTaxi(4);
				
		while(b)
		{
			System.out.println("0 - taxi booking \n1 - taxi details");
			switch(sc.nextInt())
			{
			case 0:
				int time;
				char start,drop;
				System.out.println("enter the pickup point");
				start = sc.next().charAt(0);
				System.out.println("enter the drop point");
				drop = sc.next().charAt(0);
				System.out.println("enter the time to pickup");
				time = sc.nextInt();
				
				if(valid(start,drop,time)) 		break;
				Customer c = new Customer(time, start, drop);
				
				List<Taxi> alTaxis=Booking.isavailabeTaxi(c,taxis);
				alTaxis.sort((o1,o2)-> o2.totalSalary- o1.totalSalary);
				
				Booking.taxiBooking(alTaxis,c);
				System.out.println("customer booked");
				
				break;
				
			case 1: 
				for(Taxi t : taxis)
					System.out.println(t);
				break;
				
			default:
				System.out.println("thank you, visit again");
				b=false;
			}
		}
		
	}

	

	private static boolean valid(char start, char drop, int time) {
		if(!(start >= 'a' && start <= 'f'))
		{
			System.out.println("pickup is invalid");
			return true;
		}
		if(!(drop >= 'a' && drop <= 'f'))
		{
			System.out.println("drop is invalid");
			return true;
		}
		if(time<5)
		{
			System.out.println("time is invalid");
			return true;
		}
		return false;
	}



	private static ArrayList<Taxi> createTaxi(int n) {
		ArrayList<Taxi> al = new ArrayList<Taxi>();
		for(int i = 0 ; i<n ; i++)
			al.add(new Taxi());
		return al;
	}

}
