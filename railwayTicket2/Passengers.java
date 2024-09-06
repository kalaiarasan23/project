package railwayTicket2;

public class Passengers {
	char src,des;
	int noOfSeats;
	String status;
	
	public Passengers(char src, char des, int noOfSeats, String status) {
		this.src = src;
		this.des = des;
		this.noOfSeats = noOfSeats;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Passengers [src=" + src + ", des=" + des + ", noOfSeats=" + noOfSeats + ", status=" + status + "]\n";
	}
	
}
