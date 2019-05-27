/**
 * Nderim Kurti  7/12/2017
 **/


package phoneBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PhoneBook {

	private ArrayList<User> users;

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public static void main(String[] args) throws IOException{

		showMenu();

	}

	
	@SuppressWarnings("unchecked")
	public static void showMenu() throws IOException {

		// ArrayList<Entry> entries = new ArrayList<Entry>();
	//	User user = new User();
		// Entry entry = new Entry();

		Scanner in = new Scanner(System.in);
 	//	JSONObject root = new JSONObject();

		// String firstname;
		// String lastname;
		// String type;
		// int number;
		
		int service = 0;
		while (true) {

			System.out.println("What would you like to do ? (choose a number)");
			System.out.println("0 - Stop.");
			System.out.println("1 - Create a contact.");
			System.out.println("2 - Edit a contact.");
			System.out.println("3 - Delete a contact.");
			System.out.println("4 - Show my contacts.");

			if (in.hasNextInt()) {
				service = in.nextInt();
			} else {
				System.out.println("Error!");
				System.out.println("You have to input a number!");
				break;
			}

			if (service == 0) {
				break;
			}

			if (in.hasNextLine()) {
				in.nextLine();
			}

			switch (service) {

			case 1: // Creating a contact

			    createContact();

				break;

			case 2: // Editing a contact
				System.out.println("What is the name of the contact you want to edit? (Firstname Lastname)");
				String editContactName = in.nextLine();
				
				editContact(editContactName);

				break;

			case 3: // Deleting a contact
				System.out.println("What is the name of the contact you want to delete? (Firstname Lastname)");
				
				String deleteContactName = in.nextLine();
				deleteContact(deleteContactName);
		
				break;
			case 4: // show a contacts

				showContacts();
		
				break;

			default:
				System.out.println("Choose one of the offered services!");
				break;

			}
		}

		in.close();

	}
	
	public static void createContact(){
		

		Scanner in = new Scanner(System.in);
		JSONObject root = new JSONObject();

		JSONArray entries = new JSONArray();
		// obj.put("Name",user.getUserName());

		System.out.println("What is the firstname of the contact? ");
		String firstname = in.nextLine();
		root.put("Firstname", firstname);
		System.out.println("What is the lastname of the contact? ");
		String lastname = in.nextLine();
		root.put("Lastname", lastname);

		while (true) {
			// creating a json object for the entry data
			JSONObject entry = new JSONObject();

			System.out.println(
					"What is the type of the contact? (press enter if you don't want to register another entry)");
			System.out.println("1 - Work number.");
			System.out.println("2 - Cellphone number.");
			System.out.println("3 - Home number.");
			
			String type = in.nextLine();

			// check to see if the user hit enter (the break point)
			if (type.length() == 0) {
				break;
			}
			// put the type of the entry in the json object
			entry.put("Type", type);

			System.out.println("What is the number of the contact?");
			long number = 0;
			// check to see if the input for number is a number
			if (in.hasNextLong()) {
				number = in.nextLong();
			} else {
				System.out.println("Error!");
				System.out.println("You have to input a number!");
				System.exit(0);
			} // end else

			// get read of the input leak after in.nextLong()
			if (in.hasNextLine()) {
				in.nextLine();
			}
			// put the number in the json object
			entry.put("Number", number);
			// add the json object(entry) in the json array(entries)
			entries.add(entry);

		} // end while

		// put the json array(entries) in the main json object(root)
		root.put("Entries", entries);

		// create a json file
		File file = new File("phoneBook.json");
		try (PrintWriter pw = new PrintWriter(new FileWriter(file, true));) {

			// write the main json object(root) in the json file
			pw.println(root.toString());
			System.out.println("Successfully wrote the json object in the file.");
			System.out.println(root.toJSONString());

		} catch (IOException e) {

			e.printStackTrace();

		}

		in.close();
	}
	
	public static void showContacts(){
		
		
		try{
	        File file = new File("phoneBook.json");
			JSONParser parser = new JSONParser();
			StringBuilder jsonIn = new StringBuilder();
						   				
			Scanner in = new Scanner(file);
			while(in.hasNextLine()){
				jsonIn.append(in.nextLine());
				 System.out.println();
			}
			
				JSONObject objRoot = (JSONObject) parser.parse(jsonIn.toString());
	
			System.out.printf("Firstname of the contact is %s\n", objRoot.get("Firstname").toString());
			
			    System.out.println("List of contacts : " + jsonIn.toString());
				JSONArray entries = (JSONArray) objRoot.get("Entries");	
				System.out.println("Printing the entries of this contact :");
				// print the entries for a certain person
				for(int i=0; i<entries.size(); i++){
					
					JSONObject entry = (JSONObject) entries.get(i);
					System.out.print("Entry"+ i + "--");
					String type = (String) entry.get("Type");
					long number = (long) entry.get("Number");
					System.out.printf("Type %s: Number %d\n", type, number );				    	
					
				}
				
				System.out.println();
				
				 in.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
			       	
		
	}

	public static void deleteContact(String name){

		

	}
	
   public static void editContact(String name){

		

	}
	
	
	public static void iterateThroughContacts(){
		
		/*
		JSONObject obj = JSONUtils.getJSONObjectFromFile("/phoneBook.json");
		String names[] = JSONObject.getNames(obj);
		for(String string : names){
			
			System.out.println(string + ": " + obj.get(string));
			
		}
		*/
		
		
	}
	
	
		
	
	

}




