# // ''  ""  ?  % ^ 5 6
import math

def Enter_numbers(*numbers):
    for numbers in numbers:
        number_list = [numbers]
        return number_list

def basics():
     getList = Enter_numbers(*numbers)
     count = len(getList)
     maximum = max(getList)
     minimum = min(getList)
     range = maximum - minimum
     return count, maximum, minimum, range

class Calculator:
     
     count, minimum,maximum, range = basics()
     getList = Enter_numbers(*numbers)
     def __init__(self, name):
          self.name = name

     def add(getList):
          total = sum(getList)
          return total

     def subtract(getList):
          subtracting_value = getList[0]
          for i in getList:
               total += getList[i+1] 
               subtracting_value -= total
               return subtracting_value

     def multiply(getList):
          multiplying_value = 0
          total = getList[0] * getList[1]
          for i in getList:
               total *= getList[i+2]
               multiplying_value = total
               return multiplying_value

     def division(getList):
          dividing_value = 0
          total = getList[i] / getList[i+1]
          for i in getList:
               total /= getList[i+2]
               dividing_value = total
               return dividing_value

     def range(range_value):
            return range_value

     def classes(count):
          no_of_classes = math.sqrt(count)
          return no_of_classes

     def class_width(range_value, no_of_classes):
            class_width = range_value / no_of_classes
            return class_width

     def frequency_distribution(getList, class_width, no_of_classes, minimum, maximum):
            class_width = int(class_width)
            frequency = []
            value = minimum
            if minimum <= maximum:
                 new_value = value + class_width
                 for i in getList:
                  if getList[i] <= new_value & getList[i] > value:
                   frequency.append(getList[i])