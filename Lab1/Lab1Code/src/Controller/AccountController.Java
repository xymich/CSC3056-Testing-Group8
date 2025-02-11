package controllers;

import model.Account;
import model.Transaction;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class AccountController {

    /**
     * cal.  balance of a given account (by its number)         //need to go back to this
     * using param for  bettter code readability
     * @param account_number  account number
     * @param transactions    list of all transactions
     * @return  calculated balance.
     */
    public static double getBalance(String account_number, Vector<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getAccount_number().equals(account_number))
                .mapToDouble(Transaction::getTransaction_amount)
                .sum();
    }

    /**
     * transaction to an account after validating if the account exists
     *
     * @param account_number  account number
     * @param amount          transaction amount
     * @param transactions    list of transactions
     * @param accounts        list of accounts (used for validation)
     */
    public static void addTransaction(String account_number, double amount, Vector<Transaction> transactions, Vector<Account> accounts) {
        boolean accountExists = accounts.stream().anyMatch(acc -> acc.getAccount_number().equals(account_number));

        if (!accountExists) {
            System.out.println("⚠️ Error: Account " + account_number + " does not exist. Transaction failed.");
            return;
        }

        Transaction transaction = new Transaction(account_number, amount, new java.util.Date());
        transactions.add(transaction);
        System.out.println("✅ Transaction successful: Account " + account_number + " | Amount: $" + amount);
    }

    /**
     * prints all accounts along with their balance
     *
     * @param accounts      list of accounts
     * @param transactions  list of transactions (to calculate balance)
     */
    public static void printAllAccounts(Vector<Account> accounts, Vector<Transaction> transactions) {
        System.out.println("There are: " + accounts.size() + " accounts in the system.");
        System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-15s",
                "Account #", "Username", "Type", "Opening Date", "Balance"));
        System.out.println("--------------------------------------------------------------------------------");

        for (Account account : accounts) {
            System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| $%-15.2f",
                    account.getAccount_number(),
                    account.getUsername_of_account_holder(),
                    account.getAccount_type(),
                    new SimpleDateFormat("dd/MM/yyyy").format(account.getAccount_opening_date()),
                    getBalance(account.getAccount_number(), transactions)));
        }
        System.out.println();
    }
}

