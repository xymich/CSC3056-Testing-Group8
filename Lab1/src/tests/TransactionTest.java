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
        	TestUtils.printCasePass("Constructor_Account_number()");
        } else {
        	TestUtils.printCaseFail("Constructor_Account_number()");
        }

        if (test_transaction.getTransaction_amount() == test_TransactionAmount) {
        	TestUtils.printCasePass("Constructor_Transaction_amount()");
        } else {
        	TestUtils.printCaseFail("Constructor_Transaction_amount()");
        }

        if (test_transaction.getTransaction_date() != null) {
        	TestUtils.printCasePass("Constructor_Transaction_date()");
        } else {
        	TestUtils.printCaseFail("Constructor_Transaction_date()");
        }
        System.out.println("Starting the assertions of the test method: testTransactionConstructor");
    	assert test_transaction.getAccount_number() == test_AccountNumber;
		assert test_transaction.getTransaction_amount() == test_TransactionAmount;
		assert test_transaction.getTransaction_date() != null;
		
        TestUtils.printAssertPass("Transaction", "Constructor");
    }

    public static void testGetAccountNumber() {
    	
        Transaction test_transaction = new Transaction("98765", 200.00, new Date());
        String test_AccountNumber = "98765";
        if (test_transaction.getAccount_number().equals("98765")) {
        	TestUtils.printCasePass("GetAccountNumber()");
        } else {
        	TestUtils.printCaseFail("GetAccountNumber()");
        }
        System.out.println("Starting the assertions of the test method: testGetAccountNumber");
        assert test_transaction.getAccount_number() == test_AccountNumber;
        
        TestUtils.printAssertPass("Transaction", "GetAccountNumber");
    }

    public static void testGetTransactionAmount() {
        Transaction test_transaction = new Transaction("12345", 300.50, new Date());
        double test_TransactionAmount = 300.50;
        if (test_transaction.getTransaction_amount() == 300.50) {
        	TestUtils.printCasePass("GetTransactionAmount()");
        } else {
        	TestUtils.printCaseFail("GetTransactionAmount()");
        }
        System.out.println("Starting the assertions of the test method: testGetTransactionAmount");
        assert test_transaction.getTransaction_amount() == test_TransactionAmount;
        
        TestUtils.printAssertPass("Transaction", "GetTransactionAmount");
    }

    public static void testGetTransactionDate() {
        Date date = new Date();
        Transaction test_transaction = new Transaction("12345", 500.75, date);
        
        if (test_transaction.getTransaction_date().equals(date)) {
        	TestUtils.printCasePass("testGetTransactionDate()");
        } else {
        	TestUtils.printCaseFail("testGetTransactionDate()");
        }
        System.out.println("Starting the assertions of the test method: testGetTransactionDate");
        assert test_transaction.getTransaction_date() == date;
        
        TestUtils.printAssertPass("Transaction", "getTransactionDate");
    }
}
