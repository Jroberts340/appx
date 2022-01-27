package appx;

public class user_company {

	private int userid;
	private String companyname;
	private String address;
	private String city;
	private String state;
	private int zipcode;
	private double totalinvested;
	
	public user_company(int newuserid, String newcompname, String newaddy, String newcity, String newstate, int newzip, double newinvest) {
		this.userid = newuserid;
		this.companyname = newcompname;
		this.address = newaddy;
		this.city = newcity;
		this.state = newstate;
		this.zipcode = newzip;
		this.totalinvested = newinvest;
	}
	
	public user_company (int newuserid, String newcompname, String newaddy, String newcity, String newstate, int newzip) {
		this.userid = newuserid;
		this.companyname = newcompname;
		this.address = newaddy;
		this.city = newcity;
		this.state = newstate;
		this.zipcode = newzip;
	}
	
	public user_company(int newuserid, String newcompname,double newinvest) {
		this.userid = newuserid;
		this.companyname = newcompname;
		this.totalinvested = newinvest;
	}
	
	public void setUid (int uid) {
		this.userid = uid;
	}
	
	public int getUid() {
		return userid;
	}
	
	public void setCompName (String compname) {
		this.companyname = compname;
	}
	
	public String getCompName() {
		return companyname;
	}
	
	public void setAddy (String address) {
		this.address = address;
	}
	
	public String getAddy() {
		return address;
	}
	
	public void setCity (String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setState (String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	public void setZip (int zip) {
		this.zipcode = zip;
	}
	
	public int getZip() {
		return zipcode;
	}
	
	public void setInvest (double invest) {
		this.totalinvested = invest;
	}
	
	public double getInvest() {
		return totalinvested;
	}
}
