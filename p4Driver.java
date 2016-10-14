public class p4Driver {
public static void main(String [] args) {
PhoneBook BP = new PhoneBook(new Integer(10000));
System.out.println("Inserting dataset...");
try {
BP.load("C:\\Users\\Owner\\Desktop\\p4_data.txt");
System.out.println("Inserted Successfully");
} catch (Exception e) {
System.out.println("ERROR: Failed to insert dataset!");
System.exit(0);
}
BP.addEntry(new PhoneNumber("324-132-4435"), "Fergy, Ferguson");
System.out.println("\nTesting numberLookup()");
String failSearch = BP.numberLookup(new PhoneNumber("546-321-4543"));
String passSearch = BP.numberLookup(new PhoneNumber("324-132-4435"));
if(failSearch == null)
System.out.println("Search for nonexistant value (Should fail): Failed");
else
System.out.println("Search for nonexistant value (Should fail): Passed");
try {
if(passSearch.compareTo(new String("Fergy, Ferguson")) == 0)
System.out.println("Found number: True");
else
System.out.println("Found number: false");
} catch (Exception e) {
System.out.println("ERROR: PhoneNumber not found!");
}
System.out.println("\nTesting nameLookup()");
PhoneNumber PassSearchPhone = BP.nameLookup(new String("Fergy, Ferguson"));
PhoneNumber failSearchPhone = BP.nameLookup(new String("HoSSSffman, EmissaSy"));
if(failSearchPhone == null)
System.out.println("Search for nonexistant value (Should fail): Failed");
else
System.out.println("Search for nonexistant value (Should fail): Passed");
try {
if(PassSearchPhone.compareTo(new PhoneNumber("324-132-4435")) == 0)
System.out.println("Found number: True");
else
System.out.println("Found number: false");
} catch (Exception e) {
System.out.println("ERROR: Name not found!");
}
System.out.println("\nTesting addEntry()");
PhoneNumber newEntry = new PhoneNumber("858-717-0051");
try {
if(BP.addEntry(newEntry, "Black, Andrew"))
System.out.println("Single Insertion: Passed");
if(!BP.addEntry(newEntry, "Black, Andrew"))
System.out.println("Duplicate Insertion (Should fail): Failed");
System.out.println("Validate Insertion: validated");
} catch (Exception e) {
System.out.println("ERROR: Adding new entry failed");
}
try{
if(BP.numberLookup(newEntry).compareTo("Black, Andrew") == 0) {
System.out.println("Inserted Correctly: True");
} else {
System.out.println("Inserted Correctly: False");
}
} catch (Exception e) {
System.out.println("ERROR: INSERTION INCORRECT");
}
System.out.println("\nTesting deleteEntry()");
try {
BP.deleteEntry(newEntry);
System.out.println("Black, Andrew was deleted: True");
} catch (Exception e) {
System.out.println("ERROR: Delete function failed!");
}
if(BP.numberLookup(newEntry) != null || BP.nameLookup("Black, Andrew") != null)
System.out.println("Black, Andrew was deleted incorrectly!");
System.out.println("\n\nTesting printAll():");
BP.printAll();
System.out.println("\n\nTesting printByAreaCode():");
BP.printByAreaCode("117");
System.out.println("\n\nTesting printNames():");
BP.printNames();
}
}
