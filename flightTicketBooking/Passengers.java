package flightTicketBooking;

public class Passengers {
	String name,seatClass;
	static int id;
	int pID,age,price,seatNo;
	boolean meal;
	
	
	public Passengers(String name, int age, int seatNo,boolean meal,String seatClass) {
		pID = ++id;
		this.meal = meal;
		this.name = name;
		this.age = age;
		this.seatNo = seatNo;
		this.seatClass = seatClass;
	}


	@Override
	public String toString() {
		return "Passengers [pID=" + pID + ", name=" + name + ", age=" + age + ", seatClass=" + seatClass + ", price="
				+ price + ", seatNo=" + seatNo + ", meal=" + meal + "]\n";
	}


	



	
}
