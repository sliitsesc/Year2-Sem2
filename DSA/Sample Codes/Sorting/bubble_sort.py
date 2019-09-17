def bubble_sort(array):
    n = len(array)

    # Traverse through all array elements
    for i in range(n):
        for j in range(0, n - i - 1):
            if(array[j] > array[j + 1]):
                array[j], array[j + 1] = array[j + 1], array[j]


arr = [12, 11, 13, 5, 6]
bubble_sort(arr)
print(arr)