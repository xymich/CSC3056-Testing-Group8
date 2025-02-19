package tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.Account;
import utility.TestUtils;

public class AccountTest {

	public static void main(String[] args) {
		
		testAccountConstructor();
		
	}
	
	public static void testAccountConstructor() {
		// 1 Setup
		String test_account_number = "123456789";
		String test_username_of_account_holder = "mike@mail.com";
		String test_account_type = "Savings";
		Date test_account_opening_date = new Date();
		
		// 2 Construct the object using setup data
		Account testAccount = new Account(test_account_number, test_username_of_account_holder, 
				test_account_type, test_account_opening_date);
			
		// 3 Verify (Assert)
		System.out.println("Starting the assertions of the test method: testAccountConstructor");
		
		if (testAccount.getAccount_number() == test_account_number) {
			System.out.println(TestUtils.ANSI_GREEN + "TC1-getAccount_number-Passed"+ TestUtils.ANSI_RESET);
		} else {
			System.out.println(TestUtils.ANSI_RED + "TC1-getAccount_number-FAILED" + TestUtils.ANSI_RESET);
		}
		
		if (testAccount.getUsername_of_account_holder() == test_username_of_account_holder) {
			System.out.println(TestUtils.ANSI_GREEN + "TC2-getUsername_of_account_holder-Passed"+ TestUtils.ANSI_RESET);
		} else {
			System.out.println(TestUtils.ANSI_RED + "TC2-getUsername_of_account_holder-FAILED"+ TestUtils.ANSI_RESET);
		}
		
		if (testAccount.getAccount_type() == test_account_type) {
			System.out.println(TestUtils.ANSI_GREEN + "TC3-getAccount_type-Passed"+ TestUtils.ANSI_RESET);
		} else {
			System.out.println(TestUtils.ANSI_RED + "TC3-getAccount_type-FAILED"+ TestUtils.ANSI_RESET);
		}
		
		if (testAccount.getAccount_opening_date() == test_account_opening_date) {
			System.out.println(TestUtils.ANSI_GREEN + "TC4-getAccount_opening_date-Passed"+ TestUtils.ANSI_RESET);
		} else {
			System.out.println(TestUtils.ANSI_RED + "TC4-getAccount_opening_date-FAILED"+ TestUtils.ANSI_RESET);
		}
		
		assert testAccount.getAccount_number() == test_account_number;
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type;
		assert testAccount.getAccount_opening_date() == test_account_opening_date;
		
		System.out.println("All java assertions in the Account Constructor test suite passed.");
	}	
	
}
