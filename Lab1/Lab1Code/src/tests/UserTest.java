package tests;

import model.User;

//Testing of the User Class
public class UserTest {

	// test message text colours
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
		
		/* OLD manual testing.
		User testUser = new User("mike@mail.com", "password123", "Mike", "Smith", "12345");
		System.out.println(testUser);
		*/
		
		testUserConstructor();
		
	}
	
	public static void testUserConstructor() {
		// 1 Setup
		String test_user = "mike@mail.com";
		String test_pass = "password123";
		String test_first = "Mike";
		String test_last = "Smith";
		String test_mobile = "123456789";
		
		// 2 Construct the object using setup data
		User testUser = new User(test_user, test_pass, test_first, test_last, test_mobile);
			
		// 3 Verify (Assert)
		System.out.println("Starting the assertions of the test method: testUserConstructor");
		
		if (testUser.getUsername() == test_user) {
			System.out.println(ANSI_GREEN + "TC1-getUsername-Passed"+ ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "TC1-getUsername-FAILED" + ANSI_RESET);
		}
		
		if (testUser.getPassword() == test_pass) {
			System.out.println(ANSI_GREEN + "TC2-getPassword-Passed"+ ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "TC2-getPassword-FAILED"+ ANSI_RESET);
		}
		
		if (testUser.getFirst_name() == test_first) {
			System.out.println(ANSI_GREEN + "TC3-getFirst_name-Passed"+ ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "TC3-getFirst_name-FAILED"+ ANSI_RESET);
		}
		
		if (testUser.getLast_name() == test_last) {
			System.out.println(ANSI_GREEN + "TC4-getLast_name-Passed"+ ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "TC4-getLast_name-FAILED"+ ANSI_RESET);
		}
		
		if (testUser.getMobile_number() == test_mobile) {
			System.out.println(ANSI_GREEN + "TC5-getMobile_number-Passed"+ ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "TC5-getMobile_number-FAILED"+ ANSI_RESET);
		}
		
		assert testUser.getUsername() == test_user;
		assert testUser.getPassword() == test_pass;
		assert testUser.getFirst_name() == test_first;
		assert testUser.getLast_name() == test_last;
		assert testUser.getMobile_number() == test_mobile;
		
		System.out.println("All java assertions in the User Constructor test suite passed.");
	}	
}
