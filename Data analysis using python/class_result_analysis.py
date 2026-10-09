import pandas as pand

data_set = pand.read_csv(r"C:\Users\Hanan\Downloads\Files\Projects\Data analysis using python\data.csv")
#print(data_set[["Roll #", "Name", "CGPA" , "Remarks"]].to_string(index = False))
#above3 = data_set["CGPA"] > 3.0
#input_given = input("Enter your name: ")
data_set = data_set.drop(columns = ["Sr. No.", "Roll #", "Pre Math", "%age", "Total", "SGPA"])
data_set = data_set[data_set["Remarks"] != "Relegated"]
#data_set = data_set.apply(pand.to_numeric, errors='coerce')
#print(data_set.mean().round(1))
print(data_set.to_string())
#try:
   # if above3.loc[input_given] == True:
    #    print(f"{input_given} is in the list of above 3.0 CGPA students.")
   ## else:
   #     print(f"{input_given} is not in the list of above 3.0 CGPA students.")
#except KeyError:
   #  print(f"{input_given} is not a valid name")