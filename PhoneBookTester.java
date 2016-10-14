/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import data_structures.*;

public class PhoneBookTester {
    public static void main(String [] args) {
    try {
        PhoneBook book = new PhoneBook(100000);
        book.load("C:\\Users\\Owner\\Desktop\\p4_data.txt");	 
        book.printAll();
        // Simple lookup
        PhoneNumber number = new PhoneNumber("725-972-3525");
        System.out.println("The owner of 725-972-3525 should be Klein, Jennifer");
        System.out.println("The owner of " + number + " is " +
            book.numberLookup(number));
        // invalid insert (it should already be in the PhoneBook)
        if(book.addEntry(number, "Klein, Jennifer"))
            System.out.println("***** ERROR, duplicate entry added *****");
        // now remove this entry
        if(!book.deleteEntry(number))
            System.out.println("***** ERROR, deletion failed *****"); 
        // now search for the just deleted entry 
        String tmp = book.numberLookup(number);
        if(tmp != null)
            System.out.println("***** ERROR, found deleted entry "
                +  tmp + " *****");

        // now put Jason Klein back               
        if(!book.addEntry(number, "Klein, Jason"))            
            System.out.println("***** ERROR, insertion failed *****"); 
                           
        System.out.println(
            "====================================================");
        book.printByAreaCode("619");
      // System.out.println("Mann, Betty: " + book.nameLookup("Mann, Betty").toString());
        System.out.println(
            "====================================================");

        
        }
    catch(Exception e) {
        System.out.println("***** SERIOUS ERROR, this should never happen *****");
        System.out.println("Exception thrown " + e);
        e.printStackTrace();
        }
    }
}       
