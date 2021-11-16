package Assignment2;


public class OfficeFriend extends Official implements Sendable {
	//OfficeFriend class
	//child class of Official class
	
	private String birthday;
	
	public OfficeFriend(String name, String email,String designation,String birthday) {
		super(name, email, designation);
		this.birthday=birthday;
	}

	public String getBirthday() {
		return birthday;
	}

	@Override
	public String getBdayMsg() {
		return "Wish you a Happy Birthday. Abinesh";
	}

}
