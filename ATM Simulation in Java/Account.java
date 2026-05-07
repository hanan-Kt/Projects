// Import Scanner library for user input
import java.util.Scanner;

/**
 * Account class simulates a basic banking system with deposit, withdraw, and 
 * account detail viewing functionality. Includes PIN verification and transaction limits.
 */
public class Account {

    // Private variables for encapsulation - prevents direct access from outside the class
    private String owner_name;      // Stores the name of the account owner
    private int acc_num;            // Stores the account number
    private int pincode;            // Stores the 4-digit PIN for authentication
    private double balance;         // Stores the current account balance

    /**
     * Constructor to initialize an Account object with provided parameters.
     * @param acc_num   The account number
     * @param owner_name The name of the account owner
     * @param balance   The initial account balance
     * @param pincode   The 4-digit PIN for security
     */
    public Account(int acc_num, String owner_name, double balance, int pincode) {
        this.acc_num = acc_num;
        this.owner_name = owner_name;
        this.balance = balance;
        this.pincode = pincode;
    }

    /**
     * Default no-argument constructor for Account class.
     * Used when creating an Account object without initial values.
     */
    public Account() {
    }

    /**
     * Getter method to retrieve the account number.
     * @return the account number
     */
    public int getAccNum() {
        return acc_num;
    }

    /**
     * Getter method to retrieve the owner's name.
     * @return the owner's name
     */
    public String getOwnerName() {
        return owner_name;
    }

    /**
     * Getter method to retrieve the current account balance.
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter method to retrieve the PIN code.
     * @return the PIN code
     */
    public int getPincode() {
        return pincode;
    }

    /**
     * Withdraws a specified amount from the account.
     * Validates that: the amount doesn't exceed balance, and the withdrawal limit (10000) is not exceeded.
     * @param amount The amount to withdraw
     */
    public void withdraw(double amount) {
        // Check if withdrawal amount exceeds available balance
        if (amount > balance) {
            System.out.println("Insufficient Funds.");
        } 
        // Check if withdrawal amount is within the limit of 10000
        else if (amount <= 10000) {
            balance = balance - amount;
            System.out.println("Withdrawal successful!");
        } 
        // Withdrawal amount exceeds the limit
        else {
            System.out.println("Withdraw amount exceeds limit.");
        }
        // Display remaining balance after withdrawal attempt
        System.out.println("Remaining balance = " + balance);
    }

    /**
     * Deposits a specified amount into the account.
     * Validates that the amount is greater than zero.
     * @param amount The amount to deposit
     */
    public void deposit(double amount) {
        // Check if amount is valid (greater than zero)
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } 
        // Amount is valid, proceed with deposit
        else {
            balance = balance + amount;
            System.out.println("Deposit successful!");
        }
        // Display new balance after deposit
        System.out.println("New balance = " + balance);
    }

    /**
     * Displays the account owner's details including account number, name, and balance.
     */
    public void displayDetails() {
        System.out.println("Account number: " + acc_num);
        System.out.println("Name: " + owner_name);
        System.out.println("Total Balance: " + balance);
    }

    /**
     * Main method - entry point of the application.
     * Handles account selection, PIN verification, and menu-driven transactions.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create Data object to fetch account information from database
        Data da = new Data();
        // Create Scanner object for reading user input
        Scanner s = new Scanner(System.in);
        // Variable to store the selected account (initially null)
        Account selectedAcc = null;

        // Loop until a valid account number is entered
        while (selectedAcc == null) {
            System.out.println("Enter your account number: ");
            try {
                // Read account number from user
                int number = s.nextInt();
                // Retrieve account from Data object using account number
                selectedAcc = da.getAccount(number);
                // Validate that the account exists
                if (selectedAcc == null) {
                    System.out.println("Please enter a valid account number.");
                }
            } catch (Exception e) {
                // Handle invalid input (non-integer)
                System.out.println("Please enter a valid account number.");
                // Clear the invalid input from scanner buffer
                s.nextLine();
            }
        }

        // Initialize PIN verification variables
        int attempts = 3;           // Maximum 3 PIN attempts allowed
        boolean pinCorrect = false; // Flag to track successful PIN verification

        // Loop for PIN verification (up to 3 attempts)
        while (attempts > 0 && !pinCorrect) {
            System.out.print("Please enter your 4 digit pin: ");
            try {
                // Read PIN from user
                int code = s.nextInt();
                // Compare entered PIN with account's PIN
                if (code == selectedAcc.getPincode()) {
                    System.out.println("PIN verified successfully!");
                    pinCorrect = true; // Set flag to exit PIN loop
                } 
                // PIN is incorrect
                else {
                    System.out.println("Wrong pin code.");
                    attempts--;
                    // Display remaining attempts if any
                    if (attempts > 0) {
                        System.out.println("Attempts remaining: " + attempts);
                    }
                }
            } catch (Exception e) {
                // Handle invalid PIN input (non-integer)
                System.out.println("Given pin code is not valid");
                // Clear the invalid input from scanner buffer
                s.nextLine();
                attempts--;
            }
        }

        // Check if PIN verification failed (all attempts exhausted)
        if (!pinCorrect) {
            System.out.println("Maximum attempts exceeded. Account locked.");
            // Close the scanner resource
            s.close();
            // Exit the program
            return;
        }

        // Initialize option variable for menu selection
        int option = 0;

        // Main transaction menu loop (continues until user selects option 4 to exit)
        while (option != 4) {
            // Display transaction menu
            System.out.println("\nPlease select an option");
            System.out.println("1. Deposit Cash");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Check Account Details");
            System.out.println("4. Exit Simulation");
            System.out.print("Enter your choice: ");

            try {
                // Read user's menu choice
                option = s.nextInt();
            } catch (Exception e) {
                // Handle invalid menu input (non-integer)
                System.out.println("Please enter a valid option.");
                // Clear the invalid input from scanner buffer
                s.nextLine();
                // Skip to next iteration without processing invalid input
                continue;
            }

            // Process user's selected option
            switch (option) {
                case 1:
                    // Deposit cash option
                    System.out.println("Enter amount you want to deposit: ");
                    try {
                        // Read amount from user
                        double amount = s.nextDouble();
                        // Call deposit method with user-entered amount
                        selectedAcc.deposit(amount);
                    } catch (Exception e) {
                        // Handle invalid amount input (non-numeric)
                        System.out.println("Please enter a valid amount");
                        // Clear the invalid input from scanner buffer
                        s.nextLine();
                    }
                    break;
                case 2:
                    // Withdraw cash option
                    System.out.println("Enter amount you want to withdraw: ");
                    try {
                        // Read amount from user
                        double amount = s.nextDouble();
                        // Call withdraw method with user-entered amount
                        selectedAcc.withdraw(amount);
                    } catch (Exception e) {
                        // Handle invalid amount input (non-numeric)
                        System.out.println("Please enter a valid amount");
                        // Clear the invalid input from scanner buffer
                        s.nextLine();
                    }
                    break;
                case 3:
                    // Display account details option
                    System.out.println("---- Account Details ----");
                    // Call method to display account information
                    selectedAcc.displayDetails();
                    break;
                case 4:
                    // Exit simulation option
                    System.out.println("----- Exiting Simulation ------");
                    break;
                default:
                    // Handle invalid menu option
                    System.out.println("Please enter a valid option.");
            }
        }

        // Close the scanner resource to free up system resources
        s.close();
    }
}
