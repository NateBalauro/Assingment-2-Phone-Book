// Name: Nate Balauro
// Class: CS&145
// Assignment: Phone Book
// Purpose: To create a phone book manager that allows you to add, delete, or change entries in a phonebook.

package Phone_Book;

import java.util.*;
  
public class LinkedList {
  
   private ListNode head; // first value of list starts as empty
    
   static LinkedList phoneBook = new LinkedList(); // empty list
  
   public static void main(String[] args) {
   
      // Sample
      phoneBook = createNode(phoneBook, "Nate", "Balauro", "123-456-7891", "123 Easy St", "Wenatchee");
        
      mainMenu();
           
   } // end of main
    
    // Method to print the LinkedList.
   public static void viewBook(LinkedList phoneBook)
   {
      ListNode currentNode = phoneBook.head; 
      System.out.println("\nPhone Book:");
      // head has no value
      if(currentNode.firstName == null) {
         System.out.println("No Entries In phone book.");
      }
      // if head has a value
      else {
         while (currentNode != null) {
            System.out.println(currentNode.firstName + " " + currentNode.lastName + ":");
            System.out.println(currentNode.phone + ", " + currentNode.address + ", " + currentNode.city + ".");
            currentNode = currentNode.next; 
         } 
      }
      loop();
   } // end viewBook method
    
   // Method to create new node
   public static LinkedList createNode(LinkedList phoneBook, String firstName, String lastName, String phone, String address, String city) {
      ListNode node = new ListNode(firstName, lastName, phone, address, city); 
   
      if (phoneBook.head == null) { phoneBook.head = node; } //make new node head if list is empty
      else {
         ListNode tail = phoneBook.head; 
         while (tail.next != null) { 
            tail = tail.next;
         } 
         tail.next = node; // changes next value of last node to data value of new node
      }
      return phoneBook;
   } // end of createNode method
    
   // displays main menu
   public static void mainMenu() {
      int menu = 0;
      Scanner input = new Scanner(System.in); 
      while (menu < 1 || menu > 5) {
         try {
            System.out.println("Please Select An Option Below:");
            System.out.println("1. View Phone Book");
            System.out.println("2. Edit Phone Book");
            System.out.println("3. Delete Phone Book");
            System.out.println("4. Add To Phone Book");
            System.out.println("5. Quit");
            menu = input.nextInt();
         } catch (InputMismatchException e) {
            String error = input.nextLine();
         }
         if (menu < 1 || menu > 5) {
            System.out.println("Error: Not A Valid Response");
         }
      } 
   
      if (menu == 1) { // View Directory
         viewBook(phoneBook);
      }
      else if (menu == 2) { // Edit
         editEntry(phoneBook);
      } 
      else if (menu == 3) { // Delete
         deleteEntry(phoneBook);
      }
      else if (menu == 4) { // add 
         addEntry(phoneBook);
      }
      else { // end program
         System.out.println("Quitting...Goodbye!");
         System.exit(0);
      }
   } // end of main menu
   
   public static void addEntry(LinkedList phoneBook) {
      Scanner input = new Scanner(System.in); 
      int answer = 0;
      while (answer < 1 || answer > 3) {
         try {
            System.out.println("Where would you like to add a new entry in the Phone Book? Beginning = 1, Middle = 2, End = 3\t");
            answer = input.nextInt();
         } catch (InputMismatchException e) {
            String error = input.nextLine();
         }
         if (answer < 1 || answer > 3) {
            System.out.println("Error: Not A Valid Response");
         }
      }
   
      if(answer == 1) { addBeginning(phoneBook); }
      else if(answer == 2) { addMiddle(phoneBook); }
      else { addEnd(phoneBook); }
      loop();
   }
   
   // method to add entry to middle
   public static void addMiddle(LinkedList phoneBook) {
      Scanner input = new Scanner(System.in); 
      String firstName; 
      String lastName; 
      String phone; 
      String address; 
      String city; 
   
      System.out.println("Please Provide The Preceding Entry.");
      ListNode entry = findEntry(phoneBook);
   
      System.out.println("NEW ENTRY:");
   
      System.out.print("First Name:\t");
      firstName = input.next();
   
      System.out.print("Last Name:\t");
      lastName = input.next();
        
      System.out.print("Phone Number:\t");
      phone = input.next();
        
      System.out.print("Address:\t");
      address = input.nextLine(); 
      address = input.nextLine();
        
      System.out.print("City:\t");
      city = input.nextLine();
   
      ListNode newEntry = new ListNode(firstName, lastName, phone, address, city); // new entry added
   
      newEntry.next = entry.next; // connects newEntry to node after entry
      entry.next = newEntry; // connects entry to newEntry
   }
   
   // method to add another entry to the beginning
   public static void addBeginning(LinkedList phoneBook) {
   
      Scanner input = new Scanner(System.in); 
      String firstName; 
      String lastName; 
      String phone; 
      String address; 
      String city; 
   
      ListNode oldHead = new ListNode(phoneBook.head.firstName, phoneBook.head.lastName, phoneBook.head.phone, phoneBook.head.address, phoneBook.head.city);
      oldHead.next = phoneBook.head.next; 
   
      System.out.print("First Name:\t");
      firstName = input.next();
   
      System.out.print("Last Name:\t");
      lastName = input.next();
        
      System.out.print("Phone Number:\t");
      phone = input.next();
        
      System.out.print("Address:\t");
      address = input.nextLine();
      address = input.nextLine();
        
      System.out.print("City:\t");
      city = input.nextLine();
   
   // replaces current head values with new values
      phoneBook.head.firstName = firstName; 
      phoneBook.head.lastName = lastName;
      phoneBook.head.phone = phone;
      phoneBook.head.address = address;
      phoneBook.head.city = city;
      phoneBook.head.next = oldHead;
   
      System.out.println("SUCCESSFULLY ADDED:");
      System.out.println(phoneBook.head.firstName + " " + phoneBook.head.lastName + ":");
      System.out.println(phoneBook.head.phone + ", " + phoneBook.head.address + ", " + phoneBook.head.city);
      System.out.println();
   }// end of addBeginning
   
