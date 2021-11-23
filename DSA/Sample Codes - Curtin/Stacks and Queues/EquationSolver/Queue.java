class Queue
{
    private Object[] Queue = new Object[50];
    Integer head = -1;
    Integer tail = -1;

    public void Queue()
    {
        for (int x = 0; x < 50; x ++)
        {
            Queue[x] = 0;
        }
    }

    public void enqueue(Object pVal)
    {
        if (head == -1) //first element
        {
            head = 0;
            tail = 0;
            Queue[head] = pVal;
        }
        else if (tail == 49)
        {
            System.out.println("Queue is full!");
        }
        else
        {
            tail = tail + 1;
            Queue[tail] =  pVal;
        }
    }

    public Object dequeue()
    {
        Object returnVal;
        if (tail == -1)
        {
            System.out.println("Nothing to dequeue, this queue is empty!");
            returnVal = -1;
        }
        else
        {
            head = head + 1;
            if (head > tail)
            {
                System.out.println("Out of space in this queue!");
                returnVal = -1;
            }
            else
            {
                System.out.println(Queue[head -1]);
                returnVal = Queue[head - 1];
            }
        }
        return returnVal;
    }
}