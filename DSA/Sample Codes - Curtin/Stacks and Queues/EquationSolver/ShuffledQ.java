class ShuffledQ extends Queue
{
    private Object[] ShuffledQ = new Object[50];

    public void ShuffledQ()
    {
        for (int x = 0; x < 50; x ++)
        {
            ShuffledQ[x] = 0;
        }
    }

    public void enqueue(Object pVal)
    {
        // System.out.println("Adding something to the shuffle queue");
        if (head == -1) //first element
        {
            head = 0;
            tail = 0;
            ShuffledQ[head] = pVal;
        }
        else if (tail == 49)
        {
            System.out.println("Queue is full!");
        }
        else
        {
            tail = tail + 1;
            ShuffledQ[tail] =  pVal;
        }
    }

    public Object dequeue()
    {
        Object returnVal;
        if (tail == -1)
        {
            returnVal = -1;
        }   
        else
        {
            returnVal = ShuffledQ[head];
            for (int x = head + 1; x <= tail; x++)
            {
                ShuffledQ[x-1] = ShuffledQ[x];
            }
            tail = tail -1;
        }
        return returnVal;
    }

    public boolean isEmpty()
    {
        boolean returnVal;
        if (tail == -1)
        {
            returnVal = true;
        }
        else
        {
            returnVal = false;
        }
        return returnVal;
    }
}