   // method to add another entry to the end 
   public static void addEnd(LinkedList phoneBook) {
      Scanner input = new Scanner(System.in);      
      String firstName; 
      String lastName; 
      String phone; 
      String address;    
      String city;    
   
      System.out.print("First Name:\t");
      firstName = input.next();
   
      System.out.print("Last Name:\t");
      lastName = input.next();
        
      System.out.print("Phone Number:\t");
      phone = input.next();
        
      System.out.print("Address:\t");
      address = input.nextLine();
      address = input.nextLine();
        
      System.out.print("City:\t");
      city = input.nextLine();
        
      createNode(phoneBook, firstName, lastName, phone, address, city);
                
      System.out.println("SUCCESFULLY ADDED:");
      System.out.println(firstName + " " + lastName + ":");
      System.out.println(phone + ", " + address + ", " + city);
      System.out.println();
   } // end addend 
   
   // method to edit 
   public static void editEntry(LinkedList phoneBook) {
      System.out.println("Which Entry Would you Like To Edit?");
      ListNode entry = findEntry(phoneBook);
      
      Scanner input = new Scanner(System.in); 
      int answer = 0;
      String edit;
   
      System.out.println("What Would You Like To edit?");
     
     while (answer < 1 || answer >5){
      try{
      System.out.print("First Name = 1, Last Name = 2, Phone Number = 3, Address = 4, City = 5\t");
      answer = input.nextInt();
        
        } catch (InputMismatchException e) {
            String error = input.nextLine();
         }
         if (answer < 1 || answer > 5) {
            System.out.println("Error: Not A Valid Response");
         }
     }
      
      switch (answer) {
      
         case 1:
            System.out.println("New First Name:\t");
            edit = input.next();
            entry.firstName = edit; 
         
            break;
      
         case 2:
            System.out.println("New Last Name:\t");
            edit = input.next();
            entry.lastName = edit;
            break;
      
         case 3:
            System.out.println("New Phone Number:\t");
            edit = input.next();
            entry.phone = edit;
            break;
      
         case 4:
            System.out.println("New Address:\t");
            edit = input.next();
            entry.address = edit;
            break;
      
         case 5:
            System.out.println("New City:\t");
            edit = input.next();
            entry.city = edit;
            break;
      
         default:
            break;
      
      }
      loop();
   } // end edit
   
    // method to delete 
   public static void deleteEntry(LinkedList phoneBook) {
      System.out.println("Which Would you Like To Delete?");
      ListNode entry = findEntry(phoneBook);
      
      if (entry.firstName.equals(phoneBook.head.firstName)&& entry.lastName.equals(phoneBook.head.lastName)) {
        
         if(entry.next == null){
         
            entry.firstName = null; 
            entry.lastName = null;
            entry.phone = null;
            entry.address = null;
            entry.city = null;
            entry.next = null;
         }
         else {
            entry.firstName = entry.next.firstName; 
            entry.lastName = entry.next.lastName;
            entry.phone = entry.next.phone;
            entry.address = entry.next.address;
            entry.city = entry.next.city;
            entry.next = entry.next.next;
         }
      }
      // if entry is not the head 
      else{  
         ListNode beforeEntry = phoneBook.head;
         while (beforeEntry.next != entry) { 
            beforeEntry = beforeEntry.next; 
         } 
      
         if(beforeEntry.next.next != null) { 
            beforeEntry.next = beforeEntry.next.next;
         }
         else { 
            beforeEntry.next = null;
         }
         entry.next = null; 
      }
      
      loop();
   } // end edit
   
   // method to search phone book by name
   public static ListNode findEntry(LinkedList phoneBook) {
      Scanner input = new Scanner(System.in); 
      String firstName; 
      String lastName;
      int answer = 0;
   
      System.out.print("First Name:\t");
      firstName = input.next();
   
      System.out.print("Last Name:\t");
      lastName = input.next();
   
      ListNode entry = phoneBook.head; 
      while (entry.next != null && !entry.firstName.equals(firstName) && !entry.lastName.equals(lastName)) { 
         entry = entry.next; 
      }
      if(!entry.firstName.equals(firstName)) { 
         System.out.println("Entry was not found");
         loop();
      }
      return entry;
   } // end of search method
   
   public static void loop() {
      Scanner input = new Scanner(System.in); 
      int answer = 0;
      while (answer < 1 || answer >2) {
         try {
             System.out.print("\nWhat do you want to do next?\nReturn To Main Menu = 1, or Quit Program = 2\t");
            answer = input.nextInt();
         } catch (InputMismatchException e) {
            String error = input.nextLine();
         }
         if (answer < 1 || answer > 2) {
            System.out.println("Error: Not A Valid Response");
         }
      } 
      if (answer == 1) {
         mainMenu();
      } else {
         System.out.println("Quitting...Goodbye!");
         System.exit(0);
      }  // end of loop
   }  // end of end
} // end of linkedlistclass

