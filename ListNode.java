// Name: Nate Balauro
// Class: CS&145
// Assignment: Phone Book
// Purpose: To create a phone book manager that allows you to add, delete, or change entries in a phonebook.

package Phone_Book;

public class ListNode {
  
   protected String firstName; // data value of node
   protected String lastName; 
   protected String phone; 
   protected String address; 
   protected String city; 
   protected ListNode next;
  
   ListNode(String firstName, String lastName, String phone, String address, String city) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
      this.address = address;
      this.city = city;
      next = null; 
   }
   
} // end of Listnode class