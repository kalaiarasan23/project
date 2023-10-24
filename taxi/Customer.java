package taxi;

public class Customer {
	int cusId,price,time;
	char pickUp,Drop;
	static int id;
	public Customer( int time, char pickUp, char drop) {
		this.cusId=++id;
		this.time = time;
		this.pickUp = pickUp;
		Drop = drop;
	}
	
	public void getPrice(int price)
	{
		this.price=price;
	}
	
	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Customer {cusId=" + cusId + ", price=" + price + ", time=" + time + ", pickUp=" + pickUp + ", Drop="
				+ Drop + "}\n";
	}
}
