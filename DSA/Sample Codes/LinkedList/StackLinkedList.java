/**
 * @author chamodshehanka on 10/21/2019
 * @project Demo
 **/
public class StackLinkedList {
    Node top;

    StackLinkedList() {
        this.top = null;
    }

    public static void main(String[] args) {
        StackLinkedList s = new StackLinkedList();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Peek : " + s.peek());
        System.out.println(s.pop());
    }

    public void push(int value) {
        if (top == null) {
            top = new Node(value);
            return;
        }

        Node current = top;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty !!");
            return -1;
        }else {
            Node current = top;
            while (current.next != null) {
                current = current.next;
            }
            int value = current.data;
            current = null;
            return value;
        }
    }

    public int peek() {
        int value = pop();
        push(value);

        return value;
    }
}
