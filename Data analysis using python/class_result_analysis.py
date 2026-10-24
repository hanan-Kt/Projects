import pandas as pand
array1 = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
data_set = pand.read_csv(r"/home/hanan/Downloads/Projects/Projects/Data analysis using python/data.csv")
#print(data_set[["Roll #", "Name", "CGPA" , "Remarks"]].to_string(index = False))
#above3 = data_set["CGPA"] > 3.0
#input_given = input("Enter your name: ")
data_set = data_set.drop(columns = ["Sr. No.", "Roll #", "Pre Math", "%age", "Total", "SGPA"])
data_set = data_set[data_set["Remarks"] != "Relegated"]
data_set = data_set.sort_values(by = "CGPA", ascending = False)
#data_set = data_set.apply(pand.to_numeric, errors='coerce')
#print(data_set.mean().round(1))
print(data_set.nlargest(20, "CGPA").to_string(index = array1))
#print(data_set.sort_values(by = "CGPA", ascending = False).to_string(index = False))
#try:
   # if above3.loc[input_given] == True:
    #    print(f"{input_given} is in the list of above 3.0 CGPA students.")
   ## else:
   #     print(f"{input_given} is not in the list of above 3.0 CGPA students.")
#except KeyError:
   #  print(f"{input_given} is not a valid name")