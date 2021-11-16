package Assignment2;

public class Recipient {
	//Recipient class 
	
	private String name;
	private String email;
	static int recipients_num=0;	//for counting total number of recipients
	
	public Recipient(String name, String email) {
		this.name=name;
		this.email=email;
		Recipient.recipients_num++;		// increasing when creating a recipient object
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
}
