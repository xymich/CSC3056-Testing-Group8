package tests;

import model.Transaction;
import utility.TestUtils;

import java.util.Date;

public class TransactionTest {

    public static void main(String[] args) {
        testTransactionConstructor();
        testGetAccountNumber();
        testGetTransactionAmount();
        testGetTransactionDate();
    }

    public static void testTransactionConstructor() {
        // 1. Setup
        String test_AccountNumber = "12345";
        double test_TransactionAmount = 150.75;
        Date test_TransactionDate = new Date();

        // 2. Exercise
        Transaction test_transaction = new Transaction(test_AccountNumber, test_TransactionAmount, test_TransactionDate);

        // 3. Verify
        if (test_transaction.getAccount_number().equals(test_AccountNumber)) {
            System.out.println(TestUtils.ANSI_GREEN + "testTransactionConstructor: TC1 Passed" + TestUtils.ANSI_RESET);
        } else {
            System.out.println(TestUtils.ANSI_RED + "testTransactionConstructor: TC1 FAILED" + TestUtils.ANSI_RESET);
        }

        if (test_transaction.getTransaction_amount() == test_TransactionAmount) {
            System.out.println(TestUtils.ANSI_GREEN + "testTransactionConstructor: TC2 Passed" + TestUtils.ANSI_RESET);
        } else {
            System.out.println(TestUtils.ANSI_RED + "testTransactionConstructor: TC2 FAILED" + TestUtils.ANSI_RESET);
        }

        if (test_transaction.getTransaction_date() != null) {
            System.out.println(TestUtils.ANSI_GREEN + "testTransactionConstructor: TC3 Passed" + TestUtils.ANSI_RESET);
        } else {
            System.out.println(TestUtils.ANSI_RED + "testTransactionConstructor: TC3 FAILED" + TestUtils.ANSI_RESET);
        }
        
    	assert test_transaction.getAccount_number() == test_AccountNumber;
		assert test_transaction.getTransaction_amount() == test_TransactionAmount;
		assert test_transaction.getTransaction_date() != null;
		
		System.out.println("All java assertions in the Transaction Constructor test suite passed.");
    }

    public static void testGetAccountNumber() {
        Transaction test_transaction = new Transaction("98765", 200.00, new Date());
        String test_AccountNumber = "98765";
        if (test_transaction.getAccount_number().equals("98765")) {
            System.out.println(TestUtils.ANSI_GREEN + "testGetAccountNumber: Passed" + TestUtils.ANSI_RESET);
        } else {
            System.out.println(TestUtils.ANSI_RED + "testGetAccountNumber: FAILED" + TestUtils.ANSI_RESET);
        }
        
        assert test_transaction.getAccount_number() == test_AccountNumber;
        System.out.println("All java assertions in the Transaction GetAccountNumber test suite passed.");
    }

    public static void testGetTransactionAmount() {
        Transaction test_transaction = new Transaction("12345", 300.50, new Date());
        double test_TransactionAmount = 300.50;
        if (test_transaction.getTransaction_amount() == 300.50) {
            System.out.println(TestUtils.ANSI_GREEN + "testGetTransactionAmount: Passed" + TestUtils.ANSI_RESET);
        } else {
            System.out.println(TestUtils.ANSI_RED + "testGetTransactionAmount: FAILED" + TestUtils.ANSI_RESET);
        }
        
        assert test_transaction.getTransaction_amount() == test_TransactionAmount;
        System.out.println("All java assertions in the Transaction GetTransactionAmount test suite passed.");
    }

    public static void testGetTransactionDate() {
        Date date = new Date();
        Transaction test_transaction = new Transaction("12345", 500.75, date);
        
        if (test_transaction.getTransaction_date().equals(date)) {
            System.out.println(TestUtils.ANSI_GREEN + "testGetTransactionDate: Passed" + TestUtils.ANSI_RESET);
        } else {
            System.out.println(TestUtils.ANSI_RED + "testGetTransactionDate: FAILED" + TestUtils.ANSI_RESET);
        }
        
        assert test_transaction.getTransaction_date() == date;
        System.out.println("All java assertions in the Transaction getTransactionDate test suite passed.");
    }
}
