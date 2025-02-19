package tests;

import model.User;
import utility.TestUtils;

//Testing of the User Class
public class UserTest {

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
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed"+ TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}
		
		if (testUser.getPassword() == test_pass) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed"+ TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword-FAILED"+ TestUtils.TEXT_COLOR_RESET);
		}
		
		if (testUser.getFirst_name() == test_first) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirst_name-Passed"+ TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getFirst_name-FAILED"+ TestUtils.TEXT_COLOR_RESET);
		}
		
		if (testUser.getLast_name() == test_last) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLast_name-Passed"+ TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getLast_name-FAILED"+ TestUtils.TEXT_COLOR_RESET);
		}
		
		if (testUser.getMobile_number() == test_mobile) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobile_number-Passed"+ TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobile_number-FAILED"+ TestUtils.TEXT_COLOR_RESET);
		}
		
		assert testUser.getUsername() == test_user;
		assert testUser.getPassword() == test_pass;
		assert testUser.getFirst_name() == test_first;
		assert testUser.getLast_name() == test_last;
		assert testUser.getMobile_number() == test_mobile;
		
		System.out.println("All java assertions in the User Constructor test suite passed.");
	}	
}
