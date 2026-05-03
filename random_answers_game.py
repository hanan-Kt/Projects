import random
import secrets

while True:
    print("\nType a question to get a random answer:\n")
    print("     ------------ OR -----------     \n")
    print("      Type *exit* to exit the program\n")
    question = input().strip()

    if question.lower() == "exit":
        break

    answer_list = ["Are you fucking kidding me!" , "Hell no, That is not gonna work." , "Sure, if that is your priority." , "The force is stronger in this one." , "They are like animals, and I slaughtered them like animals." , "We are loooooossst."]

    print("\n   *Answer by random library*")
    print(random.choice(answer_list))

    print("\n   *Answer by secrets library*")
    print(secrets.choice(answer_list))

print("--------- Terminating program ----------")