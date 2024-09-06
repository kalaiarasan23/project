package railwayTicketBooking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DisplayClass {
	static Map<Integer,List<Passenger>> mp = new HashMap<>();

	static Passenger addPassenger()
	{
		String name,berth;
		int age;
		char gender;
		Scanner scr = new Scanner(System.in);
		System.out.println("enter the name ");
		name = scr.nextLine();
		System.out.println("enter the gender in m or f ");
		gender = scr.next().charAt(0);
		System.out.println("enter the age ");
		age= scr.nextInt();
		System.out.println("enter the berth perference ");
		berth =scr.next();
		return new Passenger(age, name, berth, gender);
	}
	
	static void addMap(int id, List<Passenger> list)
	{
		mp.put(id, list);
	}
	
	static void removeMap(int id)
	{
		mp.remove(id);
	}
}
