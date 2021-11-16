package Assignment2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class EmailSerializer implements Runnable {
	private MyBlockingQueue myBlockingQueue;
	
	public EmailSerializer(MyBlockingQueue myBlockingQueue){
		this.myBlockingQueue=myBlockingQueue;
		(new Thread(this)).start();
	}
	
	@Override
	public void run() {		
		while(Thread.currentThread().isAlive()) {
			try {emailSerialize();} catch (Exception e) {}
		}
	}
	
	public void emailSerialize() throws Exception {
		File_Writer file_writer = new File_Writer();
		file_writer.fileExistence("D:\\Received_List.txt");

		FileOutputStream fo = new FileOutputStream("D:\\Received_List.txt",true);
		ObjectOutputStream outObj = new ObjectOutputStream(fo);
		
	
		outObj.writeObject(myBlockingQueue.dequeue());
		outObj.close();
		fo.close();
	}

}
