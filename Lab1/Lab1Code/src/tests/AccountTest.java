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
			TestUtils.printCasePass("getAccount_number");
		} else {
			TestUtils.printCaseFail("getAccount_number");
		}
		
		if (testAccount.getUsername_of_account_holder() == test_username_of_account_holder) {
			TestUtils.printCasePass("getUsername_of_account_holder");
		} else {
			TestUtils.printCaseFail("getUsername_of_account_holder");
		}
		
		if (testAccount.getAccount_type() == test_account_type) {
			TestUtils.printCasePass("getAccount_type");
		} else {
			TestUtils.printCaseFail("getAccount_type");
		}

		if (testAccount.getAccount_opening_date() == test_account_opening_date) {
			TestUtils.printCasePass("getAccount_opening_date");
		} else {
			TestUtils.printCaseFail("getAccount_opening_date");
		}
		
		assert testAccount.getAccount_number() == test_account_number;
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type;
		assert testAccount.getAccount_opening_date() == test_account_opening_date;
		
		TestUtils.printAssertPass("Account", "Constructor");
	}	
	
}
