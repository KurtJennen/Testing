package chapter1;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class PhoneBookMySqlSpringDao implements PhoneBookDao {
	
	private final JdbcTemplate jdbcTemplate;
	

	public PhoneBookMySqlSpringDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean create(PhoneEntry entry) {
		int rowCount = jdbcTemplate.update("insert into PhoneBook values (?,?,?)", new Object[] {entry.getPhoneNumber(), entry.getFirstName(), entry.getLastName()});
		return rowCount == 1;
	}

	@Override
	public boolean update(PhoneEntry entryToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PhoneEntry> searchByNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhoneEntry> searchByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhoneEntry> searchByLastName(String lasName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String number) {
		// TODO Auto-generated method stub
		return false;
	}

}
