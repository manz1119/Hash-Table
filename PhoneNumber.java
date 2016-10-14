/*
 * Michael Manzanares
 * masc0363
 */
import java.util.Iterator;
import data_structures.*;

public class PhoneNumber implements Comparable<PhoneNumber> {
    String areaCode, prefix, number;
    String phoneNumber;
   
    // Constructor.  Creates a new PhoneNumber instance.  The parameter
    // is a phone number in the form xxx-xxx-xxxx, which is area code -
    // prefix - number.  The phone number must be validated, and an
    // IllegalArgumentException thrown if it is invalid.
    public PhoneNumber(String n) {
    	phoneNumber = n;
	    this.areaCode = n.substring(0,3) ;
	    this.prefix = n.substring(4,7);
	    this.number = n.substring(8,12);
	    	
	    if(areaCode.length() != 3 || prefix.length() != 3 || number.length() != 4 )
	    	throw new IllegalArgumentException();
    }
    // Follows the specifications of the Comparable Interface.  
    public int compareTo(PhoneNumber n) {return phoneNumber.compareTo(n.phoneNumber);}
    // Returns an int representing the hashCode of the PhoneNumber.
    public int hashCode() {return phoneNumber.hashCode();}
    // Private method to validate the Phone Number.  Should be called
    // from the constructor.   
    private void verify(String n) {
        try{
            int toss = Integer.parseInt(n);
        }
        catch(NumberFormatException e){
	    if(areaCode.length() != 3 || prefix.length() != 3 || number.length() != 4 )
	    	throw new IllegalArgumentException();
        }
    }
    // Returns the area code of the Phone Number.
    public String getAreaCode() {
    	return this.areaCode;
    }
    // Returns the prefix of the Phone Number.
    public String getPrefix() {
    	return this.prefix;
    }
    // Returns the the last four digits of the number.
    public String getNumber() {
    	return this.number;
    }
    // Returns the Phone Number.       
    public String toString() {
    	return this.areaCode + "-" + this.prefix + "-" + this.number;
    }
}            