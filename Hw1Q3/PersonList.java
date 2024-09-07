import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
//Inports the linked list java class
import java.util.LinkedList;
import java.util.stream.Stream;

//Person Linked List class
public class PersonList {
    
    private LinkedList<Person> list;
    
    //Constructor
    PersonList()
    {
        list = new LinkedList<Person>();
    }

    //Accesor function
    public LinkedList<Person> getList()
    {
        return list;
    }

    //Store function
    public void store (Scanner scanner)
    {
      while (scanner.hasNextLine()) {
          String[] parts = scanner.nextLine().split(",");
          list.add(new Person(parts[0], parts[1], Integer.parseInt(parts[2])));
      }
    }

    //Display function
    public void display (PrintStream outputStream)
    {
        for (int i = 0; i < list.size(); i++) { 
            outputStream.println(list.get(i).toString()); 
        }
    }

    //Find Function
    public int find (int sid) 
    {
        for (int i=0; i < list.size(); i++)
        {
            if (list.get(i).getId() == sid) 
            {
                return i;
            }
        }
        return -1;
    }
}

class MyMainQ3 {
    public static void main(String[] args) throws FileNotFoundException {
      String fileName1, outFileName;
      String findAnother;
      File dataFile1, outFile;
      boolean findNext = true;
      int findID;
      PersonList personList = new PersonList();
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
      personList.store(fileScanner1);
      System.out.println("Displaying every person in the list:");
      personList.display(printer);

      while (findNext)
      {
        System.out.println("Please input id to find: ");
        findID = Integer.parseInt(keyScanner.nextLine());
        int index = personList.find(findID);
        if (index != -1) {
            System.out.println("Person with Id " + personList.getList().get(index).getId() + " was found: "+ personList.getList().get(index).toString());
        } else {
            System.out.println("Person with Id " + personList.getList().get(index).getId() + " not found.");
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