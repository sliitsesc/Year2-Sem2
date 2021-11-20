class CirculaQ extends Queue
{
    private Object[] CirculaQ = new Object[10];
    private int elementCount = 0;

    public void CirculaQ()
    {
        for (int x = 0; x < 10; x++)
        {
            CirculaQ[x] = 0;
        }
    }

    public void enqueue(Object pVal)
    {
        // System.out.println(pVal);
        if (elementCount == 10)
        {
            System.out.println("List is full!, tried to enter: " + pVal);
        }
        else
        {
            if (head == -1)
            {
                head = 0;
            }
            tail = tail + 1;
            if (tail == 10)
            {
                tail = 0;
            }
            CirculaQ[tail] = pVal;
            elementCount = elementCount + 1;
        }
        // System.out.println("After inserting " + pVal + ", the head:tail is " + head + ":" + tail);
    }

    public void dequeue()
    {
        if (elementCount == 0)
        {
            System.out.println("Nothing to dequeue, this queue is empty!");
        }
        else
        {
            System.out.println(CirculaQ[head]);
            elementCount = elementCount -1;
            if (head == tail)
            {
                head = -1;
                tail = -1;
            }
            else
            {
                head = head + 1;
                if (head == 10)
                {
                    head = 0;
                }
            }
        }
    }
}