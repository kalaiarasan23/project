package railwayTicketBooking;

import java.util.Objects;

public class Passenger {
	int pasId,age;
	String pasName,berthPreference,berthAllogate;
	char gender;
	static int id;
	
	public Passenger(int age, String pasName, String berthPreference, char gender) {
		this.pasId =++id;
		this.age = age;
		this.pasName = pasName;
		this.berthPreference = berthPreference;
		this.gender = gender;
		berthAllogate="";
	}

	@Override
	public String toString() {
		return "Passenger [pasId=" + pasId + ", age=" + age + ", pasName=" + pasName + ", berthPreference="
				+ berthPreference + ", berthAllogate=" + berthAllogate + ", gender=" + gender + "]\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pasId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		return pasId == other.pasId;
	}
	
	
}
