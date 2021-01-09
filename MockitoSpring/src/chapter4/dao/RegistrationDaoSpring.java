package chapter4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import chapter4.pojo.User;

public class RegistrationDaoSpring implements RegistrationDAO {
	private final JdbcTemplate jdbcTemplate;
	
	public RegistrationDaoSpring(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean isExistingUserId(String userId) {
		return jdbcTemplate.queryForInt("select count(*) from user_data where userId = ?", new Object[] {userId}) > 0;
	}

	@Override
	public void create(String userId, String password, String firstName, String lastName) {
		int rowcount = jdbcTemplate.update("insert into user_data values (?,?,?,?)", new Object[] {userId, password, firstName, lastName});
		if (rowcount != 1) {
			throw new RuntimeException("Database update row count should be 1");
		}
	}
	
	public String retrieveName(String userId) {
		final User user = new User();
		
		jdbcTemplate.query("select firstName from user_data where userid = ?", new Object[] {userId}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setName(rs.getString(0)); 
			}
		});
		
		return user.getName();
	}

}
