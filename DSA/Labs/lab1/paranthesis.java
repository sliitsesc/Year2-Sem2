package lab1;

import java.util.Scanner;


public class paranthesis {

	public static void main(String[] args) {
		
		String exp;
		char[] input = new char[100];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String to check : ");
		exp = sc.nextLine();
		input = exp.toCharArray();
		
		System.out.println(isBalanced(input));
		sc.close();
	}
	
	
	public static boolean isBalanced(char[] input) {
		Stack s = new Stack(100);
		int flag = 0;
	for(int i = 0 ; i < input.length ; i++ ) {
		
		if(input[i] == '{' || input[i] == '[' || input[i] == '(') {
			s.push(input[i]);
		}
		
		if(input[i] == '}' || input[i] == ']' || input[i] == ')') {
			if(!s.isEmpty()) {
				if(isMatching(s.peek(),input[i])) {
					s.pop();
				}
				else {
					flag = 1;
					break;
				}
					
			}
			
		}
	}
	if(flag == 0 && s.isEmpty()) {
		return true;
	}
	else
		return false;
	}
	
	public static boolean isMatching(char ch1,char ch2) {
		if(ch1 == '(' && ch2 == ')')
			return true;
		else if(ch1 == '{' && ch2 == '}')
			return true;
		else if(ch1 == '[' && ch2 == ']')
			return true;
		else
			return false;
	}
	
}


