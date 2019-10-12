/**
 * @author chamodshehanka on 8/5/2019
 * @project Demo
 **/
public class Stack {
    private int maxSize;
    private double[] stackArray;
    private int top;

    public Stack(int size){
        maxSize = size;
        stackArray = new double[maxSize];
        top = -1;
    }

    public void push(double val){
        //Check whether stack is full
        if (top == maxSize -1){
            System.out.println("Stack is full");
        }else {
            stackArray[++top] = val;
        }
    }

    public double pop(){
        if (top == -1){
            System.out.println("Stack is empty");
            return -99;
        }else {
            return stackArray[top--];
        }
    }

    public double peek(){
        if (top == -1){
            System.out.println("Stack is empty");
            return -99;
        }else {
            return stackArray[top];
        }
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize -1;
    }
}
