class DSAGraphVertex
{
    String label;
    Object value = null;
    DSALinkedList links;
    boolean visited;

    public DSAGraphVertex(String inLabel, Object inValue)
    {
        label = inLabel;
        value = inValue;
        links = new DSALinkedList();
        visited = false;
    }

    public DSAGraphVertex(String inLabel)
    {
        label = inLabel;
        links = new DSALinkedList();
        visited = false;
    }

    public void addLink(DSAGraphVertex inVertex)
    {  
       links.insertLast(inVertex);
    }

    public String getLabel()
    {
        return label;
    }

    public Object getValue()
    {
        return value;
    }

    public DSALinkedList getAdjacent()
    {
        return links;
    }

    public void setVisited()
    {
        visited = true;
    }

    public void clearVisited()
    {
        visited = false;
    }

    public boolean getVisited()
    {
        return visited;
    }


}