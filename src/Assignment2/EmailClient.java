package Assignment2;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmailClient {
	//Main class
	
	static Date date = new Date();
	static String todayDate= new SimpleDateFormat("yyyy/MM/dd").format(date);
	
	public static void main(String[] args) throws Exception {		
      
	  MyBlockingQueue myBlockingQueue = new MyBlockingQueue(4);
	  EmailReceiver emailReceiver = new EmailReceiver(myBlockingQueue);
	  EmailSerializer emailSerializer = new EmailSerializer(myBlockingQueue);
	  
	  File_Writer file_writer = new File_Writer();
      RecipientArray recipientarray = new RecipientArray();
      
      //add all details in RecipientArray when program starts
      file_writer.fileExistence("D:\\clientList.txt");	// checking existence of file
      Scanner sc0 = new Scanner(new File("D:\\clientList.txt"));
      while(sc0.hasNext()){
          String file_record = sc0.nextLine();
          recipientarray.addToReceipientArrayList(file_record);
          
      }	
      
      BdayMsg bdaymsg = new BdayMsg();
      Serialization serialization = new Serialization();
      bdaymsg.sent_mail_arr=serialization.deserialization();	//deserializing objects in Sent_List.txt file
      
      //Storing sent email id
      ArrayList<String> sent_email_id = new ArrayList<String>();	//ArrayList for storing sent email id
      for (Mail i : bdaymsg.sent_mail_arr)
      	sent_email_id.add(i.getEmail());
      	
      //sending birthday wishes for clients when program starts
      for (Sendable s : recipientarray.birthday_records) {
      	if (!sent_email_id.contains(s.getEmail()))   //checking already mail sent or not   		
      		bdaymsg.sendBdayMsg(s);
      		sent_email_id.add(s.getEmail());
      }
		
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter option type: \n"
            + "1 - Adding a new recipient\n"
            + "2 - Sending an email\n"
            + "3 - Printing out all the recipients who have birthdays\n" 
            + "4 - Printing out details of all the emails sent\n"
            + "5 - Printing out the number of recipient objects in the application");
      int option = scanner.nextInt();
      
      
      switch(option){
      
            case 1:
          	  // code to add a new recipient
          	  Scanner sc1 = new Scanner(System.in);
          	  System.out.println("Input your new recipent details");
          	  System.out.println("Input Format: \n"
	                      +"Official: Name,Email address,Designation\n"
	                      +"Office_friend: Name,Email address,Designation,Birth date\n"
	                      +"Personal: Name,Nick name,Email address,Birth date");
          	  String inp = sc1.nextLine();	// input format - Official: nimal,nimal@gmail.com,ceo
          	  
          	  File_Writer file_writer1 = new File_Writer();
          	  file_writer1.updateRecipient(inp);
          	  System.out.println("Successfully updated......!");
                                 
                break;
                
            case 2:
          	  // code to send an email
          	  Scanner sc2 = new Scanner(System.in);
          	  System.out.println("Input your email details");
          	  System.out.println("input format - email, subject, content");
          	  String email_detail_fromuser = sc2.nextLine();		// input format - email, subject, content
          	  String[] email_data = email_detail_fromuser.split(",");
          	  
          	  try {									//handle exception for wrong input type
	            	  String email= email_data[0];
	            	  String subject= email_data[1];
	            	  String content = email_data[2];
	            	  Mail mail = new Mail(todayDate,email,subject,content);
	            	  mail.sendMail();     
	            	  bdaymsg.sent_mail_arr.add(mail);
	            	  
          	  }catch (ArrayIndexOutOfBoundsException e){
          		  System.out.println("Invalid Input");
          	  }
                                
                break;
                
            case 3:
          	  // code to print recipients who have birthdays on the given date
          	  Scanner sc3 = new Scanner(System.in);
          	  System.out.println("input format - yyyy/MM/dd (ex: 2018/09/17)");	 // input format - yyyy/MM/dd (ex: 2018/09/17)
          	  String date_from_user = sc3.nextLine();
          	  
          	  System.out.println("Persons who have birthday on : "+ date_from_user);
          	  
          	  for (Sendable s : recipientarray.birthday_records) {	
                    if (s.getBirthday().substring(5, s.getBirthday().length()).equals(date_from_user.substring(5, date_from_user.length()))) {
          			  System.out.println(s.getName());
                    }
          	  }
                                 
                break;
                
            case 4:
          	  // code to print the details of all the emails sent on the input date
          	  Scanner sc4 = new Scanner(System.in);
          	  System.out.println("input format - yyyy/MM/dd (ex: 2018/09/17)"); 	// input format - yyyy/MM/dd (ex: 2018/09/17)
          	  String date_fromuser1 = sc4.nextLine();
          	  
          	  for (Mail s : bdaymsg.sent_mail_arr) {	// calling all sent mails
          		  if (s.getDate().equals(date_fromuser1))	// checking with input date
          			  System.out.println("Email Id : "+ s.getEmail()+ "\t Subject : " +s.getSubject()+ "\t Content : "+s.getContent());
          	  }
                                 
                break;
                
            case 5:
          	  // code to print the number of recipient objects in the application            	  
                System.out.println("Number of Recipients is : " + Recipient.recipients_num);
                               
                break;
                
            default:
          	  //case for other integer inputs
          	  System.out.println("Wrong Input");
      }
              
      serialization.WriteObjectToFile(bdaymsg.sent_mail_arr);	 //serializing sent mail objects
      System.out.println("Program successfully completed....!!");
      scanner.close();
	}

}
