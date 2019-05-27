import java.io.*;

class Contact implements Serializable{
 
 private String Name;
 private String LName;
 private String NoType;
 private String Phone;
 
 //konstruktori
 Contact(String name, String lname, String notype,String phone){
  
  this.Name=name;
  this.LName=lname; 
  this.NoType=notype;
  this.Phone=phone;
  
  
 }

 public String getName(){
  return (Name + LName);
 }

 public String getType(){
  return NoType;
 }

 public String getPhone(){
  return Phone;
 }
 
 public void printInfo(){
  System.out.println("Name: "+ Name+ " " + LName+ " Type: " +NoType + " Phone: "+ Phone);
 }
 }