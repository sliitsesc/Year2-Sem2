#Selection Sort
def sort(nums):
    for i in range(5):
        minpos = i
        for j in range (i,6):
            if nums[j]<nums[minpos]:
                minpos = j
        temp = nums[i]
        nums[i] = nums[minpos]
        nums[minpos] = temp
nums = list(map(int, input("Enter the Numbers: ").split()))
#nums = [5,4,3,1,2,7]
sort(nums)
print(nums)
