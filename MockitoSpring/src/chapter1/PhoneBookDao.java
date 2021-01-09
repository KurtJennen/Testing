package chapter1;

import java.util.List;

public interface PhoneBookDao {
	boolean create(PhoneEntry entry);
	boolean update(PhoneEntry entryToUpdate);
	List<PhoneEntry> searchByNumber(String number);
	List<PhoneEntry> searchByFirstName(String firstName);
	List<PhoneEntry> searchByLastName(String lasName);
	boolean delete(String number);	
}
