package taxi;

import java.util.ArrayList;
import java.util.List;


public class Booking {
	static List<Taxi> isavailabeTaxi(Customer c, ArrayList<Taxi> taxis) {
		// TODO Auto-generated method stub
		ArrayList<Taxi> al = new ArrayList<Taxi>();
		for(Taxi t : taxis)
		{
			if(c.time-t.freeTime >0 && Math.abs((c.pickUp-'a')-(t.current-'a')) <= Math.abs(c.time-t.freeTime) )
			{
				al.add(t);
			}
		}
		return al;
	}

	public static void taxiBooking(List<Taxi> alTaxis,Customer c) {
		Taxi taxi= null;
		int tempNearest=999,distance,salary; //to calulate a freetime
		for(Taxi t : alTaxis)
		{
			// find nearest taxi to customer and ass to it.
			int nearestTaxi = Math.abs((t.current - 96) - (c.pickUp - 96)) ;
			if(nearestTaxi< tempNearest)
			{
				taxi=t;
				tempNearest=nearestTaxi;
			}
		}
		if(taxi==null) {
			System.out.println("no taxi available");
		}
		else
		{
		distance = Math.abs((c.pickUp-96)-(c.Drop-96))*15;
		salary = 100+ (distance-5)*10;
		System.out.println("freetime "+distance);
		taxi.bookTaxi(false, distance/15, salary, c);
		System.out.println(taxi.taxiId+" is booked");
		}
	}
	
	
	
	
}
