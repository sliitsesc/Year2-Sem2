/**
 * @author chamodshehanka on 8/6/2019
 * @project Demo
 **/
public class Queue {

    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0; //Queue is empty
    }

    public void insert(int val) {
        if (rear == maxSize -1) {
            System.out.println("Queue is full");
        } else {
            queueArray[++rear] = val;
            nItems++;
        }
    }

    public int remove() {
        if (nItems == 0) {
            System.out.println("Queue is empty");
            return -99;
        } else {
            nItems--;
            return queueArray[front++];
        }
    }

    public int peekFront() {
        if (nItems == 0) {
            System.out.println("Queue is empty");
            return -99;
        } else {
            return queueArray[front];
        }
    }
}
