def binary_search(A, min, max, key):
    if max < min:
        return False
    else:
        mid = (min + max) // 2
        if (A[mid] > key):
            return binary_search(A, min, mid -1, key)
        elif A[mid] < key:
            return binary_search(A, mid + 1, max, key)
        else:
            return mid

binary_search([1,2,3,4,5],1,5,3) # Returns True