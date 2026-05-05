
public class Data extends Account {

    private Account acc1 = new Account(1001, "tttttt" , 190400.03, 1304);
    private Account acc2 = new Account(1002, "Hanan" , 30230.53, 2112);
    private Account acc3 = new Account(1003, "Salman" , 50000, 3465);
    private Account acc4 = new Account(1004, "fghjfgj" , 85524.66, 1734);
    private Account acc5 = new Account(1005, "Yaqoob" , 252.09,9813);
    private Account acc6 = new Account(1006, "Zahra" , 100203,1658);
    private Account acc7 = new Account(1007, "Ali" , 902423, 6533);
    private Account acc8 = new Account(1008, "Yousaf" , 34234.23, 5417);

    int acc_num;
    String owner_name;
    int balance;

    public Account gettingAcc (int accountNumber) {
        if (acc1.acc_num == accountNumber) return acc1;
        if (acc2.acc_num == accountNumber) return acc2;
        if (acc3.acc_num == accountNumber) return acc3;
        if (acc4.acc_num == accountNumber) return acc4;
        if (acc5.acc_num == accountNumber) return acc5;
        if (acc6.acc_num == accountNumber) return acc6;
        if (acc7.acc_num == accountNumber) return acc7;
        if (acc8.acc_num == accountNumber) return acc8;
        return null; // Account not found
    }

    public void Printing () {
        Account acc = new Account();
            System.out.println("Account number: " + acc.acc_num);
            System.out.println("Name: " + acc.owner_name);
            System.out.println("Total Balance: " + acc.balance);
        }

    }
