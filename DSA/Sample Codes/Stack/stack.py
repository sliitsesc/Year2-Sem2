stack_array = []
max_size = 0
top = -1

def push(value):
    stack_array.append(value)
    top += 1 

def pop():
    top -= 1
    value = stack_array.pop()
    return value

def peek():
    return stack_array[stack_array.length -1]

