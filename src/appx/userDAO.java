package appx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class userDAO 
{
	private static Connection connect;
	
	public userDAO() throws SQLException
	{
		connect = DbConnect.getInstance().getConnection();
	}
	
	public boolean addUser(user user)
	{
		boolean result = false;
		String sqlStatement = new String("INSERT INTO user(firstname, lastname, email, phone, password) VALUES (?, ?, ?, ?, ?)");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, user.getFirst());
			prepSqlStatement.setString(2, user.getLast());
			prepSqlStatement.setString(3, user.getEmail());
			prepSqlStatement.setString(4, user.getPhone());
			prepSqlStatement.setString(5, user.getPassword());
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1)
			{
				result =  false; //should throw exception but keeping it simple
			}
			else {
					result = true;
			}
		} 
		catch (SQLException ex) 
		{
			System.out.println("The Information Entered Could Not Be Used To Created An Account.");
			result =  false;
		}	
		return result; 
	}
	
	public boolean suNewUser(String username) 
	{
		boolean result = false;
		String sqlStatement = new String("SELECT * FROM user WHERE email = ?"); 
		PreparedStatement prepSqlStatement = null;
		try
		{
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, username);
			ResultSet rowCount = prepSqlStatement.executeQuery();
			if (rowCount.next())
			{
				result = false;
			}
			else
				result = true;
		}
		catch (SQLException ex)
		{
			System.out.println("There is an existing account for the email entered.");
			result = false;
		}
		return result;
	}
	
	public String getUserId(String email) {
		String userId = null;
		String sqlStatement = new String("SELECT userid FROM user WHERE email = ?"); 
		PreparedStatement prepSqlStatement = null;

		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1,email);
			ResultSet rs = prepSqlStatement.executeQuery();
			userId = rs.getString(1);
			
		} catch (SQLException e) {
			
		}
		
		return userId;
	}
	
	public boolean deleteUser(String email) {
		boolean result = false; 
		String sqlStatement = new String("DELETE FROM user WHERE email = ?"); 
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, email);
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple
			} 
			else {
				result = true;
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public boolean updateUser(user user) {
		boolean result = false; 
		String sqlStatement = 
				new String("UPDATE user SET firstname = ?, lastname = ?, email = ?,  phone = ?, password = ?"); 
		sqlStatement += " WHERE userid = ?";
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, user.getFirst());
			prepSqlStatement.setString(2, user.getLast());
			prepSqlStatement.setString(3, user.getEmail());
			prepSqlStatement.setString(4, user.getPhone());
			prepSqlStatement.setString(5, user.getPassword());
			prepSqlStatement.setString(6, user.getUser());
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple	
			}
			else {
				result = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			result = false;
		}	
		return result;
	}
}

/////////////////////////////////////////////////////////////////////////////////////////

class investmentDAO 
{
private static Connection connect;
	
	public investmentDAO() throws SQLException
	{
		connect = DbConnect.getInstance().getConnection();
	}
	
