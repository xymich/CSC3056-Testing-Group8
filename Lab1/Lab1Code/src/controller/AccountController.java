package controller;

import model.Account;
import model.Transaction;
import java.text.SimpleDateFormat;
import java.util.Vector;
import utility.TestUtils;

public class AccountController {

    //calculates the balance of a given account (by its number).

    public static double getBalance(String account_number, Vector<Transaction> transactions, Vector<Account> accounts) {
        boolean accountExists = accounts.stream().anyMatch(acc -> acc.getAccount_number().equals(account_number));

        if (!accountExists) {
            System.out.println(TestUtils.TEXT_COLOR_RED + "Error: Account " + account_number + " does not exist. Cannot calculate balance." + TestUtils.TEXT_COLOR_RESET);
            return -1; // indicating an error
        }

        return transactions.stream()
                .filter(transaction -> transaction.getAccount_number().equals(account_number))
                .mapToDouble(Transaction::getTransaction_amount)
                .sum();
    }

    //Adds a transaction to an account after validating if the account exists.

    public static void addTransaction(String account_number, double amount, Vector<Transaction> transactions, Vector<Account> accounts) {
        boolean accountExists = accounts.stream().anyMatch(acc -> acc.getAccount_number().equals(account_number));

        if (!accountExists) {
            System.out.println(TestUtils.TEXT_COLOR_RED + "Error: Account " + account_number + " does not exist. Transaction failed." + TestUtils.TEXT_COLOR_RESET);
            return;
        }

        if (amount == 0) {
            System.out.println(TestUtils.TEXT_COLOR_RED + "Error: Transaction amount cannot be zero." + TestUtils.TEXT_COLOR_RESET);
            return;
        }

        Transaction transaction = new Transaction(account_number, amount, new java.util.Date());
        transactions.add(transaction);
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "Transaction successful: Account " + account_number + " | Amount: $" + amount + TestUtils.TEXT_COLOR_RESET);
    }

    /**
     * retrieves all transactions for a given account.
     * @param account_number The account number.
     * @param transactions   The list of all transactions.
     * @param accounts       The list of accounts (used for validation).
     * @return A list of transactions for the given account.
     */
    public static Vector<Transaction> getTransactionsForAccount(String account_number, Vector<Transaction> transactions, Vector<Account> accounts) {
        boolean accountExists = accounts.stream().anyMatch(acc -> acc.getAccount_number().equals(account_number));

        if (!accountExists) {
            System.out.println(TestUtils.TEXT_COLOR_RED + "Error: Account " + account_number + " does not exist. Cannot retrieve transactions." + TestUtils.TEXT_COLOR_RESET);
            return new Vector<>(); // return  empty list
        }

        Vector<Transaction> userTransactions = new Vector<>();
        for (Transaction t : transactions) {
            if (t.getAccount_number().equals(account_number)) {
                userTransactions.add(t);
            }
        }

        return userTransactions;
    }

    //Prints all accounts along with their balance.

    public static void printAllAccounts(Vector<Account> accounts, Vector<Transaction> transactions) {
        System.out.println("There are: " + accounts.size() + " accounts in the system.");
        System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-15s",
                "Account #", "Username", "Type", "Opening Date", "Balance"));
        System.out.println("--------------------------------------------------------------------------------");

        for (Account account : accounts) {
            double balance = getBalance(account.getAccount_number(), transactions, accounts);
            System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| $%-15.2f",
                    account.getAccount_number(),
                    account.getUsername_of_account_holder(),
                    account.getAccount_type(),
                    new SimpleDateFormat("dd/MM/yyyy").format(account.getAccount_opening_date()),
                    balance));
        }
        System.out.println();
    }
}
