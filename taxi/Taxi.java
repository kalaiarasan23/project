package taxi;

import java.util.ArrayList;

public class Taxi {
	boolean isAvailable;
	int taxiId,totalSalary,freeTime;
	char current;
	ArrayList<Customer> trips;
	static int id;
	
	Taxi()
	{
		isAvailable=true;
		taxiId=++id;
		freeTime=6;
		current='a';
		totalSalary=0;
		trips=new ArrayList<>();
	}
	
	void bookTaxi(boolean isAvailable ,int freeTime, int totalSalary, Customer c)
	{
		this.isAvailable= isAvailable;
		this.freeTime= c.time+freeTime;
		this.current = c.Drop;
		this.totalSalary += totalSalary;
		trips.add(c);
		c.setPrice(totalSalary);
	}

	@Override
	public String toString() {
		return "Taxi [isAvailable=" + isAvailable + ", taxiId=" + taxiId + ", totalSalary=" + totalSalary
				+ ", freeTime=" + freeTime + ", current=" + current + "\n trips =" + trips + "]\n\n";
	}
	
	
}

