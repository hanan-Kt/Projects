import numpy as np
a = 0
def InputingNumbers(num_arr):
      
          num_arr[a] = float(input("Enter number: "))
          a = a + 1

def sum(num_arr):
        total = np.sum(num_arr)
        return total

def subtract(num_arr):
        first = num_arr[0]
        total = np.sum(num_arr)
        subtraction = first - (total - first)
        return subtraction

def multiply(num_arr):
        multiplication = np.prod(num_arr)
        return multiplication

def divide(num_arr):
        left = num_arr[0]
        for i in range(len(num_arr)-1):
            division = num_arr[i + 1]
            left /= division
        return left

def sqrt(num_arr):
        total = np.sum(num_arr)
        squareroot = np.sqrt(total)
        return squareroot

def mean(num_arr):
        mean_value = np.mean(num_arr)
        return mean_value

def std(num_arr):
        std_value = np.std(num_arr)
        return std_value

def median(num_arr):
        median_value = np.median(num_arr)
        return median_value

def square(num_arr):
        square_value = np.square(num_arr)
        return square_value

array1 = np.array([])
print("Enter a number: ")
first = float(input())
array1 = np.append(array1, first)
print("Enter a number: ")
second = float(input())
array1 = np.append(array1, second)
print("You have more number to enter? ")
answer = input()
while answer == "Yes" or answer == "y" or answer == "Y" or answer == "yes":
    print("Enter a number: ")
    next_num = float(input())
    array1 = np.append(array1, next_num)
    print("You have more number to enter? ")
    answer = input()

print("You have entered all the numbers you want to enter.")
print("Select an operation:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Square Root\n 6. Mean\n7. Standard Deviation\n8. Median")
operation = int(input())
if operation == 1:
       print("The sum of all numbers is: ", sum(array1))
elif operation == 2:
       print("The difference of all numbers is: ", subtract(array1))
elif operation == 3:
       print("The product of all numbers is: ", multiply(array1))
elif operation == 4:
       print("The quotient of all numbers is: ", divide(array1))
elif operation == 5:
       print("The square root of the sum of all numbers is: ", sqrt(array1))
elif operation == 6:
       print("The mean of all numbers is: ", mean(array1))
elif operation == 7:
       print("The standard deviation of all numbers is: ", std(array1))
elif operation == 8:
       print("The median of all numbers is: ", median(array1))
else:
         print("Invalid operation selected.")