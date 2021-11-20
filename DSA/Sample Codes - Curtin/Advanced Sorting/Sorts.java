/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
import java.lang.Math;

class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
      int pass = 0;
      int temp;
      boolean sorted;

      do
      {
        sorted = true;
        for (int ii = 0; ii < A.length-1 - pass; ii++)
        {
          if (A[ii] > A[ii+1])
          {
            temp = A[ii];
            A[ii] = A[ii + 1];
            A[ii+1] = temp;
            sorted = false;
          }
        }
        pass = pass + 1;
      } while (sorted == false);
  
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
      int minIdx;
      int temp;

      for (int nn = 0; nn < A.length-1; nn++)
      {
        minIdx = nn;
        for (int jj = nn+1; jj < A.length; jj++)
        {
          if (A[jj] < A[minIdx])
          {
            minIdx = jj;
          }
        }

        temp = A[minIdx];
        A[minIdx] = A[nn];
        A[nn] = temp;
      }

      
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
      int ii;
      int temp;

      for (int nn = 1; nn <= A.length - 1; nn++)
      {
        ii = nn;

        while (ii > 0 && A[ii-1] > A[ii])
        {
          temp = A[ii];
          A[ii] = A[ii-1];
          A[ii-1] = temp;

          ii = ii -1;
        }
      }

    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
      int leftIdx = 0;
      int rightIdx = A.length - 1;
      mergeSortRecurse(A, leftIdx, rightIdx);
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
      if (leftIdx < rightIdx)
      {
        int midIdx = (leftIdx + rightIdx) / 2;
        mergeSortRecurse(A, leftIdx, midIdx);
        mergeSortRecurse(A, midIdx+1, rightIdx);
        merge(A, leftIdx, midIdx, rightIdx);
      }
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
      int[] tempArr = new int[rightIdx - leftIdx + 1];
      int ii = leftIdx;
      int jj = midIdx + 1;
      int kk = 0;

      while (ii <= midIdx && jj <= rightIdx)
      {
        if (A[ii] <= A[jj])
        {
          tempArr[kk] = A[ii];
          ii = ii + 1;
        }
        else
        {
          tempArr[kk] = A[jj];
          jj = jj + 1;
        }
        kk = kk + 1;
      }

      for (int i = ii; i <= midIdx; i++)
      {
        tempArr[kk] = A[i];
        kk = kk + 1;
      }

      for (int j = jj; j <= rightIdx; j++)
      {
        tempArr[kk] = A[j];
        kk = kk + 1;
      }

      for (kk = leftIdx; kk <= rightIdx; kk++)
      {
        A[kk] = tempArr[kk-leftIdx];
      }
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
      int leftIdx = 0;
      int rightIdx = A.length -1;
      quickSortRecurse(A, leftIdx, rightIdx);
    }//quickSort(), to avoid duplication, we have commented out the code, you can uncomment and run each type of quickSort
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
      if (rightIdx > leftIdx)
      {
        // int pivotIdx = leftIdx;
        int midIdx = (leftIdx + rightIdx) /2;
        int pivotIdx = (leftIdx + midIdx + rightIdx) /3;
        // int pivotIdx = (int) (Math.random()*(rightIdx - leftIdx +1) + leftIdx);
        int newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);
        

        quickSortRecurse(A, leftIdx, newPivotIdx-1);
        quickSortRecurse(A, newPivotIdx+1, rightIdx);
      }
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
      int pivotVal = A[pivotIdx];
      A[pivotIdx] = A[rightIdx];
      A[rightIdx] = pivotVal;

      int currIdx = leftIdx;

      for (int ii = leftIdx; ii <= rightIdx -1; ii++)
      {
        if (A[ii] < pivotVal)
        {
          int temp = A[ii];
          A[ii] = A[currIdx];
          A[currIdx] = temp;
          currIdx = currIdx + 1;
        }
      }
      int newPivotIdx = currIdx;
      A[rightIdx] = A[newPivotIdx];
      A[newPivotIdx] = pivotVal;

		return newPivotIdx;
    }//doPartitioning


}//end Sorts calss
