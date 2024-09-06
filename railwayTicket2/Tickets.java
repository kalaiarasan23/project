package railwayTicket2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tickets {
	static int tickets=8 , waiting=2;
	boolean chart[][] = new boolean[tickets][5];
	List<Passengers> total = new ArrayList<Passengers>();
	int[] waitingList = new int[waiting]; 
	
	{
		Arrays.fill(waitingList, -1);
	}
	
	boolean booing(char src, char des, int seat)
	{
		if(checkTicket(src,des,seat))
		{
			AssignTicket(src,des,seat);
			return total.add(new Passengers(src,des,seat,"booked"));
		}
		else if(seat <= waiting)
		{
			total.add(new Passengers(src,des,seat,"waiting"));
			waitingList[waiting-1] = total.size()-1; 		// to Store the index of waiting list
			System.out.println(waitingList[waiting-1]);
			waiting -= seat;
			return true;
		}
		System.out.println();
		return false;
	}


	private boolean AssignTicket(char src, char des, int seat) {
		int n=0;
		for(int i=0;i<tickets ;i++)
		{
			for(char j=src; j<des;j++)
			{
				if(chart[i][j] == false) 
					chart[i][j]=true;
			}
			n++;
			if(seat==n)
				return true;
		}
		return false;
	}

	public void printChart() {
		for(int i=0;i<chart.length ;i++)
		{
			for(int j=0; j<chart[0].length;j++)
			{
				System.out.print(chart[i][j]+" "); 
			}
			System.out.println();
		}
		System.out.println(total);
	}
	

	private boolean checkTicket(char src, char des, int seat) {
		int n=0;
		for(int i=0;i<tickets; i++)
		{			
					for(char j = src; j< des ;j++) 
						if(chart[i][j-'A'] == true)
							return false;
					n++;
				if(n==seat)
					return true;
		}
		return false;
	}


	public void cancel(int n, int seatNo) {
		if(total.size() < n )
		{
			System.out.println("PNR number not found");
			return ;
		}
		else if(total.get(n-1).noOfSeats < seatNo)
		{
			System.out.println("invalid seats");
			return ;
		}
		else
		{
			Passengers p =total.get(n-1);
			System.out.println(p);
			deAllocateTicket(p.src, p.des, p.noOfSeats,seatNo);
			p.noOfSeats -= seatNo; 
			total.get(n-1);
			 
			//waitiList to confirm tickets
			
			
			
		}
	}
	
	private void deAllocateTicket(char src, char des, int seat, int removeSeat) {
		int n=0,k=waitingList.length-1;
		System.out.println("seat "+seat);
		for(int i=0;i<tickets ;i++)
		{
			for(int j=src-'A'; j<des-'A';j++)
			{
				if(chart[i][j] == true) {
					n++;
					while(k >= 0 && waitingList[k] != -1) {
						Passengers p =total.get(waitingList[k]);
						System.out.println(p);
						if(AssignTicket(p.src, p.des, p.noOfSeats)){
							p.status ="booked";
							k-=p.noOfSeats;
						}
						k--;
					}
					chart[i][j]= false;
				}
				if(removeSeat==n) {
					return ;
				}
			}
		}
	}
}
