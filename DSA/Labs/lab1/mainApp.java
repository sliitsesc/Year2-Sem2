package lab1;

public class mainApp {

	public static void main(String[] args) {
		Stack s = new Stack(3);
		
		s.push('A');
		s.push('B');
		s.push('C');
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}

}
