class ShuffledQ extends Queue
{
    private Object[] ShuffledQ = new Object[10];

    public void ShuffledQ()
    {
        for (int x = 0; x < 10; x ++)
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
        else if (tail == 9)
        {
            System.out.println("Queue is full!");
        }
        else
        {
            tail = tail + 1;
            ShuffledQ[tail] =  pVal;
        }
    }

    public void dequeue()
    {
        if (tail == -1)
        {
            System.out.println("Nothing to dequeue, this queue is empty!");
        }
        else
        {
            System.out.println(ShuffledQ[head]);
            for (int x = head + 1; x <= tail; x++)
            {
                ShuffledQ[x-1] = ShuffledQ[x];
            }
            tail = tail -1;
        }
    }
}