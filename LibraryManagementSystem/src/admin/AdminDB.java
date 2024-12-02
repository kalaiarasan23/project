package admin;

import java.util.HashMap;
import java.util.Map;

public class AdminDB {
	Map<Integer, String> map ;

	public AdminDB() {
		this.map = new HashMap<>();
		map.put(1, "admin1");
		map.put(2, "admin2");
	}
	
	public boolean checkAdmin(int id) {
		return map.containsKey(id);
	}
	
	
}
