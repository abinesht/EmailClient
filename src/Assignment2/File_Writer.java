package Assignment2;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class File_Writer {
	//class for check file existence and update details of recipient in a text file
	
	public File fileExistence(String url) throws IOException {
		File file = new File(url);
		if (file.exists()==false)
			file.createNewFile();
		return file;
	}
		
	
	public void updateRecipient(String input) throws IOException {
		// store details in clientList.txt file
		FileWriter filewriter = new FileWriter(fileExistence("D:\\clientList.txt"),true);
		BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
		bufferedwriter.write(input);
		bufferedwriter.newLine();
		bufferedwriter.flush();
		bufferedwriter.close();
	}

}