	public boolean NewInvest(investment investment) {
		boolean result = false;
		String sqlStatement = new String("INSERT INTO investment(userid, companyname, shareamount, purchaseprice) VALUES (?, ?, ?, ?)");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setInt(1, investment.getID());
			prepSqlStatement.setString(2, investment.getComp());
			prepSqlStatement.setInt(3, investment.getSamount());
			prepSqlStatement.setDouble(4, investment.getPamount());
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1)
			{
				result =  false; //should throw exception but keeping it simple
			}
			else {
				result = true;
			}
		} 
		catch (SQLException ex) 
		{
			System.out.println("Investment Could Not Be Made.");
			result =  false;
		}	
		return result; 
	}
	
	public boolean idCheck(int id) {
		boolean result = false;
		String sqlStatement = new String("SELECT * FROM investment WHERE investmentid = ?");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setInt(1, id);
			ResultSet rowCount = prepSqlStatement.executeQuery();
			if (rowCount.next())
			{
				result =  true; 
			}
			else {
				System.out.println("Investment ID# Does Not Exists or Could Not Be Found");
				result = false;
			}
		} 
		catch (SQLException ex) 
		{
			System.out.println("Investment ID# Does Not Exists or Could Not Be Found");
			result =  false;
		}	
		return result; 
	}
	
	public int get() {
		int investid = 0;
		String sqlStatement = new String("SELECT * FROM investment");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			ResultSet rowCount = prepSqlStatement.executeQuery();
			while(rowCount.next()){
				investid = rowCount.getInt(1); 
			}
		} 
		catch (SQLException ex) 
		{
		}	
		return investid; 
	}
	
	public boolean updateInvestment(investment investment) {
		boolean result = false; 
		String sqlStatement = 
				new String("UPDATE investment SET shareamount = ?, purchaseprice = ?"); 
		sqlStatement += " WHERE investmentid = ?";
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setInt(1, investment.getSamount());
			prepSqlStatement.setDouble(2, investment.getPamount());
			prepSqlStatement.setInt(3, investment.getID());
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple	
			}
			else {
				result = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			result = false;
		}	
		return result;
	}
	
	public boolean deleteInvestment(int id) {
		boolean result = false; 
		String sqlStatement = new String("DELETE FROM investment WHERE investmentid = ?"); 
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setInt(1, id);
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple
			} 
			else {
				result = true;
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public double earned (String comp) {
		double price = 0;
		String sqlStatement = new String("SELECT purchaseprice FROM investment WHERE companyname = ?");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, comp);
			ResultSet rowCount = prepSqlStatement.executeQuery();
			while (rowCount.next())
			{
				price += rowCount.getDouble(1); 
			}
		} 
		catch (SQLException ex) 
		{
		}	
		return price; 
	}
	
	public int num (String comp) {
		int numb = 0;
		String sqlStatement = new String("SELECT * FROM investment WHERE companyname = ?");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, comp);
			ResultSet rowCount = prepSqlStatement.executeQuery();
			while (rowCount.next())
			{
				numb++; 
			}
		} 
		catch (SQLException ex) 
		{
		}	
		return numb; 
	}
	
	public Collection<investment> showInvest(String ID) {
		List<investment> si = new ArrayList<investment>(); 
		String sqlStatement = new String("SELECT * FROM investment WHERE userid = ?");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, ID);
			ResultSet rs = prepSqlStatement.executeQuery();
				while(rs.next()) {
					int investid = rs.getInt(1);
					String comp = rs.getString(3);
					int sAmount = rs.getInt(4);
					Double pAmount = rs.getDouble(5);
					String time = rs.getString(6);
					
					si.add(new investment(investid, comp, sAmount, pAmount, time));
				}
				ObservableList<investment> myOList = FXCollections.observableArrayList(si);

				return myOList;
		} 
		catch (SQLException e) {
			System.out.println("Cant Access Current Investments");
		}
		return null;
		
	}
	
	public Collection<investment> updInvest(int ID) {
		List<investment> si = new ArrayList<investment>(); 
		String sqlStatement = new String("SELECT * FROM investment WHERE investmentid = ?");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setInt(1, ID);
			ResultSet rs = prepSqlStatement.executeQuery();
				while(rs.next()) {
					int investid = rs.getInt(1);
					String comp = rs.getString(3);
					int sAmount = rs.getInt(4);
					double pAmount = rs.getDouble(5);
					String time = rs.getString(6);
					
					si.add(new investment(investid, comp, sAmount, pAmount, time));
				}
				ObservableList<investment> myOList = FXCollections.observableArrayList(si);

				return myOList;
		} 
		catch (SQLException e) {
			System.out.println("Cant Access Current Investments");
		}
		return null;
		
	}
	
}

/////////////////////////////////////////////////////////////////////////////////////////

class previnvestmentDAO {
private static Connection connect;
	
	public previnvestmentDAO() throws SQLException {
		connect = DbConnect.getInstance().getConnection();
	}
	
