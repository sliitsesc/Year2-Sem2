import java.io.*;

class TestHarness
{
    public static void main(String[] args)
    {
        // DSAHeap finalHeap = new DSAHeap(10);

        // System.out.println("_________Testing the entering of 2, 3, 1, 5________");
        // testHeap.add(1);
        // testHeap.add(2);
        // testHeap.add(3);
        // testHeap.add(5);

        // testHeap.display();
        // System.out.println("_________Testing the removal()________");
        // testHeap.remove();

        // testHeap.display();

        // System.out.println("_________Testing the removal()________");

        // testHeap.remove();

        // testHeap.display();

        // System.out.println("_________Testing the unordered heap!_________");

        // fileLoading("RandomNames7000.csv");

        // System.out.println("_________Sorting the heap!_________");

        DSAHeap finalHeap = new DSAHeap(10);

        finalHeap.add(50);
        finalHeap.add(30);
        finalHeap.display();

    }

    public static void fileLoading(String fileName)
    {
        String data;
        DSAHeap unorderedHeap = new DSAHeap(7000);

        try
        {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            while ((data = br.readLine()) != null)
            {
                String[] fileVertices = data.split(",");
                unorderedHeap.addUnordered(Integer.parseInt(fileVertices[0]));
            }
        } catch (Exception e)
        {
            System.out.println("Error occurred during file handling");
        }

        unorderedHeap.heapSort();
        unorderedHeap.display();
    }
}