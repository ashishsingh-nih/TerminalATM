
// ATM.
import java.util.Scanner;

class BankAC {
  private String acHolder;
  private int acNo;
  private double balance;

  // Constructor to initialize the account details.
  BankAC(String acHolder, int acNo, double balance) {
    this.acHolder = acHolder;
    this.acNo = acNo;
    this.balance = balance;
  }

  // Display balance.
  void checkBalance() {
    System.out.printf(">> Available Balance:  $%f%n%n", balance);
  }

  // Method to display transaction message.
  void transOutput(String action, double amount) {
    String message = String.format(">> Dear %s, your Ac no: %d has been %s $%.2f", acHolder, acNo, action, amount);
    System.out.println(message);
  }

  // Method to deposit money.
  final void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      transOutput("credited with", amount);
      checkBalance();
    } else {
      System.out.println("Invalid deposit amount.");
    }

  }

  // Method to withdraw money.
  final void withdraw(double amount) {
    if (amount > 0) {
      if (amount <= balance) {
        balance -= amount;
        transOutput("debited by", amount);
        checkBalance();
      } else {
        System.out.println("Insufficient balance.");
      }
    } else {
      System.out.println("Invalid amount entered.");
    }
  }

}

public class ATM {

  // Database of account details(In array).
  static int numberOfAC = 5;
  static BankAC[] account = new BankAC[numberOfAC];
  static int[] pin = new int[numberOfAC];

  // Method to store account data.
  final private static void dataBase() {
    // Account details

    // Account 01
    account[0] = new BankAC("Vaibhav Singh", 278000, 88000);
    // Account 02
    account[1] = new BankAC("Niharika Singh", 278001, 150000);
    // Account 03
    account[2] = new BankAC("Santanu Kumar", 278002, 407000);
    // Account 04
    account[3] = new BankAC("Pallavi Mehta", 278003, 40000);
    // Account 05
    account[4] = new BankAC("Prashant Kumar", 278004, 790000);

    // PIN of account. (data)
    pin[0] = 1234;
    pin[1] = 2345;
    pin[2] = 3456;
    pin[3] = 4567;
    pin[4] = 5678;

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Initialise the data base.
    dataBase();

    // Enter account number.
    System.out.print("Enter your AC number: ");
    int acNo = sc.nextInt();

    if (acNo >= 278000 && acNo <= 278004) {

      // Enter PIN.
      System.out.print("Enter your PIN: ");
      int enteredPin = sc.nextInt();
      sc.nextLine(); // Consume the newline character.

      // Verifying credentials.
      if (enteredPin == pin[acNo - 278000]) {
      // PIN is correct, proceed with actions.
        for (int i = 0; i <= 0; i--) {
          // Enter action.
          System.out.print("Enter action(Deposit/Withdraw/Check balance): ");
          String action = sc.nextLine().toLowerCase().trim();

          // Evaluating action and then completing the task.
          double amount;
          switch (action) {
            case "deposit":
              System.out.print("Amount: ");
              amount = sc.nextDouble();
              sc.nextLine(); // Consume left over line.
              account[acNo - 278000].deposit(amount);
              break;
            case "withdraw":
              System.out.print("Amount: ");
              amount = sc.nextDouble();
              sc.nextLine(); // Consume left over line.
              account[acNo - 278000].withdraw(amount);
              break;
            case "check balance":
              account[acNo - 278000].checkBalance();
              break;
            case "logout":
              System.out.println("Thanks for visiting us!");
              // sc.nextLine();
              i = 2; // Break from loop and exit the ATM programme.
              break;
            default:
              System.out.println("Invalid action.");
              sc.nextLine();
              break;
          } 

        } 

      } else {
      System.out.println("Invalid credentials.");
      }

    } else {
      System.out.println("Invalid credentials.");
    }

    sc.close();
  }
}