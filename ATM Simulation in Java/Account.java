import java.util.Scanner;

public class Account {
    private String owner_name;
    private int acc_num, pincode;
    private double balance;

    public Account(int acc_num, String owner_name, double balance, int pincode) {
        this.acc_num = acc_num;
        this.owner_name = owner_name;
        this.balance = balance;
        this.pincode = pincode;
    }

    public Account() {
    }

    public int getAccNum() {
        return acc_num;
    }

    public String getOwnerName() {
        return owner_name;
    }

    public double getBalance() {
        return balance;
    }

    public int getPincode() {
        return pincode;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Funds.");
        } else if (amount <= 10000) {
            balance = balance - amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Withdraw amount exceeds limit.");
        }
        System.out.println("Remaining balance = " + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else {
            balance = balance + amount;
            System.out.println("Deposit successful!");
        }
        System.out.println("New balance = " + balance);
    }

    public void displayDetails() {
        System.out.println("Account number: " + acc_num);
        System.out.println("Name: " + owner_name);
        System.out.println("Total Balance: " + balance);
    }

    public static void main(String[] args) {
        Data da = new Data();
        Scanner s = new Scanner(System.in);
        Account selectedAcc = null;

        while (selectedAcc == null) {
            System.out.println("Enter your account number: ");
            try {
                int number = s.nextInt();
                selectedAcc = da.getAccount(number);
                if (selectedAcc == null) {
                    System.out.println("Please enter a valid account number.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid account number.");
                s.nextLine();
            }
        }

        int attempts = 3;
        boolean pinCorrect = false;

        while (attempts > 0 && !pinCorrect) {
            System.out.print("Please enter your 4 digit pin: ");
            try {
                int code = s.nextInt();
                if (code == selectedAcc.getPincode()) {
                    System.out.println("PIN verified successfully!");
                    pinCorrect = true;
                } else {
                    System.out.println("Wrong pin code.");
                    attempts--;
                    if (attempts > 0) {
                        System.out.println("Attempts remaining: " + attempts);
                    }
                }
            } catch (Exception e) {
                System.out.println("Given pin code is not valid");
                s.nextLine();
                attempts--;
            }
        }

        if (!pinCorrect) {
            System.out.println("Maximum attempts exceeded. Account locked.");
            s.close();
            return;
        }

        int option = 0;

        while (option != 4) {
            System.out.println("\nPlease select an option");
            System.out.println("1. Deposit Cash");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Check Account Details");
            System.out.println("4. Exit Simulation");
            System.out.print("Enter your choice: ");

            try {
                option = s.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
                s.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("Enter amount you want to deposit: ");
                    try {
                        double amount = s.nextDouble();
                        selectedAcc.deposit(amount);
                    } catch (Exception e) {
                        System.out.println("Please enter a valid amount");
                        s.nextLine();
                    }
                    break;
                case 2:
                    System.out.println("Enter amount you want to withdraw: ");
                    try {
                        double amount = s.nextDouble();
                        selectedAcc.withdraw(amount);
                    } catch (Exception e) {
                        System.out.println("Please enter a valid amount");
                        s.nextLine();
                    }
                    break;
                case 3:
                    System.out.println("---- Account Details ----");
                    selectedAcc.displayDetails();
                    break;
                case 4:
                    System.out.println("----- Exiting Simulation ------");
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }

        s.close();
    }
}
