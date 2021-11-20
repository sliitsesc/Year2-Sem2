class TestHarness
{
    public static void main(String[] args)
    {
        Stack newStack = new Stack();
        testFull(newStack);
        testEmpty(newStack);
        newStack.peek(); 
        newStack.push(2020);
        newStack.peek();
        newStack.push("Budu Saranai");
        newStack.peek();
        newStack.pop();
        newStack.pop();
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
        newStack.push(11); //Should return Stack Full
        newStack.push(12); //Should return Stack Full
    }

    public static void testEmpty(Stack newStack)
    {
        newStack.pop();
        newStack.pop();
        newStack.pop();
        newStack.pop();
        newStack.pop();
        newStack.pop();
        newStack.pop();
        newStack.pop();
        newStack.pop();
        newStack.pop();
        newStack.pop(); //Should return empty
        newStack.pop(); //should return empty
    }
}