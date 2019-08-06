package DSA.Queue;

/**
 * @author chamodshehanka on 8/6/2019
 * @project Demo
 **/
public class QueueApp {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.insert(50);
        queue.insert(78);
        queue.insert(45);
        System.out.println("Remove : " + queue.remove());
        System.out.println("Peek Front : " + queue.peekFront());
    }
}
