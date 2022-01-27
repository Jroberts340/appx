package appx;

public class investment_company {
	
	private String company;
	private String oldComp;
	
	public investment_company (String newComp){
		this.company = newComp;
	}
	
	public investment_company (String newComp, String newComp1){
		this.company = newComp;
		this.oldComp = newComp1;
	}
	public String getComp () {
		return company;
	}
	
	public void setComp (String Comp) {
		this.company = Comp;
	}
	
	public String getComp1 () {
		return oldComp;
	}
	
	public void setComp1 (String Comp) {
		this.oldComp = Comp;
	}

}
