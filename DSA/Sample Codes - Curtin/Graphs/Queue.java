public class Queue
{
    private DSALinkedList DSAQueue = new DSALinkedList();

    public void enqueue(Object pVal)
    {
        DSAQueue.insertLast(pVal);
    }

    public Object dequeue()
    {
        Object returnVal = null;
        try
        {
            DSAQueue.peekFirst();
            returnVal = DSAQueue.removeFirst();
        }
        catch (Exception e)
        {
            returnVal = "Nothing to dequeue!";
        }
        return returnVal;
    }

    public boolean isEmpty()
    {
        boolean result = false;
        if (DSAQueue.isEmpty())
        {
            result = true;
        }
        return result;
    }
}