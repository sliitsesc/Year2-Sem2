import java.util.Scanner; //import Scanner class so we can take in user input
import java.util.InputMismatchException;

class Fibonacci
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); //initializes Scanner object
        int result = 0;
        int difference = 0;

        System.out.print("Please enter a number to calculate Fibonacci's: ");
        try
        {
            int n = sc.nextInt(); //takes in the number for Fibonacci's
            long startTime = System.nanoTime();
            result = fib(n); //Calls function fib with said n
            long endTime = System.nanoTime();
            difference += (endTime - startTime);
            System.out.println("Answer is " + result); //Print out result
            System.out.println("Time taken in nanoseconds: " + ((double)(difference)));
        }
        catch (InvalidIntegerException e) //Maximum is 47
        {
            System.out.println(e);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please enter a valid integer");
        }
    }

    private static int fib(int n, boolean valid) //Recursive function to calculate Fibonacci's
    {
        int fibVal = 0;
        if (valid == true)
        {
            if (n == 0) //If n is 0, then Fibonacci's is zero
            {
                fibVal = 0;
            }
            else if (n == 1)
            {
                fibVal = 1; //If n is 1, then Fibonacci's is one
            }
            else
            {
                fibVal = fib(n-1, true) + fib(n-2, true); //If neither then this is the general forumala
            }
        }
        return fibVal; //return the value to the main function
    }

    public static int fib(int n) throws InvalidIntegerException
    {
        int result = 0;
        if (n >= 46 || n <= 0)
        {
            throw new InvalidIntegerException("Program will crash, if you enter more than 47!");
        }
        else
        {
            result = fib(n, true);
        }
        return result;
    }
}