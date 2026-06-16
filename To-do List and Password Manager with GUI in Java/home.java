import java.util.Scanner;

public class home {
    
    private static class Todo extends Todolist {
        
    }

    private static class Passwords extends PasswordManager {

    }

    public static void main(String[] args) {
        Todo td = new Todo();
        Passwords pw = new Passwords();
        Scanner sc = new Scanner(System.in);
        int option = 0;

        do {

        System.out.println("Choose an option :");
        System.out.println("1. To do List");
        System.out.println("2. Password Manager");
        System.out.println("3. Exit");

        try {
        option = sc.nextInt();
        }

        catch (Exception e) {
            System.out.println("Please enter a valid number.");
        }

           if (option == 1) {
            td.show();
            }
       
            else if (option == 2) {
             pw.more();
            }
       
            else 
               System.out.println("Enter from mentioned numbers.");

        }  while (option != 3);
     
        System.out.println("Exiting program");
        sc.close();
    }
}
