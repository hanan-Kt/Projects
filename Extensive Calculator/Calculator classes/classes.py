# // ''  ""  ?  % ^ 5 6
import numpy as np
class Numbers:
     def __init__(self, name):
          self.name = name

def Enter_numbers(self, *numbers):
    number_list = np.array(numbers)
    return number_list

def basics(self):
     getList = self.Enter_numbers(numbers)
     count = len(getList)
     maximum = np.max(getList)
     minimum = np.min(getList)
     range = maximum - minimum
     return count, maximum, minimum, range

class Calculator(Numbers):

     def get_data(self):
          getList = self.Enter_numbers()
     count, minimum,maximum, range = basics()

     def __init__(self, name):
          self.name = name

     def add(self, getList):
          total = sum(getList)
          return total

     def subtract(self, getList):
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
          no_of_classes = int(math.sqrt(count))
          return no_of_classes

     def class_width(range_value, no_of_classes):
            class_width = range_value / no_of_classes
            return class_width

     def frequency_distribution(getList, class_width, no_of_classes, minimum, maximum, range_value):
            class_width = int(class_width)
            frequency = {}
            value = minimum

            for a in range(no_of_classes):
              max_value = value + class_width
              if a == no_of_classes - 1:
                   count = sum(1 for a in getList if value <= a <= max_value)
              else:
                   count = sum(1 for a in getList if value <= a < max_value)

              frequency