	public boolean saveInvest(investment_history investment) {
		boolean result = false;
		String sqlStatement = new String("INSERT INTO investment_history (type, investmentid, userid, companyname, shareamount, purchaseprice) VALUES (?, ?, ?, ?, ?, ?)");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, investment.getType());
			prepSqlStatement.setInt(2, investment.getiID());
			prepSqlStatement.setInt(3, investment.getuID());
			prepSqlStatement.setString(4, investment.getComp());
			prepSqlStatement.setInt(5, investment.getSamount());
			prepSqlStatement.setDouble(6, investment.getPamount());
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1)
			{
				result =  false; 
			}
			else {
				result = true;
			}
		} 
		catch (SQLException ex) 
		{
			result =  false;
		}	
		return result; 
	}
	
	public boolean clearHistory(int id) {
		boolean result = false; 
		String sqlStatement = new String("DELETE FROM investment_history WHERE userid = ?"); 
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setInt(1, id);
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple
			} 
			else {
				result = true;
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public Collection<investment_history> showHistory(String ID) {
		List<investment_history> si = new ArrayList<investment_history>(); 
		String sqlStatement = new String("SELECT * FROM investment_history WHERE userid = ?");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, ID);
			ResultSet rs = prepSqlStatement.executeQuery();
				while(rs.next()) {
					String type = rs.getString(1);
					int investid = rs.getInt(2);
					int userid = rs.getInt(3);
					String comp = rs.getString(4);
					int sAmount = rs.getInt(5);
					Double pAmount = rs.getDouble(6);
					String time = rs.getString(7);
					
					si.add(new investment_history(type, investid, userid, comp, sAmount, pAmount, time));
				}
				ObservableList<investment_history> myOList = FXCollections.observableArrayList(si);

				return myOList;
		} 
		catch (SQLException e) {
			System.out.println("Cant Access Current Investments");
		}
		return null;
		
	}
}

/////////////////////////////////////////////////////////////////////////////////////////

class company {
	private static Connection connect;
	
	public company() throws SQLException {
		connect = DbConnect.getInstance().getConnection();
	}
	
	public boolean addcomp(investment_company comp) {
		boolean result = false;
		String sqlStatement = new String("INSERT INTO investment_companies (company) VALUES (?)");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, comp.getComp());
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1)
			{
				result =  false; 
			}
			else {
				result = true;
			}
		} 
		catch (SQLException ex) 
		{
			result =  false;
		}	
		return result; 
	}
	
	public boolean updateComp(investment_company comp) {
		boolean result = false; 
		String sqlStatement = 
				new String("UPDATE investment_companies SET company = ?"); 
		sqlStatement += " WHERE company = ?";
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, comp.getComp());
			prepSqlStatement.setString(2, comp.getComp1());
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple	
			}
			else {
				result = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			result = false;
		}	
		return result;
	}
	
	public boolean deletecomp(String id) {
		boolean result = false; 
		String sqlStatement = new String("DELETE FROM investment_companies WHERE company = ?"); 
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, id);
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple
			} 
			else {
				result = true;
			}
		}
		catch (SQLException ex){
			result = false;
		}
		return result;
	}
	
	public Collection<investment_company> showCompany(){
		List<investment_company> sc = new ArrayList<investment_company>();
		String sqlStatement = new String("Select * From investment_companies");
		PreparedStatement prepSqlStatement = null;
		
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			ResultSet rs = prepSqlStatement.executeQuery();
				while(rs.next()) {
					String comp = rs.getString(1);
					
					sc.add(new investment_company(comp));
				}
				ObservableList<investment_company> myOlist = FXCollections.observableArrayList(sc);
				
				return myOlist;
				
		} catch (SQLException e) {
			System.out.println("Cannot List Companies");
		}
		
	
		return null;
	}
	
}

/////////////////////////////////////////////////////////////////////////////////////////

class usecomp {
	private static Connection connect;
	
	public usecomp() throws SQLException {
		connect = DbConnect.getInstance().getConnection();
	}
	
	public boolean compCheck(String id) {
			boolean result = false;
			String sqlStatement = new String("SELECT * FROM user_companies WHERE userid = ?");
			PreparedStatement prepSqlStatement = null;
			try {
				prepSqlStatement = connect.prepareStatement(sqlStatement);
				prepSqlStatement.setString(1, id);
				ResultSet rowCount = prepSqlStatement.executeQuery();
				if (rowCount.next())
				{
					result = true; 
				}
				else if (!rowCount.next()){
					result = false;
				}
			} 
			catch (SQLException ex) {} 
				
			return result; 
		
	}
		
		
	
