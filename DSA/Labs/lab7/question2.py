# a.
n = int(input("Enter array length : ")) 
array = list()
for i in range(1, n):
    array.append(int(input("Enter num : ")))

def partition(array, p, r):
    x = array[r]
    i = p - 1
    for j in range(p, r - 1):
        if(array[j] <= x):
            i += 1
            array[i], array[j] = array[j], array[i]
    array[i + 1], array[r] = array[r], array[i + 1]
    return i + 1

def quick_sort(array, p, r):
    if(p < r):
        q = partition(array, p, r)
        quick_sort(array, p, q-1)
        quick_sort(array, q + 1, r)
