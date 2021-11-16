package Assignment2;


public class Personal extends Recipient implements Sendable{
	//Personal class 
	//child class of Recipient class and implements Sendable interface
	
	private String nickName;
	private String birthday;
	
	public Personal(String name, String email,String nickName,String birthday) {
		super(name, email);			
		this.nickName=nickName;
		this.birthday=birthday;
	}

	public String getBirthday() {
		return birthday;
	}
	
	@Override
	public String getBdayMsg() {
		return "hugs and love on your birthday. Abinesh";
	}

	public String getNickName() {
		return nickName;
	}
	
}
