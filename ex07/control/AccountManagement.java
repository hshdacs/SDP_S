package ex07.control;

import java.util.Scanner;

import ex07.dao.AccountDAO;
import ex07.dao.AccountDBbySQL;
import ex07.dao.AccountDBinMemory;
import ex07.model.Account;

public class AccountManagement {
    public static void main(String[] args) {
        //AccountDAO accountDB = new AccountDBinMemory();
        AccountDAO accountDB = new AccountDBbySQL();

        Scanner input = new Scanner(System.in);
    mainloop:
        while (true) {
            // print main menu
            System.out.println("Main:");
            System.out.println("===================");
            System.out.println("1 - Create new account");
            System.out.println("2 - List all accounts");
            System.out.println("3 - Change account");
            System.out.println("4 - Delete account");
            System.out.println("5 - Deposit money");
            System.out.println("6 - Withdraw money");
            System.out.println("9 - Quit Program");
            System.out.print("Your choice: ");
            char choice  = input.nextLine().charAt(0);

            int number;
            switch (choice) {
                case '1':
                    System.out.print("Account number: ");
                    number = input.nextInt();
                    input.nextLine();
                    System.out.print("Account Owner: ");
                    String name = input.nextLine();
                    if (accountDB.insertAccount(new Account(number, name))) {
                        System.out.println("added new account successful");
                    }
                    break;

                case '2':
                    for (Account account : accountDB.getAllAccounts()) {
                        System.out.println(account);
                    }
                    break;

                case '4':
                    System.out.print("Account number: ");
                    number = input.nextInt();
                    input.nextLine();
                    if ( accountDB.getAccountByID(number) != null ) {
                        System.out.print("Do you really want to delete this account (Y/N)? ");
                        char answer = input.next().charAt(0);
                        input.nextLine();
                        if (answer == 'Y') {
                            if (accountDB.removeAccount(number)) {
                                System.out.println("Account deleted!");
                            }
                        }
                    }
                    break;

                case '5':
                    System.out.print("Account number: ");
                    number = input.nextInt();
                    input.nextLine();
                    Account account = accountDB.getAccountByID(number);
                    if ( account != null ) {
                        System.out.println("Amount to deposit: ");
                        double amount = input.nextDouble();
                        input.nextLine();
                        account.deposit(amount);
                        accountDB.changeAccount(number, account);
                    }
                break;

                case '9':
                    break mainloop; // while
                    
                default:
                    System.out.println("Sorry, not yet implemented");
                    break;
            }
        }


    }
}
