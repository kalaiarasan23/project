package subTask;

import java.util.ArrayList;
import java.util.Comparator;

public class Emp {
	int empId,phone;
	String name;
	
		
	public Emp(int empId, int phone, String name) {
		super();
		this.empId = empId;
		this.phone = phone;
		this.name = name;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Emp> al = new ArrayList<Emp>();
		
		al.add(new Emp(1, 44636565, "kali"));
		al.add(new Emp(2, 344636565, "dfsasdf"));
		al.add(new Emp(3, 463656545, "kalfjdier"));
		
		System.out.println(al);
		al.sort((o1, o2) -> o1.phone - o2.phone );
		System.out.println(al);
	}


	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", phone=" + phone + ", name=" + name + "]\n";
	}


	

}
