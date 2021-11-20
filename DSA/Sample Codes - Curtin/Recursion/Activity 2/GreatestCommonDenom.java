import java.util.Scanner; //importing so we can take in user input
import java.util.InputMismatchException;

class GreatestCommonDenom
{
    public static void main(String[] args) //main function for inputting the two numbers
    {
        int x;
        int y;
        int difference = 0;
        int gcd = 0;

        Scanner sc = new Scanner(System.in);

        try
        {
            System.out.print("Please enter the first number: ");
            x = sc.nextInt();
            System.out.print("Please enter the second number: ");
            y = sc.nextInt();
            long startTime = System.nanoTime();
            gcd = calcGCD(x,y); //call function with two numbers
            long endTime = System.nanoTime();
            difference += (endTime - startTime);

            System.out.println("The Greatest Common Denominator is " + gcd);
            System.out.println("Time taken in nanoseconds: " + ((double)(difference)));
        }
        catch (InvalidIntegerException e)
        {
            System.out.println(e);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please enter valid integers!");
        }
    }

    private static int calcGCD(int x, int y, boolean valid) //function to calculate the GCD
    {
        int result = 0;
        if (valid == true)
        {
            if (y == 0) //if remainder is 0
            {
                result = x; //return the value of x
            }
            else
            {
                result = calcGCD(y, x % y, true); //if remainder not 0 call the function again with the remainder of x division by y
            }
        }
        return result;
    }

    public static int calcGCD(int x, int y) throws InvalidIntegerException
    {
        int result = 0;
        if (x < 0 || y < 0)
        {
            throw new InvalidIntegerException("Please only enter valid positive integers");
        }
        else
        {
            result = calcGCD(x, y, true);
        }
        return result;
    }
}
