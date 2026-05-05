import secrets

print("Guess the number.")
realchoice = secrets.randbelow(51)
i = 5

while i > 0: 
    num = int(input().strip())
   

    if num == realchoice: 
     print("Tou nailed it!")
     break


    elif num < realchoice: 
     print("Too low!")
     i = i - 1
     print(f"You have {i} tries left")

    else:
     print("Too High!")
     i = i - 1
     print(f"You have {i} tries left")

if i == 0:
   print("You failed to guess the number in 5 tries")
   print(f"Number was: {realchoice}")