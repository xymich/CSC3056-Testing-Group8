package tests;

import Controller.AccountController;
import model.Account;
import model.Transaction;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountControllerTest {

    @Test
    public void testGetBalance() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("12345", "john_doe", "Standard", new Date()));

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("12345", 200.0, new Date()));
        transactions.add(new Transaction("12345", -50.0, new Date()));

        // test valid balance calculation
        assertEquals(150.0, AccountController.getBalance("12345", transactions, accounts), 0.001);

        // test non-existent account
        assertEquals(-1, AccountController.getBalance("99999", transactions, accounts), 0.001);
    }

    @Test
    public void testAddTransaction() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("12345", "john_doe", "Standard", new Date()));

        ArrayList<Transaction> transactions = new ArrayList<>();

        // Test: Valid transaction
        AccountController.addTransaction("12345", 50.0, transactions, accounts);
        assertEquals(1, transactions.size());

        // Test: Zero amount transaction
        AccountController.addTransaction("12345", 0.0, transactions, accounts);
        assertEquals(1, transactions.size()); // Should not add

        // Test: Non-existent account
        AccountController.addTransaction("99999", 20.0, transactions, accounts);
        assertEquals(1, transactions.size()); // Should not add
    }

    @Test
    public void testGetTransactionsForAccount() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("12345", 100.0, new Date()));
        transactions.add(new Transaction("12345", -50.0, new Date()));
        transactions.add(new Transaction("67890", 200.0, new Date()));

        ArrayList<Transaction> result = AccountController.getTransactionsForAccount("12345", transactions);
        assertEquals(2, result.size()); // Should return 2 transactions
    }
}
