package DSA.Stack;

/**
 * @author chamodshehanka on 8/5/2019
 * @project Demo
 **/
public class StackApp {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(30);
        stack.push(80);
        stack.push(20);
        System.out.println("Pop : " + stack.pop());
        System.out.println("Peek : " + stack.peek());
        System.out.println("Is Empty : " + stack.isEmpty());
        System.out.println("Is Full : " + stack.isFull());
    }
}
