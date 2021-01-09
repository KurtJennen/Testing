package chapter06.mockitomatchers;

import java.util.Map;

public interface UserDAO {
	User getUser(long id);
	
	User getUserByProperties(Map<String, String> properties);
}
