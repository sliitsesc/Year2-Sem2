import java.io.*;

public class TestHarness
{
    public static void main(String[] args)
    {
        DSAGraph newGraph = new DSAGraph();
        newGraph.addEdge("A", "B");
        newGraph.addEdge("D", "C");
        newGraph.addEdge("A", "C");
        newGraph.display();
        System.out.println(newGraph.getVertexCount());

        graphFromFile();
    }

    public static void graphFromFile()
    {
        String data;
        DSAGraph fileGraph = new DSAGraph();

        try
        {

            File file = new File("prac6_2.al");
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            while ((data = br.readLine()) != null)
            {
                String[] fileVertices = data.split(" ");
                fileGraph.addEdge(fileVertices[0], fileVertices[1]);
            }
        } catch (Exception e)
        {
            System.out.println("Error occurred during file handling");
        }
        fileGraph.display();
        fileGraph.breadthFirstSearch("A");
        fileGraph.depthFirstSearch("A");
    }


}