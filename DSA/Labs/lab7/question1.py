# my algo
def selection_sort(array):
    n = len(array)
    for i in range(n):
        min_inx = i
        for j in range(i + 1, n):
            if(array[min_inx] > array[j]):
                min_inx = j
        array[i], array[min_inx] = array[min_inx], array[i]

# given algo
def selection_sort2(array):
    n = len(array)
    for j in range(n -1):
        smallest = j
        for i in range(j + 1, n):
            if(array[i] < array[smallest]):
                smallest = i
        array[j], array[smallest] = array[smallest], array[j]


array = [5, 8, 6, 3 , 2 , 1]
selection_sort2(array)
print(array)
