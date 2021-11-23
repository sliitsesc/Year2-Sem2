import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


class SortFile
{
    //Both the array of object Student is declared as public variables since they can be accessed from anywhere, this is to 
    //prevent the array being passed everywhere. Pointer for array is also passed to as for some reason it refuses to acknowledge
    //individual elements
    public static Student[] arrStud; 
    public static Integer arrPointer = 0;

    public static void main(String[] args) 
    {
        Integer numLines = readLineNums("RandomNames7000.csv"); //Count the number of lines
        Student[] arrStud = new Student[numLines]; //Instantiate the Student Array with the number of lines
        readFileExample("RandomNames7000.csv", arrStud); //Start reading the file and create objects

        System.out.println("What type of sorting do you need to do?");
        System.out.println("(B)ubble Sort? (I)nsertion Sort? or (S)election Sort?"); //Crude menu of sorts for the user to enter selection
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();
        
        if (option.equals("B"))
        {
            bubbleSort(arrStud);
            writeToFile("BubbleSort", arrStud); //If entered B, sort the data using the Bubble Sort, create a sorted file
        }
        else if (option.equals("I"))
        {
            insertionSort(arrStud);
            writeToFile("InsertionSort", arrStud); //If entered I, sort the data using the Insertion Sort, create a sorted file
        }
        else if (option.equals("S"))
        {
            selectionSort(arrStud);
            writeToFile("SelectionSort", arrStud); //If entered S, sort the data using the Selection Sort, create a sorted file
        }
    }

    public static void readFileExample(String inFilename, Student[] arrStud) //Function that reads the file and creates object Students
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        try 
        {
            fileStrm = new FileInputStream(inFilename); 
            rdr = new InputStreamReader(fileStrm); 
            bufRdr = new BufferedReader(rdr);
            lineNum = 0;
            line = bufRdr.readLine(); 
            while (line != null) 
            { 
                lineNum++; 
                processLine(line, arrStud); //Pass both the line and arrStud as there it claims a NullPointerException even though
                line = bufRdr.readLine(); //array of Students is Public
            }
            fileStrm.close(); 
        }
        catch (IOException e) 
        { 
            if (fileStrm != null) 
            {
                try 
                { 
                    fileStrm.close(); 
                } catch (IOException ex2) {} 
            }
            System.out.println("Error in file processing: " + e.getMessage());
        }
    }

    public static Integer readLineNums(String inFilename) //Function that just counts the number of lines in the file
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        Integer lineNum = 0;
        String line;
        try 
        {
            fileStrm = new FileInputStream(inFilename); 
            rdr = new InputStreamReader(fileStrm); 
            bufRdr = new BufferedReader(rdr);
            line = bufRdr.readLine(); 
            while (line != null) 
            { 
                lineNum++;
                line = bufRdr.readLine(); 
            }
            fileStrm.close(); 
        }
        catch (IOException e) 
        { 
            if (fileStrm != null) 
            {
                try 
                { 
                    fileStrm.close(); 
                } catch (IOException ex2) {} 
            }
            System.out.println("Error in file processing: " + e.getMessage());
        }
        return lineNum;
    }
    
    public static void processLine(String csvRow, Student[] arrStud) //Processes the line read from the file
    {
        String[] arrValues;
        arrValues = csvRow.split(","); //splits the data from the , and puts in a temp array
        arrStud[arrPointer] = new Student(Integer.valueOf(arrValues[0]), arrValues[1]); //creates Student object from the temp array values
        arrPointer = arrPointer + 1; //increment the public variable arrpointer
    }

        // bubble sort
        public static void bubbleSort(Student[] studArr)
        {
          int pass = 0;
          Student temp;
          boolean sorted;

          System.out.println("Bubble Sort Called!");
    
          do
          {
            sorted = true;
            for (int ii = 0; ii < studArr.length-1 - pass; ii++)
            {
              if (studArr[ii].getStudentID() > studArr[ii+1].getStudentID())
              {
                temp = studArr[ii];
                studArr[ii] = studArr[ii + 1];
                studArr[ii+1] = temp;
                sorted = false;
              }
            }
            pass = pass + 1;
          } while (sorted == false);
          
      
        }//bubbleSort()
    
        // selection sort
        public static void selectionSort(Student[] studArr)
        {
          int minIdx;
          Student temp;
            
          System.out.println("Selection Sort Called!");

          for (int nn = 0; nn < studArr.length-1; nn++)
          {
            minIdx = nn;
            for (int jj = nn+1; jj < studArr.length; jj++)
            {
              if (studArr[jj].getStudentID() < studArr[minIdx].getStudentID())
              {
                minIdx = jj;
              }
            }
            temp = studArr[minIdx];
            studArr[minIdx] = studArr[nn];
            studArr[nn] = temp;
          }
    
          
        }// selectionSort()
    
        // insertion sort
        public static void insertionSort(Student[] studArr)
        {
          int ii;
          Student temp;
            
          System.out.println("Insertion Sort Called!");

          for (int nn = 1; nn <= studArr.length - 1; nn++)
          {
            ii = nn;
    
            while (ii > 0 && studArr[ii-1].getStudentID() > studArr[ii].getStudentID())
            {
              temp = studArr[ii];
              studArr[ii] = studArr[ii-1];
              studArr[ii-1] = temp;
    
              ii = ii -1;
            }
          }
    
        }// insertionSort()
    
        public static void writeToFile(String SortName, Student[] studArr) //This function is only called once someone chooses a sort
        {                                                                      //Therefore it will print the now sorted array
            try 
            {
            File myObj = new File(SortName); //create a file
            if (myObj.createNewFile()) //if successfully created
            {
                FileWriter myWriter = new FileWriter(SortName);
                for (int x = 0; x < studArr.length; x++) //for all elements in the Student Array, write
                {
                    myWriter.write(studArr[x].getStudentID() + " , " + studArr[x].getStudentName() + "\n");
                }
                myWriter.close(); //Closing something once opened because of manners
            } else 
            {
                System.out.println("File already exists.");
            }
            } catch (IOException e) 
            {
                System.out.println("Something went wrong.");
            }
        }
        
}
