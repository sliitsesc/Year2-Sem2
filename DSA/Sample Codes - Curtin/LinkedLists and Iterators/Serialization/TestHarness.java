import java.util.*;
import java.io.*;

public class TestHarness
{
    public static void main(String[] args)
    {
        Object c;
        DSALinkedList lList = new DSALinkedList();
        lList.insertFirst("Third");
        lList.insertFirst("Second");
        lList.insertFirst("Hello!");
        lList.insertLast("Fourth");
        
        save(lList, "somefile.bin");
        
        DSALinkedList loadedList = load("somefile.bin");
        System.out.println(loadedList.peekFirst());
        System.out.println(loadedList.peekLast());
    }
    
    private static void save(DSALinkedList objToSave, String fileName)
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

    private static DSALinkedList load(String fileName) throws IllegalArgumentException
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        DSALinkedList inObj = null;

        try
        {
            fileStrm = new FileInputStream(fileName);
            objStrm = new ObjectInputStream(fileStrm);
            inObj = (DSALinkedList) objStrm.readObject();
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
    
}
