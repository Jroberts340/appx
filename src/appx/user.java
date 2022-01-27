package appx;

public class user 
{
	private String userID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password;
	
	public user (String newfname, String newlname, String newemail, String pnum, String newpass)
	{
		this.firstName = newfname;
		this.lastName = newlname;
		this.email = newemail;
		this.phoneNumber = pnum;
		this.password = newpass;
	}
	
	public user (String newfname, String newlname, String newemail, String pnum, String newpass, String newuserID)
	{
		this.userID = newuserID;
		this.firstName = newfname;
		this.lastName = newlname;
		this.email = newemail;
		this.phoneNumber = pnum;
		this.password = newpass;
	}
	
	public String getUser()
	{
		return userID;
	}
	
	public void setUser(String ID)
	{
		this.userID = ID;
	}
	
	public String getFirst()
	{
		return firstName;
	}
	
	public void setFirst(String fname)
	{
		this.firstName = fname;
	}
	
	public String getLast()
	{
		return lastName;
	}
	
	public void setLast(String lname)
	{
		this.lastName = lname;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPhone()
	{
		return phoneNumber;
	}
	
	public void setPhone(String phone)
	{
		this.phoneNumber = phone;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String pass)
	{
		this.password = pass;
	}
	
	@Override
	public String toString()
	{
		return userID + ", " + firstName + ", " + lastName + ", " + email + ", " + phoneNumber + ", " + password;
	}
}
