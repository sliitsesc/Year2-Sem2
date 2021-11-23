class Queue
{
    private Object[] Queue = new Object[10];
    Integer head = -1;
    Integer tail = -1;

    public void Queue()
    {
        for (int x = 0; x < 10; x ++)
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
        else if (tail == 9)
        {
            System.out.println("Queue is full!");
        }
        else
        {
            tail = tail + 1;
            Queue[tail] =  pVal;
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
            head = head + 1;
            if (head > tail)
            {
                System.out.println("Out of space in this queue!");
            }
        }
    }
}