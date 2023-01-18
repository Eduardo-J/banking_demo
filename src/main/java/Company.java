
public class Company extends AccountHolder{

	String companyName;
	
	Company(String companyName, int taxId) {
		
		super(taxId);
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}
}
