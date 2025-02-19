package tests;

import controller.AccountController;
import model.Account;
import model.Transaction;
import utility.TestUtils;

import java.util.ArrayList;
import java.util.Date;

public class AccountControllerTest {
	
    public static void testGetBalance() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("12345", "john_doe", "Standard", new Date()));

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("12345", 200.0, new Date()));
        transactions.add(new Transaction("12345", -50.0, new Date()));
        
        double test_account_balance = 150.0;
        double test_null_account_balance = -1;
        
        // test valid balance calculation
        assert AccountController.getBalance("12345", transactions) == test_account_balance;
        
        // test non-existent account
        assert AccountController.getBalance("99999", transactions) == test_null_account_balance;
        
        System.out.println("All java assertions in the AccountController getBalance test suite passed.");
    }

    public static void testAddTransaction() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("12345", "john_doe", "Standard", new Date()));

        ArrayList<Transaction> transactions = new ArrayList<>();

        // Test: Valid transaction
        AccountController.addTransaction("12345", 50.0, transactions, accounts);
        assert transactions.size() == 1;

        // Test: Zero amount transaction
        AccountController.addTransaction("12345", 0.0, transactions, accounts);
        assert transactions.size() == 1; // Should not add

        // Test: Non-existent account
        AccountController.addTransaction("99999", 20.0, transactions, accounts);
        assert transactions.size() == 1; // Should not add
        
        TestUtils.printAssertPass("AccountController", "addTransaction");
    }

    public static void testGetTransactionsForAccount() {
    	ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("12345", "john_doe", "Standard", new Date()));
        
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("12345", 100.0, new Date()));
        transactions.add(new Transaction("12345", -50.0, new Date()));
        transactions.add(new Transaction("67890", 200.0, new Date()));

        ArrayList<Transaction> result = AccountController.getTransactionsForAccount("12345", transactions, accounts);
        assert result.size() == 2; // Should return 2 transactions
        TestUtils.printAssertPass("AccountController", "getTransactionsForAccount");
    }
    
    public static void main(String[] args) {
		
		testAddTransaction();
		testGetTransactionsForAccount();
	}
}
