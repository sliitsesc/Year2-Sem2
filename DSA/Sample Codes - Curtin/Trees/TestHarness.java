import java.util.*;
import java.io.*;

public class TestHarness
{
    public static void main(String[] args)
    {
        BinarySearchTree newTree = new BinarySearchTree();

        newTree.insert("2", "Hello world!");
        newTree.insert("1", "Hello world!");
        newTree.insert("3", "Hello world!");
        newTree.insert("5", "Hello world!");
        newTree.insert("4", "Hello world!");
        newTree.insert("4.5", "Hello world!");
        newTree.delete("1");
        newTree.display();
    
        System.out.print("The height of this tree is: ");
        System.out.println(newTree.height());
        System.out.print("The smallest value of this tree is: ");
        System.out.println(newTree.minIter());
        System.out.print("The largest value of this tree is: ");
        System.out.println(newTree.maxIter());

        BinarySearchTree balancedTree = new BinarySearchTree();
        balancedTree.insert("2", "Hello world!");
        balancedTree.insert("1", "Hello world!");
        balancedTree.insert("3", "Hello world!");

        balancedTree.balancedMark();
        
        menu();
    }

    public static void menu()
    {
        int input;
        do 
        {
            System.out.println("Please enter the required options to carry them out: ");
            System.out.println("> 1. Read a CSV File");
            System.out.println("> 2. Read a Serialized file");
            System.out.println("> 3. Display the tree");
            System.out.println("> 4. Write a CSV File");
            System.out.println("> 5. Write a Serialized File");
            System.out.println("> 0. Exit");
            Scanner sc = new Scanner(System.in);
            System.out.print("What is your requirement?: ");
            input = sc.nextInt();

            BinarySearchTree newTree = new BinarySearchTree();

            newTree.insert("2", "Hello world!");
            newTree.insert("1", "Hello world!");
            newTree.insert("3", "Hello world!");
            newTree.insert("5", "Hello world!");
            newTree.insert("4", "Hello world!");
            newTree.insert("4.5", "Hello world!");

            switch(input)
            {
                case 1:
                    BinarySearchTree inputTree = new BinarySearchTree();
                    inputTree = readFile("input.csv");
                    inputTree.display();
                    break;
                case 2: 
                    readSerializedFile();
                    break;
                case 3:
                    display(newTree);
                    break;
                case 4:
                    // writeFile(newTree);
                    break;
                case 5:
                    writeSerializedFile(newTree);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Please enter a valid answer");
            }
        } while(input != 0);
    }

    public static void display(BinarySearchTree newTree)
    {
        newTree.display();
    }

    public static void readSerializedFile()
    {
        String fileName = "Serialized File";
        BinarySearchTree loadedTree = load(fileName);
        loadedTree.display();
    }

    public static void writeSerializedFile(BinarySearchTree newTree)
    {
        String fileName = "Serialized File";
        save(newTree, fileName);
    }

    private static void save(BinarySearchTree objToSave, String fileName)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;

        try
        {
            fileStrm = new FileOutputStream(fileName);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(objToSave);
            objStrm.close();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Unable to save object to file");
        }
    }

    private static BinarySearchTree load(String fileName) throws IllegalArgumentException
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        BinarySearchTree inObj = null;

        try
        {
            fileStrm = new FileInputStream(fileName);
            objStrm = new ObjectInputStream(fileStrm);
            inObj = (BinarySearchTree) objStrm.readObject();
            objStrm.close();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class Container not found" + e.getMessage());
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Unable to load object from file");
        }
        return inObj;
    }

    public static BinarySearchTree readFile(String fileName)
    {
        BinarySearchTree returnTree = new BinarySearchTree();
        try
        {
            File myFile = new File(fileName);
            Scanner fileReader = new Scanner(myFile);
            while (fileReader.hasNextLine())
            {
                String data = fileReader.nextLine();
                String[] splitArr = data.split(",");
                returnTree.insert(splitArr[0], splitArr[1]);
            }
            fileReader.close();
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong!");
        }
        return returnTree;
    }

    // public static void writeFile(BinarySearchTree writeTree)
    // {
    //     writeTree.printInOrder("inOrder.csv");
    //     // writeTree.printPreOrder("preOrder.csv");
    //     // writeTree.printPostOrder("postOrder.csv");

    // }   
}