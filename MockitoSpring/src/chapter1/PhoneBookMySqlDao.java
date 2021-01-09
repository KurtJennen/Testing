package chapter1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class PhoneBookMySqlDao implements PhoneBookDao {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String protocol = "jdbc:mysql://localhost:3306/";
	private String userId = "root";
	private String dbName = "phonebook";
	

	public PhoneBookMySqlDao() {
		loadDriver();
	}
	
	
	protected void loadDriver() {
		try {
			Class.forName(driver).newInstance();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace(System.err);
		} catch (InstantiationException ie) {
			ie.printStackTrace(System.err);
		} catch (IllegalAccessException iae) {
			iae.printStackTrace(System.err);
		}
	}
	
	protected Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties props = new Properties();
		props.put("user",  userId);
		
		conn = DriverManager.getConnection(protocol + dbName + ";create=true", props);
		conn.setAutoCommit(false);
		return conn;
	}


	@Override
	public boolean create(PhoneEntry entry) {
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			preparedStatement = conn.prepareStatement("insert into PhoneBook values (?,?,?)");
			
			preparedStatement.setString(1, entry.getPhoneNumber());
			preparedStatement.setString(2, entry.getFirstName());
			preparedStatement.setString(3, entry.getLastName());
			
			conn.commit();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
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
