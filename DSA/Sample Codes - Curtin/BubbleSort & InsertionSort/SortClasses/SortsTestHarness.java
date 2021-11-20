import java.util.Arrays;

/**
** Testharness to generate various different types of arrays of integers
** and then sort them using various sorts.
**
** Each sort is run REPEATS times, with the first result discarded, 
** and the last REPEATS-1 runs averaged to give the running time.
**
** Authour: Andrew Turpin (andrew@cs.curtin.edu.au)
** Date:    August 2004
** Modified: Patrick Peursum
** Date:     Sep 2009
*/
class SortsTestHarness 
{
    /** No of times to run sorts to get mean time */
    private static final int    REPEATS   = 4;

    /** number of items moved (% of n) in nearly sorted array */
    private static final double NEARLY_PERCENT = 0.10;

    /** No of times (*n) to randomly swap elements to get random array */
    private static final int    RANDOM_TIMES   = 100;

    private static void usage() 
    {
        System.out.println(" Usage: java TestHarness n xy [xy ...]");
        System.out.println("        where");
        System.out.println("        n is number of integers to sort");
        System.out.println("        x is one of");
        System.out.println("           b - bubblesort");
        System.out.println("           i - insertion sort");
        System.out.println("           s - selection sort");
        System.out.println("           q - quicksort");
        System.out.println("           m - mergesort");
        System.out.println("        y is one of");
        System.out.println("           a - 1..n ascending");
        System.out.println("           d - 1..n descending");
        System.out.println("           r - 1..n in random order");
        System.out.println("           n - 1..n nearly sorted (10% moved)");
    }

    /**
    ** Process command line arguments, generate array and call sort
    */
    public static void main(String[] args)
    {
        int n;
        char sortType, arrayType;
        if (args.length < 2)
            usage();
        else
            {
            n = Integer.parseInt(args[0]);
            int[] A = new int[n];
            for(int numSorts = 1 ; numSorts < args.length ; numSorts++)
                {
                sortType  = args[numSorts].charAt(0);
                arrayType = args[numSorts].charAt(1);
               
                double runningTotal = 0;
                for (int repeat = 0 ; repeat < REPEATS ; repeat++)
                {
                    // 
                    // Create array
                    // 

                    // Create initial ascending-order array
                    for(int i = 0 ; i < n ; i++)
                        A[i] = i+1;
                   
                    switch (arrayType)
                    {
                        case 'a' : break; // already ascending!
                        case 'd' :    // Convert to descending
                            for(int i = 0 ; i < n/2 ; i++)
                                swap(A, i, n - i - 1);
                            break;
                        case 'r' :  // Randomly reorder (overdo it to make sure)
                            for(int i = 0 ; i < RANDOM_TIMES*n ; i++)
                            {
                                int x = (int)Math.floor(Math.random()*(n-1));
                                int y = (int)Math.floor(Math.random()*(n-1));
                                swap(A, x, y);
                            }
                            break;
                        case 'n' : // Randomly re-order *part* of the array
                            for(int i = 0 ; i < n*NEARLY_PERCENT/2.0 ; i++)
                            {
                                int x = (int)Math.round(Math.random()*(n-1));
                                int y = (int)Math.round(Math.random()*(n-1));
                                swap(A, x, y);
                            }
                            break;
                        default :
                            System.err.println("Unsupported array type "+arrayType);
                    }
              
                    // 
                    // Do the sorting
                    // 
//                    long startTime = System.currentTimeMillis();
                    long startTime = System.nanoTime();
                    switch (sortType)
                    {
                        case 'b' : Sorts.bubbleSort(A); break;
                        case 's' : Sorts.selectionSort(A); break;
                        case 'q' : Sorts.quickSort(A); break;
                        case 'j' : Arrays.sort(A); break;    // Java's QuickSort
                        case 'm' : Sorts.mergeSort(A); break;
                        case 'i' : Sorts.insertionSort(A); break;
                        //case 'h' : Sorts.heapSort(A); break;
                        default :
                            throw new IllegalArgumentException("Unsupported sort type " + sortType);
                    }
//                    long endTime = System.currentTimeMillis();
                    long endTime = System.nanoTime();

                   

                    if (repeat == 0) {
                        // Check that it actually sorted correctly!
                        for(int i = 1 ; i < A.length; i++) {
                            if (A[i] < A[i-1])
                                throw new IllegalStateException("Array is not in sorted order! At element: " + i);                        
                        }
                    }
                    else {
                        // PP: Why is this code ignoring repeat #0?
                        // Is it attempting to downplay initial L2 caching?
                        runningTotal += (int)((double)(endTime - startTime) / 1000.0);	// Convert to microsecs
                    }
                }// repeat sort
              
                System.out.print(args[numSorts]+ " " + n);
                System.out.println(" " + (runningTotal/(REPEATS-1)));
            }// end for numSorts
         } // end else
     } //main()

    private static void swap(int[] A, int idx1, int idx2)
    {
        int temp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = temp;
    }

}
