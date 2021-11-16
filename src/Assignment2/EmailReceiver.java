package Assignment2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.search.*;


public class EmailReceiver implements Runnable {
	private MyBlockingQueue myBlockingQueue;
	private List<StateObserver> observers;
	private EmailStatPrinter emailStatPrinter;
	private EmailStatRecorder emailStatRecorder;

	public EmailReceiver(MyBlockingQueue myBlockingQueue){
		this.myBlockingQueue=myBlockingQueue;
		observers=new ArrayList<>();
		emailStatPrinter = new EmailStatPrinter();
		emailStatRecorder = new EmailStatRecorder();
		attach(emailStatPrinter);
		attach(emailStatRecorder);
		(new Thread(this)).start();		//starting this thread
	}
	
	@Override
	public void run() {
		while (Thread.currentThread().isAlive()) {
			try{emailReceive();} catch(Exception e) {}
		}
		
	}

	public void emailReceive() throws Exception {
		
		//Email properties
		String host = "imap.gmail.com";
		String user = "abinesh.19@cse.mrt.ac.lk";
		String password = "Abisharu1126";

		Properties properties = System.getProperties();
		Session session = Session.getDefaultInstance(properties);
		Store store = session.getStore("imaps");
		store.connect(host, user, password);
		Folder inbox = store.getFolder("inbox");
		inbox.open(Folder.READ_WRITE);
		
		// search for all "unseen" messages
		Flags seen = new Flags(Flags.Flag.SEEN);
		FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
		Message messages[] = inbox.search(unseenFlagTerm);

		if (inbox.getUnreadMessageCount()> 0) {
			for (int i = 0; i < messages.length; i++) {
				notifyAllObserver(messages[i].getSentDate());	//notify all observers when receive an email
				Email email = new Email((messages[i].getFrom()[0]).toString(), messages[i].getSubject(),(messages[i].getContent()).toString(),messages[i].getSentDate());
				
				myBlockingQueue.enqueue(email);
				messages[i].setFlag(Flags.Flag.SEEN, true);			//set flag as seen
			}
		}
		inbox.close(true);
		store.close();
	}
	
	public void attach(StateObserver observer) {
		observers.add(observer);
	}
	
	public void notifyAllObserver(Date date) {
		for(StateObserver observer:observers) {
			String message = "An email is received at "+date;
			observer.update(message);
		}
	}

}
