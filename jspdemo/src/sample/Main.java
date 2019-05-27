package sample;



import java.util.ArrayList;
import java.util.Scanner;



import databaseLayer.Container;
import entity.PhoneBook;
import entity.PhoneBookManager;

public class Main {

	private static ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
	
	private static PhoneBookManager phoneBookManager = new PhoneBookManager();
	private static String fname;
    
    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);
       
        
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

		
			switch (service) {

			case 1: // Creating a contact

			  //  createContact();
			    System.out.println("Main.main after create");
		        printAllData();

				break;

			case 2: // Editing a contact
				editContact();
				System.out.println("after edit");
				printAllData();
				break;

			case 3: // Deleting a contact
				
				   deleteContact();
				   System.out.println("after delete");
				   printAllData();
				break;
			case 4: // show a contacts

				   printAllData();
		
				break;

			default:
				System.out.println("Choose one of the offered services!");
				break;

			}
		}

		in.close();

	}

        
      /*  phoneBook.setFirstName("BB");
        phoneBook.setLastName("BB");
        phoneBook.setTypeOfNumber(PhoneBook.TYPE_OF_NUMBER_CELLPHONE);
        phoneBook.setNumber("asdasdassad");
        list.add(phoneBook);

        PhoneBook phoneBook1 = new PhoneBook();
        phoneBook1.setFirstName("AAAA");
        phoneBook1.setLastName("AAAA");
        phoneBook1.setTypeOfNumber(PhoneBook.TYPE_OF_NUMBER_WORK);
        phoneBook1.setNumber("asdasdassad2");
        list.add(phoneBook1);

        phoneBookManager.savePhoneBooks(list);
        System.out.println("Main.main after save");
        printAllData();

        PhoneBook phoneBook2 = phoneBookManager.getPhoneBooks("AAAA", "AAAA").get(0);
        phoneBook2.setFirstName("CC");
        phoneBook2.setLastName("CC");
        phoneBook2.setNumber("new Number");
        phoneBookManager.updatePhoneBook(phoneBook2);
        System.out.println("after update");
        printAllData();


        phoneBookManager.deletePhoneBook(phoneBook2);
        System.out.println("after delete");
        printAllData();
   }
*/
   
    public static String getFirstName(){
    	
    	return fname;
    }
    	public static void createContact(String fname, String lname, String type, String number  ){
    		
    		
    		PhoneBook phoneBook = new PhoneBook();
    		
            
//    		Scanner in = new Scanner(System.in);

//    		System.out.println("What is the firstname of the contact? ");
//    		String firstname = in.nextLine();
    		phoneBook.setFirstName(fname);
//    		System.out.println("What is the lastname of the contact? ");
//    		String lastname = in.nextLine();
    		phoneBook.setLastName(lname);
    		

//    			System.out.println(
//    					"What is the type of the contact? (press enter if you don't want to register another entry)");
//    			System.out.println("1 - Work number.");
//    			System.out.println("2 - Cellphone number.");
//    			System.out.println("3 - Home number.");
//    			
//    			String type = in.nextLine();
    			phoneBook.setTypeOfNumber(type);

//    			System.out.println("What is the number of the contact?");
//    			String number = in.nextLine();
    			phoneBook.setNumber(number);
    		
    			  list.add(phoneBook);
    			  try {
					phoneBookManager.savePhoneBooks(list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	
    		// in.close();
    	}
    	
    	
public static void editContact(){
    		
    		Scanner in = new Scanner(System.in);

    		System.out.println("What is the first name of the contact?");
    		String firstname = in.nextLine();
    		System.out.println("What is the last name of the contact?");
    		String lastname = in.nextLine();
    		
    		
    		PhoneBook phoneBook2= null;
    		  try {
				phoneBook2 = phoneBookManager.getPhoneBooks(firstname, lastname).get(0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		  
    		System.out.println("What is the new first name of the contact?");
      		String nfirstname = in.nextLine();
      		System.out.println("What is the new last name of the contact?");
      		String nlastname = in.nextLine();
      		System.out.println("What is the new number of the contact?");
      		String nnumber = in.nextLine();
      		System.out.println("What is the new number of the contact?");
      		String ntypeOfNumber = in.nextLine();
    		  
    		   phoneBook2.setFirstName(nfirstname);
               phoneBook2.setLastName(nlastname);
               phoneBook2.setTypeOfNumber(ntypeOfNumber);
               phoneBook2.setNumber(nnumber);
               
               try {
				phoneBookManager.updatePhoneBook(phoneBook2);
						
	               
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   			
    } 		  
    	public static void deleteContact(){
    		
    		Scanner in = new Scanner(System.in);

    		System.out.println("What is the first name of the contact?");
    		String firstname = in.nextLine();
    		System.out.println("What is the last name of the contact?");
    		String lastname = in.nextLine();
    		
    		
    		PhoneBook phoneBook2= null;
    		  try {
				phoneBook2 = phoneBookManager.getPhoneBooks(firstname, lastname).get(0);
				
				phoneBook2.setFirstName("CC");
		        phoneBook2.setLastName("CC");
		        phoneBook2.setNumber("new Number1");
		        phoneBookManager.updatePhoneBook(phoneBook2);
		       
		        phoneBookManager.deletePhoneBook(phoneBook2);
		        
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        
        
    	
    		/*Scanner in = new Scanner(System.in);
    		// ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
    		
    		System.out.println("What is the first name of the contact?");
    		String firstname = in.nextLine();
    		System.out.println("What is the last name of the contact?");
    		String lastname = in.nextLine();

    		
				 PhoneBook phoneBook1;
						   
				try {
					phoneBook1 = phoneBookManager.getPhoneBooks(firstname, lastname).get(0);
					phoneBookManager.deletePhoneBook(phoneBook1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
	 
				 try {
					phoneBookManager.savePhoneBooks(list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				 	
    		*/
    	}

    public static void printAllData() throws Exception {
        ArrayList<PhoneBook> list = Container.getInstance().getObjects();
        for(PhoneBook phoneBook : list){
            System.out.println(phoneBook);
        }
    }
}
