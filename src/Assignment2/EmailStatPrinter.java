package Assignment2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EmailStatPrinter implements StateObserver{

	@Override
	public void update(String message) {
		File_Writer file_writer = new File_Writer();
		try {			
			FileWriter filewriter = new FileWriter(file_writer.fileExistence("D:\\notification.txt"),true);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			bufferedwriter.write(message);
			bufferedwriter.newLine();
			bufferedwriter.flush();
			bufferedwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
