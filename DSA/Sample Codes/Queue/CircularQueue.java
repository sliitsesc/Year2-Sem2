public class CircularQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int val) {
        if(nItems == maxSize) {
            System.out.println("Queue is full !!");
        } else {
            if(rear == maxSize -1) {
                rear--;
            }
            queueArray[++rear] = val;
            nItems++;
        }
    }

    public int remove() {
        if (nItems == 0){
            System.out.println("Queue is empty");
            return -99;
        }else {
            int num = queueArray[front++];
            if(front == maxSize)
                front = 0;
            nItems--;
            return num;
        }
    }

    public int peekFront(){
        if (nItems == 0){
            System.out.println("Queue is empty");
            return -99;
        }else {
            return queueArray[front];
        }
    }
}