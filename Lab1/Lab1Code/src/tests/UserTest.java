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
			TestUtils.printCasePass("getUsername()");
		} else {
			TestUtils.printCaseFail("getUsername()");
		}
		
		if (testUser.getPassword() == test_pass) {
			TestUtils.printCasePass("getPassword()");
		} else {
			TestUtils.printCaseFail("getPassword()");
			}
		
		if (testUser.getFirst_name() == test_first) {
			TestUtils.printCasePass("getFirst_name()");
		} else {
			TestUtils.printCaseFail("getFirst_name()");
		}
		
		if (testUser.getLast_name() == test_last) {
			TestUtils.printCasePass("getLast_name()");
		} else {
			TestUtils.printCaseFail("getLast_name()");
		}
		
		if (testUser.getMobile_number() == test_mobile) {
			TestUtils.printCasePass("getMobile_number()");
		} else {
			TestUtils.printCaseFail("getMobile_number()");
		}
		
		assert testUser.getUsername() == test_user;
		assert testUser.getPassword() == test_pass;
		assert testUser.getFirst_name() == test_first;
		assert testUser.getLast_name() == test_last;
		assert testUser.getMobile_number() == test_mobile;
		
		TestUtils.printAssertPass("User", "Constructor");
	}	
}
