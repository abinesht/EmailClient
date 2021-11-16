package Assignment2;

import java.util.LinkedList;


public class MyBlockingQueue {
	 private LinkedList<Email> myQueue;
	 private int max_queue_size;
	 
	 public MyBlockingQueue(int max_queue_size) {
		 myQueue = new LinkedList<Email>();
		 this.max_queue_size=max_queue_size;
	 }
	 
	 
	 public synchronized void enqueue(Email email) {
		 
		 while (myQueue.size()>=max_queue_size) {
			 try {wait();} catch(Exception e) {}
		 }
		 myQueue.add(email);
		 notifyAll();
		
		 
	 }
	 
	 public synchronized Email dequeue() {
		 Email email;
		 while (myQueue.isEmpty()) {
			 try {wait();} catch(Exception e) {}

		 }
		 email=myQueue.pop();
		 notifyAll();
		 return email;
		 
	 }
}
