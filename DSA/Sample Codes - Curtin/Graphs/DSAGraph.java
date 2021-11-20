import java.util.Iterator;

class DSAGraph
{
    DSALinkedList vertices;
    Object value = null;


    public DSAGraph()
    {
        vertices = new DSALinkedList();
    }

    public void addVertex(String inLabel, Object inValue)
    {
        if (hasVertex(inLabel) == false)
        {
            DSAGraphVertex vertex = new DSAGraphVertex(inLabel, inValue);
            vertices.insertLast(vertex);
        }
    }

    public void addVertex(String inLabel)
    {
        if (hasVertex(inLabel) == false)
        {
            DSAGraphVertex vertex = new DSAGraphVertex(inLabel);
            vertices.insertLast(vertex);
        }
    }

    public boolean hasVertex(String inLabel)
    {
        boolean found = false;
        DSAGraphVertex tempVertice;
        Iterator itVertices = vertices.iterator();
        while (itVertices.hasNext())
        {
            tempVertice= (DSAGraphVertex) itVertices.next();
            if (tempVertice.getLabel().equals(inLabel))
            {
                found = true;
            }
        }
        return found;
    }

    public Integer getVertexCount()
    {
        Integer count = vertices.getLength();
        return count;
    }

    public void addEdge(String inLabel1, String inLabel2)
    {
        addVertex(inLabel1);
        addVertex(inLabel2);
        getVertex(inLabel1).addLink(getVertex(inLabel2));
    }

    public DSAGraphVertex getVertex(String inLabel)
    {
        DSAGraphVertex returnVertice = null;
        DSAGraphVertex tempVertice;
        Iterator itVertices = vertices.iterator();
        while(itVertices.hasNext())
        {
            tempVertice = (DSAGraphVertex) itVertices.next();
            if (tempVertice.getLabel().equals(inLabel))
            {
                returnVertice = tempVertice;
            }
        }
        return returnVertice;
    }

    public DSALinkedList getAdjacent(String inLabel)
    {
        DSALinkedList returnList = null;
        Iterator itVertices = vertices.iterator();
        DSAGraphVertex tempVertice;
        while (itVertices.hasNext())
        {
            tempVertice = (DSAGraphVertex) itVertices.next();
            if (tempVertice.getLabel().equals(inLabel))
            {
                returnList = tempVertice.getAdjacent();
            }
        }
        return returnList;
    }

    public void display()
    {
        System.out.println("-------------Calling the display function!-------------");
        Iterator itVertices = vertices.iterator();
        DSAGraphVertex tempVertice;
        DSAGraphVertex tempLink;
        while (itVertices.hasNext())
        {
            tempVertice = (DSAGraphVertex) itVertices.next();
            System.out.print("| " +  tempVertice.getLabel());
            Iterator itLinks = tempVertice.getAdjacent().iterator();
            System.out.print(" | ");
            while (itLinks.hasNext())
            {
                tempLink = (DSAGraphVertex) itLinks.next();
                System.out.print(tempLink.getLabel());
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public void breadthFirstSearch(String inLabel)
    {
        DSAGraphVertex startVertex = getVertex(inLabel);
        Queue bfsqueue = new Queue();
        System.out.println(bfsUtil(startVertex, bfsqueue));
    }

    private String bfsUtil(DSAGraphVertex inVertex, Queue bfsqueue)
    {
        DSAGraphVertex currVertice;
        String result = "";
        String currLabel;
        
        bfsqueue.enqueue(inVertex.getLabel());

        while (!bfsqueue.isEmpty())
        {
            currLabel = (String) bfsqueue.dequeue();
            currVertice = getVertex(currLabel);
            if (!currVertice.getVisited())
            {
                result = result + currVertice.getLabel();
                currVertice.setVisited();

                Iterator itNeighbours = currVertice.getAdjacent().iterator();

                while (itNeighbours.hasNext())
                {
                    currVertice = (DSAGraphVertex) itNeighbours.next();
                    bfsqueue.enqueue(currVertice.getLabel());
                }
            }
        }

        Iterator itVertices = vertices.iterator();

        while (itVertices.hasNext())
        {
            currVertice = (DSAGraphVertex) itVertices.next();
            currVertice.clearVisited();
        }

        return result;
    }

    public void depthFirstSearch(String inLabel)
    {
        DSAGraphVertex currVertice;
        DSAGraphVertex startVertex = getVertex(inLabel);
        String result = "";
        dfsUtil(startVertex, result);

        Iterator itVertices = vertices.iterator();

        while (itVertices.hasNext())
        {
            currVertice = (DSAGraphVertex) itVertices.next();
            currVertice.clearVisited();
        }
    }

    private void dfsUtil(DSAGraphVertex inVertex, String result)
    {
        DSAGraphVertex currVertice;
        Iterator itVertex = inVertex.getAdjacent().iterator();
        System.out.print(inVertex.getLabel());
        inVertex.setVisited();

        while (itVertex.hasNext())
        {
            currVertice = (DSAGraphVertex) itVertex.next();
            if (!currVertice.getVisited())
            {
                dfsUtil(currVertice, result);
            } 
        }
    }
}