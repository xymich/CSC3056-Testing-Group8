package tests;

import model.Transaction;
import java.util.Date;

public class TransactionTest {

    // Test message text colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        testTransactionConstructor();
        testGetAccountNumber();
        testGetTransactionAmount();
        testGetTransactionDate();
    }

    public static void testTransactionConstructor() {
        // 1. Setup
        String testAccountNumber = "12345";
        double testTransactionAmount = 150.75;
        Date testTransactionDate = new Date();

        // 2. Exercise
        Transaction transaction = new Transaction(testAccountNumber, testTransactionAmount, testTransactionDate);

        // 3. Verify
        if (transaction.getAccount_number().equals(testAccountNumber)) {
            System.out.println(ANSI_GREEN + "testTransactionConstructor: TC1 Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "testTransactionConstructor: TC1 FAILED" + ANSI_RESET);
        }

        if (transaction.getTransaction_amount() == testTransactionAmount) {
            System.out.println(ANSI_GREEN + "testTransactionConstructor: TC2 Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "testTransactionConstructor: TC2 FAILED" + ANSI_RESET);
        }

        if (transaction.getTransaction_date() != null) {
            System.out.println(ANSI_GREEN + "testTransactionConstructor: TC3 Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "testTransactionConstructor: TC3 FAILED" + ANSI_RESET);
        }
    }

    public static void testGetAccountNumber() {
        Transaction transaction = new Transaction("98765", 200.00, new Date());
        if (transaction.getAccount_number().equals("98765")) {
            System.out.println(ANSI_GREEN + "testGetAccountNumber: Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "testGetAccountNumber: FAILED" + ANSI_RESET);
        }
    }

    public static void testGetTransactionAmount() {
        Transaction transaction = new Transaction("12345", 300.50, new Date());
        if (transaction.getTransaction_amount() == 300.50) {
            System.out.println(ANSI_GREEN + "testGetTransactionAmount: Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "testGetTransactionAmount: FAILED" + ANSI_RESET);
        }
    }

    public static void testGetTransactionDate() {
        Date date = new Date();
        Transaction transaction = new Transaction("12345", 500.75, date);
        if (transaction.getTransaction_date().equals(date)) {
            System.out.println(ANSI_GREEN + "testGetTransactionDate: Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "testGetTransactionDate: FAILED" + ANSI_RESET);
        }
    }
}
