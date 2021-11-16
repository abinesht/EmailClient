package Assignment2;

public class Official extends Recipient{
	//Official class 
	//child class of Recipient class
	
	private String designation;
	
	public Official(String name, String email,String designation) {
		
		super(name, email);
		this.designation=designation;
		
	}

	public String getDesignation() {
		return designation;
	}	
	
}
