package railwayTicket2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);
		boolean flow = true;
		Tickets t= new Tickets();
		while(flow)
		{
			System.out.println("Enter your choice \n1. booking \n2. cancel \n3. check\n4. exit");
			int n =src.nextInt();
			switch(n)
			{
			case 1:
				System.out.println("enter the src ");
				char from = src.next().charAt(0);
				System.out.println("enter the des ");
				char des = src.next().charAt(0);
				System.out.println("enter the no of seats ");
				int seat = src.nextInt();
				System.out.println((int)from+" "+(int)des);
				if(from <'A' || des > 'E' )
				{
					System.out.println("no place are available");
					break;
				}
				if(t.booing(from,des,seat))
					System.out.println("booked successfully");
				else
					System.out.println("No seats are available");
				break;
				
			case 2:
				System.out.println("enter PNR number ");
				int pnr = src.nextInt();
				System.out.println("enter the no of seats");
				int seat2 = src.nextInt();
				t.cancel(pnr,seat2);
				break;
				
			case 3:
				t.printChart();
				break;
				
			default:
				flow = false;
			}
		}
		src.close();
	}

}
