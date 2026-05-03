
public class Data extends Account {

    private Account acc1 = new Account(1001, "Adeena" , 190400.03, 1304);
    private Account acc2 = new Account(1002, "Hanan" , 30230.53, 2112);
    private Account acc3 = new Account(1003, "Salman" , 50000, 3465);
    private Account acc4 = new Account(1004, "Khadija" , 85524.66, 1734);
    private Account acc5 = new Account(1005, "Yaqoob" , 252.09,9813);
    private Account acc6 = new Account(1006, "Zahra" , 100203,1658);
    private Account acc7 = new Account(1007, "Ali" , 902423, 6533);
    private Account acc8 = new Account(1008, "Yousaf" , 34234.23, 5417);


    int acc_num = acc1.acc_num;
    String owner_name = acc1.owner_name;
    double balance = acc1.balance;
    int pincode = acc1.pincode;

    public void Printing () {
            System.out.println("Account number: " + acc_num);
            System.out.println("Name: " + owner_name);
            System.out.println("Total Balance: " + balance);
        }

    }