package lab1;

public class Stack {
	
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public Stack(int size) {
		maxSize = size;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	public void push(char c) {
	
		if(!isFull()) {
			stackArray[++top] = c;
		}
		else {
			System.out.println("Stack is Full");
		}
	}
	
	
	public char pop() {
		if(!isEmpty()) {
			return stackArray[top--];
		}
		else
			return '/';
	}
	
	public char peek() {
		if(isEmpty()) {
			return '/';
		}
		else
			return stackArray[top];
	}

	public boolean isFull() {
		
		
		if(top == (maxSize-1)) {
			return true;
		}
		else
			return false;
	}
	
	public boolean isEmpty() {
		
		
		if(top == -1) {
			return true;
		}
		else
			return false;
	}
}
