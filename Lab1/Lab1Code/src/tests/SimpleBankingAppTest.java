package tests;

import app.SimpleBankingApp;
import utility.TestUtils;

public class SimpleBankingAppTest {

	// system under test (SUT):
	//static SimpleBankingApp mainApp = new SimpleBankingApp ();

	// this test method (test case) verifies if the data load feature of the class (unit or component) 
	// under test (UUT) works properly
	public static void testLoadData() {
		// Reminder: the classical Four-Phase test pattern (Setup-Exercise-Verify-Teardown
		// http://xunitpatterns.com/Four%20Phase%20Test.html 
		
		// 1-Setup phase: none
		
		// 2-Exercise phase
		SimpleBankingApp.loadUserData();

		// 3-Verify phase
		// we see in the load function of the UUT that we have loaded 3 users, so let's verify that
		if (SimpleBankingApp.users.size() == 3) {
			TestUtils.printCasePass("loadUserData");
			} else {
				TestUtils.printCaseFail("loadUserData");
			}
		// The above only verification is basic (simple, weak) 
		// To do STRONGER verification, we would need more assertions for user names and account balances, etc.
		
		SimpleBankingApp.loadAccountData();
		if (SimpleBankingApp.accounts.size() == 4) {
			TestUtils.printCasePass("loadAccountData");
		} else {
				TestUtils.printCaseFail("loadAccountData");
		}
			
		// 4-Teardown phase: if our goal was to only test the load, as Teardown (mainApp.accounts)
		// we would have deleted the loaded deleted from memory (variables users, and accounts), but we want
		// to use those data in the other tests, thus, we do not do any Teardown in this test case
	}
	
	// this test method (test case) verifies if the Deposit feature works properly
	public static void testDeposits() {
		// 1-Setup phase
		double balanceBefore = SimpleBankingApp.getBalance("5495-1234"); 
		double depositAmount = 50.21;
		
		// 2-Exercise phase
		SimpleBankingApp.addTransaction("5495-1234", depositAmount);
		double balanceAfter = SimpleBankingApp.getBalance("5495-1234");
		
		// 3-verify
		assert balanceBefore + depositAmount == balanceAfter;
		if (balanceBefore + depositAmount == balanceAfter)
			TestUtils.printCasePass("testDeposits");
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED XXX: balanceBefore + depositAmount != balanceAfter");
			System.out.format("testDeposits: balanceBefore = %.2f ; depositAmount = %.2f ; balanceAfter = %.2f %s\n", 
					balanceBefore , depositAmount , balanceAfter, TestUtils.TEXT_COLOR_RESET);
		}
		
		// 4-tear-down: put the system state back in where it was
		// read more about the tear-down phase of test cases: http://xunitpatterns.com/Four%20Phase%20Test.html
		SimpleBankingApp.addTransaction("5495-1234", -depositAmount);
	}

	// this test method (test case) verifies if the Withdraw feature works properly
	
	public static void testWithdrawals() {
		// 1-Setup phase
		double balanceBefore = SimpleBankingApp.getBalance("5495-1234"); 
		double withdrawalAmount = -30.00;
		
		// 2-Exercise phase
		SimpleBankingApp.addTransaction("5495-1234", withdrawalAmount);
		double balanceAfter = SimpleBankingApp.getBalance("5495-1234");
		
		// 3-verify
		System.out.println("Starting the assertions of the test method: testWithdrawals");
		
		assert balanceBefore + withdrawalAmount == balanceAfter;
		if (balanceBefore + withdrawalAmount == balanceAfter)
			TestUtils.printCasePass("testWithdrawals");
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testWithdrawals: TC1 FAILED XXX: balanceBefore + withdrawalAmount != balanceAfter");
			System.out.format("testWithdrawals: balanceBefore = %.2f ; withdrawalAmount = %.2f ; balanceAfter = %.2f %s\n", 
					balanceBefore , withdrawalAmount , balanceAfter, TestUtils.TEXT_COLOR_RESET);
		}
		TestUtils.printAssertPass("SimpleBankingAppTest", "testWithdrawals");
   		// 4-tear-down
		SimpleBankingApp.addTransaction("5495-1234", -withdrawalAmount);
		
		
	}
	
	public static void testGetBalance() {
		double balance = -333;
		double nullBalance = -1;
		double zeroBalance = 0.00;
		double updatedBalance = 100.50;
		
		
		//test non existent account number
		balance = SimpleBankingApp.getBalance("99999"); 
		if (balance == nullBalance) {
			TestUtils.printCasePass("GetBalanceNullAccount");
		} else {
			TestUtils.printCaseFail("GetBalanceNullAccount");
		}
		
		//test valid account number assuming balance is 0.00
		balance = SimpleBankingApp.getBalance("5495-1234"); 
		if (balance == zeroBalance) {
			TestUtils.printCasePass("GetBalance");
		} else {
			TestUtils.printCaseFail("GetBalance");
		}
		
		//test updated balance
		SimpleBankingApp.addTransaction("5495-1234", updatedBalance);
		balance = SimpleBankingApp.getBalance("5495-1234"); 
		if (balance >= updatedBalance) {
			TestUtils.printCasePass("GetBalanceUpdated");
		} else {
			TestUtils.printCaseFail("GetBalanceUpdated");
		}
		
		System.out.println("Starting the assertions of the test method: testGetBalance");
		
		assert SimpleBankingApp.getBalance("99999") == nullBalance;
		SimpleBankingApp.addTransaction("5495-1234", -1*updatedBalance);
		assert SimpleBankingApp.getBalance("5495-1234") == zeroBalance;
		SimpleBankingApp.addTransaction("5495-1234", updatedBalance);
		assert SimpleBankingApp.getBalance("5495-1234") == updatedBalance;
		
		TestUtils.printAssertPass("SimpleBankingAppTest", "testGetBalance");
		
	}
	
	public static void testGetAllTransactionsForAccount() {
		SimpleBankingApp.getTransactionsForAccount("5495-1234");
		// Should print out all Transactions for the specified account in Console.
	}
	
	
	public static void main(String[] args) {
		// we need to call our test cases (methods)
		testLoadData();
		testGetBalance();
		testDeposits();
		testWithdrawals();
		testGetAllTransactionsForAccount();
	}

}
