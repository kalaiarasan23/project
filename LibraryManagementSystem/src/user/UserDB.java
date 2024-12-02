package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDB {
//	List<User> userMap ;
	
	Map<Integer, User> userMaps;
	
	public UserDB() {
//		userMap = new ArrayList<User>();
		userMaps = new HashMap<>();
	}
	
	public void addUser(User user) {
//		userMap.add(new User(name));
		userMaps.put(user.getUserId(),user);
		System.out.println("your id is "+user.getUserId());
	}
	
//	public void updateUser(int id, String name) {
//		User u = userMap.get(id-1);
//		u.setName(name);
//		updateUser(u);
//	}
	
	public void updateUser(User u) {
		userMaps.put(u.getUserId(), u);
	}
	
	public User getUserById(int id) {
		return userMaps.get(id);
	}
	
	public int TotalUserCount() {
		return userMaps.size();
	}
	
	public void printAllUser() {
		System.out.println(userMaps);
	}
	
	public List<User> userTable() {
		return new ArrayList<>(userMaps.values());
	}
	
}
