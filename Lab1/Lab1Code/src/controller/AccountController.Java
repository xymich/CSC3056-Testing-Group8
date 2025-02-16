package controller;

import model.Account;
import model.Transaction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AccountController {
	
	// using parameter comments for  better code readability
	// test message text colours
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";

    /**
     * cal.  balance of a given account (by its number)         //need to go back to this
     * @param account_number  account number
     * @param transactions    list of all transactions
     * @return  calculated balance.
     */
    public static double getBalance(String account_number, ArrayList<Transaction> transactions) {
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
    public static void addTransaction(String account_number, double amount, ArrayList<Transaction> transactions, ArrayList<Account> accounts) {
        boolean accountExists = accounts.stream().anyMatch(acc -> acc.getAccount_number().equals(account_number));

        if (!accountExists) {
            System.out.println(ANSI_RED + "Error: Account " + account_number + " does not exist. Transaction failed." + ANSI_RESET);
            return;
        }

        Transaction transaction = new Transaction(account_number, amount, new java.util.Date());
        transactions.add(transaction);
        System.out.println(ANSI_GREEN + "Transaction successful: Account " + account_number + " | Amount: $" + amount + ANSI_RESET);
    }
    
    public static ArrayList<Transaction> getTransactionsForAccount(String account_number) {
    	
    }

    /**
     * prints all accounts along with their balance
     *
     * @param accounts      list of accounts
     * @param transactions  list of transactions (to calculate balance)
     */
    public static void printAllAccounts(ArrayList<Account> accounts, ArrayList<Transaction> transactions) {
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

