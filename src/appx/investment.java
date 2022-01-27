package appx;

public class investment 
{
	private int userID;
	private String companyname;
	private int shareamount;
	private double purchaseamount;
	private String Time;
	
	public investment(int newUserID, String newCompName, int newSAmount, double newPAmount) {
		this.userID = newUserID;
		this.companyname = newCompName;
		this.shareamount = newSAmount;
		this.purchaseamount = newPAmount;
	}
	
	public investment(int newUserID, String newCompName, int newSAmount, double newPAmount, String newtime) {
		this.userID = newUserID;
		this.companyname = newCompName;
		this.shareamount = newSAmount;
		this.purchaseamount = newPAmount;
		this.Time = newtime;
	}
	
	public investment(int newUserID, int newSAmount, double newPAmount) {
		this.userID = newUserID;
		this.shareamount = newSAmount;
		this.purchaseamount = newPAmount;
	}
	
	public int getID() {
		return userID;
	}
	
	public void setID(int ID) {
		this.userID = ID;
	}
	
	public String getComp() {
		return companyname;
	}
	
	public void setComp(String company) {
		this.companyname = company;
	}
	
	public int getSamount() {
		return shareamount;
	}
	
	public void setSamount(int shareamount) {
		this.shareamount = shareamount;
	}
	
	public double getPamount() {
		return purchaseamount;
	}
	
	public void setPamount(double purchaseamount) {
		this.purchaseamount = purchaseamount;
	}
	
	public String getTime() {
		return Time;
	}
	
	public void setTime(String time) {
		this.Time = time;
	}
	
	@Override
	public String toString()
	{
		return userID + ", " + companyname + ", " + shareamount + ", " + purchaseamount + ", " + Time;
	}
	
}

	