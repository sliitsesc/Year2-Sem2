def insertion_sort(A):
    n = len(A)
    for j in range(1, n):
        key = A[j]
        i = j -1
        while(i >= 0 and key < A[i]):
            A[i + 1] = A[i]
            i -= 1
        A[i + 1] = key

arr = [12, 11, 13, 5, 6]
insertion_sort(arr)
print(arr)