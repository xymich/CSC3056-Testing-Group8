package tests;

import controller.AccountController;
import model.Account;
import model.Transaction;
import utility.TestUtils;
import java.util.Date;
import java.util.Vector;

public class AccountControllerTest {
	
    public static void testGetBalance() {
    	Vector<Account> accounts = new Vector<>();
        accounts.add(new Account("12345", "john_doe", "Standard", new Date()));

        Vector<Transaction> transactions = new Vector<>();
        transactions.add(new Transaction("12345", 200.0, new Date()));
        transactions.add(new Transaction("12345", -50.0, new Date()));
        
        double test_account_balance = 150.0;
        double test_null_account_balance = -1;
        
        // test valid balance calculation
        assert AccountController.getBalance("12345", transactions, accounts) == test_account_balance;
        
        // test non-existent account
        assert AccountController.getBalance("99999", transactions, accounts) == test_null_account_balance;
        
        TestUtils.printAssertPass("AccountController", "getBalance");
    }

    public static void testAddTransaction() {
    	Vector<Account> accounts = new Vector<>();
        accounts.add(new Account("12345", "john_doe", "Standard", new Date()));

        Vector<Transaction> transactions = new Vector<>();

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
    	Vector<Account> accounts = new Vector<>();
        accounts.add(new Account("12345", "john_doe", "Standard", new Date()));
        
        Vector<Transaction> transactions = new Vector<>();
        transactions.add(new Transaction("12345", 100.0, new Date()));
        transactions.add(new Transaction("12345", -50.0, new Date()));
        transactions.add(new Transaction("67890", 200.0, new Date()));

        Vector<Transaction> result = AccountController.getTransactionsForAccount("12345", transactions, accounts);
        assert result.size() == 2; // Should return 2 transactions
        TestUtils.printAssertPass("AccountController", "getTransactionsForAccount");
    }
    
    public static void main(String[] args) {
    	//testGetBalance();
		//testAddTransaction();
		testGetTransactionsForAccount();
	}
}
