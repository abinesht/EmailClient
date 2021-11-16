package Assignment2;


import java.util.ArrayList;

public class RecipientArray {
	ArrayList<Recipient> all_records = new ArrayList<Recipient>();		//ArrayList for keep records of all
	ArrayList<Sendable> birthday_records = new ArrayList<Sendable>();	//ArrayList for keep records of birthday wishable persons
	
	public void addToReceipientArrayList(String detail) {
		//method for adding details to ArrayLists
		
		String[] record = detail.split(":");
		String type = record[0];
		if (type.equals("Official")) {
			String[] official_Arr = record[1].split(",");
			Official official = new Official(official_Arr[0],official_Arr[1],official_Arr[2]);
			all_records.add(official);
			
		}else if(type.equals("Personal")){
			String[] personal_Arr = record[1].split(",");
			Personal personal = new Personal(personal_Arr[0],personal_Arr[2],personal_Arr[1],personal_Arr[3]);
			birthday_records.add(personal);
			all_records.add(personal);
			
		}else if (type.equals("Office_friend")) {
			String[] office_friend_Arr = record[1].split(",");
			OfficeFriend officefriend = new OfficeFriend(office_friend_Arr[0],office_friend_Arr[1],office_friend_Arr[2],office_friend_Arr[3]);
			birthday_records.add(officefriend);
			all_records.add(officefriend);
		}

	}
	
}
