import pandas as pand

data_set = pand.read_csv(r"C:\Users\Hanan\Downloads\Files\Projects\Data analysis using python\data.csv", index_col = "Name")
#print(data_set[["Roll #", "Name", "CGPA" , "Remarks"]].to_string(index = False))

input_given = input("Enter your name: ")

try:
    print(data_set.loc[input_given])

except KeyError:
      print(f"{input_given} not found in the data set.")