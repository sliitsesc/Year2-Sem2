class Stack
{
    private Object[] Stack = new Object[50];
    private int head = -1;

    public void Stack() //Constructor to instantiate and initialize the values
    {
        for (int x =0; x < 50; x++)
        {
            Stack[x] = null;
        }
    }

    public void push(Object pVal)
    {
        if (head == 29)
        {
            System.out.println("Stack is full!");
        }
        else
        {
            head = head + 1;
            Stack[head] = pVal;
        }
    }

    public Object pop()
    {
        Object returnAns;
        if (head == -1)
        {
            System.out.println("Stack is empty!");
            returnAns = -1;
        }
        else
        {
            returnAns = Stack[head];
            head = head - 1;
        }
        return returnAns;
    }

    public Object peek()
    {
        Object returnAns;
        if (head == -1)
        {
            returnAns = -1;
        }
        else
        {
            returnAns = Stack[head];
        }   
        return returnAns;
    }

    public boolean isEmpty()
    {
        boolean returnVal;
        if (head == -1)
        {
            returnVal = true;
        }
        else 
        {
            returnVal = false;
        }
        return returnVal;
    }

    public void display()
    {
        for (int x = 29; x > -1; x--)
        {
            System.out.println(x + " : " + Stack[x]);
        }
    }
}