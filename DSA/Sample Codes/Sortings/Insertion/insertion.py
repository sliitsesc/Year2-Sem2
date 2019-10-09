#Insertion Sort
def sort(nums):
    for i in range (1, len(nums)):
        for j in range (i, 0, -1):
            if nums [j] < nums [j-1]:
                temp = nums[j]
                nums[j] = nums [j-1]
                nums[j-1] = temp
                
nums = list(map(int, input("Enter the Numbers: ").split()))
#nums = [5,3,8,6,7,2]   
sort(nums)

print(nums)
