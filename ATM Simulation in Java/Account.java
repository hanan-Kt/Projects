import java.util.Scanner;
public class Account {
    String owner_name;
    int acc_num, pincode;
    double balance;

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
        } else if (amount > balance) {
            System.out.println("Insufficient Funds.");
        } else {
            System.out.println("Withdraw amount exceeds limit.");
        }

        System.out.println("Remaining balance = " + balance);
        return;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else {
            balance = balance + amount;
            System.out.println("New balance = " + balance);
        }
        System.out.println("New balance = " + balance);
    }

    public static void main(String[] args) {
        int number = 0;

        Data da = new Data();
        Scanner s = new Scanner(System.in);

        System.out.println("Enter your account number : ");


        try {
            number = s.nextInt();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Please enter a valid account number.");

        } finally {


            if (number != da.acc_num) {
                do {

                    try {
                        number = s.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter a valid account number.");

                    }
                } while (number != da.acc_num);
            } else {
                Account selectedAcc = da.gettingAcc(number);

                int i = 3;
                int code = 0;

                while (i > 0 || code != selectedAcc.pincode) {
                    System.out.print("Please enter your 4 digit pin: ");

                    try {
                        code = s.nextInt();
                    } catch (Exception e) {
                        System.out.println("Given pin code is not valid");
                    }

                    if (code != selectedAcc.pincode) {
                        System.out.println("Wrong pin code.");
                    } else if (code == selectedAcc.pincode) {
                        break;
                    }
                    i = i - 1;
                }
                ;


                int option = 0;
                double amount = 0;

                while (option != 4) {

                    System.out.println("Please select an option");
                    System.out.println("1. Deposit Cash");
                    System.out.println("2. Withdraw Cash");
                    System.out.println("3. Check Account Details");
                    System.out.println("4. Exit Simulation");

                    try {
                        option = s.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter a valid option.");
                    }

                    if (option == 1) {

                        System.out.println("Enter amount you want to deposit: ");

                        try {
                            amount = s.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Pleased enter a valid amount");
                        }

                        selectedAcc.deposit(amount);

                    } else if (option == 2) {

                        System.out.println("Enter amount you want to withdraw");

                        try {
                            amount = s.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Please enter a valid amount");
                        }

                        selectedAcc.withdraw(amount);
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
    }
}
