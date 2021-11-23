import java.util.Scanner;

class Hanoi
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of loops you want?: ");
        int numLoops = sc.nextInt();
        System.out.println("towers(" + numLoops + " ,1, 3, 2)");
        towers(numLoops, 1, 3, 2, "");
    }

    public static void towers(int num, int src, int dest, int temp, String pSpace)
    {
        String space = pSpace;
        if (num == 1)
        {
            moveDisk(src, dest, space);
        }
        else
        {
            space += space + "*"; //Stars indicate recursion level
            towers(num-1, src, temp, dest, space);
            towers(1, src, dest, temp, space);
            towers(num-1, temp, dest, src, space);
        }
    }
    
    public static void moveDisk(int src,int dest, String space) //Prints output statements
    {
        System.out.println("(" + dest + ")" + space + " Move from " + src + " to " + dest);
    }
}