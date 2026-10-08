def basics(self):
     getList = self.Enter_numbers(numbers)
     count = len(getList)
     maximum = np.max(getList)
     minimum = np.min(getList)
     range = maximum - minimum
     return count, maximum, minimum, range    

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