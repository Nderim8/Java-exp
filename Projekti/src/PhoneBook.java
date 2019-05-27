import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBook{
 static HashMap<String,Contact> ls; 
   public static void main(String[] args){
    ls=readList(); // lexon kontaktet dhe i shton ne liste
    int ch;
    char con='y';
    Scanner sc=new Scanner(System.in); //krijimi i nje objekti scanner per te marre inputet
    
    while(con=='y'){
     showMenu(); //therret metoden qe na shfaq veprimet qe mund te bejme
     System.out.println("Enter your choice:");
     ch=sc.nextInt();    
     switch(ch){
      case 1:viewAll();break;
      case 2:addToList();break;
      case 3:deleteFromList();break;
      case 4:searchByName();break;
      case 5:System.exit(0);break;
      default: System.out.println("Invalid choice");
      }
    
     try{
      InputStreamReader isr=new InputStreamReader(System.in);
      System.out.println("Press y to continue, any other key to exit:");
      con=(char)isr.read();
     }catch(IOException ie){}
    }
    
   }
   //metoda qe afishon te gjithe kontaktet e ruajtura
   public static void viewAll(){
    
    if(ls!=null){
     Set<String> set=ls.keySet();
     Iterator<String> iterator=set.iterator();
     while(iterator.hasNext()){
      Contact cu=ls.get(iterator.next());
      cu.printInfo();
      }
     }
    
   }
   
   
   // metoda qe shton kontakte te reja ne listen ekzistuese
   public static void addToList(){
	   
    if(ls==null) ls=new HashMap<String,Contact>();
    try{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter name:");
    String name=br.readLine();
    System.out.println("Enter lname:");
    String lname=br.readLine();
    System.out.println("Type (Work, Home etc): ");
    String notype=br.readLine();
    System.out.println("Enter phone:");
    String phone=br.readLine();   
    Contact st=new Contact(name,lname,notype,phone);
    ls.put(name,st); //shtohet kontakti
    writeIt(ls); //ruhet lista e perditesuar
    }catch(IOException e){}
   }
   
   // Fshin nje kontakt te caktuar nga lista
   public static void deleteFromList(){
    if(ls!=null){
     int si=ls.size(); //mban numrin e kontakteve ne liste para fshirjes
     try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Contact name:");
     String key=br.readLine();
     ls.remove(key); //fshirja e kontaktit
     if(ls.size()<si){ // kotrollon a eshte bere vertet fshirja
      writeIt(ls);
      System.out.println("The contact has been deleted.");
     }
     else
      System.out.println("Wrong Contact name");
     }catch(IOException ie){}
     
     
    }
  }
  
   //metoda qe gjen nje kontakt te caktuar
   public static void searchByName(){
    if(ls!=null){
     try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Search by name:");
     String key=br.readLine();
     Contact cu=ls.get(key);
     if(cu!=null)
      cu.printInfo();
      
     else
      System.out.println("Not found");
     }catch(IOException ie){}
     
     
    }
   }
   
   //Shkrimi i objektit Hashmap ne listen e kontakteve qe ruhet ne filein contacts.bin
   public static void writeIt(HashMap<String,Contact> obj){
    try{
    FileOutputStream fos=new FileOutputStream("contacts.bin");
    ObjectOutputStream oos=new ObjectOutputStream(fos);
    oos.writeObject(obj);
    oos.flush();
    oos.close();
    }catch(IOException ie){}
    
   }
   
   // lexon te gjitha kontaktet nga file contacts1.bin
   
   public static HashMap<String,Contact> readList(){
    HashMap<String,Contact> lObject=null;
    try{
    FileInputStream fis=new FileInputStream("contacts1.bin");
    ObjectInputStream ois=new ObjectInputStream(fis);
    lObject=(HashMap<String,Contact>)ois.readObject();
    ois.close();
   
    }catch(Exception ie){}
    return lObject;
    
   }
   
 
   
   // metoda qe shfaq listen e veprimeve qe mund te behet ne fillim
   public static void showMenu(){
    System.out.println("1. VIEW ALL");
    System.out.println("2. ADD");
    System.out.println("3. DELETE");
    System.out.println("4. FIND");
    System.out.println("6. EXIT");
   }
}