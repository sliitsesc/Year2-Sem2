class CallStack
{
    private static Stack callStack = new Stack();

    public static void main(String[] args)
    {
        functionSimulator();
        recursionSimulator(1);
    }

    public static void functionSimulator()
    {
        function1("Inside Function 1 wohoo!");
    }

    public static void function1(String pVal)
    {
        callStack.push("function1: " + pVal);
        function2("Inside Function 2 wohoo!");
        callStack.pop();
    }

    public static void function2(String pVal)
    {
        callStack.push("function2: " + pVal);
        function3("Inside Function 3 wohoo!");
        callStack.pop();
    }

    public static void function3(String pVal)
    {
        callStack.push("function3: " + pVal);
        callStack.display();
        callStack.pop();
    }

    public static void recursionSimulator(Integer count)
    {
        if (count == 4)
        {
            callStack.pop();
        }
        else
        {
            callStack.push("Recursion Simulator Count: " + count);
            recursionSimulator(count + 1);
            callStack.pop();
        }
    }
}