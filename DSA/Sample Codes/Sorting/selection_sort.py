def selection_sort(array):
    n = len(array)

    for i in range(n):
        min_idx = i
        for j in range(i + 1, n):
            if(array[min_idx] > array[j]):
                min_idx = j
        array[i], array[min_idx] = array[min_idx], array[i]

array = [5, 8, 6, 3 , 2 , 1]
selection_sort(array)
print(array)