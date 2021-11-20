import java.util.Scanner; //importing scanner library
import java.util.InputMismatchException;

class NumberConvertions
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String result = "";
        int difference = 0;

        try
        {
            System.out.print("Input a number to convert into other number bases: ");
            int n = sc.nextInt(); //input number

            System.out.print("Input a base to convert into other number bases: ");
            int base = sc.nextInt(); //input base system
            
            long startTime = System.nanoTime();
            result = convertNumber(n, base); //call convert number function
            long endTime = System.nanoTime();
            difference += (endTime - startTime);
            System.out.println(result);
            System.out.println("Time taken in nanoseconds: " + ((double)(difference/100.00)));
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please enter integer values (base 10)");
        }
        catch (InvalidIntegerException e)
        {
            System.out.println(e);
        }
            
    }

    private static String convertNumber(int decimal, int base, boolean valid)
    {
        String result = ""; //initializing string result
        if (valid == true)
        {
            if (decimal == 0)
            {
                result = ""; //if the number is zero, then stop recursion
            }
            else
            {
                if (decimal % base == 10)
                {
                    result = convertNumber(decimal / base, base, true) + "A";
                }
                else if (decimal % base == 11)
                {
                    result = convertNumber(decimal / base, base, true) + "B";
                }
                else if (decimal % base == 12)
                {
                    result = convertNumber(decimal / base, base, true) + "C";
                }
                else if (decimal % base == 13)
                {
                    result = convertNumber(decimal / base, base, true) + "D";
                }
                else if (decimal % base == 14)
                {
                    result = convertNumber(decimal / base, base, true) + "E";
                }
                else if (decimal % base == 15)
                {
                    result = convertNumber(decimal / base, base, true) + "F";
                }
                else
                {
                    result = convertNumber(decimal / base, base, true) + (decimal % base);
                }
            }
        }
        return result; //return result
    }

    public static String convertNumber(int decimal, int base) throws InvalidIntegerException
    {
        String result = "";
        if (decimal >= 0)
        {
            if (base >= 2 && base <= 16)
            {
                result = convertNumber(decimal, base, true);
            }
            else
            {
                throw new InvalidIntegerException("Base values can only be between binary and hexa");
            }
        }
        else
        {
            throw new InvalidIntegerException("Please enter valid integer values");
        }

        return result;
    }

}