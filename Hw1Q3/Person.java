import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
//Inports the linked list java class
import java.util.LinkedList;

public class Person 
{

  //Create all the string fields
  private String firstName;
  private String lastName;
  private int Id;

  //Person Constructor
  Person(String fname, String lname, int id)
  {
    firstName = fname;
    lastName = lname;
    Id = id;
  }

//Declaring the accessor functions
  public String getFirstName()
  {
    return firstName;
  }
  public String getLastName()
  {
    return lastName;
  }
  public int getId()
  {
    return Id;
  }

  //toString method
  public String toString(){
    return "The person's First Name is: " + firstName + ", Last Name is: " + lastName + ", and Id is:" + Id ;
  }
}

class MyMain 
{
    //Store function to store each person in a linked lsit
    public static void store (Scanner scanner, LinkedList<Person> list)
    {
        // Scans each line as long as there is a person
      while (scanner.hasNextLine()) {
          String[] parts = scanner.nextLine().split(",");
          list.add(new Person(parts[0], parts[1], Integer.parseInt(parts[2])));
      }
    }

    //Display function to print out the linked list
    public static void display (PrintStream outputStream, LinkedList<Person> list)
    {
        //Print out for each item in the list
        for (int i = 0; i < list.size(); i++) { 
            outputStream.println(list.get(i).toString()); 
        }
    }

    //Find function to find a person by the id
    public static int find (int sid, LinkedList<Person> list) 
    {
        //Searches for user
        for (int i=0; i < list.size(); i++)
        {
            if (list.get(i).getId() == sid) 
            {
                return i;
            }
        }
        //If user couldn't be found return -1
        return -1;
    }


    public static void main(String[] args) throws FileNotFoundException 
    {

      String fileName1, outFileName;
      String findAnother;
      File dataFile1, outFile;
      boolean findNext = true;
      int findID;
      LinkedList<Person> personList = new LinkedList<>();
      Scanner keyScanner = new Scanner(System.in);
      //Ask user for input file to be scanned
      System.out.println("Please eneter the name of your input file: ");
      fileName1 = keyScanner.nextLine();
      //Ask user to name the output file it will be printed to
      System.out.println("Please enter name of your output file: ");
      outFileName = keyScanner.nextLine();
      dataFile1 = new File(fileName1);
      outFile = new File(outFileName);
      Scanner fileScanner1 = new Scanner(dataFile1);
      PrintStream printer = new PrintStream(outFile);
      //Store function until print function 
      store(fileScanner1, personList);
      System.out.println("Displaying every person in the list:");
      display(printer, personList);
      while (findNext)
      {
        System.out.println("Please input id to find: ");
        findID = Integer.parseInt(keyScanner.nextLine());
        int index = find(findID, personList);
        if (index != -1) {
            System.out.println("Person with Id " + personList.get(index).getId() + " was found: "+ personList.get(index).toString());
        } else {
            System.out.println("Person with Id " + personList.get(index).getId() + " not found.");
        }
        System.out.println("would you like to continue (y/n): ");
        findAnother = keyScanner.nextLine();
        if (findAnother != "y")
        {
            findNext = false;
        }
      }
    }
}