class TestHarness
{
    public static void main(String[] args)
    {
        Stack newStack = new Stack();
        testFull(newStack);
        testEmpty(newStack);
        newStack.push(2020);
        System.out.println(newStack.peek()); //returns 2020
        System.out.println(newStack.pop()); //returns 2020
        newStack.push("Budu Saranai");
        newStack.peek();
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        newStack.isEmpty();
        newStack.push("Hello world!");
        newStack.isEmpty();
    }

    public static void testFull(Stack newStack)
    {
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        newStack.push(5);
        newStack.push(6);
        newStack.push(7);
        newStack.push(8);
        newStack.push(9);
        newStack.push(10);
        newStack.push(11); 
        newStack.push(12); 
    }

    public static void testEmpty(Stack newStack)
    {
        for (int x=0; x < 13; x++)
        {
            System.out.println(newStack.pop());
        }
    }
}