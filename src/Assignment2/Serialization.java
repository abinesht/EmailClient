package Assignment2;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Serialization {
	//Serializing and object
	
	public void WriteObjectToFile(ArrayList<Mail> Obj) throws IOException {
		// writes object in Sent_List.txt file
	
		File_Writer file_writer = new File_Writer();
		file_writer.fileExistence("D:\\Sent_List.txt");
		
		FileOutputStream fo = new FileOutputStream("D:\\Sent_List.txt");
		ObjectOutputStream outObj = new ObjectOutputStream(fo);
		
		outObj.writeObject(Obj);
		outObj.close();
		fo.close();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Mail> deserialization() {
		//deserialize objects in Sent_List.txt file and returns an ArrayList
		
		ArrayList<Mail> arrayList = new ArrayList<Mail>();
		try {
	        FileInputStream fi = new FileInputStream("D:\\Sent_List.txt");
	        ObjectInputStream inObj = new ObjectInputStream(fi);
	        
	        arrayList= (ArrayList<Mail>) inObj.readObject();
	
	        inObj.close();
	        fi.close();
        }
        catch(IOException ex)
        {
            System.out.println("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
        }
		return arrayList;
		
	}
}




