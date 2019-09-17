def insertion_sort(array):
    for i in range(1, len(array)):
        key = array[i]

        j = i - 1
        while(j >= 0 and key < array[j]):
            array[j + 1] = array[j]
            j -= 1
        array[j + 1] = key

array = list()
n = int(input("Enter array length : "))
for i in range(n):
    array.append(int(input("Enter num : ")))

insertion_sort(array)
print(array)