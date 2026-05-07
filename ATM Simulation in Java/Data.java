/**
 * Data class manages a collection of bank accounts for the banking system.
 * It stores predefined Account objects and provides a method to retrieve accounts by account number.
 * 
 * This class extends Account to inherit account-related functionality.
 * In a real-world application, this would typically connect to a database instead of hardcoding accounts.
 */
public class Data extends Account {
    
    // Pre-defined account objects - in production, these would be loaded from a database
    // Each account contains: account number, owner name, balance, and PIN code
    
    /**
     * Account 1: Owner "tttttt" with account number 1001
     * Balance: 190400.03, PIN: 1304
     */
    private Account acc1 = new Account(1001, "tttttt", 190400.03, 1304);
    
    /**
     * Account 2: Owner "Hanan" with account number 1002
     * Balance: 30230.53, PIN: 2112
     */
    private Account acc2 = new Account(1002, "Hanan", 30230.53, 2112);
    
    /**
     * Account 3: Owner "Salman" with account number 1003
     * Balance: 50000.00, PIN: 3465
     */
    private Account acc3 = new Account(1003, "Salman", 50000, 3465);
    
    /**
     * Account 4: Owner "fghjfgj" with account number 1004
     * Balance: 85524.66, PIN: 1734
     */
    private Account acc4 = new Account(1004, "fghjfgj", 85524.66, 1734);
    
    /**
     * Account 5: Owner "Yaqoob" with account number 1005
     * Balance: 252.09, PIN: 9813
     */
    private Account acc5 = new Account(1005, "Yaqoob", 252.09, 9813);
    
    /**
     * Account 6: Owner "Zahra" with account number 1006
     * Balance: 100203.00, PIN: 1658
     */
    private Account acc6 = new Account(1006, "Zahra", 100203, 1658);
    
    /**
     * Account 7: Owner "Ali" with account number 1007
     * Balance: 902423.00, PIN: 6533
     */
    private Account acc7 = new Account(1007, "Ali", 902423, 6533);
    
    /**
     * Account 8: Owner "Yousaf" with account number 1008
     * Balance: 34234.23, PIN: 5417
     */
    private Account acc8 = new Account(1008, "Yousaf", 34234.23, 5417);
    
    /**
     * Retrieves an Account object based on the provided account number.
     * Searches through all pre-defined accounts and returns the matching account.
     * 
     * This method uses sequential if-statements to find the account.
     * For better performance with more accounts, consider using a HashMap or Array instead.
     * 
     * @param accountNumber The account number to search for
     * @return The Account object if found, or null if no matching account exists
     */
    public Account getAccount(int accountNumber) {
        // Check if account number matches acc1
        if (acc1.getAccNum() == accountNumber) {
            return acc1; // Account found, return it
        }
        
        // Check if account number matches acc2
        if (acc2.getAccNum() == accountNumber) {
            return acc2; // Account found, return it
        }
        
        // Check if account number matches acc3
        if (acc3.getAccNum() == accountNumber) {
            return acc3; // Account found, return it
        }
        
        // Check if account number matches acc4
        if (acc4.getAccNum() == accountNumber) {
            return acc4; // Account found, return it
        }
        
        // Check if account number matches acc5
        if (acc5.getAccNum() == accountNumber) {
            return acc5; // Account found, return it
        }
        
        // Check if account number matches acc6
        if (acc6.getAccNum() == accountNumber) {
            return acc6; // Account found, return it
        }
        
        // Check if account number matches acc7
        if (acc7.getAccNum() == accountNumber) {
            return acc7; // Account found, return it
        }
        
        // Check if account number matches acc8
        if (acc8.getAccNum() == accountNumber) {
            return acc8; // Account found, return it
        }
        
        // No matching account found, return null
        // This null value is handled in the Account class main method
        return null;
    }
}
