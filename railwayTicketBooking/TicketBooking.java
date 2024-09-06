package railwayTicketBooking;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TicketBooking {
	final static int CON_TICKETS = 3;
	final static int RAC_TICKETS = 1;
	final static int WAITING_TICKETS=1;
	final static int TOTAL_TICKETS = CON_TICKETS+(2*RAC_TICKETS)+WAITING_TICKETS;
	static Queue<Passenger> racQueue = new LinkedList<>(),
			waitingQueue = new LinkedList<>();
	static List<Passenger> upperList = new LinkedList<>(),
			lowerList = new LinkedList<>(),
			middleList = new LinkedList<>();
	static Passenger[] ticketBooking = new Passenger[CON_TICKETS];
	static int lower=0,middle=1,upper=2;
	
	static void addPassangers(Passenger p) {
		if(p.berthPreference.equals("l") && lowerList.size() < (CON_TICKETS/3))
		{
			p.berthAllogate="l";
			lowerList.add(p);
		}
		else if(p.berthPreference.equals("u") && upperList.size() < (CON_TICKETS/3))
		{
			p.berthAllogate="u";
			upperList.add(p);
		}
		else if(p.berthPreference.equals("m") && middleList.size() < (CON_TICKETS/3))
		{
			p.berthAllogate="m";
			middleList.add(p);
		}
		else if(lowerList.size() < (CON_TICKETS/3))
		{
			p.berthAllogate ="l";
			lowerList.add(p);
		}
		else if(upperList.size() < (CON_TICKETS/3))
		{
			p.berthAllogate ="u";
			upperList.add(p);
		}
		else if(middleList.size() < (CON_TICKETS/3))
		{
			p.berthAllogate ="m";
			middleList.add(p);
		}
		else if(racQueue.size() < ( 2*RAC_TICKETS ))
		{
			p.berthAllogate = "RAC";
			racQueue.add(p);
		}
		else
		{
			p.berthAllogate ="waiting";
			waitingQueue.add(p);
		}
	}
	
	static void cancelTicket(int id) {
		List<Passenger> li = DisplayClass.mp.get(id);
		for(Passenger p : li)
		{
			removeFromList(p);
		}
	}
	
	static void removeFromList(Passenger p)
	{
		switch(p.berthAllogate)
		{
		case "u":
			replaceRAC(p, upperList);
			break;
		case "l":
			replaceRAC(p, lowerList);
			break;
		case "m":
			replaceRAC(p, upperList);
			break;
		}
	}

	private static void replaceRAC(Passenger p,List<Passenger> list) {
		if(!racQueue.isEmpty()) {
//			DisplayClass.mp.containsValue(list)
			ticketBooking[p.pasId] = racQueue.poll();
			
		}
		if(!waitingQueue.isEmpty()) 
		{			
			racQueue.add(waitingQueue.poll());
		}
		else
			list.remove(p);
	}

	public static void available() {
		System.out.println("ticket in lower "+(CON_TICKETS/3 - lowerList.size()));
		System.out.println("ticket in middle "+(CON_TICKETS/3 - middleList.size()));
		System.out.println("ticket in upper "+(CON_TICKETS/3 - upperList.size()));
		System.out.println("ticket in Rac "+(2*RAC_TICKETS - racQueue.size()));
		System.out.println("ticket in waiting "+(WAITING_TICKETS - waitingQueue.size()));
		
	}
}
