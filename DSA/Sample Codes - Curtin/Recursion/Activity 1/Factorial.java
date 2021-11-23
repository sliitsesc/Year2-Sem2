import java.util.Scanner; //import Scanner library
import java.util.InputMismatchException;

class Factorial
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); //Initializes Scanner object
        int difference =0;
        int result =0;

        System.out.print("Please enter the value to calculate the factorial for: ");
        
        try
        {
            int n = sc.nextInt(); //Gets user input for the value they would like the factorial for
            long startTime = System.nanoTime();
            result = factorial(n); //call factorial function
            long endTime = System.nanoTime();
            difference += (endTime - startTime);
            System.out.println("The factorial was " + result); //print out the result of the factorial function
            System.out.println("Time taken in nanoseconds: " + ((double)(difference)));
        }
        catch (InvalidIntegerException e)
        {
            System.out.println(e);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please enter an integer");
        }
        
    }

    private static int factorial(int n, boolean valid)
    {
        int result =0;
        if (valid == true)
        {
            if (n == 1) //if n is one, the factorial of that is one
            {
                result = 1;
            }
            else
            {
                result = n * factorial(n-1, true); //if n is not one the factorial is n times the value one less
            }
        }
        return result; //return result to main function
    }

    public static int factorial(int n) throws InvalidIntegerException
    {
        int result =0;
        if (n > 32 || n < 0)
        {
            throw new InvalidIntegerException("Are you trying to crash us all?!?");
        }
        else
        {
            result = factorial(n, true);
        }
        return result;
    }
}
