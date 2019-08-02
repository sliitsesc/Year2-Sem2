import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QueueX mainQueue = new QueueX(5);
		QueueX evenQueue = new QueueX(5);
		QueueX oddQueue = new QueueX(5);
		
		for(int i = 1;i<6;i++) {
			System.out.println("Enter trasaction ID "+i+": ");
			mainQueue.insert(sc.nextInt());
		}
		
		while(!mainQueue.isEmpty()) {
			int element = mainQueue.remove();
			if(element % 2==0) {
				evenQueue.insert(element);
			}
			else {
				oddQueue.insert(element);
			}
		}
		
		System.out.println("PC1");
		while(!evenQueue.isEmpty()) {
			System.out.println("Transaction "+evenQueue.remove());
		}
		
		System.out.println("PC2");
		while(!oddQueue.isEmpty()) {
			System.out.println("Transaction "+oddQueue.remove());
		}
		
	}

}
