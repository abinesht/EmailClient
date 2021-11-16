package Assignment2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BdayMsg {
	Date date = new Date();
	String todayDate= new SimpleDateFormat("yyyy/MM/dd").format(date);	
	ArrayList<Mail> sent_mail_arr = new ArrayList<Mail>();	//keeping details of sent mails
	
	
	public boolean isBday(Sendable obj) {
		// method for check birthday
		if (obj.getBirthday().substring(5).equals(todayDate.substring(5)))
			return true;
		return false;
	}
	

	public void sendBdayMsg(Sendable obj) throws Exception {
		if (isBday(obj)){
			System.out.println("We are sending Birthday Wishes to " + obj.getName());
			Mail mail = new Mail(todayDate,obj.getEmail(), "Birthday Wish", obj.getBdayMsg());	//sending birthday mail
			mail.sendMail();
			sent_mail_arr.add(mail);	//adding Mail object to sent_mail_arr ArrayList

			
		}
			
	}
}