	public boolean register(user_company comp) {
		boolean result = false;
		String sqlStatement = new String("INSERT INTO user_companies (userid, companyname, address, city, state, zipcode, totalinvested) VALUES (?, ?, ?, ?, ?, ?, ?)");
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setInt(1, comp.getUid());
			prepSqlStatement.setString(2, comp.getCompName());
			prepSqlStatement.setString(3, comp.getAddy());
			prepSqlStatement.setString(4, comp.getCity());
			prepSqlStatement.setString(5, comp.getState());
			prepSqlStatement.setInt(6, comp.getZip());
			prepSqlStatement.setDouble(7, comp.getInvest());
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1)
			{
				result =  false; 
			}
			else {
				result = true;
			}
		} 
		catch (SQLException ex) 
		{
			result =  false;
		}	
		return result; 
	}
	
	public boolean updateamount(user_company comp) {
		boolean result = false; 
		String sqlStatement = 
				new String("UPDATE user_companies SET totalinvested = ? WHERE userid = ? AND companyname = ?"); 
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setDouble(1, comp.getInvest());
			prepSqlStatement.setInt(2, comp.getUid());
			prepSqlStatement.setString(3, comp.getCompName());
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple	
			}
			else {
				result = true;
			}
		} catch (SQLException ex) {
			result = false;
		}	
		return result;
	}
	
	public boolean deleteComp(int id) {
		boolean result = false; 
		String sqlStatement = new String("DELETE FROM user_companies WHERE userid = ?"); 
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setInt(1, id);
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple
			} 
			else {
				result = true;
			}
		}
		catch (SQLException ex){
			result = false;
		}
		return result;
	}
	
	public Collection<user_company> showUserCompany(int ID){
		List<user_company> sc = new ArrayList<user_company>();
		String sqlStatement = new String("Select * From user_companies WHERE userid = ?");
		PreparedStatement prepSqlStatement = null;
		
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setInt(1, ID);
			ResultSet rs = prepSqlStatement.executeQuery();
				while(rs.next()) {
					int user = rs.getInt(1);
					String comp = rs.getString(2);
					String addy = rs.getString(3);
					String city = rs.getString(4);
					String state = rs.getString(5);
					int zip = rs.getInt(6);
					double tot = rs.getDouble(7);
					
					sc.add(new user_company(user, comp, addy, city, state, zip, tot));
				}
				ObservableList<user_company> myOlist = FXCollections.observableArrayList(sc);
				
				return myOlist;
				
		} catch (SQLException e) {
			System.out.println("Cannot List Companies");
		}
		
	
		return null;
	}
	
	public boolean deleteIComp(String id) {
		boolean result = false; 
		String sqlStatement = new String("DELETE FROM investment WHERE companyname = ?"); 
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, id);
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple
			} 
			else {
				result = true;
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public boolean updateCompInfo(user_company comp) {
		boolean result = false; 
		String sqlStatement = 
				new String("UPDATE user_companies SET companyname = ?, address = ?, city = ?,  state = ?, zipcode = ?"); 
		sqlStatement += " WHERE userid = ?";
		PreparedStatement prepSqlStatement = null;
		try {
			prepSqlStatement = connect.prepareStatement(sqlStatement);
			prepSqlStatement.setString(1, comp.getCompName());
			prepSqlStatement.setString(2, comp.getAddy());
			prepSqlStatement.setString(3, comp.getCity());
			prepSqlStatement.setString(4, comp.getState());
			prepSqlStatement.setInt(5, comp.getZip());
			prepSqlStatement.setInt(6, comp.getUid());
			int rowCount = prepSqlStatement.executeUpdate();
			if (rowCount != 1){
				result = false; //should throw exception but keeping it simple	
			}
			else {
				result = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			result = false;
		}	
		return result;
	}
}
