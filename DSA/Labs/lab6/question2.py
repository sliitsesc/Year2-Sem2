def bubble_sort(array):
    n = len(array)

    for i in range(n):
        for j in range(0, n - i - 1):
            if(array[j] > array[j + 1]):
                array[j], array[j + 1] = array[j + 1], array[j]


array = list()
n = int(input("Enter array length : "))
for i in range(n):
    array.append(int(input("Enter num : ")))

bubble_sort(array)
print(array)