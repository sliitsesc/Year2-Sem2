class DSAHeap
{
    DSAHeapEntry[] heap;
    Integer count = 0;

    public DSAHeap(Integer maxSize)
    {
        heap = new DSAHeapEntry[maxSize];
    }

    public void add(Integer inPriority, Object value)
    {
        if (heap.length > count)
        {
            heap[count] = new DSAHeapEntry(inPriority, value);
            heap = trickleUp(heap, count);
            count = count + 1;
        }
        else
        {
            System.out.println("Heap is full!");
        }
    }

    public void add(Integer inPriority)
    {
        if (heap.length > count)
        {
            heap[count] = new DSAHeapEntry(inPriority);
            heap = trickleUp(heap, count);
            count = count + 1;
        }
        else
        {
            System.out.println("Heap is full!");
        }
    }

    public void addUnordered(Integer inPriority)
    {
        if (heap.length > count)
        {
            heap[count] = new DSAHeapEntry(inPriority);
            count = count + 1;
        }
    }

    public void addUnordered(Integer inPriority, Object value)
    {
        if (heap.length > count)
        {
            heap[count] = new DSAHeapEntry(inPriority, value);
            count = count + 1;
        }
    }

    public Integer remove()
    {
        Integer returnVal = heap[0].getPriority();
        heap[0] = heap[count-1];
        count = count - 1;
        heap = trickleDown(heap, 0, count);
        return returnVal;
    }

    public void heapSort()
    {
        DSAHeapEntry tempHeap;

        heap = heapify(heap, heap.length);

        for (int ii = heap.length - 1; ii >= 1; ii--)
        {
            tempHeap = heap[ii];
            heap[ii] = heap[0];
            heap[0] = tempHeap;
            heap = trickleDown(heap, 0, ii);
        }
    }


    private DSAHeapEntry[] heapify(DSAHeapEntry[] heap, Integer count)
    {
        for (int ii = (count/2)-1; ii >= 0; ii--)
        {
            heap = trickleDown(heap, ii, count);
        }

        return heap;
    }

    private DSAHeapEntry[] trickleUp(DSAHeapEntry[] heap, Integer currIndex)
    {
        DSAHeapEntry temp;
        Integer parentIndex = (currIndex - 1) / 2;
        if (currIndex > 0)
        {
            if (heap[currIndex].getPriority() > heap[parentIndex].getPriority())
            {
                temp = heap[parentIndex];
                heap[parentIndex] = heap[currIndex];
                heap[currIndex] = temp;
                heap = trickleUp(heap, parentIndex);
            }
        }
        return heap;
    }   

    private DSAHeapEntry[] trickleDown(DSAHeapEntry[] heap, Integer currIndex, Integer count)
    {
        DSAHeapEntry tempHeapEntry;
        Integer largeIndex;
        Integer leftChildIndex = currIndex * 2 + 1;
        Integer rightChildIndex = leftChildIndex + 1;

        if (leftChildIndex < count)
        {
            largeIndex = leftChildIndex;
            if (rightChildIndex < count)
            {
                if (heap[leftChildIndex].getPriority() < heap[rightChildIndex].getPriority())
                {
                    largeIndex = rightChildIndex;
                }
            }
            if (heap[largeIndex].getPriority() > heap[currIndex].getPriority())
            {
                tempHeapEntry = heap[currIndex];
                heap[currIndex] = heap[largeIndex];
                heap[largeIndex] = tempHeapEntry;

                heap = trickleDown(heap, largeIndex, count);
            }
        }

        return heap;
    }

    public void display()
    {
        for (int x = 0; x < count; x++)
        {
            System.out.println(heap[x].getPriority());
        }
    }
}