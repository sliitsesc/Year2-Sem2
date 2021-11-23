class Stack
{
    private Object[] Stack = new Object[10];
    private int head = -1;

    public void Stack() //Constructor to instantiate and initialize the values
    {
        for (int x =0; x < 10; x++)
        {
            Stack[x] = 0;
        }
    }

    public void push(Object pVal)
    {
        if (head == 9)
        {
            System.out.println("Stack is full!");
        }
        else
        {
            head = head + 1;
            Stack[head] = pVal;
        }
    }

    public void pop()
    {
        if (head == -1)
        {
            System.out.println("Stack is empty!");
        }
        else
        {
            System.out.println(Stack[head]);
            head = head - 1;
        }
    }

    public void peek()
    {
        if (head == -1)
        {
            System.out.println("Tried to peek at nothing since its empty!");
        }
        else
        {
            System.out.println(Stack[head]);
        }   
    }

    public void isEmpty()
    {
        if (head == -1)
        {
            System.out.println("Stack empty!");
        }
        else 
        {
            System.out.println("Stack is not empty!");
        }
    }
}