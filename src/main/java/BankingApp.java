import java.util.HashMap;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Bank chaseBank = new Bank();
        Account account1 = new Account("777", "Checking", 1000);
        Account account2 = new Account("333", "Savings", 10000);
        chaseBank.addAccount(account1);
        chaseBank.addAccount(account2);
        Scanner input = new Scanner(System.in);
        String action = "0";
        do {
            System.out.println("Which account do you want to access?");
            String choice = input.nextLine();
            Account currentAccount = chaseBank.getAccount(choice);
            if (currentAccount != null) {
                System.out.println("What do you want to do?");
                System.out.println("(1) to withdraw");
                System.out.println("(2) to deposit");
                System.out.println("(3) to get account balance");
                System.out.println("(4) to exit");
                action = input.nextLine();
                if (action.equals("1")) {
                    System.out.println("How much do you want to withdraw?");
                    double amount = input.nextDouble();
                    input.nextLine();
                    currentAccount.withdraw(amount);
                    System.out.println(currentAccount.checkAccountBalance());
                }
                else if (action.equals("2")) {
                    System.out.println("How much do you want to deposit?");
                    double amount = input.nextDouble();
                    input.nextLine();
                    currentAccount.deposit(amount);
                    System.out.println(currentAccount.checkAccountBalance());
                }
                else if (action.equals("3")) {
                    System.out.println(currentAccount.checkAccountBalance());
                }
            }
            else {
                System.out.println("Incorrect account number!");
            }
        } while (!action.equals("4"));
    }
}
