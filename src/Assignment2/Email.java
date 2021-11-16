package Assignment2;

import java.io.Serializable;
import java.util.Date;

public class Email implements Serializable{
	private static final long serialVersionUID = 1L;
	private String senderID;
	private String subject;
	private String content;
	private Date receivedDate;
	
	public Email(String senderID,String subject,String content,Date receivedDate) {
		this.senderID=senderID;
		this.subject=subject;
		this.content=content;
		this.receivedDate=receivedDate;
	}
	public String getSenderID() {
		return senderID;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}
		
}
