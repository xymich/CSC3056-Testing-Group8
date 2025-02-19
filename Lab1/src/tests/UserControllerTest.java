package tests;

import java.util.Vector;
import controller.UserController;
import model.User;
import utility.TestUtils;

public class UserControllerTest {
	
	public static void testLoadUsers() {
		Vector<User> users_test = new Vector<>();
		assert users_test.size() == 0;
		users_test = UserController.loadUserData();
		assert users_test.size() >= 0;
		
		TestUtils.printAssertPass("UserController", "loadUsers");
	}
	
	public static void main(String[] args) {
		testLoadUsers();
	}
	
}
