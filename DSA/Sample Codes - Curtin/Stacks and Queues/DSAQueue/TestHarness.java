class TestHarness
{
    public static void main(String[] args)
    {
        ShuffledQ shuffleQ = new ShuffledQ();
        fillQueue(shuffleQ);
        emptyQueue(shuffleQ);

        System.out.println("_______________________________________");
        CirculaQ circulaQ = new CirculaQ();
        fillQueue(circulaQ);
        emptyQueue(circulaQ);
        circulaQ.enqueue("Water");
        circulaQ.enqueue("Fire");
        circulaQ.enqueue("Earth");
        circulaQ.dequeue();
        circulaQ.dequeue();
        circulaQ.dequeue();
        circulaQ.dequeue();
        circulaQ.dequeue();
        circulaQ.dequeue();
        circulaQ.dequeue();
        circulaQ.dequeue();
        circulaQ.dequeue();
        circulaQ.dequeue();
        circulaQ.dequeue(); //should return empty
        circulaQ.dequeue(); //should return empty
    }

    public static void fillQueue(ShuffledQ queue)
    {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11); //should return queue is full
    }

    public static void emptyQueue(ShuffledQ queue)
    {
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); //should return empty queue
        queue.dequeue(); //should return empty queue
    }

    public static void fillQueue(CirculaQ queue)
    {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11); //should return queue is full
    }

    public static void emptyQueue(CirculaQ queue)
    {
        queue.dequeue();
        queue.dequeue();
    }
}