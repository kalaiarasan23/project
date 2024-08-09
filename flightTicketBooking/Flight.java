package flightTicketBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight {
	private static int id ;
	private int flightId,businessSeat, economicSeat, priceBusiness, priceEconomic;
	private boolean availableSeatEconomic[], availableSeatBusiness[];
	private String present, destination;
	private Map<Integer,List<Passengers>> TicketsOfPassengers;
	

	public Flight(int businessSeat, int economicSeat, int priceBusiness, int priceEconomic, String present,
			String destination) 
	{
		flightId = ++id;
		this.businessSeat = businessSeat;
		this.economicSeat = economicSeat;
		this.priceBusiness = priceBusiness;
		this.priceEconomic = priceEconomic;
		this.present = present;
		this.destination = destination;
		availableSeatBusiness = new boolean[businessSeat];
		availableSeatEconomic = new boolean[economicSeat];
		TicketsOfPassengers = new HashMap<>();
	}

	
	public int getBusinessSeat() {
		return businessSeat;
	}

	public int getEconomicSeat() {
		return economicSeat;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", businessSeat=" + businessSeat + ", economicSeat=" + economicSeat
				+ ", priceBusiness=" + priceBusiness + ", priceEconomic=" + priceEconomic + ", present=" + present
				+ ", destination=" + destination + "]\n";
	}
	
	public boolean isIDPresent(int id) {
		if(TicketsOfPassengers.containsKey(id))
			return true;
		return false;
	}

	public void finalStage(List<Passengers> list, int e,int b,int bookerId) {
		priceBusiness += (b*200);
		priceEconomic += (e*100);
		TicketsOfPassengers.put(bookerId, list);
	}
	
	public boolean checkTicket(Passengers p) {
		if(p.seatClass.equals("economic") && (economicSeat > 0 && availableSeatEconomic[p.seatNo-1] == false)) 
		{
			economicSeat --;
			availableSeatEconomic[p.seatNo-1]=true;
			p.price = priceEconomic;
			return true;
		}
		else if(p.seatClass.equals("business") && (businessSeat > 0 && availableSeatBusiness[p.seatNo-1] == false))
		{
			businessSeat --;
			availableSeatBusiness[p.seatNo-1]=true;
			p.price = priceBusiness;
			return true;
		}
		
		return false;
	}

	
	public void displaySeats()
	{
		for(int i=0;i<availableSeatBusiness.length;i++) {
			if(availableSeatBusiness[i] == false)
			System.out.print("B"+(i+1)+" ");
		if((i+1)%5 == 0)
			System.out.println();
		}
		for(int i=0;i<availableSeatEconomic.length;i++) {
			if(availableSeatEconomic[i]== false)
			System.out.print("E"+(i+1)+" ");
			if((i+1)%5 == 0)
				System.out.println();
		}
	}
	
	public void displayAll()
	{
		System.out.println(TicketsOfPassengers);
	}


	
	public int cancelTicket(int id) {
		List<Passengers> p = new ArrayList<Passengers>();
		int totalprice =0;
		p = TicketsOfPassengers.get(id);
		for(Passengers passenger : p)
		{
			if(passenger.seatClass.equals("economic")) {
				economicSeat++;
				availableSeatEconomic[passenger.seatNo-1] = false;
			}
			else
			{
				availableSeatBusiness[passenger.seatNo-1] = false;
				businessSeat++;
			}
			totalprice += passenger.price;
		}
		return totalprice;
	}

	
}
