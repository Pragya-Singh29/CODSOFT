import java.util.Scanner;

class ATM{
    private BankAccount account;
    Scanner sc= new Scanner(System.in);
    //Constructor to initialize the ATM with a BankAccount
    public ATM(BankAccount account){
        this.account=account;
    }

    //Display the menu
    public void displayMenu(){
        System.out.println("------------WELCOME TO OUT ATM-----------");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    //Method to process the transaction according to the user's demand
    public void processTransaction(){
        boolean exit=false;

        while(!exit){
            displayMenu();
            System.out.print("Choose an option (1-4) accordingly: ");
            int option= sc.nextInt();

            switch (option) {
                case 1:  //Withdraw
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 2:  //Deposit
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:  //Check balance
                    account.checkBalance();
                    break;

                case 4:  //Exit
                    System.out.println("Thank you for using the ATM.");
                    exit = true;
                    break;
            
                default:
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class BankAccount{
    double balance;

    //Constructor to initialize the BankAccount with a balance
    public BankAccount(double initialBalance){
        balance= initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: Rs" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check account balance
    public void checkBalance() {
        System.out.println("Current balance: Rs" + balance);
    }
}

public class Task3 {
    public static void main(String[] args) {
        //Create the user's Bank Account with an initial amount i.e. 2000 here
       BankAccount account= new BankAccount(2000.00);

       // Create an ATM linked to the bank account
       ATM atm = new ATM(account);

       // Start the ATM and process transactions
       atm.processTransaction();
    }
}
