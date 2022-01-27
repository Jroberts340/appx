package appx;

public class investment_history 
{
	private String type;
	private int investID;
	private int userID;
	private String companyname;
	private int shareamount;
	private double purchaseamount;
	private String Time;
	
	public investment_history(String newType, int newInvestID, int newUserID, String newCompName, int newSAmount, double newPAmount) {
		this.type = newType;
		this.investID = newInvestID;
		this.userID = newUserID;
		this.companyname = newCompName;
		this.shareamount = newSAmount;
		this.purchaseamount = newPAmount;
	}
	
	public investment_history(String newType, int newInvestID, int newUserID, String newCompName, int newSAmount, double newPAmount, String newTime) {
		this.type = newType;
		this.investID = newInvestID;
		this.userID = newUserID;
		this.companyname = newCompName;
		this.shareamount = newSAmount;
		this.purchaseamount = newPAmount;
		this.Time = newTime;
	}
	
	public investment_history(int newInvestID) {
		this.investID = newInvestID;
	}
	
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getiID() {
		return investID;
	}
	
	public void setiID(int ID) {
		this.investID = ID;
	}
	
	public int getuID() {
		return userID;
	}
	
	public void setuID(int ID) {
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

	
