package bankingapplication;

import java.util.Scanner;

/**
 *
 * @author SamyB
 */
public class BankingApplication {

    public static void main(String[] args) {

        BankAccount ba = new BankAccount("Samy", "23AAA8B");
        ba.displayMenu();

    }
}

class BankAccount {

    int bal;
    int priorSettlement;
    String cusName;
    String cusId;

    BankAccount(String name, String id) {

        cusName = name;
        cusId = id;

    }

    void deposit(int value) {
        // user enters value (parameter)

        if (value != 0) {
            bal = bal + value;
            priorSettlement = value;
        }

    }

    void withdraw(int value) {
        if (value != 0) {
            bal = bal - value;
            priorSettlement = -value;
        }
    }

    // priorSettlement basically means totalDeposit/totalWithdraw
    void getPriorSettlement() {
        if (priorSettlement > 0) {
            System.out.println("You Deposited: " + priorSettlement);
        } else if (priorSettlement < 0) {
            System.out.println("You Withdrew: " + Math.abs(priorSettlement));
        } else {
            System.out.println("Sorry, no transactions took place.");
        }
    }

    void displayMenu() {

        char choice = '1';
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello " + cusName + "!");
        System.out.println("Your ID code is: " + cusId);
        System.out.println("\n");
        System.out.println("A. Check your balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("===================================");
            System.out.println("Please enter a choice");
            System.out.println("===================================");
            choice = scan.next().charAt(0);

            switch (choice) {
                case 'A':
                    System.out.println("------------------");
                    System.out.println("Balance: " + bal);
                    System.out.println("------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("------------------");
                    System.out.println("Enter a value to deposit: ");
                    System.out.println("------------------");
                    int value = scan.nextInt();
                    deposit(value);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("------------------");
                    System.out.println("Enter an value to withdraw: ");
                    System.out.println("------------------");
                    int value2 = scan.nextInt();
                    withdraw(value2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("------------------");
                    getPriorSettlement();
                    System.out.println("------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("****************");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter again.");
                    break;
            }

        } while (choice != 'E');

        System.out.println("Thank you for using our services!");

    }

}
