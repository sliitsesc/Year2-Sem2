class TestHarnessQueue
{
    public static void main(String[] args)
    {
        Queue newQueue = new Queue();
        testFull(newQueue);
        testEmpty(newQueue);
        newQueue.enqueue(2020);
        System.out.println(newQueue.dequeue()); //returns 2020
        newQueue.enqueue("Budu Saranai");
        System.out.println(newQueue.dequeue()); //returns Budusaranai
        System.out.println(newQueue.dequeue());
        newQueue.enqueue("Hello world!");
    }

    public static void testFull(Queue newQueue)
    {
        newQueue.enqueue(1);
        newQueue.enqueue(2);
        newQueue.enqueue(3);
        newQueue.enqueue(4);
        newQueue.enqueue(5);
        newQueue.enqueue(6);
        newQueue.enqueue(7);
        newQueue.enqueue(8);
        newQueue.enqueue(9);
        newQueue.enqueue(10);
        newQueue.enqueue(11); 
        newQueue.enqueue(12); 
    }

    public static void testEmpty(Queue newQueue)
    {
        for (int x=0; x < 13; x++)
        {
            System.out.println(newQueue.dequeue());
        }
    }
}