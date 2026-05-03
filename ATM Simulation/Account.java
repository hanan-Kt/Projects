import java.util.Scanner;
public class Account {
    String owner_name;
    int acc_num;
    double balance;
    int pincode;

    public Account(int acc_num, String owner_name, double balance, int pincode) {
        this.acc_num = acc_num;
        this.owner_name = owner_name;
        this.balance = balance;
        this.pincode = pincode;
    }

    public Account() {
    }

    void withdraw(double amount) {

        if (amount <= 10000) {
            balance = balance - amount;
        }

        else if (amount > balance) {
            System.out.println("Insufficient Funds.");
        }

        else {
            System.out.println("Withdraw amount exceeds limit.");
        }

        System.out.println("Remaining balance = " + balance);
    }

    void deposit(double amount) {
        balance = balance + amount;
    }


    static void main(String[] args) {
        Account acc = new Account();
        Data da = new Data();
        int pin = da.pincode;

        Scanner s = new Scanner(System.in);

        System.out.println("Enter your account number : ");

        try {
            int number = s.nextInt();
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("Please enter a valid account number.");

        }

        int i = 3;

        int code = 0;
        for (i >= 0) {
            do {
                System.out.print("Please enter your 4 digit pin: ");

                try {
                    code = s.nextInt();
                } catch (Exception e) {
                    System.out.println("Given pin code is not valid");
                }

                if (code != pin) {
                    System.out.println("Wrong pin code.");
                }
            } while (code != pin);


            System.out.println("Please select an option");
            System.out.println("1. Deposit Cash");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Check Account Details");
            System.out.println("4. Exit Simulation");
            int option = 0;
            double amount = 0;

            if (option == 1) {

                System.out.println("Enter amount you want to deposit: ");

                try {
                    amount = s.nextDouble();
                } catch (Exception e) {
                    System.out.println("Pleased enter a valid amount");
                }

                acc.deposit(amount);

            } else if (option == 2) {

                System.out.println("Enter amount you want to withdraw");

                try {
                    amount = s.nextDouble();
                } catch (Exception e) {
                    System.out.println("Please enter a valid amount");
                }

                acc.withdraw(amount);
            } else if (option == 3) {

                System.out.println("---- Account Details ----");
                da.Printing();
            } else if (option == 4) {

                System.out.println("----- Exiting Simulation ------");
            } else {
                System.out.println("Please enter a valid option.");
            }

        }
    }
}

